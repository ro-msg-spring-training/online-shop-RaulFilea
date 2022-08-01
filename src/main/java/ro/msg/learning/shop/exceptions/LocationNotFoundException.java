package ro.msg.learning.shop.exceptions;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(Long id) {
        super("Could not find location " + id);
    }
}
