package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Stock implements Serializable{

    @Data @Embeddable
    @NoArgsConstructor @AllArgsConstructor
    public static class StockId implements Serializable {
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
        @JoinColumn(name = "product_id")
        private Product product;
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
        @JoinColumn(name = "location_id")
        private Location location;
    }

    @EmbeddedId
    private StockId id;

    @Column
    private int quantity;
}

