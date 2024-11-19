package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vector3
 */
public interface Vector3 extends ArbitraryVector {

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

    void add(Vector3 other);

    Vector3 plus(Vector3 other);

    void subtract(Vector3 other);

    Vector3 minus(Vector3 other);

    float dot(Vector3 other);

    boolean equalsTo(Vector3 vector);

    Vector3 cross(Vector3 other);
}
