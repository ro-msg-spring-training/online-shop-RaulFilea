package ro.msg.learning.shop.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entities.Orders;

@Component
public class OrderMapper implements EntityDTOMapper<Orders, OrderDTO> {

    @Override
    public OrderDTO toDTO(Orders entity) {
        if (entity == null) {
            return null;
        }
        return OrderDTO.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .addressCountry(entity.getAddressCountry())
                .addressCity(entity.getAddressCity())
                .addressCounty(entity.getAddressCounty())
                .addressStreetAddress(entity.getAddressStreet()).build();
    }

    @Override
    public Orders toEntity(OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        return Orders.builder()
                .createdAt(dto.getCreatedAt())
                .addressCountry(dto.getAddressCountry())
                .addressCity(dto.getAddressCity())
                .addressCounty(dto.getAddressCounty())
                .addressStreet(dto.getAddressStreetAddress()).build();
    }
}
