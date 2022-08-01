package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
public class Product extends BaseEntity<Long> {

    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    private String imageurl;
}
