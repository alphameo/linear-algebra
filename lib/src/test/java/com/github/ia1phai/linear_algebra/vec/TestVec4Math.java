package com.github.ia1phai.linear_algebra.vec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.ia1phai.linear_algebra.vec.Vec4Math.*;

/**
 * TestVec
 */
public class TestVec4Math {

    @Test
    public void testLength() {
        Vector4 v = new Vec4(2, 1.2f, 0.3f, 4);

        Assertions.assertTrue(Math.abs(length(v) - 4.64004310324807f) < 0.00001f);
    }

    @Test
    public void testMultiply() {
        Vector4 v1 = new Vec4(-12, 3, 4, 8);
        Vector4 expected = new Vec4(-18, 4.5f, 6, 12);

        multiply(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testDivideNormal() {
        Vector4 v1 = new Vec4(-18, 4.5f, 6, 12);
        Vector4 expected = new Vec4(-12, 3, 4, 8);

        divide(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testAdd() {
        Vector4 v1 = new Vec4(-12, 3, 4, 8);
        Vector4 v2 = new Vec4(1, 2, 3, 4);
        Vector4 expected = new Vec4(-11, 5, 7, 12);

        add(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testSubtract() {
        Vector4 v1 = new Vec4(-12, 3, 4, 8);
        Vector4 v2 = new Vec4(1, 2.03f, 3, 4);
        Vector4 expected = new Vec4(-13, 0.97f, 1, 4);

        subtract(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDot() {
        Vector4 v1 = new Vec4(-12, 3, 4, 8);
        Vector4 v2 = new Vec4(1, 2.03f, 3, 4);

        // Assertions.assertTrue(Validator.areEquals(dot(v1, v2), 38.09f));
        Assertions.assertEquals(38.09f, dot(v1, v2));
    }

    @Test
    public void testEquals() {
        Vector4 v1 = new Vec4(-12, 3, 4, 0.1f);
        Vector4 v2 = new Vec4(-12, 3, 4, 0.1f);

        Assertions.assertTrue(VecMath.equals(v1, v2));
    }

    @Test
    public void testNotEquals() {
        Vector4 v1 = new Vec4(-12, 3, 4, 12.4f);
        Vector4 v2 = new Vec4(-12, 4, 4, 12.3f);

        Assertions.assertTrue(!VecMath.equals(v1, v2));
    }

    @Test
    public void testZeroVect() {
        Vector4 v = zeroVec();
        Vector4 expected = new Vec4(0, 0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testZeroVec() {
        Vector4 v = zeroVec();
        Vector4 expected = new Vec4(0, 0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testUnitVect() {
        Vector4 v = unitVec();
        Vector4 expected = new Vec4(1, 1, 1, 1);

        Assertions.assertEquals(expected, v);
    }
}
