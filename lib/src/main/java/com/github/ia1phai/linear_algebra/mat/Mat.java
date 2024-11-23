package com.github.ia1phai.linear_algebra.mat;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;
import com.github.ia1phai.linear_algebra.NumberChecker;
import com.github.ia1phai.linear_algebra.vec.Vec;
import com.github.ia1phai.linear_algebra.vec.Vector;

/**
 * Matr
 */
public class Mat implements Matrix, Equatable<Matrix>, Copyable<Mat> {

    float[][] entries;

    public Mat(final int size) {
        entries = new float[size][size];

    }

    public Mat(final float[][] entries) {
        this.entries = new float[entries.length][entries[0].length];
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].length != entries[0].length) {
                throw new IllegalArgumentException(
                        "Matrix creation denied: input data has rows with different lengths");
            }
            this.entries[i] = Arrays.copyOf(entries[i], entries[i].length);
        }
    }

    public Mat(final Matrix m) {
        entries = new float[m.height()][m.width()];
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                entries[i][j] = m.get(i, j);
            }
        }
    }

    public Mat(final int height, final int width) {
        entries = new float[height][width];
    }

    @Override
    public float get(final int row, final int col) {
        return entries[row][col];
    }

    @Override
    public void set(final int row, final int col, final float value) {
        entries[row][col] = value;
    }

    @Override
    public int width() {
        return entries[0].length;
    }

    @Override
    public int height() {
        return entries.length;
    }

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

    public Matrix transposed() {
        return this.copy().transpose();
    }

    public Matrix swapRows(final int r1, final int r2) {
        UncheckedMatrixMath.swapRows(this, r1, r2);

        return this;
    }

    public Matrix swapCols(final int c1, final int c2) {
        UncheckedMatrixMath.swapColumns(this, c1, c2);

        return this;
    }

    public Matrix multiply(final float multiplier) {
        UncheckedMatrixMath.multiply(this, multiplier);

        return this;
    }

    public Matrix divide(final float divisor) {
        UncheckedMatrixMath.divide(this, divisor);

        return this;
    }

    public Matrix add(final Matrix m) {
        checkSameSizes(this, m, "Addition denied");
        UncheckedMatrixMath.add(this, m);

        return this;
    }

    public Matrix plus(final Matrix m) {
        return this.copy().add(m);
    }

    public Matrix subtract(final Matrix m) {
        checkSameSizes(this, m, "Subtraction denied");
        UncheckedMatrixMath.subtract(this, m);

        return this;
    }

    public Matrix minus(final Matrix m) {
        return this.copy().subtract(m);
    }

    public Matrix product(final Matrix m) {
        if (this.width() == m.height()) {
            throw new IllegalArgumentException(
                    String.format("Matrix product denied: matrices with sizes %dx%d and %dx%d", this.height(),
                            this.width(), m.height(), m.width()));
        }
        final Matrix result = new Mat(this.height(), m.width());

        UncheckedMatrixMath.product(this, m, result);

        return result;
    }

    public Vector product(final Vector v) {
        if (this.width() != v.size()) {
            throw new IllegalArgumentException(
                    String.format("Matrix and vector product denied: matrix with size %dx%d and vector with size",
                            this.height(),
                            this.width(), v.size()));
        }

        final Vector result = new Vec(v.size());
        UncheckedMatrixMath.product(this, v, result);

        return result;
    }

    public Matrix triangulate() {
        UncheckedMatrixMath.triangulate(this, Math.max(this.height(), this.width()));

        return this;
    }

    public Matrix triangularTable() {
        return this.copy().triangulate();
    }

    public float det() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Determinant does not exists: matrix is not square");
        }

        return UncheckedMatrixMath.determinant(this);
    }

    public Matrix invertible() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Invertible matrix does not exists: matrix is not square");
        }

        final Matrix result = new Mat(this.height(), this.width());

        UncheckedMatrixMath.invertibleMatrix(this, result);

        return result;
    }

    public Matrix minorMatrix(final int row, final int col) {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Minors do not exist: matrix is not square");
        }

        return UncheckedMatrixMath.minorMatrix(this, row, col);
    }

    public float cofactor(final int row, final int col) {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Can not find cofactor: matrix is not square");
        }

        return UncheckedMatrixMath.cofactor(this, row, col);
    }

    public Matrix cofactorMatrix() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Cofactor matrix does not exist: matrix is not square");
        }

        final Matrix result = new Mat(this.height(), this.width());
        UncheckedMatrixMath.cofactorMatrix(this, result);

        return result;
    }

    public boolean isSquare() {
        return width() == height();
    }

    public boolean isZeroed() {
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                if (entries[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isDiagonal() {
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                if (i == j) {
                    continue;
                }
                if (Math.abs(this.get(i, j)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean equalsTo(final Matrix m) {
        checkSameSizes(this, m, "Equalizationt denied");
        return UncheckedMatrixMath.equals(this, m);
    }

    @Override
    public Mat copy() {
        final Mat result = new Mat(height(), width());

        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                result.set(i, j, this.get(i, j));
            }
        }

        return result;
    }

    private static void checkSameSizes(final Matrix m1, final Matrix m2,
            final String errMessage) {
        if (m1.width() != m2.width() || m1.height() != m2.height()) {
            throw new IllegalArgumentException(String.format("%s: matrices with different sizes (%dx%d and %dx%d)",
                    errMessage, m1.height(), m1.width(), m2.height(), m2.width()));
        }
    }
}
