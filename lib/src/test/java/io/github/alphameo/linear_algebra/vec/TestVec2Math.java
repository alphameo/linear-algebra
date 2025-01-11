package io.github.alphameo.linear_algebra.vec;

import static io.github.alphameo.linear_algebra.vec.Vector2Math.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.alphameo.linear_algebra.Validator;

/**
 * TestVec
 */
public class TestVec2Math {

    @Test
    public void testLength() {
        Vector2 v = new Vec2(2, 1.2f);

        Assertions.assertTrue(Validator.equals(len(v), 2.33238076f));
    }

    @Test
    public void testLength2() {
        Vector2 v = new Vec2(2, 1.2f);

        Assertions.assertTrue(Validator.equals(len2(v), 5.44f));
    }

    @Test
    public void testMultiply() {
        Vector2 v1 = new Vec2(-12, 3);
        Vector2 expected = new Vec2(-18, 4.5f);

        Vector2 v = multiplied(v1, 1.5f);
        mult(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDivide() {
        Vector2 v1 = new Vec2(-18, 4.5f);
        Vector2 expected = new Vec2(-12, 3);

        Vector2 v = divided(v1, 1.5f);
        divide(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testAdd() {
        Vector2 v1 = new Vec2(-12, 3);
        Vector2 v2 = new Vec2(1, 2);
        Vector2 expected = new Vec2(-11, 5);

        Vector2 v = added(v1, v2);
        add(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testSubtract() {
        Vector2 v1 = new Vec2(-12, 3);
        Vector2 v2 = new Vec2(1, 2.03f);
        Vector2 expected = new Vec2(-13, 0.97f);

        Vector2 v = subtracted(v1, v2);
        sub(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
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

        Assertions.assertTrue(VectorMath.equals(v1, v2));
    }

    @Test
    public void testNotEquals() {
        Vector2 v1 = new Vec2(-12, 4);
        Vector2 v2 = new Vec2(-12, 3);

        Assertions.assertTrue(!Vector2Math.equals(v1, v2));
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
