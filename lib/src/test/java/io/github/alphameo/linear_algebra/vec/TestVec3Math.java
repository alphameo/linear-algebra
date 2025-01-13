package io.github.alphameo.linear_algebra.vec;

import static io.github.alphameo.linear_algebra.vec.Vector3Math.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.alphameo.linear_algebra.Validator;

/**
 * TestVec
 */
public class TestVec3Math {

    @Test
    public void testLength() {
        Vector3 v = new Vec3(2, 1.2f, 0.3f);

        Assertions.assertTrue(Validator.equals(len(v), 2.3515952032609695f));
    }

    @Test
    public void testMultiply() {
        Vector3 v1 = new Vec3(-12, 3, 4);
        Vector3 expected = new Vec3(-18, 4.5f, 6);

        Vector3 v = mul(v1, 1.5f);
        mulAsgn(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDivide() {
        Vector3 v1 = new Vec3(-18, 4.5f, 6);
        Vector3 expected = new Vec3(-12, 3, 4);

        Vector3 v = div(v1, 1.5f);
        divAsgn(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testAdd() {
        Vector3 v1 = new Vec3(-12, 3, 4);
        Vector3 v2 = new Vec3(1, 2, 3);
        Vector3 expected = new Vec3(-11, 5, 7);

        Vector3 v = add(v1, v2);
        addAsgn(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testSubtract() {
        Vector3 v1 = new Vec3(-12, 3, 4);
        Vector3 v2 = new Vec3(1, 2.03f, 3);
        Vector3 expected = new Vec3(-13, 0.97f, 1);

        Vector3 v = sub(v1, v2);
        subAsgn(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
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

        Assertions.assertTrue(VectorMath.equals(v1, v2));
    }

    @Test
    public void testNotEquals() {
        Vector v1 = new Vec(-12, 3, 4);
        Vector v2 = new Vec(-12, 4, 4);

        Assertions.assertTrue(!VectorMath.equals(v1, v2));
    }

    @Test
    public void testZeroVec() {
        Vector3 v = zeroVector();
        Vector3 expected = new Vec3(0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testToVec3() {
        Vector3 v1 = new Vec3(-12, 4, 3);
        Vector4 expected = new Vec4(-12, 4, 3, 1);

        Assertions.assertEquals(expected, toVector4(v1));
    }

    @Test
    public void testUnitVect() {
        Vector3 v = unitVector();
        Vector3 expected = new Vec3(1, 1, 1);

        Assertions.assertEquals(expected, v);
    }
}
