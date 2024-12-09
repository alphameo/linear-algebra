package com.github.ia1phai.linear_algebra;

import com.github.ia1phai.linear_algebra.mat.Matrix;
import com.github.ia1phai.linear_algebra.vec.Vector;

/**
 * Class with static functions of validation
 */
public class Validator {

    public static final float EPS = 0.000001f;

    public static void validateDivisor(final float divisor) throws ArithmeticException {

        if (equals(divisor, 0)) {
            throw new ArithmeticException("Division denied: divisor equals 0");
        }
    }

    public static void validateVectorSizes(final Vector v1, final Vector v2,
            final String errMessage) {
        if (v1.size() != v2.size()) {
            throw new IllegalArgumentException(String.format("%s: vectors with different lengths (%d and %d)",
                    errMessage, v1.size(), v2.size()));
        }
    }

    public static void validateMatrixSizes(final Matrix m1, final Matrix m2,
            final String errMessage) {
        if (m1.width() != m2.width() || m1.height() != m2.height()) {
            throw new IllegalArgumentException(String.format("%s: matrices with different sizes (%dx%d and %dx%d)",
                    errMessage, m1.height(), m1.width(), m2.height(), m2.width()));
        }
    }

    public static boolean equals(float value1, float value2) {
        return Math.abs(value1 - value2) < EPS;
    }

    public static boolean equalsEpsilon(float value1, float value2, float eps) {
        return Math.abs(value1 - value2) < eps;
    }
}
