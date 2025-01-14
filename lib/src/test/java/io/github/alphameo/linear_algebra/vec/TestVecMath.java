package io.github.alphameo.linear_algebra.vec;

import static io.github.alphameo.linear_algebra.vec.VectorMath.add;
import static io.github.alphameo.linear_algebra.vec.VectorMath.addAsgn;
import static io.github.alphameo.linear_algebra.vec.VectorMath.cross;
import static io.github.alphameo.linear_algebra.vec.VectorMath.div;
import static io.github.alphameo.linear_algebra.vec.VectorMath.divAsgn;
import static io.github.alphameo.linear_algebra.vec.VectorMath.dot;
import static io.github.alphameo.linear_algebra.vec.VectorMath.len;
import static io.github.alphameo.linear_algebra.vec.VectorMath.len2;
import static io.github.alphameo.linear_algebra.vec.VectorMath.mul;
import static io.github.alphameo.linear_algebra.vec.VectorMath.mulAsgn;
import static io.github.alphameo.linear_algebra.vec.VectorMath.prod;
import static io.github.alphameo.linear_algebra.vec.VectorMath.sub;
import static io.github.alphameo.linear_algebra.vec.VectorMath.subAsgn;
import static io.github.alphameo.linear_algebra.vec.VectorMath.transformedCol;
import static io.github.alphameo.linear_algebra.vec.VectorMath.transformedRow;
import static io.github.alphameo.linear_algebra.vec.VectorMath.unitVector;
import static io.github.alphameo.linear_algebra.vec.VectorMath.zeroVector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.mat.Mat;
import io.github.alphameo.linear_algebra.mat.Matrix;

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

        Vector v = mul(v1, 1.5f);
        mulAsgn(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testDivideNormal() {
        Vector v1 = new Vec(-18, 4.5f, 6, 12);
        Vector expected = new Vec(-12, 3, 4, 8);

        Vector v = div(v1, 1.5f);
        divAsgn(v1, 1.5f);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testAdd() {
        Vector v1 = new Vec(-12, 3, 4, 8);
        Vector v2 = new Vec(1, 2, 3, 4);
        Vector expected = new Vec(-11, 5, 7, 12);

        Vector v = add(v1, v2);
        addAsgn(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
        Assertions.assertEquals(expected, v1);
    }

    @Test
    public void testSubtract() {
        Vector v1 = new Vec(-12, 3, 4, 8);
        Vector v2 = new Vec(1, 2.03f, 3, 4);
        Vector expected = new Vec(-13, 0.97f, 1, 4);

        Vector v = sub(v1, v2);
        subAsgn(v1, v2);

        // Assertions.assertTrue(v1.equals(expected));
        Assertions.assertEquals(expected, v);
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
    public void testProdVec() {
        Matrix m = new Mat(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 },
                { 1, 2, 3 }
        });
        Vector v = new Vec(1, 2, 4, 9);

        Vector expected = new Vec(60, 62, 64);

        Assertions.assertEquals(expected, prod(v, m));
    }

    @Test
    public void testTransformCol() {
        Matrix m = new Mat(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 },
                { 1, 2, 3 }
        });
        Vector v = new Vec(1, 2, 4);

        Vector expected = new Vec(11, 32, 53, 17);

        Assertions.assertEquals(expected, transformedCol(v, m));
    }

    @Test
    public void testTransformRow() {
        Matrix m = new Mat(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 },
                { 1, 2, 3 }
        });
        Vector v = new Vec(1, 2, 4, 9);

        Vector expected = new Vec(60, 62, 64);

        Assertions.assertEquals(expected, transformedRow(v, m));
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
    public void testZeroVect() {
        Vector v = zeroVector(4);
        Vector expected = new Vec(0, 0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testZeroVec() {
        Vector v = zeroVector(5);
        Vector expected = new Vec(0, 0, 0, 0, 0);

        Assertions.assertEquals(expected, v);
    }

    @Test
    public void testUnitVect() {
        Vector v = unitVector(5);
        Vector expected = new Vec(1, 1, 1, 1, 1);

        Assertions.assertEquals(expected, v);
    }
}
