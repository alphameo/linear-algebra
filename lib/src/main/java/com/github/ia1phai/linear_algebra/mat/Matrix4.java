package com.github.ia1phai.linear_algebra.mat;

/**
 * Matrix3
 */
public interface Matrix4 extends Matrix {

    float get(Matrix4Row row, Matrix4Col col);

    void set(Matrix4Row row, Matrix4Col col, float value);
}
