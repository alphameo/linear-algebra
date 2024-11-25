package com.github.ia1phai.linear_algebra.vec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.ia1phai.linear_algebra.vec.Vec2Math.*;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * TestVec
 */
public class TestVec2Math {

    @Test
    public void testLength() {
        Vector2 v = new Vec2(2, 1.2f);

        Assertions.assertTrue(Validator.areEquals(len(v), 2.33238076f));
    }

    @Test
    public void testMultiply() {
        Vector2 v1 = new Vec2(-12, 3);
        Vector2 expected = new Vec2(-18, 4.5f);
        mult(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testDivideNormal() {
        Vector2 v1 = new Vec2(-18, 4.5f);
        Vector2 expected = new Vec2(-12, 3);
        divide(v1, 1.5f);
        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testAdd() {
        Vector2 v1 = new Vec2(-12, 3);
        Vector2 v2 = new Vec2(1, 2);
        Vector2 expected = new Vec2(-11, 5);

        add(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(v1, expected);
    }

    @Test
    public void testSubtract() {
        Vector2 v1 = new Vec2(-12, 3);
        Vector2 v2 = new Vec2(1, 2.03f);
        Vector2 expected = new Vec2(-13, 0.97f);

        sub(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDot() {
        Vector2 v1 = new Vec2(-12, 3);
        Vector2 v2 = new Vec2(1, 2.03f);

        // Assertions.assertTrue(Validator.areEquals(dot(v1, v2), 38.09f));
        Assertions.assertEquals(-5.91f, dot(v1, v2));
    }

    @Test
    public void testEquals() {
        Vector2 v1 = new Vec2(-12, 3);
        Vector2 v2 = new Vec2(-12, 3);

        Assertions.assertTrue(VecMath.equals(v1, v2));
    }

    @Test
    public void testNotEquals() {
        Vector2 v1 = new Vec2(-12, 4);
        Vector2 v2 = new Vec2(-12, 3);

        Assertions.assertTrue(!Vec2Math.equals(v1, v2));
    }

    @Test
    public void testToVec3() {
        Vector2 v1 = new Vec2(-12, 4);
        Vector3 expected = new Vec3(-12, 4, 1);

        Assertions.assertEquals(expected, toVec3(v1));
    }

    @Test
    public void testZeroVec() {
        Vector2 v = zeroVec();
        Vector2 expected = new Vec2(0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testUnitVec() {
        Vector2 v = unitVec();
        Vector2 expected = new Vec2(1, 1);

        Assertions.assertEquals(expected, v);
    }
}
