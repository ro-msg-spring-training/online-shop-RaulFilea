package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDTO;
import ro.msg.learning.shop.entities.ProductCategory;

@Component
@RequiredArgsConstructor
public class ProductCategoryMapper {
    public ProductCategoryDTO toDto(ProductCategory productCategory) {
        return new ProductCategoryDTO(
                productCategory.getId(),
                productCategory.getName(),
                productCategory.getDescription()
        );
    }

    public ProductCategory toProductCategory(ProductCategoryDTO productCategoryDto) {
        return new ProductCategory(
                productCategoryDto.getName(),
                productCategoryDto.getDescription()
        );
    }
}
