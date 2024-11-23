package com.github.ia1phai.linear_algebra.mat;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.vec.Vec4;
import com.github.ia1phai.linear_algebra.vec.Vector4;

/**
 * Matr4
 */
public class Mat4 implements Matrix4, Copyable<Mat4> {

    Mat matrix;

    public Mat4() {
        matrix = new Mat(4);
    }

    public Mat4(final float entries[][]) {
        matrix = new Mat(entries);
        if (matrix.width() != 4) {
            throw new IllegalArgumentException(String.format(
                    "Square matrix 4x4 creation denied: input data has size %dx%d", matrix.height(),
                    matrix.width()));
        }
    }

    public Mat4(final Matrix4 m) {
        this();
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                this.set(i, j, m.get(i, j));
            }
        }
    }

    @Override
    public float get(final int row, final int col) {
        return matrix.get(row, col);
    }

    @Override
    public float get(Matrix4Row row, Matrix4Col col) {
        return matrix.get(row.ordinal(), col.ordinal());
    }

    @Override
    public void set(final int row, final int col, final float value) {
        matrix.set(row, col, value);
    }

    @Override
    public void set(Matrix4Row row, Matrix4Col col, float value) {
        matrix.set(row.ordinal(), col.ordinal(), value);
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
        matrix.transpose();

        return this;
    }

    public Matrix4 transposed() {
        return this.copy().transpose();
    }

    public void swapRows(final int r1, final int r2) {
        matrix.swapRows(r1, r2);
    }

    public void swapCols(final int c1, final int c2) {
        matrix.swapCols(c1, c2);
    }

    public Matrix4 divide(final float divisor) {
        matrix.divide(divisor);

        return this;
    }

    public Matrix4 multiply(final float multiplier) {
        matrix.multiply(multiplier);

        return this;
    }

    public Matrix4 add(final Matrix4 mat) {
        UncheckedMatrixOperation.add(this, mat);

        return this;
    }

    public Matrix4 plus(final Matrix4 mat) {
        return this.copy().add(mat);
    }

    public Matrix4 subtract(final Matrix4 mat) {
        UncheckedMatrixOperation.subtractFrom(this, mat);

        return this;
    }

    public Matrix4 product(final Matrix4 mat) {
        final Matrix4 result = new Mat4();
        UncheckedMatrixOperation.product(this, mat, result);

        return result;
    }

    public Vector4 product(final Vector4 vec) {
        Vector4 result = new Vec4();
        UncheckedMatrixOperation.product(this, vec, result);

        return result;
    }

    public Matrix4 triangulate() {
        Matrix4 result = new Mat4();
        UncheckedMatrixOperation.triangulate(this, this.width());

        return result;
    }

    public Matrix triangularTable() {
        return this.copy().triangulate();
    }

    public float det() {
        return UncheckedMatrixOperation.determinant3(matrix);
    }

    public Matrix4 invertible() {
        Matrix4 result = new Mat4();

        UncheckedMatrixOperation.invertibleMatrix(this, result);

        return result;
    }

    public Matrix minorMatrix(int row, int col) {
        return UncheckedMatrixOperation.minorMatrix(this, row, col);
    }

    public float cofactor(final int row, final int col) {
        return UncheckedMatrixOperation.cofactor(this, row, col);
    }

    public Matrix3 cofactorMatrix() {
        Matrix3 result = new Mat3();
        UncheckedMatrixOperation.cofactorMatrix(this, result);

        return result;
    }

    public boolean isSquare() {
        return true;
    }

    public boolean isZeroed() {
        return matrix.isZeroed();
    }

    public boolean isDiagonal() {
        return matrix.isDiagonal();
    }

    @Override
    public boolean equalsTo(final Matrix mat) {
        return UncheckedMatrixOperation.equals(this, mat);
    }

    @Override
    public Mat4 copy() {
        final Mat4 result = new Mat4();

        for (int i = 0; i < width(); i++) {
            for (int j = 0; j < width(); j++) {
                result.set(i, j, matrix.get(i, j));
            }
        }

        return result;
    }
}
