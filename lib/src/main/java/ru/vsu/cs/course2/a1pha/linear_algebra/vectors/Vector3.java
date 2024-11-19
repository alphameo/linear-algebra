package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vector3
 */
public interface Vector3 extends VectorInterface<Vector3> {

    float x();

    float y();

    float z();

    void setX(float value);

    void setY(float value);

    void setZ(float value);

    @Override
    default int size() {
        return 3;
    }

    Vector3 cross(Vector3 other);

    Vector4 toVec4();
}
