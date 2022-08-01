package ro.msg.learning.shop.exceptions;

public class StockNotFoundException extends RuntimeException {
    public StockNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}
