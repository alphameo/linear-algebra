package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;

/**
 * IVector2
 */
public interface Vector2<Vec> extends VectorOperations<Vec>, Copyable<Vec> {

    float x();

    float y();

    void setX(float value);

    void setY(float value);
}
