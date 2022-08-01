package ro.msg.learning.shop.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}
