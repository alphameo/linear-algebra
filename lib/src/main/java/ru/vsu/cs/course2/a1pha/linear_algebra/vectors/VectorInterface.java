package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;

/**
 * Vector
 */
public interface VectorInterface<VecType extends VectorInterface<VecType>> extends ScalarOperatable, Copyable<VecType>, Equatable<VecType> {

    float get(int index);

    void set(int index, float value);

    int size();

    default void normalize() {
        divide(length());
    }

    float length();

    void add(VecType vec);

    default VecType plus(final VecType vec) {
        final VecType result = copy();
        result.add(vec);

        return result;
    }

    void subtract(VecType vec);

    default VecType minus(final VecType vec) {
        final VecType result = copy();
        result.add(vec);

        return result;
    };

    float dot(VecType vec);
}
