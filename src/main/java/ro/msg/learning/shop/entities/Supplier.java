package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Supplier extends BaseEntity<Long>{
    private String name;
}
