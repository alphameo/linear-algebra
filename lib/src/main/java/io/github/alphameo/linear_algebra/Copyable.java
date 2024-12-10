package io.github.alphameo.linear_algebra;

/**
 * Interface for copyable entities.
 * 
 * @param <T> class for copying
 */
public interface Copyable<T> {

    /**
     * Copies object values into new object of same class.
     * 
     * @return copy of object
     */
    T copy();
}
