package com.github.ia1phai.linear_algebra.mat;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;
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
        MatMath.swapRows(this, r1, r2);

        return this;
    }

    public Matrix swapCols(final int c1, final int c2) {
        MatMath.swapCols(this, c1, c2);

        return this;
    }

    public Matrix multiply(final float multiplier) {
        MatMath.multiply(this, multiplier);

        return this;
    }

    public Matrix divide(final float divisor) {
        MatMath.divide(this, divisor);

        return this;
    }

    public Matrix add(final Matrix m) {
        MatMath.add(this, m);

        return this;
    }

    public Matrix plus(final Matrix m) {
        return this.copy().add(m);
    }

    public Matrix subtract(final Matrix m) {
        MatMath.subtract(this, m);

        return this;
    }

    public Matrix minus(final Matrix m) {
        return this.copy().subtract(m);
    }

    public Matrix product(final Matrix m) {
        return MatMath.product(this, m);
    }

    public Vector product(final Vector v) {
        return MatMath.product(this, v);
    }

    public Matrix triangulate() {
        MatMath.triangulate(this);

        return this;
    }

    public Matrix triangularTable() {
        return this.copy().triangulate();
    }

    public float det() {
        return MatMath.det(this);
    }

    public Matrix invertible() {
        return MatMath.invertibleMatrix(this);
    }

    public Matrix minorMatrix(final int r, final int c) {
        return MatMath.minorMatrix(this, r, c);
    }

    public float cofactor(final int r, final int c) {
        return MatMath.cofactor(this, r, c);
    }

    public Matrix cofactorMatrix() {
        final Matrix result = new Mat(this.height(), this.width());
        MatMath.cofactorMatrix(this);

        return result;
    }

    public boolean isSquare() {
        return MatMath.isSquare(this);
    }

    public boolean isZeroed() {
        return MatMath.isZeroed(this);
    }

    public boolean isDiagonal() {
        return MatMath.isDiagonal(this);
    }

    public Matrix zeroMat(final int height, final int width) {
        return MatMath.zeroMat(height, width);
    }

    public Matrix unitMat(final int size) {
        return MatMath.unitMat(size);
    }

    @Override
    public boolean equalsTo(final Matrix m) {
        return MatMath.equals(this, m);
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
        return equalsTo((Matrix) obj);
    }
}
