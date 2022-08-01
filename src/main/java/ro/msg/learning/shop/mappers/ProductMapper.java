package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.dto.ProductSaveDTO;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    public ProductDTO toDto(Product product) {
        Long id = Long.valueOf(product.getId());
        String name = product.getName();
        String description = product.getDescription();
        BigDecimal price = product.getPrice();
        Double weight = product.getWeight();
        ProductCategory category = product.getCategory();
        Supplier supplier = product.getSupplier();
        return new ProductDTO(id, name, description, price, weight, category.getName(), supplier.getName());
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
