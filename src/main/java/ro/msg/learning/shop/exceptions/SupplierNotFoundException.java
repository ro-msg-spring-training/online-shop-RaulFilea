package ro.msg.learning.shop.exceptions;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}
