package ro.msg.learning.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.Order;
import ro.msg.learning.shop.mappers.OrderMapper;
import ro.msg.learning.shop.services.strategy.OrderStrategy;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ro.msg.learning.shop.services.OrderServiceImplemented orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderInfo) {
        OrderStrategy strategy = this.orderService.selectStrategy();
        List<StockDTO> finalProducts = strategy.run(orderInfo);

        // create and save new order entity
        Order order = orderMapper.toEntity(orderInfo);
        Location primaryLocation = this.orderService.getPrimaryLocation(finalProducts);
        order.setShippedFrom(primaryLocation);

        // process order
        Order newOrder = this.orderService.placeOrder(order, finalProducts);

        // prepare order dto for return
        OrderDTO orderDto = orderMapper.toDTO(newOrder);
        orderDto.setProducts(finalProducts);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }
}
