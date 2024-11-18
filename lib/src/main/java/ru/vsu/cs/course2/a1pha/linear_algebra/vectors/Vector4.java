package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;

/**
 * Vector4
 */
public interface Vector4<Vec> extends VectorOperations<Vec>, Copyable<Vec> {

    float x();

    float y();

    float z();

    float w();

    void setX(float value);

    void setY(float value);

    void setZ(float value);

    void setW(float value);
}
