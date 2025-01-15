package io.github.alphameo.linear_algebra.mat;

import static io.github.alphameo.linear_algebra.mat.Matrix3Math.add;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.addAsgn;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.cofactor;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.det;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.diagonal;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.div;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.divAsgn;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.inv;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.minorMatrix;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.mul;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.mulAsgn;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.prod;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.prodCol;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.prodRow;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.sub;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.subAsgn;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.swapCols;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.swapRows;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.swappedCols;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.swappedRows;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.transpose;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.transposed;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.triangulate;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.unitMatrix;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.zeroMatrix;
import static io.github.alphameo.linear_algebra.mat.Matrix3Math.zeroed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.alphameo.linear_algebra.vec.Vec3;
import io.github.alphameo.linear_algebra.vec.Vector3;

/**
 * TestMatMath
 */
public class TestMat3Math {

    @Test
    public void testTranspose() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 5, 6, 7 }
        });
        Matrix3 expected = new Mat3(new float[][] {
                { 1, 4, 5 },
                { 2, 5, 6 },
                { 3, 6, 7 }
        });

        Assertions.assertEquals(expected, transposed(m));
        Assertions.assertEquals(expected, transpose(m));
    }

    @Test
    public void testSwapRows() {
        Matrix3 m = new Mat3(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 }
        });
        Matrix3 expected = new Mat3(new float[][] {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        });

        Assertions.assertEquals(expected, swappedRows(m, Matrix3Row.R0, Matrix3Row.R2));
        Assertions.assertEquals(expected, swapRows(m, Matrix3Row.R0, Matrix3Row.R2));
    }

    @Test
    public void testSwapCols() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });
        Matrix3 expected = new Mat3(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 }
        });

        Assertions.assertEquals(expected, swappedCols(m, Matrix3Col.C0, Matrix3Col.C2));
        Assertions.assertEquals(expected, swapCols(m, Matrix3Col.C0, Matrix3Col.C2));
    }

    @Test
    public void testMult() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });
        Matrix3 expected = new Mat3(new float[][] {
                { 2, 4, 6 },
                { 8, 10, 12 },
                { 14, 16, 18 }
        });

        Assertions.assertEquals(expected, mul(m, 2));
        Assertions.assertEquals(expected, mulAsgn(m, 2));
    }

    @Test
    public void testDivide() {
        Matrix3 m = new Mat3(new float[][] {
                { 2, 4, 6 },
                { 8, 10, 12 },
                { 14, 16, 18 }
        });
        Matrix3 expected = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(expected, div(m, 2));
        Assertions.assertEquals(expected, divAsgn(m, 2));
    }

    @Test
    public void testAdd() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });
        Matrix3 expected = new Mat3(new float[][] {
                { 2, 4, 6 },
                { 8, 10, 12 },
                { 14, 16, 18 }
        });

        Assertions.assertEquals(expected, add(m, m));
        Assertions.assertEquals(expected, addAsgn(m, m));
    }

    @Test
    public void testSub() {
        Matrix3 m = new Mat3(new float[][] {
                { 2, 4, 6 },
                { 8, 10, 12 },
                { 14, 16, 18 }
        });
        Matrix3 expected = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(expected, sub(m, expected));
        Assertions.assertEquals(expected, subAsgn(m, expected));
    }

    @Test
    public void testProdMat() {
        Matrix3 m1 = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });
        Matrix3 m2 = new Mat3(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 }
        });

        Matrix3 expected = new Mat3(new float[][] {
                { 42, 36, 30 },
                { 96, 81, 66 },
                { 150, 126, 102 }
        });

        Assertions.assertEquals(expected, prod(m1, m2));
    }

    @Test
    public void testProdVec() {
        Matrix3 m = new Mat3(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 }
        });
        Vector3 v = new Vec3(1, 2, 4);

        Vector3 expected = new Vec3(11, 32, 53);

        Assertions.assertEquals(expected, prod(m, v));
    }

    @Test
    public void testProdVecCol() {
        Matrix3 m = new Mat3(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 }
        });
        Vector3 v = new Vec3(1, 2, 4);

        Vector3 expected = new Vec3(11, 32, 53);

        Assertions.assertEquals(expected, prodCol(m, v));
    }

    @Test
    public void testProdVecRow() {
        Matrix3 m = new Mat3(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 }
        });
        Vector3 v = new Vec3(1, 2, 4);

        Vector3 expected = new Vec3(51, 44, 37);

        Assertions.assertEquals(expected, prodRow(m, v));
    }

    @Test
    public void testTriangulation() {
        Matrix3 m = new Mat3(new float[][] {
                { 2, -1, 1 },
                { 1, 2, -1 },
                { 2, -1, 1 }
        });

        Matrix3 expected = new Mat3(new float[][] {
                { 2, -1, 1 },
                { 0, 2.5f, -1.5f },
                { 0, 0, 0 }
        });

        Assertions.assertEquals(expected, triangulate(m));
    }

    @Test
    public void testDet0() {
        Matrix3 m = new Mat3(new float[][] {
                { 2, -1, 1 },
                { 1, 2, -1 },
                { 2, -1, 1 }
        });

        Assertions.assertEquals(0, det(m));
    }

    @Test
    public void testDet() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(-84, det(m));
    }

    @Test
    public void testInvert() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix3 expected = new Mat3(new float[][] {
                { -5f / 7, -1f / 14, 2f / 7 },
                { -1f / 14, 1f / 7, -1f / 14 },
                { 13f / 21, -1f / 14, -1f / 21 }
        });

        Assertions.assertEquals(expected, inv(m));
    }

    @Test
    public void testMinorMatrix1() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix expected = new Mat(new float[][] {
                { 12, 6 },
                { 8, 9 }
        });

        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, Matrix3Row.R0, Matrix3Col.C0)));
    }

    @Test
    public void testMinorMatrix2() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix expected = new Mat(new float[][] {
                { 1, 3 },
                { 7, 9 }
        });

        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, Matrix3Row.R1, Matrix3Col.C1)));
    }

    @Test
    public void testMinorMatrix3() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix expected = new Mat(new float[][] {
                { 1, 2 },
                { 4, 12 },
        });

        Assertions.assertTrue(MatrixMath.equals(expected, minorMatrix(m, Matrix3Row.R2, Matrix3Col.C2)));
    }

    @Test
    public void testCofactor1() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(60, cofactor(m, Matrix3Row.R0, Matrix3Col.C0));
    }

    @Test
    public void testCofactor2() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(6, cofactor(m, Matrix3Row.R0, Matrix3Col.C1));
    }

    @Test
    public void testEquals() {
        Matrix3 m1 = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix3 m2 = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertTrue(MatrixMath.equals(m1, m2));
    }

    @Test
    public void testNotEquals() {
        Matrix3 m1 = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix3 m2 = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 2, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertTrue(!MatrixMath.equals(m1, m2));
    }

    @Test
    public void testIsZeroed() {
        Matrix3 m = new Mat3(new float[][] {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        });

        Assertions.assertTrue(zeroed(m));
    }

    @Test
    public void testIsNotZeroed() {
        Matrix3 m = new Mat3(new float[][] {
                { 0, 0, 0 },
                { 0, 0, 5 },
                { 0, 0, 0 }
        });

        Assertions.assertTrue(!zeroed(m));
    }

    @Test
    public void testDiagonal1() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 0, 0 },
                { 0, 2, 0 },
                { 0, 0, 45 }
        });

        Assertions.assertTrue(diagonal(m));
    }

    @Test
    public void testDiagonal2() {
        Matrix3 m = new Mat3(new float[][] {
                { 0, 0, 0 },
                { 0, 2, 0 },
                { 0, 0, 45 }
        });

        Assertions.assertTrue(diagonal(m));
    }

    @Test
    public void testNotDiagonal() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 0, 3 },
                { 0, 2, 0 },
                { 0, 0, 45 }
        });

        Assertions.assertTrue(!diagonal(m));
    }

    @Test
    public void TestToMat4T1() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix4 expected = new Mat4(new float[][] {
                { 1, 0, 0, 0 },
                { 0, 1, 2, 3 },
                { 0, 4, 12, 6 },
                { 0, 7, 8, 9 }
        });

        Assertions.assertEquals(expected,
                Matrix3Math.toMatrix4(
                        m,
                        Matrix4Row.R0,
                        Matrix4Col.C0));
    }

    @Test
    public void TestToMat4T2() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix4 expected = new Mat4(new float[][] {
                { 1, 0, 2, 3 },
                { 0, 1, 0, 0 },
                { 4, 0, 12, 6 },
                { 7, 0, 8, 9 }
        });

        Assertions.assertEquals(expected,
                Matrix3Math.toMatrix4(
                        m,
                        Matrix4Row.R1,
                        Matrix4Col.C1));
    }

    @Test
    public void TestToMat4T3() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix4 expected = new Mat4(new float[][] {
                { 1, 2, 0, 3 },
                { 4, 12, 0, 6 },
                { 0, 0, 1, 0 },
                { 7, 8, 0, 9 }
        });

        Assertions.assertEquals(expected,
                Matrix3Math.toMatrix4(
                        m,
                        Matrix4Row.R2,
                        Matrix4Col.C2));
    }

    @Test
    public void TestToMat4T4() {
        Matrix3 m = new Mat3(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix4 expected = new Mat4(new float[][] {
                { 1, 2, 3, 0 },
                { 4, 12, 6, 0 },
                { 7, 8, 9, 0 },
                { 0, 0, 0, 1 }
        });

        Assertions.assertEquals(expected,
                Matrix3Math.toMatrix4(
                        m,
                        Matrix4Row.R3,
                        Matrix4Col.C3));
    }

    @Test
    public void testZeroMat() {
        Matrix3 m = zeroMatrix();
        Matrix3 expected = new Mat3(new float[][] {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        });

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testUnitMat() {
        Matrix3 m = unitMatrix();
        Matrix3 expected = new Mat3(new float[][] {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        });

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testFromVectorRows() {
        Vector3 v1 = new Vec3(1, 2, 3);
        Vector3 v2 = new Vec3(4, 5, 6);
        Vector3 v3 = new Vec3(7, 8, 9);
        Matrix3 m = Matrix3Math.fromVecRows(v1, v2, v3);
        Matrix3 expected = new Mat3(
                1, 2, 3,
                4, 5, 6,
                7, 8, 9);

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testFromVectorCols() {
        Vector3 v1 = new Vec3(1, 2, 3);
        Vector3 v2 = new Vec3(4, 5, 6);
        Vector3 v3 = new Vec3(7, 8, 9);
        Matrix3 m = Matrix3Math.fromVecCols(v1, v2, v3);
        Matrix3 expected = new Mat3(
                1, 4, 7,
                2, 5, 8,
                3, 6, 9);

        Assertions.assertEquals(expected, m);
    }
}
