package pl.edu.pw.elka.postsearch.commons.exceptions;

/**
 * @author Piotr Jarosik
 */
public class ItemAlreadyExistsException extends Exception {

    public ItemAlreadyExistsException(final String message) {
        super(message);
    }

    public ItemAlreadyExistsException(Object id) {
        super("Item already exists: " + id.toString());
    }
}
