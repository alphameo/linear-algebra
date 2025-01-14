package io.github.alphameo.linear_algebra.vec;

/**
 * Interface that declares operations between a fixed-dimensional vectors and
 * their corresponding matrices.
 * <p>
 * {@code V} is a vector class/interface which should implements this
 * operations
 *
 * {@code M} corresponding square matrix class/interface
 *
 * @since 3.0.0
 */
public interface FixedVectorTransformable<V, M> {

    /**
     * Returns the result of product of this vector-row and the given matrix.
     *
     * @param m matrix for product
     * @return new vector, which represents product of {@code this} and matrix
     *         {@code m}
     *
     * @since 3.0.0
     */
    V prod(M m);

    /**
     * Transforms this vector-column by the the given transformation operator
     * matrix and returns it.
     *
     * @param operator transformation matrix
     * @return vector {@code this} transformed by matrix {@code operator}
     *
     * @since 3.0.0
     */
    V transformCol(final M operator);

    /**
     * Returns the result of transforming this vector-column by the the given
     * transformation operator matrix.
     *
     * @param operator transformation matrix
     * @return new vector with result of transforming vector {@code this} by matrix
     *         {@code operator}
     *
     * @since 3.0.0
     */
    V transformedCol(final M operator);

    /**
     * Transforms this vector-row by the given transformation operator
     * matrix and returns it.
     *
     * @param operator transformation matrix
     * @return vector {@code this} transformed by matrix {@code operator}
     *
     * @since 3.0.0
     */
    V transformRow(final M operator);

    /**
     * Returns the result of transforming this vector-row by the given
     * transformation operator matrix.
     *
     * @param operator transformation matrix
     * @return new vector with result of transforming vector {@code this} by matrix
     *         {@code operator}
     *
     * @since 3.0.0
     */
    V transformedRow(final M operator);

}
