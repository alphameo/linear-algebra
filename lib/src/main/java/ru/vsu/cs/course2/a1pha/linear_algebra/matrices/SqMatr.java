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
    public SquareMatrix cofactorMatrix() {
        SquareMatrix result = new SqMatr(this.size());
        UncheckedMatrixOperations.cofactorMatrix(this, result);

        return result;
    }

    @Override
    public float det() {
        if (this.size() == 1) {
            return this.get(0, 0);
        } else if (this.size() == 2) {
            return UncheckedMatrixOperations.determinant2(this);
        } else if (this.size() == 3) {
            return UncheckedMatrixOperations.determinant3(this);
        }

        float determinant = 0;

        for (int i = 0; i < this.width(); i++) {
            determinant += this.get(0, i) * this.cofactor(0, i);
        }

        return determinant;
    }

    @Override
    public SquareMatrix invertible() {
        return UncheckedMatrixOperations.invertibleMatrix(this);
    }

    @Override
    public void swapRows(int r1, int r2) {
        matrix.swapRows(r1, r2);
    }

    @Override
    public void swapCols(int c1, int c2) {
        swapCols(c1, c2);
    }

    @Override
    public void triangulate() {
        matrix.triangulate();
    }

    @Override
    public SquareMatrix minorMatrix(int row, int col) {
        SquareMatrix result = new SqMatr(size() - 1);
        int destRow = 0;
        int destCol = 0;
        for (int i = 0; i < this.size(); i++) {
            if (i == row) {
                continue;
            }
            for (int j = 0; j < this.size(); j++) {
                if (j == col) {
                    continue;
                }

                result.set(destRow, destCol, this.get(i, j));
                destCol++;
            }
            destRow++;
        }
        return result;
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
        SquareMatrix result = new SqMatr(size());
        UncheckedMatrixOperations.product(this, matr, result);

        return result;
    }

    @Override
    public <T extends VectorInterface<T>> T product(T vec) {
        return product(vec);
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
