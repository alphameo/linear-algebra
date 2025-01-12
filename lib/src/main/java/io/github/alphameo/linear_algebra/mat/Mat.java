package io.github.alphameo.linear_algebra.mat;

import java.util.Arrays;

/**
 * Default implementation of arbitrary matrix ({@code Matrix interface}).
 *
 * @since 1.0.0
 */
public class Mat implements Matrix {

    private float[][] entries;

    /**
     * Constructs new matrix {@code height} x {@code width} with all 0.
     * 
     * @param height height of matrix for construction
     * @param width  width of matrix for construction
     *
     * @since 1.0.0
     */
    public Mat(final int height, final int width) {
        entries = new float[height][width];
    }

    /**
     * Constructs new square matrix {@code size} x {@code size} with all 0.
     * 
     * @param size height and width of matrix for construction
     *
     * @since 1.0.0
     */
    public Mat(final int size) {
        this(size, size);
    }

    /**
     * Constructs new matrix using values from {@code entries}.
     * 
     * @param entries values for matrix elements
     * @throws IllegalArgumentException if given two-dimensional array cannot be
     *                                  interpreted as rectangular matrix
     *
     * @since 1.0.0
     */
    public Mat(final float[][] entries) throws IllegalArgumentException {
        this(entries.length, entries[0].length);
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].length != entries[0].length) {
                throw new IllegalArgumentException(
                        "Matrix creation denied: input data has rows with different lengths");
            }
            this.entries[i] = Arrays.copyOf(entries[i], entries[i].length);
        }
    }

    /**
     * Copies given matrix values into new matrix.
     * 
     * @param m matrix for copying
     *
     * @since 1.0.0
     */
    public Mat(final Matrix m) {
        entries = new float[m.height()][m.width()];
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                entries[i][j] = m.get(i, j);
            }
        }
    }

    @Override
    public float get(final int r, final int c) {
        return entries[r][c];
    }

    @Override
    public void set(final int r, final int c, final float value) {
        entries[r][c] = value;
    }

    @Override
    public int width() {
        return entries[0].length;
    }

    @Override
    public int height() {
        return entries.length;
    }

    @Override
    public Matrix transpose() {
        final float[][] result = new float[entries[0].length][entries.length];
        for (int i = 0; i < entries.length; i++) {
            for (int j = 0; i < entries[0].length; j++) {
                result[j][i] = entries[i][j];
            }
        }
        entries = result;

        return this;
    }

    @Override
    public Matrix clone() {
        final Mat result = new Mat(height(), width());

        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                result.set(i, j, this.get(i, j));
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
        final Mat other = (Mat) obj;
        return MatrixMath.equals(this, other);
    }

    /**
     * Constructs matrix of given sizes with all 0 elements.
     * 
     * @param height height of matrix to be constructed
     * @param width  width of matrix to be constructed
     * @return matrix {@code height} x {@code width} with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix zeroMatrix(final int height, final int width) {
        return MatrixMath.zeroMatrix(height, width);
    }

    /**
     * Constructs square matrix of given size with 1 on main diagonal.
     * 
     * @param size height and width of matrix to be constructed
     * @return square matrix {@code size} x {@code size} with 1 on main diagonal
     *
     * @since 1.0.0
     */
    public static Matrix unitMatrix(final int size) {
        return MatrixMath.unitMatrix(size);
    }
}
