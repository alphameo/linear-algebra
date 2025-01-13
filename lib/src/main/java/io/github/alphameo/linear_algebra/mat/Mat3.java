package io.github.alphameo.linear_algebra.mat;

import java.util.Arrays;

/**
 * Default implementation of matrix 3x3 ({@code Matrix3 interface}).
 *
 * @since 1.0.0
 */
public class Mat3 implements Matrix3 {

    private final float[][] entries;

    /**
     * Constructs new matrix 3x3 with all 0.
     *
     * @since 1.0.0
     */
    public Mat3() {
        this.entries = new float[3][3];
    }

    /**
     * Constructs new matrix 3x3 using the given values.
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
     *
     * @since 1.0.0
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
     * @throws IllegalArgumentException if the given two-dimensional array cannot be
     *                                  interpreted as matrix 3x3
     *
     * @since 1.0.0
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
     * Copies the given matrix 3x3 values into new matrix 3x3.
     * 
     * @param m matrix 3x3 for copying
     *
     * @since 1.0.0
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

    @Override
    public Matrix3 clone() {
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
        return MatrixStringer.matrixToString(this);
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
        return Matrix3Math.equals(this, other);
    }

    /**
     * Constructs matrix 3x3 of with all 0 elements.
     * 
     * @return matrix 3x3 with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix3 zeroMatrix() {
        return Matrix3Math.zeroMatrix();
    }

    /**
     * Constructs square matrix 3x3 with 1 on main diagonal.
     * 
     * @return square matrix 3x3 with 1 on main diagonal
     *
     * @since 1.0.0
     */
    public static Matrix3 unitMatrix() {
        return Matrix3Math.unitMatrix();
    }
}
