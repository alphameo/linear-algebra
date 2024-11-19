package ru.vsu.cs.course2.a1pha.linear_algebra;

/**
 * Checker
 */
public class NumberChecker {

    public static void checkDivisor(float divisor) throws ArithmeticException {

        if (Float.compare(divisor, 0f) == 0) {
            throw new ArithmeticException("Division denied: division by 0");
        }
    }
}
