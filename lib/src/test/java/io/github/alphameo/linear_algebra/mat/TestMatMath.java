package io.github.alphameo.linear_algebra.mat;

import static io.github.alphameo.linear_algebra.mat.MatrixMath.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.vec.Vec;
import io.github.alphameo.linear_algebra.vec.Vector;

/**
 * TestMatMath
 */
public class TestMatMath {

    @Test
    public void testTranspose() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 }
        });
        Matrix expected = new Mat(new float[][] {
                { 1, 4 },
                { 2, 5 },
                { 3, 6 }
        });

        Assertions.assertEquals(expected, transposed(m));
    }

    @Test
    public void testSwapRows() {
        Matrix m = new Mat(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 },
                { 1, 2, 3 }
        });
        Matrix expected = new Mat(new float[][] {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 },
                { 1, 2, 3 }
        });

        Assertions.assertEquals(expected, swappedRows(m, 0, 2));
        Assertions.assertEquals(expected, swapRows(m, 0, 2));
    }

    @Test
    public void testSwapCols() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });
        Matrix expected = new Mat(new float[][] {
                { 3, 2, 1, 3 },
                { 6, 5, 4, 4 },
                { 9, 8, 7, 0 }
        });

        Assertions.assertEquals(expected, swappedCols(m, 0, 2));
        Assertions.assertEquals(expected, swapCols(m, 0, 2));
    }

    @Test
    public void testMult() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });
        Matrix expected = new Mat(new float[][] {
                { 2, 4, 6, 6 },
                { 8, 10, 12, 8 },
                { 14, 16, 18, 0 }
        });

        Assertions.assertEquals(expected, mul(m, 2));
        Assertions.assertEquals(expected, mulIncr(m, 2));
    }

    @Test
    public void testDivide() {
        Matrix m = new Mat(new float[][] {
                { 2, 4, 6, 6 },
                { 8, 10, 12, 8 },
                { 14, 16, 18, 0 }
        });
        Matrix expected = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });

        Assertions.assertEquals(expected, div(m, 2));
        Assertions.assertEquals(expected, divIncr(m, 2));
    }

    @Test
    public void testAdd() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });
        Matrix expected = new Mat(new float[][] {
                { 2, 4, 6, 6 },
                { 8, 10, 12, 8 },
                { 14, 16, 18, 0 }
        });

        Assertions.assertEquals(expected, add(m, m));
        Assertions.assertEquals(expected, addIncr(m, m));
    }

    @Test
    public void testSub() {
        Matrix m = new Mat(new float[][] {
                { 2, 4, 6, 6 },
                { 8, 10, 12, 8 },
                { 14, 16, 18, 0 }
        });
        Matrix expected = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });

        Assertions.assertEquals(expected, sub(m, expected));
        Assertions.assertEquals(expected, subIncr(m, expected));
    }

    @Test
    public void testProdMat1() {
        Matrix m1 = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });
        Matrix m2 = new Mat(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 },
                { 1, 2, 3 }
        });

        Matrix expected = new Mat(new float[][] {
                { 45, 42, 39 },
                { 100, 89, 78 },
                { 150, 126, 102 }
        });

        Assertions.assertEquals(expected, prod(m1, m2));
    }

    @Test
    public void testProdMat2() {
        Matrix m1 = new Mat(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 },
                { 1, 2, 3 }
        });
        Matrix m2 = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });

        Matrix expected = new Mat(new float[][] {
                { 18, 24, 30, 17 },
                { 54, 69, 84, 38 },
                { 90, 114, 138, 59 },
                { 30, 36, 42, 11 }
        });

        Assertions.assertEquals(expected, prod(m1, m2));
    }

    @Test
    public void testProdMatException() {
        Matrix m1 = new Mat(new float[][] {
                { 3, 2 },
                { 6, 5 },
                { 9, 8 },
                { 1, 2 }
        });
        Matrix m2 = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });

        try {
            prod(m1, m2);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testProdVec1() {
        Matrix m = new Mat(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 },
                { 1, 2, 3 }
        });
        Vector v = new Vec(1, 2, 4);

        Vector expected = new Vec(11, 32, 53, 17);

        Assertions.assertEquals(expected, prodCol(m, v));
    }

    @Test
    public void testProdVecException() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 0 }
        });
        Vector v = new Vec(1, 2, 4);

        try {
            prodCol(m, v);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testTriangulation() {
        Matrix m = new Mat(new float[][] {
                { 2, -1, 1 },
                { 1, 2, -1 },
                { 2, -1, 1 }
        });

        Matrix expected = new Mat(new float[][] {
                { 2, -1, 1 },
                { 0, 2.5f, -1.5f },
                { 0, 0, 0 }
        });

        Assertions.assertEquals(expected, triangulate(m));
    }

    @Test
    public void testDet0() {
        Matrix m = new Mat(new float[][] {
                { 2, -1, 1 },
                { 1, 2, -1 },
                { 2, -1, 1 }
        });

        Assertions.assertEquals(0, detThroughCofactors(m));
    }

    @Test
    public void testDet2() {
        Matrix m = new Mat(new float[][] {
                { 3, 2 },
                { 6, 5 }
        });

        Assertions.assertEquals(3, detThroughCofactors(m));
    }

    @Test
    public void testDet3() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(-84, detThroughCofactors(m));
    }

    @Test
    public void testDet4() {
        Matrix m = new Mat(new float[][] {
                { 2, 6, -2, 1 },
                { 3, -1, 5, -3 },
                { 1, 7, 4, -1 },
                { 2, 3, -3, 1 }
        });

        Assertions.assertTrue(Validator.equalsEpsilon(3, MatrixMath.det(m), 0.0001f));
    }

    @Test
    public void testDet5() {
        Matrix m = new Mat(new float[][] {
                { 1, 4, 3, 6, 6 },
                { 4, 9, 8, 9, 4 },
                { 4, 6, 4, 2, 3 },
                { 3, 5, 5, 7, 1 },
                { 3, 3, 9, 6, 5 }
        });

        Assertions.assertEquals(1616, det(m));
    }

    @Test
    public void testInvert() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix expected = new Mat(new float[][] {
                { -5f / 7, -1f / 14, 2f / 7 },
                { -1f / 14, 1f / 7, -1f / 14 },
                { 13f / 21, -1f / 14, -1f / 21 }
        });

        Assertions.assertEquals(expected, inv(m));
    }

    @Test
    public void testMinorMatrix1() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix expected = new Mat(new float[][] {
                { 12, 6 },
                { 8, 9 }
        });

        Assertions.assertEquals(expected, minorMatrix(m, 0, 0));
    }

    @Test
    public void testMinorMatrix2() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix expected = new Mat(new float[][] {
                { 1, 3 },
                { 7, 9 }
        });

        Assertions.assertEquals(expected, minorMatrix(m, 1, 1));
    }

    @Test
    public void testMinorMatrix3() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix expected = new Mat(new float[][] {
                { 1, 2 },
                { 4, 12 },
        });

        Assertions.assertEquals(expected, minorMatrix(m, 2, 2));
    }

    @Test
    public void testCofactor1() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(60, cofactor(m, 0, 0));
    }

    @Test
    public void testCofactor2() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(6, cofactor(m, 0, 1));
    }

    @Test
    public void testEquals() {
        Matrix m1 = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix m2 = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertTrue(MatrixMath.equals(m1, m2));
    }

    @Test
    public void testNotEquals() {
        Matrix m1 = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Matrix m2 = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 2, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertTrue(!MatrixMath.equals(m1, m2));
    }

    @Test
    public void testSquare() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertTrue(square(m));
    }

    @Test
    public void testNotSquare1() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertTrue(!square(m));
    }

    @Test
    public void testNotSquare2() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3, 2 },
                { 4, 12, 6, 1 },
                { 7, 8, 9, 4 }
        });

        Assertions.assertTrue(!square(m));
    }

    @Test
    public void testDiagonal1() {
        Matrix m = new Mat(new float[][] {
                { 1, 0, 0 },
                { 0, 2, 0 },
                { 0, 0, 45 }
        });

        Assertions.assertTrue(diagonal(m));
    }

    @Test
    public void testIsZeroed() {
        Matrix m = new Mat(new float[][] {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        });

        Assertions.assertTrue(zeroed(m));
    }

    @Test
    public void testIsNotZeroed() {
        Matrix m = new Mat(new float[][] {
                { 0, 0, 0 },
                { 0, 0, 5 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        });

        Assertions.assertTrue(!zeroed(m));
    }

    @Test
    public void testDiagonal2() {
        Matrix m = new Mat(new float[][] {
                { 0, 0, 0 },
                { 0, 2, 0 },
                { 0, 0, 45 }
        });

        Assertions.assertTrue(diagonal(m));
    }

    @Test
    public void testNotDiagonal() {
        Matrix m = new Mat(new float[][] {
                { 1, 0, 3 },
                { 0, 2, 0 },
                { 0, 0, 45 }
        });

        Assertions.assertTrue(!diagonal(m));
    }

    @Test
    public void testZeroMat() {
        Matrix m = MatrixMath.zeroMatrix(3, 4);
        Matrix expected = new Mat(new float[][] {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        });

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testUnitMat() {
        Matrix m = MatrixMath.unitMatrix(3);
        Matrix expected = new Mat(new float[][] {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        });

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testFromVectorRows() {
        Vector v1 = new Vec(1, 2, 3, 3);
        Vector v2 = new Vec(4, 5, 6, 4);
        Vector v3 = new Vec(7, 8, 9, 6);
        Matrix m = MatrixMath.fromVecRows(v1, v2, v3);
        Matrix expected = new Mat(new float[][] {
                { 1, 2, 3, 3 },
                { 4, 5, 6, 4 },
                { 7, 8, 9, 6 }
        });

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testFromVectorRowsException() {
        Vector v1 = new Vec(1, 2, 3);
        Vector v2 = new Vec(4, 5);
        Vector v3 = new Vec(7, 8, 9);
        try {
            Matrix m = MatrixMath.fromVecRows(v1, v2, v3);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testFromVectorCols() {
        Vector v1 = new Vec(1, 2, 3);
        Vector v2 = new Vec(4, 5, 6);
        Matrix m = MatrixMath.fromVecCols(v1, v2);
        Matrix expected = new Mat(new float[][] {
                { 1, 4 },
                { 2, 5 },
                { 3, 6 }
        });

        Assertions.assertEquals(expected, m);
    }

    @Test
    public void testFromVectorColsException() {
        Vector v1 = new Vec(1, 2, 3);
        Vector v2 = new Vec(4, 5);
        Vector v3 = new Vec(7, 8, 9);
        try {
            Matrix m = MatrixMath.fromVecCols(v1, v2, v3);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
