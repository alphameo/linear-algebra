package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * MatrixOperatable
 */
public interface MatrixInterface<M extends MatrixInterface<M>>
        extends ScalarOperatable, Copyable<M>, Equatable<M> {

    float get(int row, int col);

    void set(int row, int col, float value);

    int width();

    int height();

    void transpose();

    default M transposed() {
        final M result = copy();
        result.transpose();

        return result;
    }

    void add(M matr);

    default M plus(final M matr) {
        final M result = copy();
        result.add(matr);

        return result;
    }

    void subtract(M matr);

    default M minus(final M matr) {
        final M result = copy();
        result.subtract(matr);

        return result;
    }

    void triangulate();

    default M triangularTable() {
        final M result = copy();
        result.triangulate();

        return result;
    }

    void swapRows(int r1, int r2);

    void swapCols(int c1, int c2);

    M product(M matr);

    <T extends VectorInterface<T>> T product(VectorInterface<T> vec);

    boolean isSquare();

    boolean isZeroed();
}
