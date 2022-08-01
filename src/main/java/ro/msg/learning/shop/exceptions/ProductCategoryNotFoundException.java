package ro.msg.learning.shop.exceptions;

public class ProductCategoryNotFoundException extends RuntimeException {

    public ProductCategoryNotFoundException(Long id) {
        super("Could not find product category " + id);
    }
}