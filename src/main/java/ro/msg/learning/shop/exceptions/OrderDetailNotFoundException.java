package ro.msg.learning.shop.exceptions;

public class OrderDetailNotFoundException extends RuntimeException {
    public OrderDetailNotFoundException(Long id) {
        super("Could not find order detail " + id);
    }
}
