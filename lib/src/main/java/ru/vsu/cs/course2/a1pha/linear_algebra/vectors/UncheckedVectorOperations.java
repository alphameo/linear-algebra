package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * UncheckedVectorOperations
 */
public class UncheckedVectorOperations {

    public static <V extends VectorInterface<V>> void addTo(final V targetV,
            final V termV) {
        for (int i = 0; i < targetV.size(); i++) {
            targetV.set(i, targetV.get(i) + termV.get(i));
        }
    }

    public static <V extends VectorInterface<V>> void subtractFrom(final V targetV,
            final V subtrahendV) {
        for (int i = 0; i < targetV.size(); i++) {
            targetV.set(i, targetV.get(i) - subtrahendV.get(i));
        }
    }

    public static <V extends VectorInterface<V>> float dot(final V v1, final V v2) {
        float sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }

    public static <V extends VectorInterface<V>> boolean equalTo(final V v1, final V v2) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i) != v2.get(i)) {
                return false;
            }
        }

        return true;
    }
}
