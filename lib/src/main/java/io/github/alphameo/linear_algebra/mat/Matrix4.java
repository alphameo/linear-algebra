package io.github.alphameo.linear_algebra.mat;

import io.github.alphameo.linear_algebra.vec.Vector4;

/**
 * Interface for 4x4 matrix.
 *
 * @since 1.0.0
 */
public interface Matrix4 extends Matrix, FixedMatrixOperatable<Matrix4, Vector4, Matrix4Row, Matrix4Col> {

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

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default float get(int r, int c) throws ArrayIndexOutOfBoundsException {
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

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default void set(int r, int c, final float value) throws ArrayIndexOutOfBoundsException {
        set(Matrix4Row.values()[r], Matrix4Col.values()[c], value);
    }

    /**
     * @since 1.0.0
     */
    @Override
    Matrix4 clone();

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 transpose() {
        return Matrix4Math.transpose(this);
    }

    /**
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
    @Override
    default Matrix4 swapRows(final Matrix4Row r1, final Matrix4Row r2) {
        return Matrix4Math.swapRows(this, r1, r2);
    }

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default Matrix4 swapRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Matrix4Math.swapRows(this, Matrix4Row.values()[r1], Matrix4Row.values()[r2]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 swappedRows(final Matrix4Row r1, final Matrix4Row r2) {
        return Matrix4Math.swappedRows(this, r1, r2);
    }

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default Matrix4 swappedRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Matrix4Math.swappedRows(this, Matrix4Row.values()[r1], Matrix4Row.values()[r2]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 swapCols(final Matrix4Col c1, final Matrix4Col c2) {
        return Matrix4Math.swapCols(this, c1, c2);
    }

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default Matrix4 swapCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Matrix4Math.swapCols(this, Matrix4Col.values()[c1], Matrix4Col.values()[c2]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 swappedCols(final Matrix4Col c1, final Matrix4Col c2) {
        return Matrix4Math.swappedCols(this, c1, c2);
    }

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default Matrix4 swappedCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Matrix4Math.swappedCols(this, Matrix4Col.values()[c1], Matrix4Col.values()[c2]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 mulAsgn(final float multiplier) {
        return Matrix4Math.mulAsgn(this, multiplier);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 mul(final float multiplier) {
        return Matrix4Math.mul(this, multiplier);
    }

    /**
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    @Override
    default Matrix4 divAsgn(final float divisor) throws ArithmeticException {
        return Matrix4Math.divAsgn(this, divisor);
    }

    /**
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    @Override
    default Matrix4 div(final float divisor) throws ArithmeticException {
        return Matrix4Math.div(this, divisor);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 addAsgn(final Matrix4 addendum) {
        return Matrix4Math.addAsgn(this, addendum);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 add(final Matrix4 addendum) {
        return Matrix4Math.add(this, addendum);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 subAsgn(final Matrix4 subtrahend) {
        return Matrix4Math.subAsgn(this, subtrahend);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 sub(final Matrix4 subtrahend) {
        return Matrix4Math.sub(this, subtrahend);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 prod(final Matrix4 m) {
        return Matrix4Math.prod(this, m);
    }

    /**
     * Returns the result of the product of this matrix and the given vector-column.
     *
     * @param vCol vector-column (right)
     * @return new vector with result of product of matrix {@code this} and vector
     *         {@code vCol}
     * @throws IllegalArgumentException if width of the given matrix is not equal
     *                                  to dimension of the given vector-column
     *
     * @since 3.0.0
     */
    default Vector4 prod(final Vector4 vCol) {
        return Matrix4Math.prod(this, vCol);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector4 prodCol(final Vector4 vCol) {
        return Matrix4Math.prodCol(this, vCol);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector4 prodRow(final Vector4 vRow) {
        return Matrix4Math.prodRow(this, vRow);
    }

    /**
     * @since 1.0.0
     */
    default Matrix4 triangulate() {
        return Matrix4Math.triangulate(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float det() {
        return Matrix4Math.det(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 triangulated() {
        return Matrix4Math.triangulated(this);
    }

    /**
     * @since 1.0.0
     */
    default Matrix4 inv() throws RuntimeException {
        return Matrix4Math.inv(this);
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
     * @since 1.0.0
     */
    @Override
    default Matrix3 minorMatrix(final int r, final int c) {
        return Matrix4Math.minorMatrix(this, Matrix4Row.values()[r], Matrix4Col.values()[c]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float cofactor(final Matrix4Row r, final Matrix4Col c) {
        return Matrix4Math.cofactor(this, r, c);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float cofactor(final int r, final int c) {
        return Matrix4Math.cofactor(this, Matrix4Row.values()[r], Matrix4Col.values()[c]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix4 cofactorMatrix() {
        return Matrix4Math.cofactorMatrix(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default boolean square() {
        return true;
    }

    /**
     * @since 1.0.0
     */
    @Override
    default boolean zeroed() {
        return Matrix4Math.zeroed(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default boolean diagonal() {
        return Matrix4Math.diagonal(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default boolean equalsEpsilon(final Matrix4 m, final float eps) {
        return Matrix4Math.equalsEpsilon(this, m, eps);
    }

    /**
     * Returns {@code true} if the elements of the given matrices are approximately
     * equal.
     * 
     * @param m second matrix for comparison
     * @return {@code true} if all elements of matrices are approximately equal, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equals(final Matrix4 m) {
        return Matrix4Math.equals(this, m);
    }
}
