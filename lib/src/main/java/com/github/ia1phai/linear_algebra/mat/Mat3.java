package com.github.ia1phai.linear_algebra.mat;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;
import com.github.ia1phai.linear_algebra.vec.Vector3;

/**
 * Default implementation of matrix 3x3 ({@code Matrix3 interface}).
 */
public class Mat3 implements Matrix3, Equatable<Matrix3>, Copyable<Mat3> {

    private final float[][] entries;

    /**
     * Constructs new matrix 3x3 with all 0.
     */
    public Mat3() {
        this.entries = new float[3][3];
    }

    /**
     * Constructs new matrix 3x3 using given values.
     * 
     * @param m00 element under row = 0, column = 0
     * @param m01 element under row = 0, column = 1
     * @param m02 element under row = 0, column = 2
     * @param m10 element under row = 1, column = 0
     * @param m11 element under row = 1, column = 1
     * @param m12 element under row = 1, column = 2
     * @param m20 element under row = 2, column = 0
     * @param m21 element under row = 2, column = 1
     * @param m22 element under row = 2, column = 2
     */
    public Mat3(
            final float m00, final float m01, final float m02,
            final float m10, final float m11, final float m12,
            final float m20, final float m21, final float m22) {
        this();
        entries[0][0] = m00;
        entries[0][1] = m01;
        entries[0][2] = m02;
        entries[1][0] = m10;
        entries[1][1] = m11;
        entries[1][2] = m12;
        entries[2][0] = m20;
        entries[2][1] = m21;
        entries[2][2] = m22;
    }

    /**
     * Constructs new matrix 3x3 using values from {@code entries}.
     * 
     * @param entries values for matrix elements
     * @throws IllegalArgumentException if given two dimensional array cannot be
     *                                  interpreted as matrix 3x3
     */
    public Mat3(final float entries[][]) {
        this();
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].length != entries[0].length) {
                throw new IllegalArgumentException(
                        "Matrix 3x3 creation denied: input data has rows with different lengths");
            }
            this.entries[i] = Arrays.copyOf(entries[i], entries[i].length);
        }
        if (entries.length != 3 || entries[0].length != 3) {
            throw new IllegalArgumentException(String.format(
                    "Matrix 3x3 creation denied: input data has size %dx%d", entries.length,
                    entries[0].length));
        }
    }

    /**
     * Copies given matrix 3x3 values into new matrix 3x3.
     * 
     * @param m matrix 3x3 for copying
     */
    public Mat3(final Matrix3 m) {
        this();
        for (final Matrix3Row i : Matrix3Row.values()) {
            for (final Matrix3Col j : Matrix3Col.values()) {
                this.set(i, j, m.get(i, j));
            }
        }
    }

    @Override
    public float get(final int r, final int c) {
        if (r < 0 || r > 3) {
            throw new IllegalArgumentException(String.format("Row %d is out of Mat3 bounds", r));
        }
        if (c < 0 || c > 3) {
            throw new IllegalArgumentException(String.format("Column %d is out of Mat3 bounds", c));
        }

        return entries[r][c];
    }

    @Override
    public float get(final Matrix3Row r, final Matrix3Col c) {
        return entries[r.ordinal()][c.ordinal()];
    }

    @Override
    public void set(final int r, final int c, final float value) {
        if (r < 0 || r > 3) {
            throw new IllegalArgumentException(String.format("Row %d is out of Mat3 bounds", r));
        }
        if (c < 0 || c > 3) {
            throw new IllegalArgumentException(String.format("Column %d is out of Mat3 bounds", c));
        }

        entries[r][c] = value;
    }

    @Override
    public void set(final Matrix3Row r, final Matrix3Col c, final float value) {
        entries[r.ordinal()][c.ordinal()] = value;
    }

    @Override
    public int width() {
        return 3;
    }

    @Override
    public int height() {
        return 3;
    }

    /**
     * Transposes current matrix.
     *
     * @return current transposed matrix
     */
    public Matrix3 transpose() {
        return Mat3Math.transpose(this);
    }

    /**
     * Construts transposed matrix from current matrix.
     *
     * @return new matrix, which is result of transposing of current square matrix
     */
    public Matrix3 transposed() {
        return Mat3Math.transposed(this);
    }

    /**
     * Safely swaps rows of matrix
     *
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return current matrix with swapped rows
     */
    public Matrix3 swapRows(final Matrix3Row r1, final Matrix3Row r2) {
        return Mat3Math.swapRows(this, r1, r2);
    }

    /**
     * Swaps rows of matrix
     *
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return current matrix with swapped rows
     * @throws Exception if any row index is out of bounds
     */
    public Matrix3 swapRows(final int r1, final int r2) {
        return Mat3Math.swapRows(this, r1, r2);
    }

    /**
     * Copies current matrix and safely swaps its rows.
     * 
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix with swapped rows of curren matrix
     */
    public Matrix3 swappedRows(final Matrix3Row r1, final Matrix3Row r2) {
        return Mat3Math.swappedRows(this, r1, r2);
    }

    /**
     * Copies current matrix and swaps its rows.
     * 
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return new matrix with swapped rows of curren matrix
     * @throws Exception if any row index is out of bounds
     */
    public Matrix3 swappedRows(final int r1, final int r2) {
        return Mat3Math.swappedRows(this, r1, r2);
    }

    /**
     * Safely swaps columns of matrix.
     *
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return current matrix with swapped columns
     */
    public Matrix3 swapCols(final Matrix3Col c1, final Matrix3Col c2) {
        return Mat3Math.swapCols(this, c1, c2);
    }

    /**
     * Swaps columns of matrix.
     *
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return current matrix with swapped columns
     * @throws Exception if any column index is out of bounds
     */
    public Matrix3 swapCols(final int c1, final int c2) {
        return Mat3Math.swapCols(this, c1, c2);
    }

    /**
     * Copies current matrix and safely swaps its columns.
     *
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return new matrix with swapped columns of current matrix
     */
    public Matrix3 swappedCols(final Matrix3Col c1, final Matrix3Col c2) {
        return Mat3Math.swappedCols(this, c1, c2);
    }

    /**
     * Copies current matrix and swaps its columns.
     *
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return new matrix with swapped columns of current matrix
     * @throws Exception if any column index is out of bounds
     */
    public Matrix3 swappedCols(final int c1, final int c2) {
        return Mat3Math.swappedCols(this, c1, c2);
    }

    /**
     * Multiplies matrix elements by a scalar value.
     * 
     * @param multiplier scalar value
     * @return current matrix with multiplied elements
     */
    public Matrix3 mult(final float multiplier) {
        return Mat3Math.mult(this, multiplier);
    }

    /**
     * Copies current matrix and multiplies its components by a scalar value.
     * 
     * @param multiplier scalar value
     * @return new matrix with multiplied elements of current matrix
     */
    public Matrix3 multiplied(final float multiplier) {
        return Mat3Math.multiplied(this, multiplier);
    }

    /**
     * Divides matrix elements by a scalar value.
     * 
     * @param divisor scalar value
     * @return current matrix with divided elements
     * @throws IllegalArgumentException if {@code divisor} approximately equals 0
     */
    public Matrix3 divide(final float divisor) {
        return Mat3Math.divide(this, divisor);
    }

    /**
     * Copies current matrix and divides its components by a scalar value.
     *
     * @param divisor scalar value
     * @return new matrix with divided elements of current matrix
     * @throws IllegalArgumentException if {@code divisor} approximately equals 0
     */
    public Matrix3 divided(final float divisor) {
        return Mat3Math.divided(this, divisor);
    }

    /**
     * Adds the {@code addendum} matrix elements to the current matrix
     * elements.
     * 
     * @param addendum matrix 3x3 to add
     * @return current matrix increased by {@code addendum} matrix
     */
    public Matrix3 add(final Matrix3 addendum) {
        return Mat3Math.add(this, addendum);
    }

    /**
     * Copies current matrix and adds the {@code addendum} matrix elements to
     * its elements.
     * 
     * @param addendum matrix 3x3 to add
     * @return new matrix with sum of elements of current matrix and
     *         {@code addendum} matrix
     */
    public Matrix3 added(final Matrix3 addendum) {
        return Mat3Math.added(this, addendum);
    }

    /**
     * Subtracts the {@code subtrahend} matrix elements from the current
     * matrix elements.
     * 
     * @param subtrahend matrix 3x3 to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     */
    public Matrix3 sub(final Matrix3 subtrahend) {
        return Mat3Math.sub(this, subtrahend);
    }

    /**
     * Copies current matrix and subtracts the {@code subtrahend} matrix
     * elements from its elements.
     * 
     * @param subtrahend matrix 3x3 to subtract
     * @return current matrix subtracted by {@code addendum} matrix
     */
    public Matrix3 subtracted(final Matrix3 subtrahend) {
        return Mat3Math.subtracted(this, subtrahend);
    }

    /**
     * Calculates product of current and given matrices.
     *
     * @param m second (right) matrix 3x3
     * @return matrix, which represents product of matrices
     */
    public Matrix3 prod(final Matrix3 m) {
        return Mat3Math.prod(this, m);
    }

    /**
     * Calculates product of current matrix and vector.
     *
     * @param v column vector of size 3 (right)
     * @return vector of size 3, which represents product of current matrix and
     *         given vector
     */
    public Vector3 prod(final Vector3 v) {
        return Mat3Math.prod(this, v);
    }

    /**
     * Triangulates current matrix.
     * 
     * @return current matrix, which is triangulated
     */
    public Matrix3 triangulate() {
        return Mat3Math.triangulate(this);
    }

    /**
     * Copies current matrix and triangulates it.
     * 
     * @return new matrix, which is result of triangulating of current matrix
     */
    public Matrix3 triangulated() {
        return Mat3Math.triangulated(this);
    }

    /**
     * Calculates matrix determinant.
     * 
     * @return matrix determinant
     */
    public float det() {
        return Mat3Math.det(this);
    }

    /**
     * Constructs invertible matrix from current matrix.
     *
     * @return invertible matrix
     * @throws RuntimeException if matrix determinant equals to 0
     */
    public Matrix3 invertible() {
        return Mat3Math.invertible(this);
    }

    /**
     * Safely constructs minor matrix excluding given row and column from current
     * matrix.
     * 
     * @param r row to exclude
     * @param c column to exclude
     * @return minor matrix excluding given row and column
     */
    public Matrix minorMatrix(final Matrix3Row r, final Matrix3Col c) {
        return Mat3Math.minorMatrix(this, r, c);
    }

    /**
     * Constructs minor matrix excluding given row and column from current matrix.
     * 
     * @param r row index to exclude
     * @param c column index to exclude
     * @return minor matrix excluding given row and column
     */
    public Matrix minorMatrix(final int r, final int c) {
        return Mat3Math.minorMatrix(this, r, c);
    }

    /**
     * Safely calculates cofactor (algebraic complement) from current matrix for
     * position of given row and column.
     * 
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from given positions in current matrix
     */
    public float cofactor(final Matrix3Row r, final Matrix3Col c) {
        return Mat3Math.cofactor(this, r, c);
    }

    /**
     * Calculates cofactor (algebraic complement) from current matrix for position
     * of given row and column.
     * 
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from given positions in current matrix
     */
    public float cofactor(final int r, final int c) {
        return Mat3Math.cofactor(this, r, c);
    }

    /**
     * Constructs matrix of cofactors (algebraic complements)
     * 
     * @return matrix of cofactors
     */
    public Matrix3 cofactorMatrix() {
        return Mat3Math.cofactorMatrix(this);
    }

    /**
     * Returns true, because matrix is square.
     * 
     * @return {@code true}
     */
    public boolean square() {
        return true;
    }

    /**
     * Returns {@code true} if matrix elements are approximately equal 0.
     * 
     * @return {@code true} if matrix elements are approximately equal 0, and
     *         {@code false} otherwise
     */
    public boolean isZeroed() {
        return Mat3Math.isZeroed(this);
    }

    /**
     * Returns {@code true} if matrix is diagonal.
     * 
     * @return {@code true} if matrix is square diagonal, and {@code false}
     *         otherwise
     */
    public boolean diagonal() {
        return Mat3Math.diagonal(this);
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
     */
    public Matrix4 toMat4() {
        return Mat3Math.toMat4(this);
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
     */
    public Matrix4 toMat4(final Matrix4Row insertionRow, final Matrix4Col insertionCol) {
        return Mat3Math.toMat4(this, insertionRow, insertionCol);
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
     */
    public Matrix4 toMat4(final int insertionRow, final int insertionCol) {
        return Mat3Math.toMat4(this, insertionRow, insertionCol);
    }

    @Override
    public boolean equalsTo(final Matrix3 m) {
        return MatMath.equals(this, m);
    }

    @Override
    public boolean equalsEpsilonTo(final Matrix3 other, final float eps) {
        return Mat3Math.equalsEpsilon(this, other, eps);
    }

    @Override
    public Mat3 copy() {
        final Mat3 result = new Mat3();

        for (final Matrix3Row i : Matrix3Row.values()) {
            for (final Matrix3Col j : Matrix3Col.values()) {
                result.set(i, j, entries[i.ordinal()][j.ordinal()]);
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
        final Mat3 other = (Mat3) obj;
        return Mat3Math.equals(this, other);
    }

    /**
     * Constructs matrix 3x3 of with all 0 elements.
     * 
     * @return matrix 3x3 with all 0 elements
     */
    public static Matrix3 zeroMat() {
        return Mat3Math.zeroMat();
    }

    /**
     * Constructs square matrix 3x3 with 1 on main diagonal.
     * 
     * @return square matrix 3x3 with 1 on main diagonal
     */
    public static Matrix3 unitMat() {
        return Mat3Math.unitMat();
    }
}
