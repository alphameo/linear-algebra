package io.github.alphameo.linear_algebra;

/**
 * Interface for copyable entities.
 * 
 * @param <T> class for copying
 *
 * @since 1.0.0
 */
public interface Copyable<T> {

    /**
     * Copies object values into new object of same class.
     * 
     * @return copy of object
     *
     * @since 1.0.0
     */
    T copy();
}
