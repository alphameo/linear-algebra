package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * UncheckedVectorOperations
 */
public class VecMath {

    public static float len(final Vector v) {
        float sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.get(i) * v.get(i);
        }

        return (float) Math.sqrt(sum);
    }

    public static Vector mult(final Vector v, final float multiplier) {
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) * multiplier);
        }

        return v;
    }

    public static Vector divide(final Vector v, final float divisor) {
        Validator.validateDivisor(divisor);
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) / divisor);
        }

        return v;
    }

    public static Vector add(final Vector target, final Vector addendum) {
        Validator.validateVectorSizes(target, addendum, "Addition denied");
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) + addendum.get(i));
        }

        return target;
    }

    public static Vector sub(final Vector target, final Vector subtrahend) {
        Validator.validateVectorSizes(target, subtrahend, "Subtraction denied");
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) - subtrahend.get(i));
        }

        return target;
    }

    public static float dot(final Vector v1, final Vector v2) {
        Validator.validateVectorSizes(v1, v2, "Scalar product denied");
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
        final Vector result = new Vec(3);
        result.set(0, v1.get(1) * v2.get(2) - v1.get(2) * v2.get(1));
        result.set(1, v1.get(2) * v2.get(0) - v1.get(0) * v2.get(2));
        result.set(2, v1.get(0) * v2.get(1) - v1.get(1) * v2.get(0));

        return result;
    }

    public static boolean equals(final Vector v1, final Vector v2) {
        Validator.validateVectorSizes(v1, v2, "Equalization denied");
        for (int i = 0; i < v1.size(); i++) {
            if (!Validator.areEquals(v1.get(i), v2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static Vector zeroVec(final int size) {
        return new Vec(size);
    }

    public static Vector unitVec(final int size) {
        final Vector result = new Vec(size);
        for (int i = 0; i < size; i++) {
            result.set(i, 1);
        }

        return result;
    }
}
