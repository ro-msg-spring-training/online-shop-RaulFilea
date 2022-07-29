package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity @Data
@Getter @Setter @NoArgsConstructor
public class Order implements Serializable{
    private @Id @Setter(AccessLevel.PROTECTED) int id;
    @ManyToOne
    @JoinColumn(name = "shipped_from_id")
    private Location shippedFrom;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Date createdAt;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreet;
}
