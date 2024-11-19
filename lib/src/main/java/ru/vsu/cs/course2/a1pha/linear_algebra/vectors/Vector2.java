package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * IVector2
 */
public interface Vector2<VecType> extends Vector<VecType> {

    float x();

    float y();

    void setX(float value);

    void setY(float value);
}
