package com.github.ia1phai.linear_algebra.vec;

/**
 * Vector4
 */
public interface Vector4 extends Vector {

    float x();

    float y();

    float z();

    float w();

    void setX(float value);

    void setY(float value);

    void setZ(float value);

    void setW(float value);

    @Override
    default int size() {
        return 4;
    }
}
