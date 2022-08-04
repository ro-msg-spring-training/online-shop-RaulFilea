package ro.msg.learning.shop.services.strategy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.repositories.StockRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleLocation implements OrderStrategy {

    private final StockRepository stockRepository;

    public SingleLocation(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    private Integer inspectLocations(HashMap<Integer, ArrayList<StockDTO>> potentialLocations,
                                     List<StockDTO> orderedProducts) {

        for (Map.Entry<Integer, ArrayList<StockDTO>> entry: potentialLocations.entrySet()) {
            if (entry.getValue().size() == orderedProducts.size()) {
                return entry.getKey();
            }
        }
        throw new NoSuchLocationException();
    }

    @Override
    public List<StockDTO> run(OrderDTO orderInfo) {
        HashMap<Integer, ArrayList<StockDTO>> potentialLocations = new HashMap<>();
        List<StockDTO> orderedProducts = orderInfo.getProducts();
        List<Stock> stocks = this.stockRepository.findAll();

        for (Stock stock: stocks) {
            Stock.StockId stockId = stock.getId();
            int productId = Math.toIntExact(stockId.getProduct().getId());

            Integer quantity = OrderDTO.getQuantityById(orderedProducts, productId);

            // curr product found in order list
            // and curr product entirely available in this location
            if (quantity != null && quantity <= stock.getQuantity()) {
                Long locationId = stockId.getLocation().getId();

                potentialLocations.putIfAbsent(Math.toIntExact(locationId), new ArrayList<>());
                potentialLocations.get(locationId).add(new StockDTO(stockId, productId, Math.toIntExact(locationId), quantity));
            }
        }

        // obtain best location
        int bestLocation = this.inspectLocations(potentialLocations, orderedProducts);
        return potentialLocations.get(bestLocation);
    }

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Couldn't find a single location that has all the required products")
    class NoSuchLocationException extends RuntimeException {
    }
}
