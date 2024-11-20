package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * MatrixOperatable
 */
public interface MatrixInterface<MatrType extends MatrixInterface<MatrType>>
        extends ScalarOperatable, Copyable<MatrType>, Equatable<MatrType> {

    float get(int row, int col);

    void set(int row, int col, float value);

    int width();

    int height();

    void transpose();

    default MatrType transposed() {
        final MatrType result = copy();
        result.transpose();

        return result;
    }

    void add(MatrType matr);

    default MatrType plus(final MatrType matr) {
        final MatrType result = copy();
        result.add(matr);

        return result;
    }

    void subtract(MatrType matr);

    default MatrType minus(final MatrType matr) {
        final MatrType result = copy();
        result.subtract(matr);

        return result;
    }

    void triangulate();

    default MatrType triangularTable() {
        final MatrType result = copy();
        result.triangulate();

        return result;
    }

    void swapRows(int r1, int r2);

    void swapCols(int c1, int c2);

    MatrType product(MatrType matr);

    <T extends VectorInterface<T>> T product(VectorInterface<T> vec);

    boolean isSquare();

    boolean isZeroed();
}
