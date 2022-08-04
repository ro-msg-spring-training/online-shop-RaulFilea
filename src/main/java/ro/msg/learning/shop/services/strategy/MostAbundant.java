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

public class MostAbundant implements OrderStrategy {

    private final StockRepository stockRepository;

    public MostAbundant(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<StockDTO> run(OrderDTO orderInfo) {
        HashMap<Integer, StockDTO> orderStock = new HashMap<>();
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

                orderStock.putIfAbsent(productId, new StockDTO(stockId, productId, Math.toIntExact(locationId), quantity));
                if (quantity > orderStock.get(productId).getQuantity()) {
                    orderStock.put(productId, new StockDTO(stockId, productId, Math.toIntExact(locationId), quantity));
                }
            }
        }

        if (orderStock.size() < orderedProducts.size()) {
            throw new StockUnavailableException();
        }

        return new ArrayList<>(orderStock.values());
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Stock unavailable for some of the requested products")
    class StockUnavailableException extends RuntimeException {
    }
}