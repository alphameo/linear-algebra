package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.NumberChecker;

/**
 * UncheckedVectorOperations
 */
public class VecMath {

    public static float length(final Vector v) {
        float sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.get(i) * v.get(i);
        }

        return (float) Math.sqrt(sum);
    }

    public static void multiply(final Vector v, final float multiplier) {
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) * multiplier);
        }
    }

    public static void divide(final Vector v, final float divisor) {
        NumberChecker.checkDivisor(divisor);
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) / divisor);
        }
    }

    public static void add(final Vector target,
            final Vector addendum) {
        checkSameVectorSizes(target, addendum, "Addition denied");
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) + addendum.get(i));
        }
    }

    public static void subtract(final Vector target,
            final Vector subtrahend) {
        checkSameVectorSizes(target, subtrahend, "Subtraction denied");
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) - subtrahend.get(i));
        }
    }

    public static float dot(final Vector v1, final Vector v2) {
        checkSameVectorSizes(v1, v2, "Scalar product denied");
        float sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }

    public static Vector cross(final Vector v1, final Vector v2) {
        if (v1.size() != 3 || v2.size() != 3) {
            throw new IllegalArgumentException(
                    String.format(String.format("Cross product denien: vector size must be 3, but given are %d, %d"),
                            v1.size(), v2.size()));
        }
        Vector result = new Vec(3);
        result.set(0, v1.get(1) * v2.get(2) - v1.get(2) * v2.get(1));
        result.set(1, v1.get(2) * v2.get(0) - v1.get(0) * v2.get(2));
        result.set(2, v1.get(0) * v2.get(1) - v1.get(1) * v2.get(0));

        return result;
    }

    public static boolean equals(final Vector v1, final Vector v2) {
        checkSameVectorSizes(v1, v2, "Equalization denied");
        for (int i = 0; i < v1.size(); i++) {
            if (Math.abs(v1.get(i) - v2.get(i)) >= NumberChecker.EPS) {
                return false;
            }
        }

        return true;
    }

    private static void checkSameVectorSizes(final Vector v1, final Vector v2,
            final String errMessage) {
        if (v1.size() != v2.size()) {
            throw new IllegalArgumentException(String.format("%s: vectors with different lengths (%d and %d)",
                    errMessage, v1.size(), v2.size()));
        }
    }
}
