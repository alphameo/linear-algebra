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

    float determinatn();

    M invertible();
}
