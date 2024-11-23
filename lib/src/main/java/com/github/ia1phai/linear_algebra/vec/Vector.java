package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Equatable;

public interface Vector {

    public float get(final int index);

    public void set(final int index, final float value);

    public int size();
}
