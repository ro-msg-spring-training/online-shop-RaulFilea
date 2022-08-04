package ro.msg.learning.shop.services;

import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.Order;
import java.util.List;

public interface OrderService {
    Order placeOrder(Order order, List<StockDTO> orderStock);
}
