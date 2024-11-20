package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

/**
 * Matr3
 */
public interface Matrix3 extends SquareMatrixInterface<Matrix3> {

    @Override
    default int height() {
        return 3;
    }

    @Override
    default int width() {
        return 3;
    }
}
