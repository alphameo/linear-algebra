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

    public Matrix3 transpose() {
        return Mat3Math.transpose(this);
    }

    public Matrix3 transposed() {
        return Mat3Math.transposed(this);
    }

    public Matrix3 swapRows(final Matrix3Row r1, final Matrix3Row r2) {
        return Mat3Math.swapRows(this, r1, r2);
    }

    public Matrix3 swapRows(final int r1, final int r2) {
        return Mat3Math.swapRows(this, r1, r2);
    }

    public Matrix3 swappedRows(final Matrix3Row r1, final Matrix3Row r2) {
        return Mat3Math.swappedRows(this, r1, r2);
    }

    public Matrix3 swappedRows(final int r1, final int r2) {
        return Mat3Math.swappedRows(this, r1, r2);
    }

    public Matrix3 swapCols(final Matrix3Col c1, final Matrix3Col c2) {
        return Mat3Math.swapCols(this, c1, c2);
    }

    public Matrix3 swapCols(final int c1, final int c2) {
        return Mat3Math.swapCols(this, c1, c2);
    }

    public Matrix3 swappedCols(final Matrix3Col c1, final Matrix3Col c2) {
        return Mat3Math.swappedCols(this, c1, c2);
    }

    public Matrix3 swappedCols(final int c1, final int c2) {
        return Mat3Math.swappedCols(this, c1, c2);
    }

    public Matrix3 mult(final float multiplier) {
        return Mat3Math.mult(this, multiplier);
    }

    public Matrix3 multiplied(final float multiplier) {
        return Mat3Math.multiplied(this, multiplier);
    }

    public Matrix3 divide(final float divisor) {
        return Mat3Math.divide(this, divisor);
    }

    public Matrix3 divided(final float divisor) {
        return Mat3Math.divided(this, divisor);
    }

    public Matrix3 add(final Matrix3 m) {
        return Mat3Math.add(this, m);
    }

    public Matrix3 added(final Matrix3 m) {
        return Mat3Math.added(this, m);
    }

    public Matrix3 sub(final Matrix3 m) {
        return Mat3Math.sub(this, m);
    }

    public Matrix3 subtracted(final Matrix3 m) {
        return Mat3Math.subtracted(this, m);
    }

    public Matrix3 prod(final Matrix3 m) {
        return Mat3Math.prod(this, m);
    }

    public Vector3 prod(final Vector3 v) {
        return Mat3Math.prod(this, v);
    }

    public Matrix3 triangulate() {
        return Mat3Math.triangulate(this);
    }

    public Matrix3 triangulated() {
        return Mat3Math.triangulated(this);
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

    public boolean square() {
        return true;
    }

    public boolean isZeroed() {
        return Mat3Math.isZeroed(this);
    }

    public boolean diagonal() {
        return Mat3Math.diagonal(this);
    }

    public Matrix4 toMat4() {
        return Mat3Math.toMat4(this);
    }

    public Matrix4 toMat4(final Matrix4Row insertionRow, final Matrix4Col insertionCol) {
        return Mat3Math.toMat4(this, insertionRow, insertionCol);
    }

    public Matrix3 zeroMat() {
        return Mat3Math.zeroMat();
    }

    public Matrix3 unitMat() {
        return Mat3Math.unitMat();
    }

    @Override
    public boolean equalsTo(final Matrix3 m) {
        return MatMath.equals(this, m);
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
        return MatMath.equals(this, (Mat) obj);
    }
}
