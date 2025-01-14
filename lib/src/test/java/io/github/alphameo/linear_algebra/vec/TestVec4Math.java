package io.github.alphameo.linear_algebra.vec;

import static io.github.alphameo.linear_algebra.vec.Vector4Math.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.mat.Mat4;
import io.github.alphameo.linear_algebra.mat.Matrix4;

/**
 * TestVec
 */
public class TestVec4Math {

    @Test
    public void testLength() {
        Vector4 v = new Vec4(2, 1.2f, 0.3f, 4);

        Assertions.assertTrue(Validator.equals(len(v), 4.64004310324807f));
    }

    @Test
    public void testMultiply() {
        Vector4 v1 = new Vec4(-12, 3, 4, 8);
        Vector4 expected = new Vec4(-18, 4.5f, 6, 12);

        Vector4 v = mul(v1, 1.5f);
        mulAsgn(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDivideNormal() {
        Vector4 v1 = new Vec4(-18, 4.5f, 6, 12);
        Vector4 expected = new Vec4(-12, 3, 4, 8);

        Vector4 v = div(v1, 1.5f);
        divAsgn(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testAdd() {
        Vector4 v1 = new Vec4(-12, 3, 4, 8);
        Vector4 v2 = new Vec4(1, 2, 3, 4);
        Vector4 expected = new Vec4(-11, 5, 7, 12);

        Vector4 v = add(v1, v2);
        addAsgn(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testSubtract() {
        Vector4 v1 = new Vec4(-12, 3, 4, 8);
        Vector4 v2 = new Vec4(1, 2.03f, 3, 4);
        Vector4 expected = new Vec4(-13, 0.97f, 1, 4);

        Vector4 v = sub(v1, v2);
        subAsgn(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
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
    public void testProdVec() {
        Matrix4 m = new Mat4(new float[][] {
                { 3, 2, 1, 5 },
                { 6, 5, 4, 7 },
                { 9, 8, 7, 2 },
                { 7, 5, 8, 2 }
        });
        Vector4 v = new Vec4(1, 2, 4, 1);

        Vector4 expected = new Vec4(58, 49, 45, 29);

        Assertions.assertEquals(expected, prod(v, m));
    }

    @Test
    public void testTransformCol() {
        Matrix4 m = new Mat4(new float[][] {
                { 3, 2, 1, 5 },
                { 6, 5, 4, 7 },
                { 9, 8, 7, 2 },
                { 7, 5, 8, 2 }
        });
        Vector4 v = new Vec4(1, 2, 4, 1);

        Vector4 expected = new Vec4(16, 39, 55, 51);

        Assertions.assertEquals(expected, transformedCol(v, m));
    }

    @Test
    public void testTransformRow() {
        Matrix4 m = new Mat4(new float[][] {
                { 3, 2, 1, 5 },
                { 6, 5, 4, 7 },
                { 9, 8, 7, 2 },
                { 7, 5, 8, 2 }
        });
        Vector4 v = new Vec4(1, 2, 4, 1);

        Vector4 expected = new Vec4(58, 49, 45, 29);

        Assertions.assertEquals(expected, transformedRow(v, m));
    }

    @Test
    public void testEquals() {
        Vector4 v1 = new Vec4(-12, 3, 4, 0.1f);
        Vector4 v2 = new Vec4(-12, 3, 4, 0.1f);

        Assertions.assertTrue(VectorMath.equals(v1, v2));
    }

    @Test
    public void testNotEquals() {
        Vector4 v1 = new Vec4(-12, 3, 4, 12.4f);
        Vector4 v2 = new Vec4(-12, 4, 4, 12.3f);

        Assertions.assertTrue(!VectorMath.equals(v1, v2));
    }

    @Test
    public void testZeroVect() {
        Vector4 v = zeroVector();
        Vector4 expected = new Vec4(0, 0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testZeroVec() {
        Vector4 v = zeroVector();
        Vector4 expected = new Vec4(0, 0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testUnitVect() {
        Vector4 v = unitVector();
        Vector4 expected = new Vec4(1, 1, 1, 1);

        Assertions.assertEquals(expected, v);
    }
}
