package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Customer extends BaseEntity<Long> {
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String email;
}
