package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperations;

/**
 * SimpleVectorOperations
 */
public interface VectorOperations<Vec> extends ScalarOperations {

    default void normalize() {
        divide(length());
    }

    float length();

    void add(Vec other);

    Vec plus(Vec other);

    void subtract(Vec other);

    Vec minus(Vec other);

    float dot(Vec other);
}
