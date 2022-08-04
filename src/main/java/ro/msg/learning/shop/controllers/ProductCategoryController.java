package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.mappers.ProductCategoryMapper;
import ro.msg.learning.shop.services.ProductCategoryService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;

    @GetMapping
    public List<ProductCategoryDTO> findAllProductCategories() {
        return this.productCategoryService.findAllProductCategories().stream().map(productCategoryMapper::toDto).toList();
    }

    @PostMapping
    public void saveProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        this.productCategoryService.saveProductCategory(productCategoryMapper.toProductCategory(productCategoryDTO));
    }

    @GetMapping("/{id}")
    public ProductCategoryDTO findProductCategoryById(@PathVariable Long id) {
        return productCategoryService.findProductCategoryById(id).map(productCategoryMapper::toDto).orElseThrow();
    }

    @PutMapping("/{id}")
    public void updateProductCategory(@PathVariable Long id, @RequestBody ProductCategoryDTO productCategoryDTO) {
        this.productCategoryService.updateProductCategory(id, productCategoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
    }
}
