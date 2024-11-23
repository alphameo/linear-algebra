package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;

/**
 * ArbitraryVector
 */
public interface Vector extends VectorInterface<Vector>, Copyable<Vector>, Equatable<Vector> {

    float get(int index);

    void set(int index, float value);

    int size();
}
