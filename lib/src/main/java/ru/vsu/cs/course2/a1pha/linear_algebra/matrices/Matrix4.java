package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector4;

/**
 * Matrix4
 */
public interface Matrix4 extends SquareMatrixInterface<Matrix4> {

    @Override
    default int height() {
        return 3;
    }

    @Override
    default int width() {
        return 3;
    }

    Vector4 product(Vector4 vec);
}
