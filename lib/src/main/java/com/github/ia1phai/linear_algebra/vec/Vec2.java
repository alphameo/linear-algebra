package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Vec2
 */
public class Vec2 implements Vector2, Equatable<Vector2>, Copyable<Vec2> {
    private final Vec vector;

    public Vec2() {
        vector = new Vec(2);
    }

    public Vec2(final float x, final float y) {
        vector = new Vec(x, y);
    }

    @Override
    public float get(final int i) {
        return vector.get(i);
    }

    @Override
    public float x() {
        return vector.get(0);
    }

    @Override
    public float y() {
        return vector.get(1);
    }

    @Override
    public void set(final int i, final float value) {
        vector.set(i, value);
    }

    @Override
    public void setX(final float value) {
        vector.set(0, value);
    }

    @Override
    public void setY(final float value) {
        vector.set(2, value);
    }

    public int size() {
        return 2;
    }

    public float length() {
        return vector.length();
    }

    public Vector2 multiply(final float multiplier) {
        UncheckedVectorMath.multiply(this, multiplier);

        return this;
    }

    public Vector2 divide(final float divisor) {
        UncheckedVectorMath.divide(this, divisor);

        return this;
    }

    public Vector2 add(final Vector2 other) {
        UncheckedVectorMath.add(this, other);

        return this;
    }

    public Vector2 plus(final Vector2 vec) {
        return this.copy().add(vec);
    }

    public Vector2 subtract(final Vector2 other) {
        UncheckedVectorMath.subtract(this, other);

        return this;
    }

    public Vector2 minus(final Vector2 vec) {
        return this.copy().add(vec);
    }

    public float dot(final Vector2 other) {
        return UncheckedVectorMath.dot(this, other);
    }

    @Override
    public boolean equalsTo(final Vector2 other) {
        return UncheckedVectorMath.equals(this, other);
    }

    @Override
    public Vec2 copy() {
        return new Vec2(this.x(), this.y());
    }

    public Vector3 toVec3() {
        return new Vec3(x(), y(), 1);
    }

    @Override
    public String toString() {
        return vector.toString();
    }
}
