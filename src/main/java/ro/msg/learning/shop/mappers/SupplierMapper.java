package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.SupplierDTO;
import ro.msg.learning.shop.entities.Supplier;

@Component
@RequiredArgsConstructor
public class SupplierMapper {
    public SupplierDTO toDto(Supplier supplier) {
        return new SupplierDTO(
                Math.toIntExact(supplier.getId()),
                supplier.getName()
        );
    }

    public Supplier toSupplier(SupplierDTO supplierDto) {
        return new Supplier(supplierDto.getName());
    }
}
