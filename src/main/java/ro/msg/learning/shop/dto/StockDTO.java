package ro.msg.learning.shop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.entities.Stock;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    @JsonIgnore
    Stock.StockId id;

    private int product;
    private int location;
    private int quantity;
}
