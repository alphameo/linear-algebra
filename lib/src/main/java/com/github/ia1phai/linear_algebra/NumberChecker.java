package com.github.ia1phai.linear_algebra;

/**
 * Checker
 */
public class NumberChecker {

    public static final float EPS = 0.000001f;

    public static void checkDivisor(float divisor) throws ArithmeticException {

        if (Float.compare(divisor, 0f) == 0) {
            throw new ArithmeticException("Division denied: division by 0");
        }
    }
}
