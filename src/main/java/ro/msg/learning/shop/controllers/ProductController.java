package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.ProductSaveDTO;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.mappers.ProductMapper;
import ro.msg.learning.shop.services.ProductCategoryService;
import ro.msg.learning.shop.services.ProductService;
import ro.msg.learning.shop.services.SupplierService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final SupplierService supplierService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDTO> findAllProducts() {
        final List<Product> products = productService.findAllProducts();
        return products.stream().map(productMapper::toDto).toList();
    }

    @PostMapping
    public void saveNewProduct(@RequestBody ProductSaveDTO productSaveDTO) {
        productService.saveProduct(productSaveDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable Long id) {
        return productService.findProductById(id).map(productMapper::toDto).orElseThrow();
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductSaveDTO productSaveDTO) {
        productService.updateProduct(id, productSaveDTO);
    }
}
