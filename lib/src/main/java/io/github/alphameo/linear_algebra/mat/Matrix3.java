package io.github.alphameo.linear_algebra.mat;

import io.github.alphameo.linear_algebra.vec.Vector3;

/**
 * Interface for matrix 3x3.
 *
 * @since 1.0.0
 */
public interface Matrix3 extends Matrix {

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

    @Override
    default float get(int r, int c) {
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

    @Override
    default void set(int r, int c, final float value) {
        set(Matrix3Row.values()[r], Matrix3Col.values()[c], value);
    }

    /**
     * Creates and returns a copy of current matrix 3x3.
     * 
     * @return copy of matrix 3x3
     */
    Matrix3 clone();

    @Override
    default float det() {
        return Matrix3Math.det(this);
    }

    @Override
    default float detViaCofactors() {
        return MatrixMath.detThroughCofactors(this);
    }

    @Override
    default float cofactor(final int r, final int c) {
        return Matrix3Math.cofactor(this, r, c);
    }

    @Override
    default boolean square() {
        return true;
    }

    @Override
    default boolean zeroed() {
        return Matrix3Math.isZeroed(this);
    }

    @Override
    default boolean diagonal() {
        return Matrix3Math.diagonal(this);
    }

    @Override
    default Matrix3 transpose() {
        return Matrix3Math.transpose(this);
    }

    default Matrix3 transposed() {
        return Matrix3Math.transposed(this);
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
    default Matrix3 swapRows(final Matrix3Row r1, final Matrix3Row r2) {
        return Matrix3Math.swapRows(this, r1, r2);
    }

    @Override
    default Matrix3 swapRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.swapRows(this, r1, r2);
    }

    default Matrix3 swappedRows(final Matrix3Row r1, final Matrix3Row r2) {
        return Matrix3Math.swappedRows(this, r1, r2);
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
    default Matrix3 swappedRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.swappedRows(this, r1, r2);
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
    default Matrix3 swapCols(final Matrix3Col c1, final Matrix3Col c2) {
        return Matrix3Math.swapCols(this, c1, c2);
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
    default Matrix3 swapCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.swapCols(this, c1, c2);
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
    default Matrix3 swappedCols(final Matrix3Col c1, final Matrix3Col c2) {
        return Matrix3Math.swappedCols(this, c1, c2);
    }

    default Matrix3 swappedCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Matrix3Math.swappedCols(this, c1, c2);
    }

    default Matrix3 mulIncr(final float multiplier) {
        return Matrix3Math.mult(this, multiplier);
    }

    /**
     * Copies current matrix and multiplies its components by a scalar value.
     * 
     * @param multiplier scalar value
     * @return new matrix with multiplied elements of current matrix
     *
     * @since 1.0.0
     */
    default Matrix3 mul(final float multiplier) {
        return Matrix3Math.multiplied(this, multiplier);
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
    default Matrix3 divIncr(final float divisor) throws ArithmeticException {
        return Matrix3Math.divide(this, divisor);
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
    default Matrix3 div(final float divisor) throws ArithmeticException {
        return Matrix3Math.divided(this, divisor);
    }

    /**
     * Adds the {@code addendum} matrix elements to the current matrix
     * elements.
     * 
     * @param addendum matrix 3x3 to add
     * @return current matrix increased by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    default Matrix3 addIncr(final Matrix3 addendum) {
        return Matrix3Math.addIncr(this, addendum);
    }

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
    default Matrix3 add(final Matrix3 addendum) {
        return Matrix3Math.add(this, addendum);
    }

    /**
     * Subtracts the {@code subtrahend} matrix elements from the current
     * matrix elements.
     * 
     * @param subtrahend matrix 3x3 to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    default Matrix3 subIncr(final Matrix3 subtrahend) {
        return Matrix3Math.subIncr(this, subtrahend);
    }

    /**
     * Copies current matrix and subtracts the {@code subtrahend} matrix
     * elements from its elements.
     * 
     * @param subtrahend matrix 3x3 to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     *
     * @since 1.0.0
     */
    default Matrix3 sub(final Matrix3 subtrahend) {
        return Matrix3Math.sub(this, subtrahend);
    }

    /**
     * Calculates product of current and the given matrices.
     *
     * @param m second (right) matrix 3x3
     * @return matrix, which represents product of matrices
     *
     * @since 1.0.0
     */
    default Matrix3 prod(final Matrix3 m) {
        return Matrix3Math.prod(this, m);
    }

    /**
     * Calculates product of current matrix and vector.
     *
     * @param v column vector of size 3 (right)
     * @return vector of size 3, which represents product of current matrix and
     *         the given vector
     *
     * @since 1.0.0
     */
    default Vector3 prodCol(final Vector3 vCol) {
        return Matrix3Math.prodCol(this, vCol);
    }

    default Vector3 prodColIncr(final Vector3 vCol) {
        return Matrix3Math.prodColIncr(this, vCol);
    }

    default Vector3 prodRow(final Vector3 vRow) {
        return Matrix3Math.prodRow(this, vRow);
    }

    default Vector3 prodRowIncr(final Vector3 vRow) {
        return Matrix3Math.prodRowIncr(this, vRow);
    }

    /**
     * Triangulates current matrix.
     * 
     * @return current matrix, which is triangulated
     *
     * @since 1.0.0
     */
    default Matrix3 triangulate() {
        return Matrix3Math.triangulate(this);
    }

    /**
     * Copies current matrix and triangulates it.
     * 
     * @return new matrix, which is result of triangulating of current matrix
     *
     * @since 1.0.0
     */
    default Matrix3 triangulated() {
        return Matrix3Math.triangulated(this);
    }

    /**
     * Constructs invertible matrix from current matrix.
     *
     * @return invertible matrix
     * @throws RuntimeException if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    default Matrix3 inv() {
        return Matrix3Math.invertible(this);
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
    default Matrix minorMatrix(final Matrix3Row r, final Matrix3Col c) {
        return Matrix3Math.minorMatrix(this, r, c);
    }

    /**
     * Constructs minor matrix excluding the given row and column from current
     * matrix.
     * 
     * @param r row index to exclude
     * @param c column index to exclude
     * @return minor matrix excluding given row and column
     *
     * @since 1.0.0
     */
    default Matrix minorMatrix(final int r, final int c) {
        return Matrix3Math.minorMatrix(this, r, c);
    }

    /**
     * Safely calculates cofactor (algebraic complement) from current matrix for
     * position of given row and column.
     * 
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from given positions in current matrix
     *
     * @since 1.0.0
     */
    default float cofactor(final Matrix3Row r, final Matrix3Col c) {
        return Matrix3Math.cofactor(this, r, c);
    }

    /**
     * Constructs matrix of cofactors (algebraic complements)
     * 
     * @return matrix of cofactors
     *
     * @since 1.0.0
     */
    default Matrix3 cofactorMatrix() {
        return Matrix3Math.cofactorMatrix(this);
    }

    /**
     * Returns {@code true} if elements of current and given matrices are equal
     * within {@code epsilon} tolerance.
     * 
     * @param m   object for comparison
     * @param eps tolerance
     * @return {@code true} if elements of current and given matrices are equal
     *         within {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equalsEpsilon(final Matrix3 m, final float eps) {
        return Matrix3Math.equalsEpsilon(this, m, eps);
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
     *
     * @since 1.0.0
     */
    default Matrix4 toMatrix4(final int insertionRow, final int insertionCol) {
        return Matrix3Math.toMat4(this, insertionRow, insertionCol);
    }
}
