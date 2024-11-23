package com.github.ia1phai.linear_algebra.mat;

/**
 * ArbitraryMatrix
 */
public interface Matrix {

    float get(int row, int col);

    void set(int row, int col, float value);

    int width();

    int height();
}
