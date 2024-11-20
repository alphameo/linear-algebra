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

    public static <VecType extends VectorInterface<VecType>> void subtractFrom(final VecType targetV,
            final VecType subtrahendV) {
        for (int i = 0; i < targetV.size(); i++) {
            targetV.set(i, targetV.get(i) - subtrahendV.get(i));
        }
    }

    public static <VecType extends VectorInterface<VecType>> float dot(final VecType v1, final VecType v2) {
        float sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }

    public static <VecType extends VectorInterface<VecType>> boolean equalTo(final VecType v1, final VecType v2) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i) != v2.get(i)) {
                return false;
            }
        }

        return true;
    }

}
