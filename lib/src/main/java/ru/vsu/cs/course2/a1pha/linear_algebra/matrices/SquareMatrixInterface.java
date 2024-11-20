package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

/**
 * SquareMatrixInterface
 */
public interface SquareMatrixInterface<M extends SquareMatrixInterface<M>>
        extends MatrixInterface<M> {

    default int size() {
        return width();
    }

    @Override
    default boolean isSquare() {
        return true;
    }

    boolean isDiagonal();

    float det();

    M invertible();

    SquareMatrix minorMatrix(int row, int col);

    default float cofactor(int row, int col) {
        int coefficient = (row + col) % 2 == 0 ? 1 : -1;
        return coefficient * this.minorMatrix(row, col).det();
    }

    M cofactorMatrix();
}
