package com.github.ia1phai.linear_algebra.mat;

import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;

/**
 * ArbitraryMatrix
 */
public interface Matrix extends Equatable<Matrix> {

    float get(int row, int col);

    void set(int row, int col, float value);

    int width();

    int height();
}
