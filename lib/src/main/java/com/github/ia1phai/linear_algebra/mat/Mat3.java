package com.github.ia1phai.linear_algebra.mat;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;
import com.github.ia1phai.linear_algebra.vec.Vector3;

/**
 * Matr3
 */
public class Mat3 implements Matrix3, Equatable<Matrix3>, Copyable<Mat3> {

    float[][] entries;

    public Mat3() {
        this.entries = new float[3][3];
    }

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

    public Mat3(final Matrix3 m) {
        this();
        for (Matrix3Row i : Matrix3Row.values()) {
            for (Matrix3Col j : Matrix3Col.values()) {
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

    public Matrix3 transpose() {
        Mat3Math.transpose(this);

        return this;
    }

    public Matrix3 transposed() {
        return this.copy().transpose();
    }

    public void swapRows(final Matrix3Row r1, final Matrix3Row r2) {
        Mat3Math.swapRows(this, r1, r2);
    }

    public void swapCols(final Matrix3Col c1, final Matrix3Col c2) {
        Mat3Math.swapCols(this, c1, c2);
    }

    public Matrix3 multiply(final float multiplier) {
        Mat3Math.multiply(this, multiplier);

        return this;
    }

    public Matrix3 divide(final float divisor) {
        Mat3Math.divide(this, divisor);

        return this;
    }

    public Matrix3 add(final Matrix3 m) {
        MatMath.add(this, m);

        return this;
    }

    public Matrix3 plus(final Matrix3 m) {
        return this.copy().add(m);
    }

    public Matrix3 subtract(final Matrix3 m) {
        MatMath.subtract(this, m);

        return this;
    }

    public Matrix3 product(final Matrix3 m) {
        return Mat3Math.product(this, m);
    }

    public Vector3 product(final Vector3 v) {
        return Mat3Math.product(this, v);
    }

    public Matrix3 triangulate() {
        return Mat3Math.triangulate(this);
    }

    public Matrix triangularTable() {
        return this.copy().triangulate();
    }

    public float det() {
        return Mat3Math.det(this);
    }

    public Matrix3 invertible() {
        return Mat3Math.invertible(this);
    }

    public Matrix minorMatrix(final Matrix3Row r, final Matrix3Col c) {
        return MatMath.minorMatrix(this, r.ordinal(), c.ordinal());
    }

    public float cofactor(final Matrix3Row r, final Matrix3Col c) {
        return Mat3Math.cofactor(this, r, c);
    }

    public Matrix3 cofactorMatrix() {
        return Mat3Math.cofactorMatrix(this);
    }

    public boolean isSquare() {
        return true;
    }

    public boolean isZeroed() {
        return Mat3Math.isZeroed(this);
    }

    public boolean isDiagonal() {
        return Mat3Math.isDiagonal(this);
    }

    public Matrix3 zeroMat() {
        return Mat3Math.zeroMat();
    }

    public Matrix3 unitMat() {
        return Mat3Math.unitMat();
    }

    @Override
    public boolean equalsTo(final Matrix3 mat) {
        return MatMath.equals(this, mat);
    }

    @Override
    public Mat3 copy() {
        final Mat3 result = new Mat3();

        for (Matrix3Row i : Matrix3Row.values()) {
            for (Matrix3Col j : Matrix3Col.values()) {
                result.set(i, j, entries[i.ordinal()][j.ordinal()]);
            }
        }

        return result;
    }
}
