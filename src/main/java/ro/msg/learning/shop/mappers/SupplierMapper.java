package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.SupplierDTO;
import ro.msg.learning.shop.entities.Supplier;

@Component
@RequiredArgsConstructor
public class SupplierMapper {
    public SupplierDTO toDto(Supplier supplier) {
        Long id = supplier.getId();
        String name = supplier.getName();
        return new SupplierDTO(Math.toIntExact(id), name);
    }

    public Supplier toSupplier(SupplierDTO supplierDto) {
        return new Supplier(supplierDto.getName());
    }
}
