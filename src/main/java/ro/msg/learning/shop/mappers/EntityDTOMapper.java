package ro.msg.learning.shop.mappers;

public interface EntityDTOMapper <E, D> {
    D toDTO (E entity);
    E toEntity (D dto);
}
