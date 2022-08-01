package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.exceptions.ProductCategoryNotFoundException;
import ro.msg.learning.shop.repositories.ProductCategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public void saveProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    public List<ProductCategory> findAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public Optional<ProductCategory> findProductCategoryById(final Long id) {
        return Optional.ofNullable(productCategoryRepository.findById(id).orElseThrow(
                () -> new ProductCategoryNotFoundException(id)));
    }

    public void deleteProductCategory(Long categoryId) {
        if (productCategoryRepository.existsById(categoryId)) {
            productCategoryRepository.deleteById(categoryId);
        } else {
            throw (new ProductCategoryNotFoundException(categoryId));
        }
    }

    public void updateProductCategory(final ProductCategory productCategory) {
        if (productCategoryRepository.existsById(productCategory.getId())) {
            productCategoryRepository.save(productCategory);
        } else {
            throw (new ProductCategoryNotFoundException(productCategory.getId()));
        }
    }
}
