package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@Getter @Setter @NoArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetail implements Serializable{
    @Id @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Id @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
}
