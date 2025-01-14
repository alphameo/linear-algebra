package io.github.alphameo.linear_algebra.mat;

import io.github.alphameo.linear_algebra.vec.Vector;

/**
 * Interface for arbitrary matrix.
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
     * @param value component value to be set
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
     * Creates and returns a copy of this matrix.
     * 
     * @return copy of matrix {@code this}
     */
    Matrix clone();

    /**
     * Transposes this matrix and returns it.
     *
     * @return transposed matrix {@code this}
     *
     * @since 1.0.0
     */
    Matrix transpose() throws IllegalArgumentException;

    /**
     * Returns the result of the transpose operation of this matrix.
     *
     * @return new matrix with elements of transposed matrix {@code this}
     *
     * @since 1.0.0
     */
    default Matrix transposed() {
        return MatrixMath.transposed(this);
    }

    /**
     * Swaps the rows of this matrix with the given indices and returns it.
     *
     * @param r1 first row index for swapping
     * @param r2 second row index for swapping
     * @return matrix {@code this} with swapped rows
     *
     * @since 1.0.0
     */
    default Matrix swapRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return MatrixMath.swapRows(this, r1, r2);
    }

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
    default Matrix swappedRows(final int r1, final int r2) {
        return MatrixMath.swappedRows(this, r1, r2);
    }

    /**
     * Swaps the columns of this matrix with the given indices and returns it.
     *
     * @param c1 first column index for swapping
     * @param c2 second column index for swapping
     * @return matrix {@code this} with swapped columns
     *
     * @since 1.0.0
     */
    default Matrix swapCols(final int c1, final int c2) {
        return MatrixMath.swapCols(this, c1, c2);
    }

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
    default Matrix swappedCols(final int c1, final int c2) {
        return MatrixMath.swappedCols(this, c1, c2);
    }

    /**
     * Multiplies elements of this matrix by a scalar value and returns it.
     * 
     * @param multiplier scalar value
     * @return matrix {@code this} multiplied by {@code multiplier}
     *
     * @since 1.0.0
     */
    default Matrix mulAsgn(final float multiplier) {
        return MatrixMath.mulAsgn(this, multiplier);
    }

    /**
     * Returns the result of multiplying the elements of this matrix by a
     * scalar value.
     * 
     * @param multiplier scalar value
     * @return new matrix with components of matrix {@code this} multiplied by
     *         {@code multiplier}
     *
     * @since 1.0.0
     */
    default Matrix mul(final float multiplier) {
        return MatrixMath.mul(this, multiplier);
    }

    /**
     * Divides elements of this matrix by a scalar value and returns it.
     * 
     * @param divisor scalar value
     * @return matrix {@code this} divided by {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    default Matrix divAsgn(final float divisor) throws ArithmeticException {
        return MatrixMath.divAsgn(this, divisor);
    }

    /**
     * Returns the result of dividing the elements of this matrix by a scalar value.
     *
     * @param divisor scalar value
     * @return new matrix with elements of matrix {@code this} divided by
     *         {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    default Matrix div(final float divisor) throws ArithmeticException {
        return MatrixMath.div(this, divisor);
    }

    /**
     * Adds the components of the addendum matrix to the components of this
     * matrix and returns it.
     * 
     * @param addendum matrix to add
     * @return matrix {@code this} increased by matrix {@code addendum}
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default Matrix addAsgn(final Matrix addendum) throws IllegalArgumentException {
        return MatrixMath.addAsgn(this, addendum);
    }

    /**
     * Returns the result of adding the elements of the addendum matrix to the
     * elements of this matrix.
     * 
     * @param addendum matrix to add
     * @return new matrix with the sum of matrix {@code this} and matrix
     *         {@code addendum}
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default Matrix add(final Matrix addendum) throws IllegalArgumentException {
        return MatrixMath.add(this, addendum);
    }

    /**
     * Subtracts elements of the subtrahend matrix from the elements of this matrix
     * and returns it.
     * 
     * @param subtrahend matrix to subtract
     * @return matrix {@code this} reduced by matrix {@code subtrahend}
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default Matrix subAsgn(final Matrix subtrahend) throws IllegalArgumentException {
        return MatrixMath.subAsgn(this, subtrahend);
    }

    /**
     * Returns the result of subtracting the elements of the subtrahend matrix
     * from the elements of this matrix.
     * 
     * @param subtrahend matrix to subtract
     * @return new matrix with result of subtracting matrix {@code subtrahend} from
     *         matrix {@code this}
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default Matrix sub(final Matrix subtrahend) throws IllegalArgumentException {
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
    default Matrix prod(final Matrix m) throws IllegalArgumentException {
        return MatrixMath.prod(this, m);
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
    default Vector prod(final Vector vCol) throws IllegalArgumentException {
        return MatrixMath.prodCol(this, vCol);
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
    default Vector prodCol(final Vector vCol) throws IllegalArgumentException {
        return MatrixMath.prodCol(this, vCol);
    }

    /**
     * Returns the result of product of the given vector-row and this matrix.
     *
     * @param vRow column vector (left)
     * @return new vector with result of product of vector {@code vCol} and matrix
     *         {@code this}
     * @throws IllegalArgumentException if height of the given matrix is not equal
     *                                  to the dimension of the given vector-row
     *
     * @since 3.0.0
     */
    default Vector prodRow(final Vector vRow) {
        return MatrixMath.prodRow(this, vRow);
    }

    /**
     * Triangulates this matrix and returns it.
     * 
     * @return triangulated matrix {@code this}
     *
     * @since 1.0.0
     */
    default Matrix triangulate() {
        return MatrixMath.triangulate(this);
    }

    /**
     * Returns result of triangulation of this matrix.
     * 
     * @param m matrix to be triangulated
     * @return new matrix, with elements of triangulated matrix {@code this}
     *
     * @since 1.0.0
     */
    default Matrix triangulated() {
        return MatrixMath.triangulated(this);
    }

    /**
     * Returns determinant of this square matrix calculated via cofactors
     * (not blazingly fast).
     * 
     * @return determinant of the matrix {@code this}
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default float detCof() throws UnsupportedOperationException {
        return MatrixMath.detCof(this);
    }

    /**
     * Returns determinant of this matrix calculated via triangular table
     * (blazingly fast).
     * 
     * @return determinant of matrix {@code m}
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default float det() throws UnsupportedOperationException {
        return MatrixMath.det(this);
    }

    /**
     * Returns invertible matrix of this matrix.
     *
     * @return new invertible matrix for matrix {@code this}
     * @throws UnsupportedOperationException if matrix is not square
     * @throws RuntimeException              if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    default Matrix inv() throws UnsupportedOperationException, RuntimeException {
        return MatrixMath.inv(this);
    }

    /**
     * Returns minor matrix from this matrix excluding given row and column
     * from given matrix.
     * 
     * @param r row index to exclude
     * @param c column index to exclude
     * @return new minor matrix excluding row {@code r} and column {@code c}
     *         from matrix {@code this}
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default Matrix minorMatrix(final int r, final int c) throws UnsupportedOperationException {
        return MatrixMath.minorMatrix(this, r, c);
    }

    /**
     * Returns cofactor (algebraic complement) from this matrix for position of
     * given row and column.
     * 
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value for row {@code r} and column {@code c} for the given
     *         positions in this matrix
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default float cofactor(final int r, final int c) throws UnsupportedOperationException {
        return MatrixMath.cofactor(this, r, c);
    }

    /**
     * Returns matrix of cofactors (algebraic complements) for this matrix.
     * 
     * @return new matrix of cofactors for matrix {@code this}
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    default Matrix cofactorMatrix() throws UnsupportedOperationException {
        final Matrix result = new Mat(this.height(), this.width());
        MatrixMath.cofactorMatrix(this);

        return result;
    }

    /**
     * Returns {@code true} if this matrix is square.
     * 
     * @return {@code true} if matrix {@code this} is square, and {@code false}
     *         otherwise.
     *
     * @since 1.0.0
     */
    default boolean square() {
        return MatrixMath.square(this);
    }

    /**
     * Returns {@code true} if elements of this matrix are approximately equal 0.
     * 
     * @return {@code true} if elements of matrix {@code this} are approximately
     *         equal 0, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean zeroed() {
        return MatrixMath.zeroed(this);
    }

    /**
     * Returns {@code true} if this matrix is diagonal.
     * 
     * @return {@code true} if matrix {@code this} is square diagonal, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean diagonal() {
        return MatrixMath.diagonal(this);
    }

    /**
     * Returns {@code true} if elements of matrices are equal within
     * {@code epsilon} tolerance.
     * 
     * @param m   second matrix for comparison
     * @param eps tolerance
     * @return {@code true} if all elements of matrices are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default boolean equalsEpsilon(final Matrix m, final float eps) throws IllegalArgumentException {
        return MatrixMath.equalsEpsilon(this, m, eps);
    }

    /**
     * Returns {@code true} if the elements of the given matrices are approximately
     * equal.
     * 
     * @param m second matrix for comparison
     * @return {@code true} if all elements of matrices are approximately equal, and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    default boolean equals(final Matrix m) throws IllegalArgumentException {
        return MatrixMath.equals(this, m);
    }
}
