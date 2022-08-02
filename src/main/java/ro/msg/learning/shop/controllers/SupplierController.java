package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.SupplierDTO;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.mappers.SupplierMapper;
import ro.msg.learning.shop.services.SupplierService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    private final SupplierMapper supplierMapper;

    @GetMapping("/suppliers")
    public List<SupplierDTO> findAllSuppliers() {
        return this.supplierService.findAllSuppliers().stream().map(supplierMapper::toDto).toList();
    }

    @PostMapping("/suppliers")
    public void saveNewSupplier(@RequestBody SupplierDTO supplierDTO) {
        this.supplierService.saveSupplier(supplierMapper.toSupplier(supplierDTO));
    }

    @GetMapping("/suppliers/{id}")
    public SupplierDTO findSupplierById(@PathVariable Long id) {
        return this.supplierService.findSupplierById(id).map(supplierMapper::toDto).orElseThrow();
    }

    @PutMapping("/suppliers/{id}")
    public void updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO) {
        final Supplier supplier = supplierMapper.toSupplier(supplierDTO);
        supplier.setId(id);
        supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/suppliers/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        this.supplierService.deleteSupplier(id);
    }
}
