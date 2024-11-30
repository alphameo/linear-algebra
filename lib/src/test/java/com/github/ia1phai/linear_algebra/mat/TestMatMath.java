package com.github.ia1phai.linear_algebra.mat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.github.ia1phai.linear_algebra.vec.Vec;
import com.github.ia1phai.linear_algebra.vec.Vector;
import static com.github.ia1phai.linear_algebra.mat.MatMath.*;

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

        Assertions.assertEquals(expected, mult(m, 2));
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

        Assertions.assertEquals(expected, divide(m, 2));
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

        Assertions.assertEquals(expected, prod(m, v));
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
            prod(m, v);
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

        Assertions.assertEquals(0, det(m));
    }

    @Test
    public void testDet2() {
        Matrix m = new Mat(new float[][] {
                { 3, 2 },
                { 6, 5 }
        });

        Assertions.assertEquals(3, det(m));
    }

    @Test
    public void testDet3() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 12, 6 },
                { 7, 8, 9 }
        });

        Assertions.assertEquals(-84, det(m));
    }

    @Test
    public void testDet4() {
        Matrix m = new Mat(new float[][] {
                { 2, 6, -2, 1 },
                { 3, -1, 5, -3 },
                { 1, 7, 4, -1 },
                { 2, 3, -3, 1 }
        });

        Assertions.assertEquals(3, det(m));
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
}
