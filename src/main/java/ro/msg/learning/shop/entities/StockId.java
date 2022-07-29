package ro.msg.learning.shop.entities;
import lombok.Data;

import java.io.Serializable;

@Data
public class StockId implements Serializable {
    private Product product;
    private Location location;

    public StockId(Product p, Location l) {
        this.product = p;
        this.location = l;
    }
}
