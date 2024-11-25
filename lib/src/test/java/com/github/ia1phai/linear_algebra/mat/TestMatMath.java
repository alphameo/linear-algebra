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

        System.out.println(m);
        System.out.println(expected);
        Assertions.assertEquals(expected, transposed(m));
    }
}
