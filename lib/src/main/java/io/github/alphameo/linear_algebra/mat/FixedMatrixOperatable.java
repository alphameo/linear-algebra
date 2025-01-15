package io.github.alphameo.linear_algebra.mat;

/**
 * Interface that declares operations between fixed square matrices and with
 * fixed-dimensional corresponding vectors.
 *
 * @param <M> is a matrix class/interface which should implements this
 * operations
 * @param <V> is a corresponding fixed-dimensional vector class/interface
 * @param <R> is a matrix row enum-accessor
 * @param <C> is a matrix column enum-accessor
 *
 * @since 3.0.0
 */
public interface FixedMatrixOperatable<M, V, R, C> {
    /**
     * Swaps the rows of this matrix with the given indices and returns it.
     *
     * @param r1 first row index for swapping
     * @param r2 second row index for swapping
     * @return matrix {@code this} with swapped rows
     *
     * @since 1.0.0
     */
    M swapRows(final R r1, final R r2);

    /**
     * Returns the result of row swapping of this matrix with the given
     * indices.
     * 
     * @param r1 first row index for swapping
     * @param r2 second row index for swapping
     * @return new matrix with elements of matrix {@code this} after swapping rows
     *
     * @since 1.0.0
     */
    M swappedRows(final R r1, final R r2);

    /**
     * Swaps the columns of this matrix with the given indices and returns it.
     *
     * @param c1 first column index for swapping
     * @param c2 second column index for swapping
     * @return matrix {@code this} with swapped columns
     *
     * @since 1.0.0
     */
    M swapCols(final C c1, final C c2);

    /**
     * Returns the result of column swapping of this matrix with the given
     * indices.
     *
     * @param c1 first column index for swapping
     * @param c2 second column index for swapping
     * @return new matrix with elements of matrix {@code this} after swapping
     *         columns
     *
     * @since 1.0.0
     */
    M swappedCols(final C c1, final C c2);

    /**
     * Adds the components of the addendum matrix to the components of this
     * matrix and returns it.
     * 
     * @param addendum matrix to add
     * @return matrix {@code this} increased by matrix {@code addendum}
     *
     * @since 1.0.0
     */
    M addAsgn(final M addendum);

    /**
     * Returns the result of adding the elements of the addendum matrix to the
     * elements of this matrix.
     * 
     * @param addendum matrix to add
     * @return new matrix with the sum of matrix {@code this} and matrix
     *         {@code addendum}
     *
     * @since 1.0.0
     */
    M add(final M addendum);

    /**
     * Subtracts elements of the subtrahend matrix from the elements of this matrix
     * and returns it.
     * 
     * @param subtrahend matrix to subtract
     * @return matrix {@code this} reduced by matrix {@code subtrahend}
     *
     * @since 1.0.0
     */
    M subAsgn(final M subtrahend);

    /**
     * Returns the result of subtracting the elements of the subtrahend matrix
     * from the elements of this matrix.
     * 
     * @param subtrahend matrix to subtract
     * @return new matrix with result of subtracting matrix {@code subtrahend} from
     *         matrix {@code this}
     *
     * @since 1.0.0
     */
    M sub(final M subtrahend);

    /**
     * Calculates product of current and the given matrices.
     *
     * @param m second (right) matrix
     * @return matrix, which represents product of matrices
     *
     * @since 1.0.0
     */
    M prod(final M m);

    /**
     * Returns the result of the product of this matrix and the given vector-column.
     *
     * @param vCol vector-column (right)
     * @return new vector with result of product of matrix {@code this} and vector
     *         {@code vCol}
     *
     * @since 3.0.0
     */
    V prodCol(final V vCol);

    /**
     * Returns the result of product of the given vector-row and this matrix.
     *
     * @param vRow column vector (left)
     * @return new vector with result of product of vector {@code vCol} and matrix
     *         {@code this}
     *
     * @since 3.0.0
     */
    V prodRow(final V vRow);

    /**
     * Returns cofactor (algebraic complement) from this matrix for position of
     * given row and column.
     * 
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value for row {@code r} and column {@code c} for the given
     *         positions in this matrix
     *
     * @since 1.0.0
     */
    float cofactor(final R r, final C c);

    /**
     * Returns {@code true} if elements of matrices are equal within
     * {@code epsilon} tolerance.
     * 
     * @param m   second matrix for comparison
     * @param eps tolerance
     * @return {@code true} if all elements of matrices are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    boolean equalsEpsilon(final M m, final float eps);
}
