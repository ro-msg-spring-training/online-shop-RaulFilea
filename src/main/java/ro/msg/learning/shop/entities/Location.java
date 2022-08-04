package ro.msg.learning.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Location extends BaseEntity<Long> {
    private String name;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreet;
}
