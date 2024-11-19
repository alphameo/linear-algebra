package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;

/**
 * Vector
 */
public interface ArbitraryVector extends ScalarOperatable {

    float get(int i);

    void set(int i, float value);

    int size();

    default void normalize() {
        divide(length());
    }

    default float length() {
        float sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += get(i) * get(i);
        }

        return (float) Math.sqrt(sum);
    }

    void add(ArbitraryVector other) {

    };

    default ArbitraryVector plus(ArbitraryVector other) {
        ArbitraryVector result = copy();
        result.add(other);

        return result;
    }

    void subtract(ArbitraryVector other);

    default ArbitraryVector minus(ArbitraryVector other) {
        ArbitraryVector result = copy();
        result.subtract(other);

        return result;
    }

    float dot(ArbitraryVector other);

    boolean equalsTo(ArbitraryVector vector);

    ArbitraryVector copy();
}
