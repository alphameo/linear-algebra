package com.github.ia1phai.linear_algebra.vec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.ia1phai.linear_algebra.vec.VecMath.*;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * TestVec
 */
public class TestVecMath {

    @Test
    public void testLength() {
        Vector v = new Vec(2, 1.2f, 0.3f, 4, 6);

        Assertions.assertTrue(Validator.equals(len(v), 7.58485332752058f));
    }

    @Test
    public void testLength2() {
        Vector v = new Vec(2, 1.2f, 0.3f, 4, 6);

        Assertions.assertTrue(Validator.equals(len2(v), 57.53f));
    }

    @Test
    public void testMultiply() {
        Vector v1 = new Vec(-12, 3, 4, 8);
        Vector expected = new Vec(-18, 4.5f, 6, 12);
        mult(v1, 1.5f);

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

        sub(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDot() {
        Vector v1 = new Vec(-12, 3, 4, 8);
        Vector v2 = new Vec(1, 2.03f, 3, 4);

        // Assertions.assertTrue(Validator.areEquals(dot(v1, v2), 38.09f));
        Assertions.assertEquals(38.09f, dot(v1, v2));
    }

    @Test
    public void testCross() {
        Vector v1 = new Vec(-12, 3, 4);
        Vector v2 = new Vec(1, 2.03f, 3);
        Vector expected = new Vec(0.88f, 40, -27.36f);

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
        Vector v = zeroVec(4);
        Vector expected = new Vec(0, 0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testZeroVec() {
        Vector v = zeroVec(5);
        Vector expected = new Vec(0, 0, 0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testUnitVect() {
        Vector v = unitVec(5);
        Vector expected = new Vec(1, 1, 1, 1, 1);

        Assertions.assertEquals(expected, v);
    }
}
