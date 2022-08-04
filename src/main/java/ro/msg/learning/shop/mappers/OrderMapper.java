package ro.msg.learning.shop.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entities.Order;

@Component
public class OrderMapper implements EntityDTOMapper<Order, OrderDTO> {

    @Override
    public OrderDTO toDTO(Order entity) {
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
    public Order toEntity(OrderDTO dto) {
        if (dto == null) {
            return null;
        }
        return Order.builder()
//                .id(0)
                .createdAt(dto.getCreatedAt())
                .addressCountry(dto.getAddressCountry())
                .addressCity(dto.getAddressCity())
                .addressCounty(dto.getAddressCounty())
                .addressStreet(dto.getAddressStreetAddress()).build();
    }
}
