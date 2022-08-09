package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.exceptions.ProductCategoryNotFoundException;
import ro.msg.learning.shop.exceptions.SupplierNotFoundException;
import ro.msg.learning.shop.repositories.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public List<Supplier> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> findSupplierById(final Long id) {
        return Optional.ofNullable(supplierRepository.findById(id).orElseThrow(
                () -> new SupplierNotFoundException(id)));
    }

    public void deleteSupplier(Long supplierID) {
        if (supplierRepository.existsById(supplierID)) {
            supplierRepository.deleteById(supplierID);
        } else {
            throw (new ProductCategoryNotFoundException(supplierID));
        }
    }

    public void updateSupplier(final Supplier supplier) {
        if (supplierRepository.existsById(supplier.getId())) {
            supplierRepository.save(supplier);
        } else {
            throw (new ProductCategoryNotFoundException(supplier.getId()));
        }
    }
}
