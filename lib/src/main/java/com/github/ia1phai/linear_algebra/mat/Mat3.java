package com.github.ia1phai.linear_algebra.mat;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;
import com.github.ia1phai.linear_algebra.vec.Vec3;
import com.github.ia1phai.linear_algebra.vec.Vector3;

/**
 * Matr3
 */
public class Mat3 implements Matrix3, Equatable<Matrix3>, Copyable<Mat3> {

    Mat matrix;

    public Mat3() {
        matrix = new Mat(3);
    }

    public Mat3(final float entries[][]) {
        matrix = new Mat(entries);
        if (matrix.width() != 3) {
            throw new IllegalArgumentException(String.format(
                    "Square matrix 3x3 creation denied: input data has size %dx%d", matrix.height(),
                    matrix.width()));
        }
    }

    public Mat3(final Matrix3 m) {
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
    public float get(final Matrix3Row row, final Matrix3Col col) {
        return matrix.get(row.ordinal(), col.ordinal());
    }

    @Override
    public void set(final int row, final int col, final float value) {
        matrix.set(row, col, value);
    }

    @Override
    public void set(final Matrix3Row row, final Matrix3Col col, final float value) {
        matrix.set(row.ordinal(), col.ordinal(), value);
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
        matrix.transpose();

        return this;
    }

    public Matrix3 transposed() {
        return this.copy().transpose();
    }

    public void swapRows(final int r1, final int r2) {
        matrix.swapRows(r1, r2);
    }

    public void swapCols(final int c1, final int c2) {
        matrix.swapCols(c1, c2);
    }

    public Matrix3 multiply(final float multiplier) {
        matrix.multiply(multiplier);

        return this;
    }

    public Matrix3 divide(final float divisor) {
        matrix.divide(divisor);

        return this;
    }

    public Matrix3 add(final Matrix3 mat) {
        UncheckedMatrixOperations.add(this, mat);

        return this;
    }

    public Matrix3 plus(final Matrix3 mat) {
        return this.copy().add(mat);
    }

    public Matrix3 subtract(final Matrix3 mat) {
        UncheckedMatrixOperations.subtract(this, mat);

        return this;
    }

    public Matrix3 product(final Matrix3 mat) {
        final Matrix3 result = new Mat3();
        UncheckedMatrixOperations.product(this, mat, result);

        return result;
    }

    public Vector3 product(final Vector3 vec) {
        final Vector3 result = new Vec3();
        UncheckedMatrixOperations.product(this, vec, result);

        return result;
    }

    public Matrix3 triangulate() {
        final Matrix3 result = new Mat3();
        UncheckedMatrixOperations.triangulate(this, this.width());

        return result;
    }

    public Matrix triangularTable() {
        return this.copy().triangulate();
    }

    public float det() {
        return UncheckedMatrixOperations.determinant3(matrix);
    }

    public Matrix3 invertible() {
        final Matrix3 result = new Mat3();

        UncheckedMatrixOperations.invertibleMatrix(this, result);

        return result;
    }

    public Matrix minorMatrix(final int row, final int col) {
        return UncheckedMatrixOperations.minorMatrix(this, row, col);
    }

    public float cofactor(final int row, final int col) {
        return UncheckedMatrixOperations.cofactor(this, row, col);
    }

    public Matrix3 cofactorMatrix() {
        final Matrix3 result = new Mat3();
        UncheckedMatrixOperations.cofactorMatrix(this, result);

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
    public boolean equalsTo(final Matrix3 mat) {
        return UncheckedMatrixOperations.equals(this, mat);
    }

    @Override
    public Mat3 copy() {
        final Mat3 result = new Mat3();

        for (int i = 0; i < width(); i++) {
            for (int j = 0; j < width(); j++) {
                result.set(i, j, matrix.get(i, j));
            }
        }

        return result;
    }
}
