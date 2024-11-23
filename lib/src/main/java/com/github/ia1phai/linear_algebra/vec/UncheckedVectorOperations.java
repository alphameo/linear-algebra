package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.NumberChecker;

/**
 * UncheckedVectorOperations
 */
public class UncheckedVectorOperations {

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
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) + addendum.get(i));
        }
    }

    public static void subtract(final Vector target,
            final Vector subtrahend) {
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) - subtrahend.get(i));
        }
    }

    public static float dot(final Vector v1, final Vector v2) {
        float sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }

    public static void cross(final Vector v1, final Vector v2, final Vector out) {
        out.set(0, v1.get(1) * v2.get(2) - v1.get(2) * v2.get(1));
        out.set(1, v1.get(2) * v2.get(0) - v1.get(0) * v2.get(2));
        out.set(2, v1.get(0) * v2.get(1) - v1.get(1) * v2.get(0));
    }

    public static boolean equals(final Vector v1, final Vector v2) {
        for (int i = 0; i < v1.size(); i++) {
            if (Math.abs(v1.get(i) - v2.get(i)) >= NumberChecker.EPS) {
                return false;
            }
        }

        return true;
    }
}
