package io.github.alphameo.linear_algebra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.alphameo.linear_algebra.mat.Mat;
import io.github.alphameo.linear_algebra.mat.Matrix;
import io.github.alphameo.linear_algebra.vec.Vec;
import io.github.alphameo.linear_algebra.vec.Vector;

/**
 * TestNumberChecker
 */
class TestValidator {
    @Test
    public void testCheckDivisor0() {
        try {
            Validator.validateDivisor(0.0000000001f);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertEquals("Division denied: divisor equals 0", e.getMessage());
        }
    }

    @Test
    public void testCheckDivisorNot0() {
        try {
            Validator.validateDivisor(12);
        } catch (Exception e) {
            Assertions.fail();
        }

        Assertions.assertTrue(true);
    }

    @Test
    public void testValidateVectorSizesException() {
        try {
            Vector v1 = new Vec(1, 2, 3);
            Vector v2 = new Vec(0, 1, 2, 3);
            Validator.validateVectorSizes(v1, v2, "Error");
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    public void testValidateVectorSizesNoException() {
        try {
            Vector v1 = new Vec(1, 2, 3);
            Vector v2 = new Vec(0, 1, 3);
            Validator.validateVectorSizes(v1, v2, "Error");
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    public void testValidateMatrixSizesException() {
        try {
            Matrix v1 = new Mat(new float[][] { { 1, 2, 3 }, { 1, 2, 3 } });
            Matrix v2 = new Mat(new float[][] { { 1, 2, 3, 4 }, { 1, 2, 3, 5 } });
            Validator.validateMatrixSizes(v1, v2, "Error");
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    public void testValidateMatrixSizesNoException() {
        try {
            Matrix v1 = new Mat(new float[][] { { 1, 2, 3, 9 }, { 1, 2, 3, 15 } });
            Matrix v2 = new Mat(new float[][] { { 1, 2, 3, 4 }, { 1, 2, 3, 5 } });
            Validator.validateMatrixSizes(v1, v2, "Error");
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
