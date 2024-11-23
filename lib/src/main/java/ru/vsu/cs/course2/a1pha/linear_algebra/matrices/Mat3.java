package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vec3;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector3;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * Matr3
 */
public class Mat3 implements Matrix3, Copyable<Mat3> {

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

    @Override
    public float get(final int row, final int col) {
        return matrix.get(row, col);
    }

    @Override
    public void set(final int row, final int col, final float value) {
        matrix.set(row, col, value);
    }

    @Override
    public float det() {
        return UncheckedMatrixOperation.determinant3(matrix);
    }

    @Override
    public Matrix3 invertible() {
        return UncheckedMatrixOperation.invertibleMatrix(this);
    }

    @Override
    public Matrix3 transpose() {
        matrix.transpose();

        return this;
    }

    @Override
    public SquareMatrix minorMatrix(int row, int col) {
        return matrix.minorMatrix(row, col);
    }

    @Override
    public void swapRows(final int r1, final int r2) {
        matrix.swapRows(r1, r2);
    }

    @Override
    public void swapCols(final int c1, final int c2) {
        matrix.swapCols(c1, c2);
    }

    @Override
    public void triangulate() {
        matrix.triangulate();
    }

    @Override
    public void add(final Matrix3 mat) {
        UncheckedMatrixOperation.addTo(this, mat);
    }

    @Override
    public void subtract(final Matrix3 mat) {
        UncheckedMatrixOperation.subtractFrom(this, mat);
    }

    @Override
    public Matrix3 product(final Matrix3 mat) {
        final Matrix3 result = new Mat3();
        UncheckedMatrixOperation.product(this, mat, result);

        return result;
    }

    @Override
    public <T extends VectorInterface<T>> T product(final T vec) {
        return matrix.product(vec);
    }

    @Override
    public boolean isZeroed() {
        return matrix.isZeroed();
    }

    @Override
    public Matrix3 divide(final float divisor) {
        matrix.divide(divisor);

        return this;
    }

    @Override
    public Matrix3 multiply(final float multiplier) {
        matrix.multiply(multiplier);

        return this;
    }

    @Override
    public Matrix3 copy() {
        final Matrix3 result = new Mat3();

        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                result.set(i, j, matrix.get(i, j));
            }
        }

        return result;
    }

    @Override
    public boolean equalsTo(final Matrix3 mat) {
        return UncheckedMatrixOperation.equals(this, mat);
    }

    @Override
    public Vector3 product(final Vector3 vec) {
        final Vector3 result = new Vec3();
        UncheckedMatrixOperation.product(this, vec, result);

        return result;
    }

    public boolean isDiagonal() {
        return matrix.isDiagonal();
    }

    public Matrix3 cofactorMatrix() {
        Matrix3 result = new Mat3();
        UncheckedMatrixOperation.cofactorMatrix(this, result);

        return result;
    }
}
