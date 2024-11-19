package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vector4
 */
public interface Vector4 extends ArbitraryVector {

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

    void add(Vector4 other);

    Vector4 plus(Vector4 other);

    void subtract(Vector4 other);

    Vector4 minus(Vector4 other);

    float dot(Vector4 other);

    boolean equalsTo(Vector4 vector);
}
