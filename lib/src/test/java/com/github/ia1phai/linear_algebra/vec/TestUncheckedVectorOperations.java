package com.github.ia1phai.linear_algebra.vec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.ia1phai.linear_algebra.vec.VecMath.*;

/**
 * TestVec
 */
public class TestUncheckedVectorOperations {

    @Test
    public void testLength() {
        Vector v = new Vec(2, 1.2f, 0.3f, 4, 6);

        Assertions.assertTrue(Math.abs(length(v) - 7.58485) < 0.00001f);
    }

    @Test
    public void testMultiply() {
        Vector v1 = new Vec(-12, 3, 4, 8);
        Vector expected = new Vec(-18, 4.5f, 6, 12);
        multiply(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testDivideNormal() {
        Vector v1 = new Vec(-18, 4.5f, 6, 12);
        Vector expected = new Vec(-12, 3, 4, 8);
        divide(v1, 1.5f);
        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testDivide0() {
        Vector v1 = new Vec(-18, 4.5f, 6, 12);
        try {
            divide(v1, 0);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertEquals("Division denied: divisor equals 0", e.getMessage());
        }
    }

    @Test
    public void testAdd() {
        Vector v1 = new Vec(-12, 3, 4, 8);
        Vector v2 = new Vec(1, 2, 3, 4);
        Vector expected = new Vec(-11, 5, 7, 12);

        add(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testSubtract() {
        Vector v1 = new Vec(-12, 3, 4, 8);
        Vector v2 = new Vec(1, 2.03f, 3, 4);
        Vector expected = new Vec(-13, 0.97f, 1, 4);

        subtract(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDot() {
        Vector v1 = new Vec(-12, 3, 4, 8);
        Vector v2 = new Vec(1, 2.03f, 3, 4);

        // Assertions.assertTrue(Math.abs(dot(v1, v2) - 38.09f) < EPS);
        Assertions.assertEquals(dot(v1, v2), 38.09f);
    }

    @Test
    public void testCross() {
        Vector v1 = new Vec(-12, 3, 4);
        Vector v2 = new Vec(1, 2.03f, 3);
        Vector res = new Vec(3);
        cross(v1, v2, res);
        Vector expected = new Vec(0.88f, 40, -27.36f);

        // Assertions.assertTrue(res.equals(expected));
        Assertions.assertEquals(expected, res);
    }

    @Test
    public void testEquals() {
        Vector v1 = new Vec(-12, 3, 4);
        Vector v2 = new Vec(-12, 3, 4);

        Assertions.assertTrue(VecMath.equals(v1, v2));
    }

    @Test
    public void testNotEquals() {
        Vector v1 = new Vec(-12, 3, 4);
        Vector v2 = new Vec(-12, 4, 4);

        Assertions.assertTrue(!VecMath.equals(v1, v2));
    }
}
