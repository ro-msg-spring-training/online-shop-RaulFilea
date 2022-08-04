package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class OrderDetail implements Serializable{
    @Data @Embeddable
    @NoArgsConstructor @AllArgsConstructor
    public static class OrderDetailId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;
        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;
    }

    @EmbeddedId
    private OrderDetailId id;

    private int quantity;
}
