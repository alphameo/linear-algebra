package com.github.ia1phai.linear_algebra;

/**
 * Interface for equatable entities by its number values.
 */
public interface Equatable<T> {

    /**
     * Returns {@code true} if number values of objects are equal within
     * {@code epsilon} tolerance
     * 
     * @param other object for comparison
     * @param eps   tolerance
     * @return {@code true} if number values of objects are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     */
    boolean equalsEpsilonTo(T other, float eps);

    /**
     * Returns {@code true} if number values of objects are equal
     * 
     * @param other object for comparison
     * @return
     */
    boolean equalsTo(T other);
}
