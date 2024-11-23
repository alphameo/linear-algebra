package com.github.ia1phai.linear_algebra.mat;

/**
 * Matrix3
 */
public interface Matrix3 extends Matrix {

    float get(Matrix3Row row, Matrix3Col col);

    void set(Matrix3Row row, Matrix3Col col, float value);
}
