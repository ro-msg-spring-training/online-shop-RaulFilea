package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.mappers.ProductCategoryMapper;
import ro.msg.learning.shop.services.ProductCategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;

    @GetMapping("/productcategory")
    public List<ProductCategoryDTO> findAllProductCategories() {
        return this.productCategoryService.findAllProductCategories().stream().map(productCategoryMapper::toDto).toList();
    }

    @PostMapping("/productcategory")
    public void saveProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        this.productCategoryService.saveProductCategory(productCategoryMapper.toProductCategory(productCategoryDTO));
    }

    @GetMapping("/productcategory/{id}")
    public ProductCategoryDTO findProductCategoryById(@PathVariable Long id) {
        return productCategoryService.findProductCategoryById(id).map(productCategoryMapper::toDto).orElseThrow();
    }

    @PutMapping("/productcategory/{id}")
    public void updateProductCategory(@PathVariable Long id, @RequestBody ProductCategoryDTO productCategoryDTO) {
        final ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);
        productCategory.setId(id);
        productCategoryService.updateProductCategory(productCategory);
    }

    @DeleteMapping("/productcategory/{id}")
    public void deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
    }
}
