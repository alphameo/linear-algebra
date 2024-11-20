package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * Matr3
 */
public class SqMatr implements SquareMatrix {

    Matr matrix;

    public SqMatr(int n) {
        matrix = new Matr(n, n);
    }

    public SqMatr(float entries[][]) {
        matrix = new Matr(entries);
        if (matrix.width() != matrix.height()) {
            throw new IllegalArgumentException(String.format(
                    "Square matrix creation denied: input data has inequal height=%d and width=%d", matrix.height(),
                    matrix.width()));
        }
    }

    @Override
    public float get(int row, int col) {
        return matrix.get(row, col);
    }

    @Override
    public void set(int row, int col, float value) {
        matrix.set(row, col, value);
    }

    @Override
    public int width() {
        return matrix.width();
    }

    @Override
    public int height() {
        return matrix.height();
    }

    @Override
    public float determinatn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'determinatn'");
    }

    @Override
    public SquareMatrix invertible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invertible'");
    }

    @Override
    public void transpose() {
        for (int i = 0; i < size(); i++) {
            for (int j = i + 1; j < size(); j++) {
                float tmp = matrix.get(i, j);
                matrix.set(i, j, matrix.get(j, i));
                matrix.set(j, i, tmp);
            }
        }
    }

    @Override
    public void add(SquareMatrix matr) {
        UncheckedMatrixOperations.addTo(this, matr);
    }

    @Override
    public void subtract(SquareMatrix matr) {
        UncheckedMatrixOperations.subtractFrom(this, matr);
    }

    @Override
    public SquareMatrix product(SquareMatrix matr) {
        // return UncheckedMatrixOperations.
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends VectorInterface<T>> T product(VectorInterface<T> vec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'product'");
    }

    @Override
    public boolean isDiagonal() {
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                if (i == j) {
                    continue;
                }
                if (matrix.get(i, j) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean isZeroed() {
        return matrix.isZeroed();
    }

    @Override
    public void divide(float divisor) {
        matrix.divide(divisor);
    }

    @Override
    public void multiply(float multiplier) {
        matrix.multiply(multiplier);
    }

    @Override
    public SquareMatrix copy() {
        SquareMatrix result = new SqMatr(size());

        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                result.set(i, j, matrix.get(i, j));
            }
        }

        return result;
    }

    @Override
    public boolean equalsTo(SquareMatrix matr) {
        return UncheckedMatrixOperations.equalTo(this, matr);
    }
}
