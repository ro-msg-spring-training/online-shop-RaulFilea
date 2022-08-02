package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StockId implements Serializable {
    private Product product;
    private Location location;
}
