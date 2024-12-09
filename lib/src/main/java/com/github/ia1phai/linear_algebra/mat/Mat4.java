package com.github.ia1phai.linear_algebra.mat;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;
import com.github.ia1phai.linear_algebra.vec.Vector4;

/**
 * Mat4
 */
public class Mat4 implements Matrix4, Equatable<Matrix4>, Copyable<Mat4> {

    private final float[][] entries;

    public Mat4() {
        this.entries = new float[4][4];
    }

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
        for (final Matrix4Row r : Matrix4Row.values()) {
            for (final Matrix4Col c : Matrix4Col.values()) {
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
    public float get(final Matrix4Row r, final Matrix4Col c) {
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
        return Mat4Math.transpose(this);
    }

    public Matrix4 transposed() {
        return this.copy().transpose();
    }

    public Matrix4 swapRows(final Matrix4Row r1, final Matrix4Row r2) {
        return Mat4Math.swapRows(this, r1, r2);
    }

    public Matrix4 swapRows(final int r1, final int r2) {
        return Mat4Math.swapRows(this, r1, r2);
    }

    public Matrix4 swappedRows(final Matrix4Row r1, final Matrix4Row r2) {
        return Mat4Math.swappedRows(this, r1, r2);
    }

    public Matrix4 swappedRows(final int r1, final int r2) {
        return Mat4Math.swappedRows(this, r1, r2);
    }

    public Matrix4 swapCols(final Matrix4Col c1, final Matrix4Col c2) {
        return Mat4Math.swapCols(this, c1, c2);
    }

    public Matrix4 swapCols(final int c1, final int c2) {
        return Mat4Math.swapCols(this, c1, c2);
    }

    public Matrix4 swappedCols(final Matrix4Col c1, final Matrix4Col c2) {
        return Mat4Math.swappedCols(this, c1, c2);
    }

    public Matrix4 swappedCols(final int c1, final int c2) {
        return Mat4Math.swappedCols(this, c1, c2);
    }

    public Matrix4 mult(final float multiplier) {
        return Mat4Math.mult(this, multiplier);
    }

    public Matrix4 multiplied(final float multiplier) {
        return Mat4Math.multiplied(this, multiplier);
    }

    public Matrix4 divide(final float divisor) {
        return Mat4Math.divide(this, divisor);
    }

    public Matrix4 divided(final float divisor) {
        return Mat4Math.divide(this, divisor);
    }

    public Matrix4 add(final Matrix4 m) {
        return Mat4Math.add(this, m);
    }

    public Matrix4 added(final Matrix4 m) {
        return Mat4Math.added(this, m);
    }

    public Matrix4 sub(final Matrix4 m) {
        return Mat4Math.sub(this, m);
    }

    public Matrix4 subtracted(final Matrix4 m) {
        return Mat4Math.subtracted(this, m);
    }

    public Matrix4 prod(final Matrix4 m) {
        return Mat4Math.prod(this, m);
    }

    public Vector4 prod(final Vector4 v) {
        return Mat4Math.prod(this, v);
    }

    public Matrix4 triangulate() {
        return Mat4Math.triangulate(this);
    }

    public Matrix4 triangulated() {
        return Mat4Math.triangulated(this);
    }

    public float det() {
        return Mat4Math.det(this);
    }

    public Matrix4 invertible() {
        return Mat4Math.invertible(this);
    }

    public Matrix minorMatrix(final int r, final int c) {
        return MatMath.minorMatrix(this, r, c);
    }

    public float cofactor(final int r, final int c) {
        return MatMath.cofactor(this, r, c);
    }

    public Matrix4 cofactorMatrix() {
        return Mat4Math.cofactorMatrix(this);
    }

    public boolean square() {
        return true;
    }

    public boolean isZeroed() {
        return Mat4Math.isZeroed(this);
    }

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

    public static Matrix4 zeroMat() {
        return Mat4Math.zeroMat();
    }

    public static Matrix4 unitMat() {
        return Mat4Math.unitMat();
    }
}
