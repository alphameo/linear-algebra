package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;

/**
 * Vector
 */
public interface VectorInterface<V extends VectorInterface<V>> extends ScalarOperatable, Copyable<V>, Equatable<V> {

    float get(int index);

    void set(int index, float value);

    int size();

    default void normalize() {
        divide(length());
    }

    float length();

    void add(V vec);

    default V plus(final V vec) {
        final V result = copy();
        result.add(vec);

        return result;
    }

    void subtract(V vec);

    default V minus(final V vec) {
        final V result = copy();
        result.add(vec);

        return result;
    };

    float dot(V vec);
}
