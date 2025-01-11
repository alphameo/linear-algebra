package io.github.alphameo.linear_algebra.mat;

import java.util.Arrays;

/**
 * Default implementation of matrix 4x4 ({@code Matrix4 interface}).
 *
 * @since 1.0.0
 */
public class Mat4 implements Matrix4 {

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
     * @throws IllegalArgumentException if given two-dimensional array cannot be
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

    @Override
    public Matrix4 clone() {
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
        final Mat4 other = (Mat4) obj;
        return Matrix4Math.equals(this, other);
    }

    /**
     * Constructs matrix 4x4 of with all 0 elements.
     * 
     * @return matrix 4x4 with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix4 zeroMat() {
        return Matrix4Math.zeroMat();
    }

    /**
     * Constructs square matrix 4x4 with 1 on main diagonal.
     * 
     * @return square matrix 4x4 with 1 on main diagonal
     *
     * @since 1.0.0
     */
    public static Matrix4 unitMat() {
        return Matrix4Math.unitMat();
    }
}
