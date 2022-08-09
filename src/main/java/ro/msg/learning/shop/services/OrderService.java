package ro.msg.learning.shop.services;

import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.Orders;

import java.util.List;

public interface OrderService {
    Orders placeOrder(Orders orders, List<StockDTO> orderStock);
}
