package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;

/**
 * Vector
 */
public interface VectorInterface<T extends VectorInterface<T>> extends ScalarOperatable, Copyable<T>, Equatable<T> {

    float get(int index);

    void set(int index, float value);

    int size();

    default void normalize() {
        divide(length());
    }

    float length();

    void add(T vec);

    default T plus(final T vec) {
        final T result = copy();
        result.add(vec);

        return result;
    }

    void subtract(T vec);

    default T minus(final T vec) {
        final T result = copy();
        result.add(vec);

        return result;
    };

    float dot(T vec);
}
