package io.github.alphameo.linear_algebra;

import io.github.alphameo.linear_algebra.mat.Matrix;
import io.github.alphameo.linear_algebra.vec.Vector;

/**
 * Class with static functions of validation
 *
 * @since 1.0.0
 */
public class Validator {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public Validator() {
    }

    /**
     * Default tolerance value.
     *
     * @since 1.0.0
     */
    public static final float EPS = 0.000001f;

    /**
     * Checks 0 divisor.
     * 
     * @param divisor divisor value
     * @throws ArithmeticException if divisor is approximately equal 0
     *
     * @since 1.0.0
     */
    public static void validateDivisor(final float divisor) throws ArithmeticException {

        if (equals(divisor, 0)) {
            throw new ArithmeticException("Division denied: divisor equals 0");
        }
    }

    /**
     * Checks vectors' sizes.
     * 
     * @param v1         first vector for validation
     * @param v2         second vector for validation
     * @param errMessage specific message
     * @throws IllegalArgumentException if vector sizes are different
     *
     * @since 1.0.0
     */
    public static void validateVectorSizes(final Vector v1, final Vector v2,
            final String errMessage) throws IllegalArgumentException {
        if (v1.size() != v2.size()) {
            throw new IllegalArgumentException(String.format("%s: vectors with different lengths (%d and %d)",
                    errMessage, v1.size(), v2.size()));
        }
    }

    /**
     * Checks matrices' sizes.
     * 
     * @param m1         first matrix for validation
     * @param m2         second matrix for validation
     * @param errMessage specific message
     * @throws IllegalArgumentException if vector sizes are different
     *
     * @since 1.0.0
     */
    public static void validateMatrixSizes(final Matrix m1, final Matrix m2,
            final String errMessage) {
        if (m1.width() != m2.width() || m1.height() != m2.height()) {
            throw new IllegalArgumentException(String.format("%s: matrices with different sizes (%dx%d and %dx%d)",
                    errMessage, m1.height(), m1.width(), m2.height(), m2.width()));
        }
    }

    /**
     * Returns {@code true} if values are equal within given tolerance
     * 
     * @param value1 first value for comparison
     * @param value2 second value for comparison
     * @param eps    tolerance
     * @return {@code true} if values are equal within {@code eps} tolerance,
     *         and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equalsEpsilon(float value1, float value2, float eps) {
        return Math.abs(value1 - value2) < eps;
    }

    /**
     * Returns {@code true} if values are approximately equal
     * 
     * @param value1 first value for comparison
     * @param value2 second value for comparison
     * @return {@code true} if values are approximately equal, and {@code false}
     *         otherwise
     *
     * @since 1.0.0
     */
    public static boolean equals(float value1, float value2) {
        return Math.abs(value1 - value2) < EPS;
    }
}
