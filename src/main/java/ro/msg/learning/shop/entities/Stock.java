package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@Getter @Setter @NoArgsConstructor
@IdClass(StockId.class)
public class Stock implements Serializable{
    @Id @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    private int quantity;
}

