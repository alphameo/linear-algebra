package io.github.alphameo.linear_algebra.mat;

import java.util.Arrays;

import io.github.alphameo.linear_algebra.Copyable;
import io.github.alphameo.linear_algebra.Equatable;
import io.github.alphameo.linear_algebra.vec.Vector4;

/**
 * Default implementation of matrix 4x4 ({@code Matrix4 interface}).
 *
 * @since 1.0.0
 */
public class Mat4 implements Matrix4, Equatable<Matrix4>, Copyable<Mat4> {

    private final float[][] entries;

    /**
     * Constructs new matrix 3x3 with all 0.
     *
     * @since 1.0.0
     */
    public Mat4() {
        this.entries = new float[4][4];
    }

    /**
     * Constructs new matrix 4x4 using given values.
     * 
     * @param m00 element under row = 0, column = 0
     * @param m01 element under row = 0, column = 1
     * @param m02 element under row = 0, column = 2
     * @param m03 element under row = 0, column = 3
     * @param m10 element under row = 1, column = 0
     * @param m11 element under row = 1, column = 1
     * @param m12 element under row = 1, column = 2
     * @param m13 element under row = 1, column = 3
     * @param m20 element under row = 2, column = 0
     * @param m21 element under row = 2, column = 1
     * @param m22 element under row = 2, column = 2
     * @param m23 element under row = 2, column = 3
     * @param m30 element under row = 3, column = 0
     * @param m31 element under row = 3, column = 1
     * @param m32 element under row = 3, column = 2
     * @param m33 element under row = 3, column = 3
     *
     * @since 1.0.0
     */
    public Mat4(
            final float m00, final float m01, final float m02, final float m03,
            final float m10, final float m11, final float m12, final float m13,
            final float m20, final float m21, final float m22, final float m23,
            final float m30, final float m31, final float m32, final float m33) {
        this();
        entries[0][0] = m00;
        entries[0][1] = m01;
        entries[0][2] = m02;
        entries[0][3] = m03;
        entries[1][0] = m10;
        entries[1][1] = m11;
        entries[1][2] = m12;
        entries[1][3] = m13;
        entries[2][0] = m20;
        entries[2][1] = m21;
        entries[2][2] = m22;
        entries[2][3] = m23;
        entries[3][0] = m30;
        entries[3][1] = m31;
        entries[3][2] = m32;
        entries[3][3] = m33;
    }

    /**
     * Constructs new matrix 4x4 using values from {@code entries}.
     * 
     * @param entries values for matrix elements
     * @throws IllegalArgumentException if given two dimensional array cannot be
     *                                  interpreted as matrix 4x4
     *
     * @since 1.0.0
     */
    public Mat4(final float entries[][]) throws IllegalArgumentException {
        this();
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].length != entries[0].length) {
                throw new IllegalArgumentException(
                        "Matrix 4x4 creation denied: input data has rows with different lengths");
            }
            this.entries[i] = Arrays.copyOf(entries[i], entries[i].length);
        }
        if (entries.length != 4 || entries[0].length != 4) {
            throw new IllegalArgumentException(String.format(
                    "Matrix 4x4 creation denied: input data has size %dx%d", entries.length,
                    entries[0].length));
        }
    }

    /**
     * Copies given matrix 4x4 values into new matrix 4x4.
     * 
     * @param m matrix 4x4 for copying
     *
     * @since 1.0.0
     */
    public Mat4(final Matrix4 m) {
        this();
        for (final Matrix4Row r : Matrix4Row.values()) {
            for (final Matrix4Col c : Matrix4Col.values()) {
                this.set(r, c, m.get(r, c));
            }
        }
    }

    @Override
    public float get(final int r, final int c) throws IllegalArgumentException {
        if (r < 0 || r > 3) {
            throw new IllegalArgumentException(String.format("Row %d is out of Mat3 bounds", r));
        }
        if (c < 0 || c > 3) {
            throw new IllegalArgumentException(String.format("Column %d is out of Mat3 bounds", c));
        }

        return entries[r][c];
    }

    @Override
    public float get(final Matrix4Row r, final Matrix4Col c) {
        return entries[r.ordinal()][c.ordinal()];
    }

    @Override
    public void set(final int r, final int c, final float value) throws IllegalArgumentException {
        if (r < 0 || r > 3) {
            throw new IllegalArgumentException(String.format("Row %d is out of Mat3 bounds", r));
        }
        if (c < 0 || c > 3) {
            throw new IllegalArgumentException(String.format("Column %d is out of Mat3 bounds", c));
        }

        entries[r][c] = value;
    }

    @Override
    public void set(final Matrix4Row r, final Matrix4Col c, final float value) {
        entries[r.ordinal()][c.ordinal()] = value;
    }

    @Override
    public int width() {
        return 4;
    }

    @Override
    public int height() {
        return 4;
    }

    /**
     * Transposes current matrix.
     *
     * @return current transposed matrix
     *
     * @since 1.0.0
     */
    public Matrix4 transpose() {
        return Mat4Math.transpose(this);
    }

    /**
     * Construts transposed matrix from current matrix.
     *
     * @return new matrix, which is result of transposing of current square matrix
     *
     * @since 1.0.0
     */
    public Matrix4 transposed() {
        return this.copy().transpose();
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
    public Matrix4 swapRows(final Matrix4Row r1, final Matrix4Row r2) {
        return Mat4Math.swapRows(this, r1, r2);
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
    public Matrix4 swapRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Mat4Math.swapRows(this, r1, r2);
    }

    /**
     * Copies current matrix and safely swaps its rows.
     * 
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix with swapped rows of curren matrix
     *
     * @since 1.0.0
     */
    public Matrix4 swappedRows(final Matrix4Row r1, final Matrix4Row r2) {
        return Mat4Math.swappedRows(this, r1, r2);
    }

    /**
     * Copies current matrix and swaps its rows.
     * 
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return new matrix with swapped rows of curren matrix
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    public Matrix4 swappedRows(final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return Mat4Math.swappedRows(this, r1, r2);
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
    public Matrix4 swapCols(final Matrix4Col c1, final Matrix4Col c2) {
        return Mat4Math.swapCols(this, c1, c2);
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
    public Matrix4 swapCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Mat4Math.swapCols(this, c1, c2);
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
    public Matrix4 swappedCols(final Matrix4Col c1, final Matrix4Col c2) {
        return Mat4Math.swappedCols(this, c1, c2);
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
    public Matrix4 swappedCols(final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return Mat4Math.swappedCols(this, c1, c2);
    }

    /**
     * Multiplies matrix elements by a scalar value.
     * 
     * @param multiplier scalar value
     * @return current matrix with multiplied elements
     *
     * @since 1.0.0
     */
    public Matrix4 mult(final float multiplier) {
        return Mat4Math.mult(this, multiplier);
    }

    /**
     * Copies current matrix and multiplies its components by a scalar value.
     * 
     * @param multiplier scalar value
     * @return new matrix with multiplied elements of current matrix
     *
     * @since 1.0.0
     */
    public Matrix4 multiplied(final float multiplier) {
        return Mat4Math.multiplied(this, multiplier);
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
    public Matrix4 divide(final float divisor) throws ArithmeticException {
        return Mat4Math.divide(this, divisor);
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
    public Matrix4 divided(final float divisor) throws ArithmeticException {
        return Mat4Math.divide(this, divisor);
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
    public Matrix4 add(final Matrix4 addendum) {
        return Mat4Math.add(this, addendum);
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
    public Matrix4 added(final Matrix4 addendum) {
        return Mat4Math.added(this, addendum);
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
    public Matrix4 sub(final Matrix4 subtrahend) {
        return Mat4Math.sub(this, subtrahend);
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
    public Matrix4 subtracted(final Matrix4 subtrahend) {
        return Mat4Math.subtracted(this, subtrahend);
    }

    /**
     * Calculates product of current and given matrices.
     *
     * @param m second (right) matrix 4x4
     * @return matrix, which represents product of matrices
     *
     * @since 1.0.0
     */
    public Matrix4 prod(final Matrix4 m) {
        return Mat4Math.prod(this, m);
    }

    /**
     * Calculates product of current matrix and vector.
     *
     * @param v column vector of size 4 (right)
     * @return vector of size 4, which represents product of current matrix and
     *         given vector
     *
     * @since 1.0.0
     */
    public Vector4 prod(final Vector4 v) {
        return Mat4Math.prod(this, v);
    }

    /**
     * Triangulates current matrix.
     * 
     * @return current matrix, which is triangulated
     *
     * @since 1.0.0
     */
    public Matrix4 triangulate() {
        return Mat4Math.triangulate(this);
    }

    /**
     * Copies current matrix and triangulates it.
     * 
     * @return new matrix, which is result of triangulating of current matrix
     *
     * @since 1.0.0
     */
    public Matrix4 triangulated() {
        return Mat4Math.triangulated(this);
    }

    /**
     * Calculates matrix determinant.
     * 
     * @return matrix determinant
     *
     * @since 1.0.0
     */
    public float det() {
        return Mat4Math.det(this);
    }

    /**
     * Constructs invertible matrix from current matrix.
     *
     * @return invertible matrix
     * @throws RuntimeException if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    public Matrix4 invertible() throws RuntimeException {
        return Mat4Math.invertible(this);
    }

    /**
     * Safely constructs minor matrix excluding given row and column from current
     * matrix.
     * 
     * @param r row to exclude
     * @param c column to exclude
     * @return minor matrix excluding given row and column
     *
     * @since 1.0.0
     */
    public Matrix3 minorMatrix(final Matrix4Row r, final Matrix4Col c) {
        return Mat4Math.minorMatrix(this, r, c);
    }

    /**
     * Constructs minor matrix excluding given row and column from current matrix.
     * 
     * @param r row index to exclude
     * @param c column index to exclude
     * @return minor matrix excluding given row and column
     *
     * @since 1.0.0
     */
    public Matrix3 minorMatrix(final int r, final int c) {
        return Mat4Math.minorMatrix(this, r, c);
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
    public float cofactor(final Matrix4Row r, final Matrix4Col c) {
        return Mat4Math.cofactor(this, r, c);
    }

    /**
     * Calculates cofactor (algebraic complement) from current matrix for position
     * of given row and column.
     * 
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from given positions in current matrix
     *
     * @since 1.0.0
     */
    public float cofactor(final int r, final int c) {
        return Mat4Math.cofactor(this, r, c);
    }

    /**
     * Constructs matrix of cofactors (algebraic complements)
     * 
     * @return matrix of cofactors
     *
     * @since 1.0.0
     */
    public Matrix4 cofactorMatrix() {
        return Mat4Math.cofactorMatrix(this);
    }

    /**
     * Returns true, because matrix is square.
     * 
     * @return {@code true}
     *
     * @since 1.0.0
     */
    public boolean square() {
        return true;
    }

    /**
     * Returns {@code true} if matrix elements are approximately equal 0.
     * 
     * @return {@code true} if matrix elements are approximately equal 0, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
     */
    public boolean isZeroed() {
        return Mat4Math.isZeroed(this);
    }

    /**
     * Returns {@code true} if matrix is diagonal.
     * 
     * @return {@code true} if matrix is square diagonal, and {@code false}
     *         otherwise
     *
     * @since 1.0.0
     */
    public boolean diagonal() {
        return Mat4Math.diagonal(this);
    }

    @Override
    public boolean equalsTo(final Matrix4 m) {
        return MatMath.equals(this, m);
    }

    @Override
    public boolean equalsEpsilonTo(final Matrix4 other, final float eps) {
        return Mat4Math.equalsEpsilon(this, other, eps);
    }

    @Override
    public Mat4 copy() {
        final Mat4 result = new Mat4();

        for (final Matrix4Row r : Matrix4Row.values()) {
            for (final Matrix4Col c : Matrix4Col.values()) {
                result.set(r, c, entries[r.ordinal()][c.ordinal()]);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return MatStringer.matrixToString(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(entries);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mat4 other = (Mat4) obj;
        return Mat4Math.equals(this, other);
    }

    /**
     * Constructs matrix 4x4 of with all 0 elements.
     * 
     * @return matrix 4x4 with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix4 zeroMat() {
        return Mat4Math.zeroMat();
    }

    /**
     * Constructs square matrix 4x4 with 1 on main diagonal.
     * 
     * @return square matrix 4x4 with 1 on main diagonal
     *
     * @since 1.0.0
     */
    public static Matrix4 unitMat() {
        return Mat4Math.unitMat();
    }
}
