package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vec4;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector4;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * Matr4
 */
public class Matr4 implements Matrix4 {

    SquareMatrix matrix;

    public Matr4() {
        matrix = new SqMatr(4);
    }

    public Matr4(final float entries[][]) {
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
        return UncheckedMatrixOperations.invertibleMatrix(this);
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
        UncheckedMatrixOperations.addTo(this, matr);
    }

    @Override
    public void subtract(final Matrix4 matr) {
        UncheckedMatrixOperations.subtractFrom(this, matr);
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
        final Matrix4 result = new Matr4();
        UncheckedMatrixOperations.product(this, matr, result);

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
        final Matrix4 result = new Matr4();

        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                result.set(i, j, matrix.get(i, j));
            }
        }

        return result;
    }

    @Override
    public boolean equalsTo(final Matrix4 other) {
        return UncheckedMatrixOperations.equalTo(this, other);
    }

    @Override
    public Vector4 product(final Vector4 vec) {
        final Vector4 result = new Vec4();
        UncheckedMatrixOperations.product(this, vec, result);

        return result;
    }

    @Override
    public Matrix4 cofactorMatrix() {
        Matrix4 result = new Matr4();
        UncheckedMatrixOperations.cofactorMatrix(this, result);

        return result;
    }
}
