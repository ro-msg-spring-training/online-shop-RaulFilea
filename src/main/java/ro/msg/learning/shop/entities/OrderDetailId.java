package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderDetailId implements Serializable {
    private Order order;
    private Product product;


}
