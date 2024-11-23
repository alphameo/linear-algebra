package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector3;

/**
 * Matr3
 */
public interface Matrix3 extends Matrix {

    Vector3 product(Vector3 vec);
}
