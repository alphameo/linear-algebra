package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector3;

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

    @Override
    default boolean isSquare() {
        return true;
    }

    Vector3 product(Vector3 vec);
}
