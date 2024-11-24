package com.github.ia1phai.linear_algebra.mat;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;
import com.github.ia1phai.linear_algebra.vec.Vector4;

/**
 * Matr4
 */
public class Mat4 implements Matrix4, Equatable<Matrix4>, Copyable<Mat4> {

    float[][] entries;

    public Mat4() {
        this.entries = new float[4][4];
    }

    public Mat4(final float entries[][]) {
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

    public Mat4(final Matrix4 m) {
        this();
        for (Matrix4Row r : Matrix4Row.values()) {
            for (Matrix4Col c : Matrix4Col.values()) {
                this.set(r, c, m.get(r, c));
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
    public float get(final Matrix4Row row, final Matrix4Col col) {
        return entries[row.ordinal()][col.ordinal()];
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

    public Matrix4 transpose() {
        Mat4Math.transpose(this);

        return this;
    }

    public Matrix4 transposed() {
        return this.copy().transpose();
    }

    public void swapRows(final Matrix4Row r1, final Matrix4Row r2) {
        Mat4Math.swapRows(this, r1, r2);
    }

    public void swapCols(final Matrix4Col c1, final Matrix4Col c2) {
        Mat4Math.swapCols(this, c1, c2);
    }

    public Matrix4 multiply(final float multiplier) {
        Mat4Math.multiply(this, multiplier);

        return this;
    }

    public Matrix4 divide(final float divisor) {
        Mat4Math.divide(this, divisor);

        return this;
    }

    public Matrix4 add(final Matrix4 m) {
        MatMath.add(this, m);

        return this;
    }

    public Matrix4 plus(final Matrix4 m) {
        return this.copy().add(m);
    }

    public Matrix4 subtract(final Matrix4 m) {
        MatMath.subtract(this, m);

        return this;
    }

    public Matrix4 product(final Matrix4 m) {
        return Mat4Math.product(this, m);
    }

    public Vector4 product(final Vector4 v) {
        return Mat4Math.product(this, v);
    }

    public Matrix4 triangulate() {
        Mat4Math.triangulate(this);

        return this;
    }

    public Matrix triangularTable() {
        return this.copy().triangulate();
    }

    public float det() {
        return Mat4Math.det(this);
    }

    public Matrix4 invertible() {
        return Mat4Math.invertibleMatrix(this);
    }

    public Matrix minorMatrix(final int row, final int col) {
        return MatMath.minorMatrix(this, row, col);
    }

    public float cofactor(final int row, final int col) {
        return MatMath.cofactor(this, row, col);
    }

    public Matrix4 cofactorMatrix() {
        return Mat4Math.cofactorMatrix(this);
    }

    public boolean isSquare() {
        return true;
    }

    public boolean isZeroed() {
        return Mat4Math.isZeroed(this);
    }

    public boolean isDiagonal() {
        return Mat4Math.isDiagonal(this);
    }

    public Matrix4 zeroMat() {
        return Mat4Math.zeroMat();
    }

    public Matrix4 unitMat() {
        return Mat4Math.unitMat();
    }

    @Override
    public boolean equalsTo(final Matrix4 mat) {
        return MatMath.equals(this, mat);
    }

    @Override
    public Mat4 copy() {
        final Mat4 result = new Mat4();

        for (Matrix4Row r : Matrix4Row.values()) {
            for (Matrix4Col c : Matrix4Col.values()) {
                result.set(r, c, entries[r.ordinal()][c.ordinal()]);
            }
        }

        return result;
    }
}
