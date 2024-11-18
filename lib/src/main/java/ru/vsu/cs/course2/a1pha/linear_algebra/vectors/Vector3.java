package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;

/**
 * Vector3
 */
public interface Vector3<Vec> extends VectorOperations<Vec>, Copyable<Vec> {

    float x();

    float y();

    float z();

    void setX(float value);

    void setY(float value);

    void setZ(float value);

    Vec cross(Vec other);
}
