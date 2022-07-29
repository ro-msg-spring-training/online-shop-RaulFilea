package ro.msg.learning.shop.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailId implements Serializable {
    private Order order;
    private Product product;

    public OrderDetailId (Order o, Product p) {
        this.order = o;
        this.product = p;
    }
}
