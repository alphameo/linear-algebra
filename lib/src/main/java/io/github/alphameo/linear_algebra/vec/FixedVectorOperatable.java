package io.github.alphameo.linear_algebra.vec;

/**
 * Interface that declares operations between fixed-dimensional vectors.
 * <p>
 * {@code V} is a vector class/interface which should implements this
 * operations.
 *
 * @since 3.0.0
 */
public interface FixedVectorOperatable<V> {
    /**
     * Creates and returns a copy of current vector.
     * 
     * @return copy of vector
     */
    V clone();

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     *
     * @since 1.0.0
     */
    V add(final V addendum);

    /**
     * Copies current vector and adds the {@code addendum} vector components to its
     * components.
     *
     * @param addendum vector to add
     * @return new vector with sum of components of current vector and
     *         {@code addendum} vector
     *
     * @since 1.0.0
     */
    V added(final V addendum);

    /**
     * Subtracts components of 2-dimensional {@code subtrahend} vector from the
     * components of 2-dimensional current vector.
     * 
     * @param subtrahend vector to subtract
     * @return current vector subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    V sub(final V subtrahend);

    /**
     * Copies current 2-dimensional vector and subtracts the 2-dimensional
     * {@code subtrahend} vector components from its components.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with components resulting current vector
     *         subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    V subtracted(final V subtrahend);

    /**
     * Calculates dot product (scalar product) of 2-dimensional vectors.
     *
     * @param v second vector for dot product
     * @return dot (scalar) product of vectors
     *
     * @since 1.0.0
     */
    float dot(final V v);

    /**
     * Returns {@code true} if components of current and given 2-dimensional vectors
     * are equal within {@code epsilon} tolerance.
     * 
     * @param v   vector for comparison
     * @param eps tolerance
     * @return {@code true} if all components of current and given vectors are equal
     *         within {@code epsilon} tolerance, and {@code false}
     *         otherwise
     *
     * @since 1.0.0
     */
    boolean equalsEpsilon(final V v, final float eps);
}
