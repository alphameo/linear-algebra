package io.github.alphameo.linear_algebra;

/**
 * Interface for equatable entities by its number values.
 * 
 * @param <T> class for comparison
 *
 * @since 1.0.0
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
     *
     * @since 1.0.0
     */
    boolean equalsEpsilonTo(T other, float eps);

    /**
     * Returns {@code true} if number values of objects are approximately equal
     * 
     * @param other object for comparison
     * @return {@code true} if number values of objects are approximately equal, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
     */
    boolean equalsTo(T other);
}
