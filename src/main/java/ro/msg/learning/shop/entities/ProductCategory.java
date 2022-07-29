package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Data
@Getter @Setter @NoArgsConstructor
public class ProductCategory implements Serializable {
    private @Id @Setter(AccessLevel.PROTECTED) int id;
    private String name;
    private String description;

}
