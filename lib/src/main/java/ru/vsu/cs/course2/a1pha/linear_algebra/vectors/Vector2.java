package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * IVector2
 */
public interface Vector2 extends VectorInterface<Vector2> {

    float x();

    float y();

    void setX(float value);

    void setY(float value);

    @Override
    default int size() {
        return 2;
    }

    Vector3 toVec3();
}
