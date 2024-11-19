package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * IVector2
 */
public interface Vector2 extends ArbitraryVector {

    float x();

    float y();

    void setX(float value);

    void setY(float value);

    @Override
    default int size() {
        return 2;
    }

    void add(Vector2 other);

    Vector2 plus(Vector2 other);

    void subtract(Vector2 other);

    Vector2 minus(Vector2 other);

    float dot(Vector2 other);

    boolean equalsTo(Vector2 vector);
}
