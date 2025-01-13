package io.github.alphameo.linear_algebra.vec;

/**
 * An interface that declares operations between fixed-dimensional vectors and
 * their corresponding matrices.
 * <p>
 * {@code V} is a vector class/interface which should implements this
 * operations
 *
 * {@code M} collocated square matrix class
 *
 * @since 3.0.0
 */
public interface FixedVectorOperatable<V> {
    /**
     * Creates and returns a copy of {@code this} vector.
     * 
     * @return copy of vector
     */
    V clone();

    /**
     * Adds the components of the addendum vector to the components of the target
     * vector and returns it.
     *
     * @param target   vector to be added
     * @param addendum vector to add
     * @return vector {@code target} increased by vector {@code addendum}
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    V addAsgn(final V addendum);

    /**
     * Copies {@code this} vector and adds the {@code addendum} vector components to
     * its components.
     *
     * @param addendum vector to add
     * @return new vector with sum of components of {@code this} vector and
     *         {@code addendum} vector
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    V add(final V addendum);

    /**
     * Subtracts components of 2-dimensional {@code subtrahend} vector from the
     * components of 2-dimensional current vector.
     * 
     * @param subtrahend vector to subtract
     * @return current vector subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    V subAsgn(final V subtrahend);

    /**
     * Returns the result of subtracting the components of the subtrahend vector
     * from the components of this vector.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with result of subtracting vector {@code subtrahend} from
     *         vector {@code target}
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    V sub(final V subtrahend);

    /**
     * Returns dot product (scalar product) of this and given vectors.
     *
     * @param v vector for dot product
     * @return dot product of vector {@code this} and vector {@code v}
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    float dot(final V v);

    /**
     * Returns {@code true} if the components of this vector and the components of
     * the given vector are equal within {@code epsilon} tolerance.
     * 
     * @param v   vector for comparison
     * @param eps tolerance
     * @return {@code true} if all components of vector {@code this} and vector
     *         {@code v} are equal within {@code eps} tolerance, and {@code false}
     *         otherwise
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    boolean equalsEpsilon(final V v, final float eps);
}
