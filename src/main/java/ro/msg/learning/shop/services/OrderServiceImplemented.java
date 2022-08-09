package ro.msg.learning.shop.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.config.OrderStrategyConfig;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.*;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.OrderDetailRepository;
import ro.msg.learning.shop.repositories.OrderRepository;
import ro.msg.learning.shop.repositories.StockRepository;
import ro.msg.learning.shop.services.strategy.MostAbundant;
import ro.msg.learning.shop.services.strategy.OrderStrategy;
import ro.msg.learning.shop.services.strategy.SingleLocation;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class OrderServiceImplemented implements OrderService{

    private final OrderStrategyConfig strategyConfig;
    private final LocationRepository locationRepository;
    private final StockRepository stockRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderStrategy selectStrategy(){
        OrderStrategyConfig.StratType configStrategy = strategyConfig.getStrategy();
        if (configStrategy == OrderStrategyConfig.StratType.SINGLE_LOCATION) {
            return new SingleLocation(stockRepository);
        }
        return new MostAbundant(stockRepository);
    }

    public List<Orders> findAllOrders() {
        return orderRepository.findAll();
    }

    private void updateStock(List<StockDTO> orderStock) {
        for (StockDTO stockDTO: orderStock) {

            Optional<Stock> opStock = this.stockRepository.findStockById(stockDTO.getId());
            Stock stock = opStock.get();
            int diff = stock.getQuantity() - stockDTO.getQuantity();

            // if no stock left remove from db
            if (diff == 0) {
                this.stockRepository.deleteStockById(stockDTO.getId());
            } else {
                stock.setQuantity(diff);
                this.stockRepository.save(stock);
            }

        }
    }

    private void createOrderDetails(List<StockDTO> orderStock, Orders newOrders) {
        for (StockDTO stockDTO: orderStock) {
            OrderDetail.OrderDetailId orderDetailId = new OrderDetail.OrderDetailId(newOrders,
                    stockDTO.getId().getProduct());
            OrderDetail orderDetail = new OrderDetail(orderDetailId, stockDTO.getQuantity());
            this.orderDetailRepository.save(orderDetail);
        }
    }

    public Location getPrimaryLocation(List<StockDTO> orderStock) {
        int locationId = orderStock.get(0).getLocation();
        return this.locationRepository.findById((long) locationId).get();
    }

    @Override
    public Orders placeOrder(Orders orders, List<StockDTO> orderStock) {
        Orders newOrders = this.orderRepository.save(orders);

        // create and save new order detail entity
        this.createOrderDetails(orderStock, newOrders);

        // modify stock
        this.updateStock(orderStock);

        return newOrders;
    }
}
