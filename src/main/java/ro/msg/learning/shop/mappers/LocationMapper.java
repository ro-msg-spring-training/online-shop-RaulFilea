package ro.msg.learning.shop.mappers;

import ro.msg.learning.shop.dto.LocationDTO;
import ro.msg.learning.shop.entities.Location;

public class LocationMapper implements EntityDTOMapper<Location, LocationDTO> {
    @Override
    public LocationDTO toDTO(Location entity) {
        if (entity == null) {
            return null;
        }

        return LocationDTO.builder()
                .id(Math.toIntExact(entity.getId()))
                .name(entity.getName())
                .addressCountry(entity.getAddressCountry())
                .addressCity(entity.getAddressCity())
                .addressStreetAddress(entity.getAddressStreet()).build();
    }

    @Override
    public Location toEntity(LocationDTO dto) {
        if (dto == null) {
            return null;
        }

        return Location.builder()
                .name(dto.getName())
                .addressCountry(dto.getAddressCountry())
                .addressCity(dto.getAddressCity())
                .addressCounty(dto.getAddressCounty())
                .addressStreet(dto.getAddressStreetAddress()).build();
    }
}
