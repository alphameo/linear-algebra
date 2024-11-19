package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vector4
 */
public interface Vector4<VecType> extends Vector<VecType> {

    float x();

    float y();

    float z();

    float w();

    void setX(float value);

    void setY(float value);

    void setZ(float value);

    void setW(float value);
}
