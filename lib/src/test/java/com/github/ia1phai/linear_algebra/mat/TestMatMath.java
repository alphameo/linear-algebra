package com.github.ia1phai.linear_algebra.mat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });
        Matrix expected = new Mat(new float[][] {
                { 7, 8, 9 },
                { 4, 5, 6 },
                { 1, 2, 3 }
        });

        Assertions.assertEquals(expected, swapRows(m, 0, 2));
    }

    @Test
    public void testSwapCols() {
        Matrix m = new Mat(new float[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });
        Matrix expected = new Mat(new float[][] {
                { 3, 2, 1 },
                { 6, 5, 4 },
                { 9, 8, 7 }
        });

        Assertions.assertEquals(expected, swapCols(m, 0, 2));
    }

    @Test
    public void testProd1() {
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
}
