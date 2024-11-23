package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;
import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;

/**
 * Vector
 */
public interface VectorInterface<V extends VectorInterface<V>> extends ScalarOperatable<V> {

    default V normalize() {
        return divide(length());
    }

    float length();

    V add(V vec);

    default V plus(final V vec) {
        final V result = copy();
        result.add(vec);

        return result;
    }

    V subtract(V vec);

    default V minus(final V vec) {
        final V result = copy();
        result.add(vec);

        return result;
    };

    float dot(V vec);
}
