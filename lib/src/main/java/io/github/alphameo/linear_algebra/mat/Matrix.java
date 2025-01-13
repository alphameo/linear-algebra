package io.github.alphameo.linear_algebra.mat;

import io.github.alphameo.linear_algebra.vec.Vector;

/**
 * Interface for matrix MxN.
 *
 * @since 1.0.0
 */
public interface Matrix extends Cloneable {

    /**
     * Returns element at the given row index and column index inside matrix.
     * 
     * @param r row index of element
     * @param c column index of element
     * @return element at the given position
     *
     * @since 1.0.0
     */
    float get(int r, int c);

    /**
     * Sets value into the given row index and column index inside matrix.
     *
     * @param r     row index for putting value
     * @param c     column index for putting value
     * @param value component value to be put
     *
     * @since 1.0.0
     */
    void set(int r, int c, float value);

    /**
     * Returns width (column count) of matrix.
     * 
     * @return width of matrix
     *
     * @since 1.0.0
     */
    int width();

    /**
     * Returns height (row count) of matrix.
     * 
     * @return height of matrix
     *
     * @since 1.0.0
     */
    int height();

    /**
     * Creates and returns a copy of current matrix.
     * 
     * @return copy of matrix
     */
    Matrix clone();

    /**
     * Calculates matrix determinant using triangular table (blazingly fast).
     * 
     * @return matrix determinant
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default float det() {
        return MatrixMath.det(this);
    }

    /**
     * Calculates matrix determinant using cofactors (not blazingly fast).
     * 
     * @return matrix determinant
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default float detViaCofactors() {
        return MatrixMath.detThroughCofactors(this);
    }

    /**
     * Calculates cofactor (algebraic complement) from current matrix for position
     * of the given row and column.
     * 
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from the given positions in current matrix
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default float cofactor(final int r, final int c) {
        return MatrixMath.cofactor(this, r, c);
    }

    /**
     * Returns {@code true} if matrix is square.
     * 
     * @return {@code true} if matrix is square, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean square() {
        return MatrixMath.square(this);
    }

    /**
     * Returns {@code true} if matrix elements are approximately equal 0.
     * 
     * @return {@code true} if matrix elements are approximately equal 0, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean zeroed() {
        return MatrixMath.zeroed(this);
    }

    /**
     * Returns {@code true} if matrix is diagonal.
     * 
     * @return {@code true} if matrix is square diagonal, and {@code false}
     *         otherwise
     *
     * @since 1.0.0
     */
    default boolean diagonal() {
        return MatrixMath.diagonal(this);
    }

    /**
     * Transposes current matrix.
     *
     * @return current transposed matrix
     *
     * @since 1.0.0
     */
    Matrix transpose();

    /**
     * Constructs transposed matrix from current matrix.
     *
     * @return new matrix, which is result of transposing of current square matrix
     *
     * @since 1.0.0
     */
    default Matrix transposed() {
        return MatrixMath.transposed(this);
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
    default Matrix swapRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return MatrixMath.swapRows(this, r1, r2);
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
    default Matrix swappedRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return MatrixMath.swappedRows(this, r1, r2);
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
    default Matrix swapCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return MatrixMath.swapCols(this, c1, c2);
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
    default Matrix swappedCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return MatrixMath.swappedCols(this, c1, c2);
    }

    /**
     * Multiplies matrix elements by a scalar value.
     * 
     * @param multiplier scalar value
     * @return current matrix with multiplied elements
     *
     * @since 1.0.0
     */
    default Matrix mulIncr(final float multiplier) {
        return MatrixMath.mulIncr(this, multiplier);
    }

    /**
     * Copies current matrix and multiplies its components by a scalar value.
     * 
     * @param multiplier scalar value
     * @return new matrix with multiplied elements of current matrix
     *
     * @since 1.0.0
     */
    default Matrix mul(final float multiplier) {
        return MatrixMath.mul(this, multiplier);
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
    default Matrix divIncr(final float divisor) throws ArithmeticException {
        return MatrixMath.divIncr(this, divisor);
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
    default Matrix div(final float divisor) throws ArithmeticException {
        return MatrixMath.div(this, divisor);
    }

    /**
     * Adds the {@code addendum} matrix elements to the current matrix
     * elements.
     * 
     * @param addendum matrix to add
     * @return current matrix increased by {@code addendum} matrix
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default Matrix addIncr(final Matrix addendum) {
        return MatrixMath.addIncr(this, addendum);
    }

    /**
     * Copies current matrix and adds the {@code addendum} matrix elements to
     * its elements.
     * 
     * @param addendum matrix to add
     * @return new matrix with sum of elements of current matrix and
     *         {@code addendum} matrix
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default Matrix add(final Matrix addendum) {
        return MatrixMath.add(this, addendum);
    }

    /**
     * Subtracts the {@code subtrahend} matrix elements from the current
     * matrix elements.
     * 
     * @param subtrahend matrix to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default Matrix subIncr(final Matrix subtrahend) {
        return MatrixMath.subIncr(this, subtrahend);
    }

    /**
     * Copies current matrix and subtracts the {@code subtrahend} matrix
     * elements from its elements.
     * 
     * @param subtrahend matrix to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default Matrix sub(final Matrix subtrahend) {
        return MatrixMath.sub(this, subtrahend);
    }

    /**
     * Calculates product of current and the given matrices.
     *
     * @param m second (right) matrix
     * @return matrix, which represents product of matrices
     * @throws IllegalArgumentException if the first matrix width is not equal to
     *                                  the second matrix height
     *
     * @since 1.0.0
     */
    default Matrix prod(final Matrix m) {
        return MatrixMath.prod(this, m);
    }

    /**
     * Calculates product of current matrix and vector.
     *
     * @param vCol column vector (right)
     * @return vector, which represents product of current matrix and given vector
     * @throws IllegalArgumentException if width of the matrix is not equal to the
     *                                  vector size
     *
     * @since 1.0.0
     */
    default Vector prodCol(final Vector vCol) {
        return MatrixMath.prodCol(this, vCol);
    }

    default Vector prodColIncr(final Vector vCol) {
        return MatrixMath.prodColIncr(this, vCol);
    }

    default Vector prodRow(final Vector vRow) {
        return MatrixMath.prodRow(this, vRow);
    }

    default Vector prodRowIncr(final Vector vRow) {
        return MatrixMath.prodRowIncr(this, vRow);
    }

    /**
     * Triangulates current matrix.
     * 
     * @return current matrix, which is triangulated
     *
     * @since 1.0.0
     */
    default Matrix triangulate() {
        return MatrixMath.triangulate(this);
    }

    /**
     * Copies current matrix and triangulates it.
     * 
     * @return new matrix, which is result of triangulating of current matrix
     *
     * @since 1.0.0
     */
    default Matrix triangulated() {
        return MatrixMath.triangulated(this);
    }

    /**
     * Constructs invertible matrix from current matrix.
     *
     * @return invertible matrix
     * @throws UnsupportedOperationException if matrix is not square
     * @throws RuntimeException              if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    default Matrix inv() {
        return MatrixMath.inv(this);
    }

    /**
     * Constructs minor matrix excluding given row and column from current matrix.
     * 
     * @param r row index to exclude
     * @param c column index to exclude
     * @return minor matrix excluding given row and column
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default Matrix minorMatrix(final int r, final int c) {
        return MatrixMath.minorMatrix(this, r, c);
    }

    /**
     * Constructs matrix of cofactors (algebraic complements)
     * 
     * @return matrix of cofactors
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default Matrix cofactorMatrix() {
        final Matrix result = new Mat(this.height(), this.width());
        MatrixMath.cofactorMatrix(this);

        return result;
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
    default boolean equalsEpsilon(final Matrix m, final float eps) {
        return MatrixMath.equalsEpsilon(this, m, eps);
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
    default boolean equals(final Matrix m) {
        return MatrixMath.equals(this, m);
    }
}
