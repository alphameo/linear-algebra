package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;

/**
 * SimpleVectorOperations
 */
public interface VectorOperatable<VecType> extends ScalarOperatable, Equatable<VecType> {

    void normalize();

    float length();

    void add(VecType other);

    VecType plus(VecType other);

    void subtract(VecType other);

    VecType minus(VecType other);

    float dot(VecType other);
}
