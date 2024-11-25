package com.github.ia1phai.linear_algebra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TestNumberChecker
 */
class TestNumberChecker {
    @Test
    public void testCheckDivisor0() {
        try {
            NumberChecker.validateDivisor(0.00000001f);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertEquals("Division denied: divisor equals 0", e.getMessage());
        }
    }

    @Test
    public void testCheckDivisorNot0() {
        try {
            NumberChecker.validateDivisor(12);
        } catch (Exception e) {
            Assertions.fail();
        }

        Assertions.assertTrue(true);
    }
}
