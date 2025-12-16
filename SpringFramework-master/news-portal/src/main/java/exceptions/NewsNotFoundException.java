package exceptions;

public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException(Long id) {
        super("No News found with id " + id);
    }
}
