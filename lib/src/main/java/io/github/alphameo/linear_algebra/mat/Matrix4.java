package io.github.alphameo.linear_algebra.mat;

import io.github.alphameo.linear_algebra.vec.Vector4;

/**
 * Interface for matrix 4x4.
 *
 * @since 1.0.0
 */
public interface Matrix4 extends Matrix {

    /**
     * Safely returns element at the given row and column inside matrix 4x4.
     * 
     * @param r row of element
     * @param c column of element
     * @return element at the given position
     *
     * @since 1.0.0
     */
    float get(Matrix4Row r, Matrix4Col c);

    @Override
    default float get(int r, int c) {
        return get(Matrix4Row.values()[r], Matrix4Col.values()[c]);
    }

    /**
     * Safely sets value into the given row index and column index inside matrix.
     *
     * @param r     row for putting value
     * @param c     column for putting value
     * @param value component value to be put
     *
     * @since 1.0.0
     */
    void set(Matrix4Row r, Matrix4Col c, float value);

    @Override
    default void set(int r, int c, final float value) {
        set(Matrix4Row.values()[r], Matrix4Col.values()[c], value);
    }

    /**
     * Creates and returns a copy of current matrix 4x4.
     * 
     * @return copy of matrix 4x4
     */
    Matrix4 clone();

    @Override
    default float det() {
        return Matrix4Math.det(this);
    }

    @Override
    default float detViaCofactors() {
        return MatrixMath.detCof(this);
    }

    @Override
    default float cofactor(final int r, final int c) {
        return Matrix4Math.cofactor(this, r, c);
    }

    @Override
    default boolean square() {
        return true;
    }

    @Override
    default boolean zeroed() {
        return Matrix4Math.zeroed(this);
    }

    @Override
    default boolean diagonal() {
        return Matrix4Math.diagonal(this);
    }

    @Override
    default Matrix4 transpose() {
        return Matrix4Math.transpose(this);
    }

    /**
     * Constructs transposed matrix from current matrix.
     *
     * @return new matrix, which is result of transposing of current square matrix
     *
     * @since 1.0.0
     */
    default Matrix4 transposed() {
        return Matrix4Math.transposed(this);
    }

    /**
     * Safely swaps rows of matrix
     *
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return current matrix with swapped rows
     *
     * @since 1.0.0
     */
    default Matrix4 swapRows(final Matrix4Row r1, final Matrix4Row r2) {
        return Matrix4Math.swapRows(this, r1, r2);
    }

    /**
     * Swaps rows of matrix
     *
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return current matrix with swapped rows
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    default Matrix4 swapRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Matrix4Math.swapRows(this, r1, r2);
    }

    /**
     * Copies current matrix and safely swaps its rows.
     * 
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix with swapped rows of current matrix
     *
     * @since 1.0.0
     */
    default Matrix4 swappedRows(final Matrix4Row r1, final Matrix4Row r2) {
        return Matrix4Math.swappedRows(this, r1, r2);
    }

    /**
     * Copies current matrix and swaps its rows.
     * 
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return new matrix with swapped rows of current matrix
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    default Matrix4 swappedRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Matrix4Math.swappedRows(this, r1, r2);
    }

    /**
     * Safely swaps columns of matrix.
     *
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return current matrix with swapped columns
     *
     * @since 1.0.0
     */
    default Matrix4 swapCols(final Matrix4Col c1, final Matrix4Col c2) {
        return Matrix4Math.swapCols(this, c1, c2);
    }

    /**
     * Swaps columns of matrix.
     *
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return current matrix with swapped columns
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    default Matrix4 swapCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Matrix4Math.swapCols(this, c1, c2);
    }

    /**
     * Copies current matrix and safely swaps its columns.
     *
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return new matrix with swapped columns of current matrix
     *
     * @since 1.0.0
     */
    default Matrix4 swappedCols(final Matrix4Col c1, final Matrix4Col c2) {
        return Matrix4Math.swappedCols(this, c1, c2);
    }

    /**
     * Copies current matrix and swaps its columns.
     *
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return new matrix with swapped columns of current matrix
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    default Matrix4 swappedCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Matrix4Math.swappedCols(this, c1, c2);
    }

    /**
     * Multiplies matrix elements by a scalar value.
     * 
     * @param multiplier scalar value
     * @return current matrix with multiplied elements
     *
     * @since 1.0.0
     */
    default Matrix4 mulIncr(final float multiplier) {
        return Matrix4Math.mulAsgn(this, multiplier);
    }

    /**
     * Copies current matrix and multiplies its components by a scalar value.
     * 
     * @param multiplier scalar value
     * @return new matrix with multiplied elements of current matrix
     *
     * @since 1.0.0
     */
    default Matrix4 mul(final float multiplier) {
        return Matrix4Math.mul(this, multiplier);
    }

    /**
     * Divides matrix elements by a scalar value.
     * 
     * @param divisor scalar value
     * @return current matrix with divided elements
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    default Matrix4 divIncr(final float divisor) throws ArithmeticException {
        return Matrix4Math.divAsgn(this, divisor);
    }

    /**
     * Copies current matrix and divides its components by a scalar value.
     *
     * @param divisor scalar value
     * @return new matrix with divided elements of current matrix
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    default Matrix4 div(final float divisor) throws ArithmeticException {
        return Matrix4Math.div(this, divisor);
    }

    /**
     * Adds the {@code addendum} matrix elements to the current matrix
     * elements.
     * 
     * @param addendum matrix 4x4 to add
     * @return current matrix increased by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    default Matrix4 addIncr(final Matrix4 addendum) {
        return Matrix4Math.addAsgn(this, addendum);
    }

    /**
     * Copies current matrix and adds the {@code addendum} matrix elements to
     * its elements.
     * 
     * @param addendum matrix 4x4 to add
     * @return new matrix with sum of elements of current matrix and
     *         {@code addendum} matrix
     *
     * @since 1.0.0
     */
    default Matrix4 add(final Matrix4 addendum) {
        return Matrix4Math.add(this, addendum);
    }

    /**
     * Subtracts the {@code subtrahend} matrix elements from the current
     * matrix elements.
     * 
     * @param subtrahend matrix 4x4 to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    default Matrix4 subIncr(final Matrix4 subtrahend) {
        return Matrix4Math.subAsgn(this, subtrahend);
    }

    /**
     * Copies current matrix and subtracts the {@code subtrahend} matrix
     * elements from its elements.
     * 
     * @param subtrahend matrix 4x4 to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    default Matrix4 sub(final Matrix4 subtrahend) {
        return Matrix4Math.sub(this, subtrahend);
    }

    /**
     * Calculates product of current and the given matrices.
     *
     * @param m second (right) matrix 4x4
     * @return matrix, which represents product of matrices
     *
     * @since 1.0.0
     */
    default Matrix4 prod(final Matrix4 m) {
        return Matrix4Math.prod(this, m);
    }

    /**
     * Calculates product of current matrix and vector.
     *
     * @param v column vector of size 4 (right)
     * @return vector of size 4, which represents product of current matrix and
     *         the given vector
     *
     * @since 1.0.0
     */
    default Vector4 prodCol(final Vector4 vCol) {
        return Matrix4Math.prodCol(this, vCol);
    }

    default Vector4 prodColIncr(final Vector4 vCol) {
        return Matrix4Math.prodColIncr(this, vCol);
    }

    default Vector4 prodRow(final Vector4 vRow) {
        return Matrix4Math.prodRow(this, vRow);
    }

    default Vector4 prodRowIncr(final Vector4 vRow) {
        return Matrix4Math.prodRowIncr(this, vRow);
    }

    /**
     * Triangulates current matrix.
     * 
     * @return current matrix, which is triangulated
     *
     * @since 1.0.0
     */
    default Matrix4 triangulate() {
        return Matrix4Math.triangulate(this);
    }

    /**
     * Copies current matrix and triangulates it.
     * 
     * @return new matrix, which is result of triangulating of current matrix
     *
     * @since 1.0.0
     */
    default Matrix4 triangulated() {
        return Matrix4Math.triangulated(this);
    }

    /**
     * Constructs invertible matrix from current matrix.
     *
     * @return invertible matrix
     * @throws RuntimeException if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    default Matrix4 inv() throws RuntimeException {
        return Matrix4Math.invertible(this);
    }

    /**
     * Safely constructs minor matrix excluding the given row and column from
     * current
     * matrix.
     * 
     * @param r row to exclude
     * @param c column to exclude
     * @return minor matrix excluding the given row and column
     *
     * @since 1.0.0
     */
    default Matrix3 minorMatrix(final Matrix4Row r, final Matrix4Col c) {
        return Matrix4Math.minorMatrix(this, r, c);
    }

    /**
     * Constructs minor matrix excluding the given row and column from current
     * matrix.
     * 
     * @param r row index to exclude
     * @param c column index to exclude
     * @return minor matrix excluding the given row and column
     *
     * @since 1.0.0
     */
    default Matrix3 minorMatrix(final int r, final int c) {
        return Matrix4Math.minorMatrix(this, r, c);
    }

    /**
     * Safely calculates cofactor (algebraic complement) from current matrix for
     * position of the given row and column.
     * 
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from the given positions in current matrix
     *
     * @since 1.0.0
     */
    default float cofactor(final Matrix4Row r, final Matrix4Col c) {
        return Matrix4Math.cofactor(this, r, c);
    }

    /**
     * Constructs matrix of cofactors (algebraic complements)
     * 
     * @return matrix of cofactors
     *
     * @since 1.0.0
     */
    default Matrix4 cofactorMatrix() {
        return Matrix4Math.cofactorMatrix(this);
    }

    /**
     * Returns {@code true} if elements of current and the given matrices are equal
     * within {@code epsilon} tolerance.
     * 
     * @param m   object for comparison
     * @param eps tolerance
     * @return {@code true} if elements of current and given matrices are equal
     *         within {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equalsEpsilon(final Matrix4 m, final float eps) {
        return Matrix4Math.equalsEpsilon(this, m, eps);
    }

    /**
     * Returns {@code true} if elements of current and given matrices are
     * approximately equal.
     * 
     * @param m object for comparison
     * @return {@code true} if elements of current and given matrices are
     *         approximately equal, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equals(final Matrix4 m) {
        return Matrix4Math.equals(this, m);
    }
}
