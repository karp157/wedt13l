package pl.edu.pw.elka.postsearch.commons.validator;

import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * @author Piotr Jarosik
 */
public abstract class Validator {
    private Validator(){/* empty by design */}

    public static void assertNotNull(final Object object, final String message) {
        if(object == null) {
            throw new NoSuchElementException(message);
        }
    }

    public static void assertNotEmpty(final Collection collection, final String message) {
        if(collection == null || collection.isEmpty())
            throw new NoSuchElementException(message);
    }

    public static void assertNotEmpty(final String string, final String message) {
        if(StringUtils.isBlank(string)) {
            throw new NoSuchElementException(message);
        }
    }

    public static void assertSize(final Collection collection, final Integer size, final String message) {
        if(! size.equals(collection.size())) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertTrue(final Boolean condition, final String message) {
        if(! condition) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertValueBetween(final Integer filmYear, final Integer startYear, final Integer endYear, final String message) {
        if(filmYear < startYear || filmYear > endYear)
            throw new IllegalArgumentException(message);
    }
}
