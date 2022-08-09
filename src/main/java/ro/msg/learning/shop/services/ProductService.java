package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductSaveDTO;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.entities.ProductCategory;
import ro.msg.learning.shop.entities.Supplier;
import ro.msg.learning.shop.exceptions.ProductCategoryNotFoundException;
import ro.msg.learning.shop.exceptions.ProductNotFoundException;
import ro.msg.learning.shop.mappers.ProductMapper;
import ro.msg.learning.shop.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryService productCategoryService;
    private final SupplierService supplierService;

    public void saveProduct(ProductSaveDTO productSaveDTO) {
        Optional<ProductCategory> productCategoryOptional = productCategoryService.findProductCategoryById(Long.valueOf(productSaveDTO.getProductCategoryId()));
        Optional<Supplier> supplierOptional = supplierService.findSupplierById(Long.valueOf(productSaveDTO.getSupplierId()));

        if (productCategoryOptional.isPresent() && supplierOptional.isPresent()) {
            ProductCategory productCategory = productCategoryOptional.get();
            Supplier supplier = supplierOptional.get();
            productRepository.save(productMapper.toProduct(productSaveDTO, productCategory, supplier));
        }
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(final Long id) {
        return Optional.ofNullable(productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)));
    }

    public void deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw (new ProductCategoryNotFoundException(productId));
        }
    }

    public void updateProduct(Long id, final ProductSaveDTO productSaveDTO) {
        Optional<ProductCategory> productCategoryOptional = productCategoryService.findProductCategoryById(Long.valueOf(productSaveDTO.getProductCategoryId()));
        Optional<Supplier> supplierOptional = supplierService.findSupplierById(Long.valueOf(productSaveDTO.getSupplierId()));

        if (productCategoryOptional.isPresent() && supplierOptional.isPresent()) {
            ProductCategory productCategory = productCategoryOptional.get();
            Supplier supplier = supplierOptional.get();

            final Product product = productMapper.toProduct(productSaveDTO, productCategory, supplier);
            product.setId(id);

            if (productRepository.existsById(product.getId())) {
                productRepository.save(product);
            } else {
                throw (new ProductCategoryNotFoundException(product.getId()));
            }
        }
    }
}
