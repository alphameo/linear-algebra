package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vec4;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector4;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * Matr4
 */
public class Mat4 implements Matrix4 {

    SquareMatrix matrix;

    public Mat4() {
        matrix = new SqMatr(4);
    }

    public Mat4(final float entries[][]) {
        matrix = new SqMatr(entries);
        if (matrix.width() != 4) {
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
    public boolean isDiagonal() {
        return matrix.isDiagonal();
    }

    @Override
    public float det() {
        return matrix.det();
    }

    @Override
    public Matrix4 invertible() {
        return UncheckedMatrixOperation.invertibleMatrix(this);
    }

    @Override
    public Matrix4 transpose() {
        matrix.transpose();

        return this;
    }

    @Override
    public SquareMatrix minorMatrix(int row, int col) {
        return matrix.minorMatrix(row, col);
    }

    @Override
    public void add(final Matrix4 matr) {
        UncheckedMatrixOperation.add(this, matr);
    }

    @Override
    public void subtract(final Matrix4 matr) {
        UncheckedMatrixOperation.subtractFrom(this, matr);
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
    public Matrix4 product(final Matrix4 matr) {
        final Matrix4 result = new Mat4();
        UncheckedMatrixOperation.product(this, matr, result);

        return result;
    }

    @Override
    public <V extends VectorInterface<V>> V product(final V vec) {
        return matrix.product(vec);
    }

    @Override
    public boolean isZeroed() {
        return matrix.isZeroed();
    }

    @Override
    public Matrix4 divide(final float divisor) {
        matrix.divide(divisor);

        return this;
    }

    @Override
    public Matrix4 multiply(final float multiplier) {
        matrix.multiply(multiplier);

        return this;
    }

    @Override
    public Matrix4 copy() {
        final Matrix4 result = new Mat4();

        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                result.set(i, j, matrix.get(i, j));
            }
        }

        return result;
    }

    @Override
    public boolean equalsTo(final Matrix4 other) {
        return UncheckedMatrixOperation.equals(this, other);
    }

    @Override
    public Vector4 product(final Vector4 vec) {
        final Vector4 result = new Vec4();
        UncheckedMatrixOperation.product(this, vec, result);

        return result;
    }

    @Override
    public Matrix4 cofactorMatrix() {
        Matrix4 result = new Mat4();
        UncheckedMatrixOperation.cofactorMatrix(this, result);

        return result;
    }
}
