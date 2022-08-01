package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.entities.ProductCategory;

@Component
@RequiredArgsConstructor
public class ProductCategoryMapper {
    public ProductCategoryDTO toDto(ProductCategory productCategory) {
        Long id = productCategory.getId();
        String name = productCategory.getName();
        String description = productCategory.getDescription();
        return new ProductCategoryDTO(id, name, description);
    }

    public ProductCategory toProductCategory(ProductCategoryDTO productCategoryDto) {
        return new ProductCategory(productCategoryDto.getName(), productCategoryDto.getDescription());
    }
}
