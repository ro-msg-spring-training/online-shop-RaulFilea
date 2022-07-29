package ro.msg.learning.shop.entities;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Data
@Getter @Setter @NoArgsConstructor
public class Customer implements Serializable{
    private @Id @Setter(AccessLevel.PROTECTED) int id;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String email;
}
