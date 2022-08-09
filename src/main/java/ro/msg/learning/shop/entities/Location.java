package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Data
@Getter @Setter @NoArgsConstructor
public class Location implements Serializable{
    private @Id @Setter(AccessLevel.PROTECTED) int id;
    private String name;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreet;
}
