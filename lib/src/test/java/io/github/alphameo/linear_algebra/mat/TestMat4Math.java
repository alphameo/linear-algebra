package io.github.alphameo.linear_algebra.mat;

import static io.github.alphameo.linear_algebra.mat.Matrix4Math.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.alphameo.linear_algebra.vec.Vec4;
import io.github.alphameo.linear_algebra.vec.Vector4;

/**
 * TestMatMath
 */
public class TestMat4Math {

    @Test
    public void testTranspose() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 5, 6, 12 },
                { 5, 6, 7, 5 },
                { 4, 5, 0, 1 }
        });
        Matrix4 expected = new Mat4(new float[][] {
                { 1, 4, 5, 4 },
                { 2, 5, 6, 5 },
                { 3, 6, 7, 0 },
                { 6, 12, 5, 1 }
        });

        Assertions.assertEquals(expected, transposed(m));
        Assertions.assertEquals(expected, transpose(m));
    }

    @Test
    public void testSwapRows() {
        Matrix4 m = new Mat4(new float[][] {
                { 3, 2, 1, 5 },
                { 6, 5, 4, 3 },
                { 9, 8, 7, 66 },
                { 5, 7, 3, 6 }
        });
        Matrix4 expected = new Mat4(new float[][] {
                { 9, 8, 7, 66 },
                { 6, 5, 4, 3 },
                { 3, 2, 1, 5 },
                { 5, 7, 3, 6 }
        });

        Assertions.assertEquals(expected, swappedRows(m, Matrix4Row.R0, Matrix4Row.R2));
        Assertions.assertEquals(expected, swappedRows(m, 0, 2));
        Assertions.assertEquals(expected, swapRows(m, Matrix4Row.R0, Matrix4Row.R2));
        swapRows(m, Matrix4Row.R0, Matrix4Row.R2);
        Assertions.assertEquals(expected, swapRows(m, 0, 2));
    }

    @Test
    public void testSwapCols() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 2 },
                { 4, 5, 6, 3 },
                { 7, 8, 9, 4 },
                { 1, 6, 5, 0 }
        });
        Matrix4 expected = new Mat4(new float[][] {
                { 3, 2, 1, 2 },
                { 6, 5, 4, 3 },
                { 9, 8, 7, 4 },
                { 5, 6, 1, 0 }
        });

        Assertions.assertEquals(expected, swappedCols(m, Matrix4Col.C0, Matrix4Col.C2));
        Assertions.assertEquals(expected, swappedCols(m, 0, 2));
        Assertions.assertEquals(expected, swapCols(m, Matrix4Col.C0, Matrix4Col.C2));
        swapCols(m, Matrix4Col.C0, Matrix4Col.C2);
        Assertions.assertEquals(expected, swapCols(m, 0, 2));
    }

    @Test
    public void testMult() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 5, 6, 7 },
                { 7, 8, 9, 9 },
                { 3, 6, 9, 3 }
        });
        Matrix4 expected = new Mat4(new float[][] {
                { 2, 4, 6, 12 },
                { 8, 10, 12, 14 },
                { 14, 16, 18, 18 },
                { 6, 12, 18, 6 }
        });

        Assertions.assertEquals(expected, multiplied(m, 2));
        Assertions.assertEquals(expected, mult(m, 2));
    }

    @Test
    public void testDivide() {
        Matrix4 m = new Mat4(new float[][] {
                { 2, 4, 6, 12 },
                { 8, 10, 12, 14 },
                { 14, 16, 18, 18 },
                { 6, 12, 18, 6 }
        });
        Matrix4 expected = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 5, 6, 7 },
                { 7, 8, 9, 9 },
                { 3, 6, 9, 3 }
        });

        Assertions.assertEquals(expected, divided(m, 2));
        Assertions.assertEquals(expected, divide(m, 2));
    }

    @Test
    public void testAdd() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 5, 6, 7 },
                { 7, 8, 9, 9 },
                { 3, 6, 9, 3 }
        });
        Matrix4 expected = new Mat4(new float[][] {
                { 2, 4, 6, 12 },
                { 8, 10, 12, 14 },
                { 14, 16, 18, 18 },
                { 6, 12, 18, 6 }
        });

        Assertions.assertEquals(expected, add(m, m));
        Assertions.assertEquals(expected, addIncr(m, m));
    }

    @Test
    public void testSub() {
        Matrix4 m = new Mat4(new float[][] {
                { 2, 4, 6, 12 },
                { 8, 10, 12, 14 },
                { 14, 16, 18, 18 },
                { 6, 12, 18, 6 }
        });
        Matrix4 expected = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 5, 6, 7 },
                { 7, 8, 9, 9 },
                { 3, 6, 9, 3 }
        });

        Assertions.assertEquals(expected, subtracted(m, expected));
        Assertions.assertEquals(expected, subIncr(m, expected));
    }

    @Test
    public void testProdMat() {
        Matrix4 m1 = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 5, 6, 7 },
                { 7, 8, 9, 8 },
                { 2, 6, 3, 9 }
        });
        Matrix4 m2 = new Mat4(new float[][] {
                { 3, 2, 1, 5 },
                { 6, 5, 4, 2 },
                { 9, 8, 7, 5 },
                { 3, 9, 3, 5 }
        });

        Matrix4 expected = new Mat4(new float[][] {
                { 60, 90, 48, 54 },
                { 117, 144, 87, 95 },
                { 174, 198, 126, 136 },
                { 96, 139, 74, 82 }
        });

        Assertions.assertEquals(expected, prod(m1, m2));
    }

    @Test
    public void testProdVec1() {
        Matrix4 m = new Mat4(new float[][] {
                { 3, 2, 1, 5 },
                { 6, 5, 4, 7 },
                { 9, 8, 7, 2 },
                { 7, 5, 8, 2 }
        });
        Vector4 v = new Vec4(1, 2, 4, 1);

        Vector4 expected = new Vec4(16, 39, 55, 51);

        Assertions.assertEquals(expected, prod(m, v));
    }

    @Test
    public void testTriangulation() {
        Matrix4 m = new Mat4(new float[][] {
                { 2, -1, 1, 4 },
                { 1, 2, -1, 7 },
                { 2, -1, 1, 4 },
                { 1, 5, -5, 4 }
        });

        Matrix4 expected = new Mat4(new float[][] {
                { -2, 1, -1, -4 },
                { 0, 2.5f, -1.5f, 5 },
                { 0, 0, -2.2f, -9 },
                { 0, 0, 0, 0 }
        });

        Assertions.assertEquals(expected, triangulate(m));
    }

    @Test
    public void testDet0() {
        Matrix4 m = new Mat4(new float[][] {
                { 2, -1, 1, 4 },
                { 1, 2, -1, 7 },
                { 2, -1, 1, 4 },
                { 1, 5, -5, 4 }
        });

        Assertions.assertEquals(0, det(m));
    }

    @Test
    public void testDet() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Assertions.assertEquals(-1260, det(m));
    }

    @Test
    public void testInvert() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Matrix4 expected = new Mat4(new float[][] {
                { -58f / 105, -0.1f, 5f / 21, 2f / 35 },
                { 6f / 35, 0.1f, -1f / 7, 3f / 35 },
                { 8f / 315, 1f / 30, 8f / 63, -22f / 105 },
                { 17f / 90, -1f / 30, -1f / 18, 1f / 15 }
        });

        Assertions.assertEquals(expected, invertible(m));
    }

    @Test
    public void testMinorMatrix1() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Matrix3 expected = new Mat3(new float[][] {
                { 12, 6, 0 },
                { 8, 9, 12 },
                { 7, 2, 8 }
        });

        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, 0, 0)));
        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, Matrix4Row.R0, Matrix4Col.C0)));
    }

    @Test
    public void testMinorMatrix2() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Matrix expected = new Mat(new float[][] {
                { 1, 3, 6 },
                { 7, 9, 12 },
                { 5, 2, 8 }
        });

        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, 1, 1)));
        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, Matrix4Row.R1, Matrix4Col.C1)));
    }

    @Test
    public void testMinorMatrix3() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Matrix expected = new Mat(new float[][] {
                { 1, 2, 6 },
                { 4, 12, 0 },
                { 5, 7, 8 }
        });

        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, 2, 2)));
        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, Matrix4Row.R2, Matrix4Col.C2)));
    }

    @Test
    public void testMinorMatrix4() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Matrix expected = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, 3, 3)));
        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, Matrix4Row.R3, Matrix4Col.C3)));
    }

    @Test
    public void testCofactor1() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 12, 6, 5 },
                { 7, 8, 9, 7 },
                { 3, 2, 1, 5 }
        });

        Assertions.assertEquals(250, cofactor(m, 0, 0));
    }

    @Test
    public void testCofactor2() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 12, 6, 5 },
                { 7, 8, 9, 7 },
                { 3, 2, 1, 5 }
        });

        Assertions.assertEquals(32, cofactor(m, 0, 1));
    }

    @Test
    public void testEquals() {
        Matrix4 m1 = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Matrix4 m2 = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Assertions.assertTrue(MatrixMath.equals(m1, m2));
    }

    @Test
    public void testNotEquals() {
        Matrix4 m1 = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 0, 8 }
        });

        Matrix4 m2 = new Mat4(new float[][] {
                { 1, 2, 3, 6 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 12 },
                { 5, 7, 2, 8 }
        });

        Assertions.assertTrue(!MatrixMath.equals(m1, m2));
    }

    @Test
    public void testIsZeroed() {
        Matrix4 m = new Mat4(new float[][] {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        });

        Assertions.assertTrue(isZeroed(m));
    }

    @Test
    public void testIsNotZeroed() {
        Matrix4 m = new Mat4(new float[][] {
                { 0, 0, 0, 0 },
                { 2, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        });

        Assertions.assertTrue(!isZeroed(m));
    }

    @Test
    public void testDiagonal1() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 0, 0, 0 },
                { 0, 2, 0, 0 },
                { 0, 0, 45, 0 },
                { 0, 0, 0, 6 }
        });

        Assertions.assertTrue(diagonal(m));
    }

    @Test
    public void testDiagonal2() {
        Matrix4 m = new Mat4(new float[][] {
                { 0, 0, 0, 0 },
                { 0, 2, 0, 0 },
                { 0, 0, 45, 0 },
                { 0, 0, 0, 0 }
        });

        Assertions.assertTrue(diagonal(m));
    }

    @Test
    public void testNotDiagonal() {
        Matrix4 m = new Mat4(new float[][] {
                { 1, 0, 3, 0 },
                { 0, 2, 0, 0 },
                { 0, 0, 45, 0 },
                { 0, 0, 0, 0 }
        });

        Assertions.assertTrue(!diagonal(m));
    }

    @Test
    public void testZeroMat() {
        Matrix4 m = zeroMatrix();
        Matrix4 expected = new Mat4(new float[][] {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        });

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testUnitMat() {
        Matrix4 m = unitMatrix();
        Matrix4 expected = new Mat4(new float[][] {
                { 1, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 1 }
        });

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testFromVectorRows() {
        Vector4 v1 = new Vec4(1, 2, 3, 0);
        Vector4 v2 = new Vec4(4, 5, 6, 5);
        Vector4 v3 = new Vec4(7, 8, 9, 8);
        Vector4 v4 = new Vec4(1, 6, 5, 0);
        Matrix4 m = Matrix4Math.fromVecRows(v1, v2, v3, v4);
        Matrix4 expected = new Mat4(
                1, 2, 3, 0,
                4, 5, 6, 5,
                7, 8, 9, 8,
                1, 6, 5, 0);

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testFromVectorCols() {
        Vector4 v1 = new Vec4(1, 2, 3, 0);
        Vector4 v2 = new Vec4(4, 5, 6, 5);
        Vector4 v3 = new Vec4(7, 8, 9, 8);
        Vector4 v4 = new Vec4(1, 6, 5, 0);
        Matrix4 m = Matrix4Math.fromVecCols(v1, v2, v3, v4);
        Matrix4 expected = new Mat4(
                1, 4, 7, 1,
                2, 5, 8, 6,
                3, 6, 9, 5,
                0, 5, 8, 0);

        Assertions.assertEquals(expected, m);
    }
}
