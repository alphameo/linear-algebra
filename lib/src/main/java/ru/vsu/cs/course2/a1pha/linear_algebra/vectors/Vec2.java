package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Checker;

/**
 * Vec2
 */
public class Vec2 implements Vector2<Vec2> {
    public float x;
    public float y;

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float x() {
        return x;
    }

    @Override
    public float y() {
        return y;
    }

    @Override
    public void setX(float value) {
        x = value;
    }

    @Override
    public void setY(float value) {
        y = value;
    }

    @Override
    public void divide(float divisor) throws ArithmeticException {
        Checker.checkDivisor(divisor);

        x /= divisor;
        y /= divisor;
    }

    @Override
    public void multiply(float multiplier) {
        x *= multiplier;
        y *= multiplier;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    @Override
    public void add(Vec2 other) {
        x += other.x;
    }

    @Override
    public Vec2 plus(Vec2 other) {
        Vec2 result = this.copy();
        result.add(other);

        return result;
    }

    @Override
    public void subtract(Vec2 other) {
        x -= other.x;
        y -= other.y;
    }

    @Override
    public Vec2 minus(Vec2 other) {
        Vec2 result = this.copy();
        result.subtract(other);

        return result;
    }

    @Override
    public float dot(Vec2 other) {
        return x * other.x + y * other.y;
    }

    @Override
    public Vec2 copy() {
        return new Vec2(x, y);
    }
}
