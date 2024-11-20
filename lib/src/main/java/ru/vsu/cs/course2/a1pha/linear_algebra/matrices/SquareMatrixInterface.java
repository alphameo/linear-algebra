package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

/**
 * SquareMatrixInterface
 */
public interface SquareMatrixInterface<MatrType extends SquareMatrixInterface<MatrType>>
        extends MatrixInterface<MatrType> {

    default int size() {
        return width();
    }

    @Override
    default boolean isSquare() {
        return true;
    }

    boolean isDiagonal();

    float determinatn();

    MatrType invertible();
}
