package com.github.ia1phai.linear_algebra;

/**
 * Checker
 */
public class NumberChecker {

    public static final float EPS = 0.000001f;

    public static void checkDivisor(float divisor) throws ArithmeticException {

        if (Math.abs(divisor) < EPS) {
            throw new ArithmeticException("Division denied: divisor equals 0");
        }
    }
}
