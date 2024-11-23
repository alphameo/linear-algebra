package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector;

/**
 * MatrixOperatable
 */
public interface MatrixInterface<M extends MatrixInterface<M>>
        extends ScalarOperatable<M> {

    M transpose();

    M transposed();

    M add(M matr);

    M plus(final M matr);

    M subtract(M matr);

    M minus(final M matr);

    M triangulate();

    M triangularTable();

    M swapRows(int r1, int r2);

    M swapCols(int c1, int c2);

    M product(M matr);

    Vector product(Vector vec);

    float det();

    M invertible();

    M minorMatrix(int row, int col);

    float cofactor(int row, int col);

    M cofactorMatrix();

    boolean isSquare();

    boolean isZeroed();

    boolean isDiagonal();
}
