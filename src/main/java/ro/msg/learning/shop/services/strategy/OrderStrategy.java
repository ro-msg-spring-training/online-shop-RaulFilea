package ro.msg.learning.shop.services.strategy;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.StockDTO;

import java.util.List;

public interface OrderStrategy {
    List<StockDTO> run(OrderDTO orderInfo);
}
