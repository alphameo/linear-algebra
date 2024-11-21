package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import java.util.Arrays;

import ru.vsu.cs.course2.a1pha.linear_algebra.NumberChecker;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * Matr
 */
public class Matr implements Matrix {

    float[][] entries;

    public Matr(float[][] entries) {
        this.entries = new float[entries.length][entries[0].length];
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].length != entries[0].length) {
                throw new IllegalArgumentException(
                        "Matrix creation denied: input data has rows with different lengths");
            }
            this.entries[i] = Arrays.copyOf(entries[i], entries[i].length);
        }
    }

    public Matr(int height, int width) {
        entries = new float[height][width];
    }

    public Matr(int size) {
        entries = new float[size][size];

    }

    @Override
    public float get(int row, int col) {
        return entries[row][col];
    }

    @Override
    public void set(int row, int col, float value) {
        entries[row][col] = value;
    }

    @Override
    public int width() {
        return entries[0].length;
    }

    @Override
    public int height() {
        return entries.length;
    }

    @Override
    public Matrix transpose() {
        float[][] result = new float[entries[0].length][entries.length];
        for (int i = 0; i < entries.length; i++) {
            for (int j = 0; i < entries[0].length; j++) {
                result[j][i] = entries[i][j];
            }
        }
        entries = result;

        return this;
    }

    @Override
    public void add(Matrix matr) {
        checkSameSizes(this, matr, "Addition denied");
        UncheckedMatrixOperations.addTo(this, matr);
    }

    @Override
    public void subtract(Matrix matr) {
        checkSameSizes(this, matr, "Subtraction denied");
        UncheckedMatrixOperations.subtractFrom(this, matr);
    }

    @Override
    public Matrix product(Matrix matr) {
        if (this.width() == matr.height()) {
            throw new IllegalArgumentException(
                    String.format("Product denied: matrices with sizes %dx%d and %dx%d", this.height(),
                            this.width(), matr.height(), matr.width()));
        }

        Matr result = new Matr(this.height(), matr.width());
        UncheckedMatrixOperations.product(this, matr, result);

        return result;
    }

    @Override
    public <V extends VectorInterface<V>> V product(V vec) {
        if (this.width() != vec.size()) {
            throw new IllegalArgumentException(
                    String.format("Product denied: matrix with size %dx%d and vector with size", this.height(),
                            this.width(), vec.size()));
        }

        V result = vec.copy();
        UncheckedMatrixOperations.product(this, vec, result);

        return result;
    }

    @Override
    public boolean isSquare() {
        return width() == height();
    }

    @Override
    public boolean isZeroed() {
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                if (entries[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public Matrix divide(float divisor) {
        NumberChecker.checkDivisor(divisor);

        for (int i = 0; i < entries.length; i++) {
            for (int j = 0; j < entries[0].length; j++) {
                entries[i][j] /= divisor;
            }
        }

        return this;
    }

    @Override
    public Matrix multiply(float multiplier) {
        for (int i = 0; i < entries.length; i++) {
            for (int j = 0; j < entries[0].length; j++) {
                entries[i][j] *= multiplier;
            }
        }

        return this;
    }

    @Override
    public void triangulate() {
        int countOfSwaps = 0;

        int border = Math.max(entries.length, entries[0].length);
        for (int i = 0; i < border; i++) {
            if (Math.abs(entries[i][i]) < NumberChecker.EPS) {
                boolean isNonZeroFound = false;

                for (int row = i + 1; row < entries.length; row++) {
                    if (entries[row][i] != 0) {
                        this.swapRows(i, row);
                        countOfSwaps++;
                        isNonZeroFound = true;
                        break;
                    }
                }

                if (!isNonZeroFound)
                    continue;
            }

            for (int row = i + 1; row < entries.length; row++) {
                float coefficient = -(entries[row][i] / entries[i][i]);

                for (int col = i; col < entries[0].length; col++) {
                    entries[row][col] += coefficient * entries[i][col];
                }
            }
        }

        if (countOfSwaps % 2 == 1) {
            for (int i = 0; i < entries[0].length; i++) {
                entries[0][i] *= -1;
            }
        }
    }

    @Override
    public void swapRows(int r1, int r2) {
        float tmp;
        for (int i = 0; i < entries[0].length; i++) {
            tmp = entries[r1][i];
            entries[r1][i] = entries[r2][i];
            entries[r2][i] = tmp;
        }
    }

    @Override
    public void swapCols(int c1, int c2) {
        float tmp;
        for (int i = 0; i < entries.length; i++) {
            tmp = entries[i][c1];
            entries[i][c1] = entries[i][c2];
            entries[i][c2] = tmp;
        }
    }

    @Override
    public Matrix copy() {
        Matr result = new Matr(height(), width());

        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                result.set(i, j, this.get(i, j));
            }
        }

        return result;
    }

    @Override
    public boolean equalsTo(Matrix matr) {
        checkSameSizes(this, matr, "Equalizationt denied");
        return UncheckedMatrixOperations.equalTo(this, matr);
    }

    private static void checkSameSizes(final Matrix m1, final Matrix m2,
            final String errMessage) {
        if (m1.width() != m2.width() || m1.height() != m2.height()) {
            throw new IllegalArgumentException(String.format("%s: matrices with different sizes (%dx%d and %dx%d)",
                    errMessage, m1.height(), m1.width(), m2.height(), m2.width()));
        }
    }

    @Override
    public float det() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Determinant does not exists: matrix is not square");
        }

        return UncheckedMatrixOperations.determinant(this);
    }

    @Override
    public Matrix invertible() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Invertible matrix does not exists: matrix is not square");
        }

        return UncheckedMatrixOperations.invertibleMatrix(this);
    }

    @Override
    public Matrix minorMatrix(int row, int col) {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Minors do not exist: matrix is not square");
        }
        Matrix result = new Matr(this.height(), this.width());
        UncheckedMatrixOperations.cofactorMatrix(this, result);

        return result;
    }

    @Override
    public float cofactor(int row, int col) {
        return UncheckedMatrixOperations.cofactor(this, row, col);
    }

    @Override
    public Matrix cofactorMatrix() {
        Matrix result = new Matr(this.height(), this.width());
        UncheckedMatrixOperations.cofactorMatrix(this, result);

        return result;
    }

    @Override
    public boolean isDiagonal() {
        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                if (i == j) {
                    continue;
                }
                if (Math.abs(this.get(i, j)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
    }
}
