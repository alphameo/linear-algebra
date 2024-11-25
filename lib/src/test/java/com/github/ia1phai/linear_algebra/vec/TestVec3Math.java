package com.github.ia1phai.linear_algebra.vec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.ia1phai.linear_algebra.vec.Vec3Math.*;

/**
 * TestVec
 */
public class TestVec3Math {

    @Test
    public void testLength() {
        Vector3 v = new Vec3(2, 1.2f, 0.3f);

        Assertions.assertTrue(Math.abs(length(v) - 2.351592f) < 0.00001f);
    }

    @Test
    public void testMultiply() {
        Vector3 v1 = new Vec3(-12, 3, 4);
        Vector3 expected = new Vec3(-18, 4.5f, 6);
        multiply(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testDivideNormal() {
        Vector3 v1 = new Vec3(-18, 4.5f, 6);
        Vector3 expected = new Vec3(-12, 3, 4);
        divide(v1, 1.5f);
        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testAdd() {
        Vector3 v1 = new Vec3(-12, 3, 4);
        Vector3 v2 = new Vec3(1, 2, 3);
        Vector3 expected = new Vec3(-11, 5, 7);

        add(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testSubtract() {
        Vector3 v1 = new Vec3(-12, 3, 4);
        Vector3 v2 = new Vec3(1, 2.03f, 3);
        Vector3 expected = new Vec3(-13, 0.97f, 1);

        subtract(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDot() {
        Vector3 v1 = new Vec3(-12, 3, 4);
        Vector3 v2 = new Vec3(1, 2.03f, 3);

        // Assertions.assertTrue(Validator.areEquals(dot(v1, v2), 38.09f));
        Assertions.assertEquals(6.09f, dot(v1, v2));
    }

    @Test
    public void testCross() {
        Vector3 v1 = new Vec3(-12, 3, 4);
        Vector3 v2 = new Vec3(1, 2.03f, 3);
        Vector3 expected = new Vec3(0.88f, 40, -27.36f);

        // Assertions.assertTrue(res.equals(expected));
        Assertions.assertEquals(expected, cross(v1, v2));
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

    @Test
    public void testZeroVect() {
        Vector3 v = zeroVec();
        Vector3 expected = new Vec3(0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testUnitVect() {
        Vector3 v = unitVec();
        Vector3 expected = new Vec3(1, 1, 1);

        Assertions.assertEquals(expected, v);
    }
}
