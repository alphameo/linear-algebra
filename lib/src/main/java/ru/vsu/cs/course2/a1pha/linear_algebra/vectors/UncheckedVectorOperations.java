package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * UncheckedVectorOperations
 */
public class UncheckedVectorOperations {

    public static <VecType> void addTo(final ArbitraryVector targetV, final ArbitraryVector termV) {
        for (int i = 0; i < targetV.size(); i++) {
            targetV.set(i, targetV.get(i) + termV.get(i));
        }
    }

    public static <VecType> void subtractFrom(final ArbitraryVector targetV, final ArbitraryVector subtrahendV) {
        for (int i = 0; i < targetV.size(); i++) {
            targetV.set(i, targetV.get(i) - subtrahendV.get(i));
        }
    }

    public static <VecType> float dot(final ArbitraryVector v1, final ArbitraryVector v2) {
        float sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }

    public static <VecType> boolean equalTo(final ArbitraryVector v1, final ArbitraryVector v2) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i) != v2.get(i)) {
                return false;
            }
        }

        return true;
    }

}
