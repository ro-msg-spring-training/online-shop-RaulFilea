package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.ProductSaveDTO;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.mappers.ProductMapper;
import ro.msg.learning.shop.services.ProductCategoryService;
import ro.msg.learning.shop.services.ProductService;
import ro.msg.learning.shop.services.SupplierService;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductCategoryService productCategoryService;

    private final SupplierService supplierService;
    private final ProductMapper productMapper;

    @GetMapping("/products")
    public List<ProductDTO> findAllProducts() {
        final List<Product> products = productService.findAllProducts();
        return products.stream().map(productMapper::toDto).toList();
    }

    @PostMapping("/products")
    public void saveNewProduct(@RequestBody ProductSaveDTO productSaveDTO) {
        Optional<ProductCategory> productCategoryOptional = productCategoryService.findProductCategoryById(Long.valueOf(productSaveDTO.getProductCategoryId()));
        Optional<Supplier> supplierOptional = supplierService.findSupplierById(Long.valueOf(productSaveDTO.getSupplierId()));

        if (productCategoryOptional.isPresent() && supplierOptional.isPresent()) {
            ProductCategory productCategory = productCategoryOptional.get();
            Supplier supplier = supplierOptional.get();
            productService.saveProduct(productMapper.toProduct(productSaveDTO, productCategory, supplier));
        }
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/{id}")
    public ProductDTO findProductById(@PathVariable Long id) {
        return productService.findProductById(id).map(productMapper::toDto).orElseThrow();
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductSaveDTO productSaveDTO) {
        Optional<ProductCategory> productCategoryOptional = productCategoryService.findProductCategoryById(Long.valueOf(productSaveDTO.getProductCategoryId()));
        Optional<Supplier> supplierOptional = supplierService.findSupplierById(Long.valueOf(productSaveDTO.getSupplierId()));

        if (productCategoryOptional.isPresent() && supplierOptional.isPresent()) {
            ProductCategory productCategory = productCategoryOptional.get();
            Supplier supplier = supplierOptional.get();

            final Product product = productMapper.toProduct(productSaveDTO, productCategory, supplier);
            product.setId(id);
            productService.updateProduct(product);
        }
    }
}
