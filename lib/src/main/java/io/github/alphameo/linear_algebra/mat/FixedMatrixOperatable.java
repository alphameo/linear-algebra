package io.github.alphameo.linear_algebra.mat;

/**
 * Interface that declares operations between fixed square matrices.
 * <p>
 * {@code M} is a matrix class/interface which should implements this
 * operations
 * <p>
 * {@code R} is a matrix row enum-accessor
 * <p>
 * {@code C} is a matrix column enum-accessor
 *
 * @since 3.0.0
 */
public interface FixedMatrixOperatable<M, V, R, C> {
    /**
     * Safely swaps rows of matrix
     *
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return current matrix with swapped rows
     *
     * @since 1.0.0
     */
    Matrix3 swapRows(final R r1, final R r2);

    /**
     * Copies current matrix and safely swaps its rows.
     * 
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix with swapped rows of current matrix
     *
     * @since 1.0.0
     */
    M swappedRows(final R r1, final R r2);

    /**
     * Safely swaps columns of matrix.
     *
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return current matrix with swapped columns
     *
     * @since 1.0.0
     */
    M swapCols(final C c1, final C c2);

    /**
     * Copies current matrix and safely swaps its columns.
     *
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return new matrix with swapped columns of current matrix
     *
     * @since 1.0.0
     */
    M swappedCols(final C c1, final C c2);

    /**
     * Adds the {@code addendum} matrix elements to the current matrix
     * elements.
     * 
     * @param addendum matrix 3x3 to add
     * @return current matrix increased by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    M addIncr(final M addendum);

    /**
     * Copies current matrix and adds the {@code addendum} matrix elements to
     * its elements.
     * 
     * @param addendum matrix 3x3 to add
     * @return new matrix with sum of elements of current matrix and
     *         {@code addendum} matrix
     *
     * @since 1.0.0
     */
    M add(final M addendum);

    /**
     * Subtracts the {@code subtrahend} matrix elements from the current
     * matrix elements.
     * 
     * @param subtrahend matrix 3x3 to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    M subIncr(final M subtrahend);

    /**
     * Copies current matrix and subtracts the {@code subtrahend} matrix
     * elements from its elements.
     * 
     * @param subtrahend matrix 3x3 to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    M sub(final M subtrahend);

    /**
     * Calculates product of current and given matrices.
     *
     * @param m second (right) matrix 3x3
     * @return matrix, which represents product of matrices
     *
     * @since 1.0.0
     */
    M prod(final M m);

    /**
     * Calculates product of current matrix and vector.
     *
     * @param v column vector of size 3 (right)
     * @return vector of size 3, which represents product of current matrix and
     *         given vector
     *
     * @since 1.0.0
     */
    V prodCol(final V vCol);

    V prodColIncr(final V vCol);

    V prodRow(final V vRow);

    V prodRowIncr(final V vRow);
}
