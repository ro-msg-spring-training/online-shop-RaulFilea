package ro.msg.learning.shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.Orders;
import ro.msg.learning.shop.mappers.OrderMapper;
import ro.msg.learning.shop.services.OrderServiceImplemented;
import ro.msg.learning.shop.services.strategy.OrderStrategy;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceImplemented orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public List<OrderDTO> findAllSuppliers() {
        return this.orderService.findAllOrders().stream().map(orderMapper::toDTO).toList();
    }

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderInfo) {
        OrderStrategy strategy = this.orderService.selectStrategy();
        List<StockDTO> finalProducts = strategy.run(orderInfo);

        // create and save new order entity
        Orders orders = orderMapper.toEntity(orderInfo);
        Location primaryLocation = this.orderService.getPrimaryLocation(finalProducts);
        orders.setShippedFrom(primaryLocation);

        // process order
        Orders newOrders = this.orderService.placeOrder(orders, finalProducts);

        // prepare order dto for return
        OrderDTO orderDto = orderMapper.toDTO(newOrders);
        orderDto.setProducts(finalProducts);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }
}
