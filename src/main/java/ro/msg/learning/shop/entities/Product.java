package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity @Data
@Getter @Setter @NoArgsConstructor
public class Product implements Serializable {
    private @Id @Setter(AccessLevel.PROTECTED) int id;
    private String name;
    private String description;
    private Float price;
    private Double weight;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    private String imageurl;
}
