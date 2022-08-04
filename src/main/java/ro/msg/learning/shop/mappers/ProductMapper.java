package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.ProductSaveDTO;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    public ProductDTO toDto(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getCategory().getName(),
                product.getCategory().getName()
        );
    }

    public Product toProduct(ProductSaveDTO productSaveDTO, ProductCategory productCategory, Supplier supplier) {
        return new Product(
                productSaveDTO.getName(),
                productSaveDTO.getDescription(),
                productSaveDTO.getPrice(),
                productSaveDTO.getWeight(),
                productCategory,
                supplier,
                productSaveDTO.getImageUrl()
        );
    }
}
