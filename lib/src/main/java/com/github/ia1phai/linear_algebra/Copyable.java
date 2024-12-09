package com.github.ia1phai.linear_algebra;

/**
 * Interface for copyable entities.
 */
public interface Copyable<T> {

    /**
     * Copies object values into new object of same class.
     * 
     * @return copy of object
     */
    T copy();
}
