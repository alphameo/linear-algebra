package io.github.alphameo.linear_algebra.mat;

import io.github.alphameo.linear_algebra.vec.Vector3;

/**
 * Interface for 3x3 matrix.
 *
 * @since 1.0.0
 */
public interface Matrix3 extends Matrix, FixedMatrixOperatable<Matrix3, Vector3, Matrix3Row, Matrix3Col> {

    /**
     * Safely returns element at the given row and column inside matrix 3x3.
     * 
     * @param r row of element
     * @param c column of element
     * @return element at the given position
     *
     * @since 1.0.0
     */
    float get(Matrix3Row r, Matrix3Col c);

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default float get(int r, int c) throws ArrayIndexOutOfBoundsException {
        return get(Matrix3Row.values()[r], Matrix3Col.values()[c]);
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
    void set(Matrix3Row r, Matrix3Col c, float value);

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default void set(int r, int c, final float value) {
        set(Matrix3Row.values()[r], Matrix3Col.values()[c], value);
    }

    /**
     * @since 1.0.0
     */
    @Override
    Matrix3 clone();

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 transpose() {
        return Matrix3Math.transpose(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 transposed() {
        return Matrix3Math.transposed(this);
    }

    @Override
    /**
     * @since 1.0.0
     */
    default Matrix3 swapRows(final Matrix3Row r1, final Matrix3Row r2) {
        return Matrix3Math.swapRows(this, r1, r2);
    }

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default Matrix3 swapRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.swapRows(this, Matrix3Row.values()[r1], Matrix3Row.values()[r2]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 swappedRows(final Matrix3Row r1, final Matrix3Row r2) {
        return Matrix3Math.swappedRows(this, r1, r2);
    }

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default Matrix3 swappedRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.swappedRows(this, Matrix3Row.values()[r1], Matrix3Row.values()[r2]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 swapCols(final Matrix3Col c1, final Matrix3Col c2) {
        return Matrix3Math.swapCols(this, c1, c2);
    }

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default Matrix3 swapCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.swapCols(this, Matrix3Col.values()[c1], Matrix3Col.values()[c2]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 swappedCols(final Matrix3Col c1, final Matrix3Col c2) {
        return Matrix3Math.swappedCols(this, c1, c2);
    }

    /**
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    @Override
    default Matrix3 swappedCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.swappedCols(this, Matrix3Col.values()[c1], Matrix3Col.values()[c2]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 mulAsgn(final float multiplier) {
        return Matrix3Math.mulAsgn(this, multiplier);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 mul(final float multiplier) {
        return Matrix3Math.mul(this, multiplier);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 divAsgn(final float divisor) throws ArithmeticException {
        return Matrix3Math.divAsgn(this, divisor);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 div(final float divisor) throws ArithmeticException {
        return Matrix3Math.div(this, divisor);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 addAsgn(final Matrix3 addendum) {
        return Matrix3Math.addAsgn(this, addendum);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 add(final Matrix3 addendum) {
        return Matrix3Math.add(this, addendum);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 subAsgn(final Matrix3 subtrahend) {
        return Matrix3Math.subAsgn(this, subtrahend);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 sub(final Matrix3 subtrahend) {
        return Matrix3Math.sub(this, subtrahend);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 prod(final Matrix3 m) {
        return Matrix3Math.prod(this, m);
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
    default Vector3 prod(final Vector3 vCol) {
        return Matrix3Math.prod(this, vCol);
    }

    /**
     * @since 3.0.0
     */
    @Override
    default Vector3 prodCol(final Vector3 vCol) {
        return Matrix3Math.prodCol(this, vCol);
    }

    /**
     * @since 3.0.0
     */
    @Override
    default Vector3 prodRow(final Vector3 vRow) {
        return Matrix3Math.prodRow(this, vRow);
    }

    /**
     * @since 1.0.0
     */
    default Matrix3 triangulate() {
        return Matrix3Math.triangulate(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 triangulated() {
        return Matrix3Math.triangulated(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float det() {
        return Matrix3Math.det(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float detCof() {
        return MatrixMath.detCof(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 inv() {
        return Matrix3Math.inv(this);
    }

    /**
     * Returns minor matrix from this matrix excluding given row and column
     * from given matrix.
     * 
     * @param r row index to exclude
     * @param c column index to exclude
     * @return new minor matrix excluding row {@code r} and column {@code c}
     *         from matrix {@code this}
     * @since 1.0.0
     * 
     */
    default Matrix minorMatrix(final Matrix3Row r, final Matrix3Col c) {
        return Matrix3Math.minorMatrix(this, r, c);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix minorMatrix(final int r, final int c) {
        return Matrix3Math.minorMatrix(this, Matrix3Row.values()[r], Matrix3Col.values()[c]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float cofactor(final Matrix3Row r, final Matrix3Col c) {
        return Matrix3Math.cofactor(this, r, c);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float cofactor(final int r, final int c) {
        return Matrix3Math.cofactor(this, Matrix3Row.values()[r], Matrix3Col.values()[c]);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Matrix3 cofactorMatrix() {
        return Matrix3Math.cofactorMatrix(this);
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
        return Matrix3Math.zeroed(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default boolean diagonal() {
        return Matrix3Math.diagonal(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default boolean equalsEpsilon(final Matrix3 m, final float eps) {
        return Matrix3Math.equalsEpsilon(this, m, eps);
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
    default boolean equals(final Matrix3 m) {
        return Matrix3Math.equals(this, m);
    }

    /**
     * Constructs new matrix 4x4 with elements of given matrix 3x3 and 0 on last
     * row and last column, 1 at right down corner.
     * <p>
     * example for insertionRow = 2, insertionCol = 2:
     * 
     * <pre>
     * ⎡ m00 m01 m02 0 ⎤
     *⎢ m10 m11 m12 0 ⎥
     *⎢ m20 m21 m22 0 ⎥ 
     *⎣  0   0   0  1 ⎦
     * </pre>
     * 
     * @return new matrix 4x4
     *
     * @since 1.0.0
     */
    default Matrix4 toMatrix4() {
        return Matrix3Math.toMatrix4(this);
    }

    /**
     * Safely constructs new matrix 4x4 with elements of given matrix 3x3 and 0 on
     * inserted
     * row and column, 1 on intersection of row and column.
     * <p>
     * example for insertionRow = 2, insertionCol = 2:
     * 
     * <pre>
     * ⎡ m00 m01 0 m02 ⎤
     *⎢  0   0  1  0  ⎥
     *⎢ m10 m11 0 m12 ⎥
     *⎣ m20 m21 0 m22 ⎦
     * </pre>
     * 
     * @param insertionRow row for insertion 0
     * @param insertionCol column for insertion 0
     * @return new matrix 4x4
     *
     * @since 1.0.0
     */
    default Matrix4 toMatrix4(final Matrix4Row insertionRow, final Matrix4Col insertionCol) {
        return Matrix3Math.toMatrix4(this, insertionRow, insertionCol);
    }

    /**
     * Constructs new matrix 4x4 with elements of given matrix 3x3 and 0 on inserted
     * row and column, 1 at intersection of row and column.
     * <p>
     * example for insertionRow = R2, insertionCol = C2:
     * 
     * <pre>
     * ⎡ m00 m01 0 m02 ⎤
     *⎢  0   0  1  0  ⎥
     *⎢ m10 m11 0 m12 ⎥
     *⎣ m20 m21 0 m22 ⎦
     * </pre>
     * 
     * @param insertionRow row index for insertion 0
     * @param insertionCol column index for insertion 0
     * @return new matrix 4x4
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    default Matrix4 toMatrix4(final int insertionRow, final int insertionCol) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.toMatrix4(this, Matrix4Row.values()[insertionRow], Matrix4Col.values()[insertionCol]);
    }
}
