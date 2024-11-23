package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import java.util.Arrays;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.NumberChecker;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vec;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector;

/**
 * Matr
 */
public class Matr implements Matrix, Copyable<Matr> {

    float[][] entries;

    public Matr(final float[][] entries) {
        this.entries = new float[entries.length][entries[0].length];
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].length != entries[0].length) {
                throw new IllegalArgumentException(
                        "Matrix creation denied: input data has rows with different lengths");
            }
            this.entries[i] = Arrays.copyOf(entries[i], entries[i].length);
        }
    }

    public Matr(final Matrix m) {
        entries = new float[m.height()][m.width()];
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                entries[i][j] = m.get(i, j);
            }
        }
    }

    public Matr(final int height, final int width) {
        entries = new float[height][width];
    }

    public Matr(final int size) {
        entries = new float[size][size];

    }

    @Override
    public float get(final int row, final int col) {
        return entries[row][col];
    }

    @Override
    public void set(final int row, final int col, final float value) {
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

    public Matrix transposed() {
        return this.copy().transpose();
    }

    public Matrix swapRows(final int r1, final int r2) {
        UncheckedMatrixOperations.swapRows(this, r1, r2);

        return this;
    }

    public Matrix swapCols(final int c1, final int c2) {
        UncheckedMatrixOperations.swapColumns(this, c1, c2);

        return this;
    }

    public Matrix divide(final float divisor) {
        UncheckedMatrixOperations.divide(this, divisor);

        return this;
    }

    public Matrix multiply(final float multiplier) {
        UncheckedMatrixOperations.multiply(this, multiplier);

        return this;
    }

    public Matrix add(final Matrix matr) {
        checkSameSizes(this, matr, "Addition denied");
        UncheckedMatrixOperations.addTo(this, matr);

        return this;
    }

    public Matrix plus(final Matrix matr) {
        return this.copy().add(matr);
    }

    public Matrix subtract(final Matrix matr) {
        checkSameSizes(this, matr, "Subtraction denied");
        UncheckedMatrixOperations.subtractFrom(this, matr);

        return this;
    }

    public Matrix minus(final Matrix matr) {
        return this.copy().subtract(matr);
    }

    public Matrix product(final Matrix matr) {
        if (this.width() == matr.height()) {
            throw new IllegalArgumentException(
                    String.format("Matrix product denied: matrices with sizes %dx%d and %dx%d", this.height(),
                            this.width(), matr.height(), matr.width()));
        }
        Matrix result = new Matr(this.height(), matr.width());

        UncheckedMatrixOperations.product(this, matr, result);

        return result;
    }

    public Vector product(final Vector vec) {
        if (this.width() != vec.size()) {
            throw new IllegalArgumentException(
                    String.format("Matrix and vector product denied: matrix with size %dx%d and vector with size",
                            this.height(),
                            this.width(), vec.size()));
        }

        Vector result = new Vec(vec.size());
        UncheckedMatrixOperations.product(this, vec, result);

        return result;
    }

    public Matrix transpose() {
        final float[][] result = new float[entries[0].length][entries.length];
        for (int i = 0; i < entries.length; i++) {
            for (int j = 0; i < entries[0].length; j++) {
                result[j][i] = entries[i][j];
            }
        }
        entries = result;

        return this;
    }

    public Matrix triangulate() {
        UncheckedMatrixOperations.triangulate(this, Math.max(this.height(), this.width()));

        return this;
    }

    public Matrix triangularTable() {
        return this.copy().triangulate();
    }

    public float det() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Determinant does not exists: matrix is not square");
        }

        return UncheckedMatrixOperations.determinant(this);
    }

    public Matrix invertible() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Invertible matrix does not exists: matrix is not square");
        }

        return UncheckedMatrixOperations.invertibleMatrix(this);
    }

    public Matrix minorMatrix(final int row, final int col) {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Minors do not exist: matrix is not square");
        }

        return UncheckedMatrixOperations.minorMatrix(this, row, col);
    }

    public float cofactor(final int row, final int col) {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Can not find cofactor: matrix is not square");
        }

        return UncheckedMatrixOperations.cofactor(this, row, col);
    }

    public Matrix cofactorMatrix() {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Cofactor matrix does not exist: matrix is not square");
        }

        return UncheckedMatrixOperations.cofactorMatrix(this);
    }

    public boolean isSquare() {
        return width() == height();
    }

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

    @Override
    public boolean equalsTo(final Matrix matr) {
        checkSameSizes(this, matr, "Equalizationt denied");
        return UncheckedMatrixOperations.equals(this, matr);
    }

    @Override
    public Matr copy() {
        final Matr result = new Matr(height(), width());

        for (int i = 0; i < height(); i++) {
            for (int j = 0; j < width(); j++) {
                result.set(i, j, this.get(i, j));
            }
        }

        return result;
    }

    private static void checkSameSizes(final Matrix m1, final Matrix m2,
            final String errMessage) {
        if (m1.width() != m2.width() || m1.height() != m2.height()) {
            throw new IllegalArgumentException(String.format("%s: matrices with different sizes (%dx%d and %dx%d)",
                    errMessage, m1.height(), m1.width(), m2.height(), m2.width()));
        }
    }
}
