package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * MatrixOperatable
 */
public interface MatrixInterface<M extends MatrixInterface<M>>
        extends ScalarOperatable<M>, Copyable<M>, Equatable<M> {

    float get(int row, int col);

    void set(int row, int col, float value);

    int width();

    int height();

    M transpose();

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

    void swapRows(int r1, int r2);

    void swapCols(int c1, int c2);

    void triangulate();

    default M triangularTable() {
        final M result = copy();
        result.triangulate();

        return result;
    }

    M product(M matr);

    <V extends VectorInterface<V>> V product(V vec);

    boolean isSquare();

    boolean isZeroed();
}
