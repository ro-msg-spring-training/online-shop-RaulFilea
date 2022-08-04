package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class LocationDTO {
    private Integer id;
    private String name;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;
}
