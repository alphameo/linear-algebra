package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vector3
 */
public interface Vector3<VecType> extends Vector<VecType> {

    float x();

    float y();

    float z();

    void setX(float value);

    void setY(float value);

    void setZ(float value);

    VecType cross(VecType other);
}
