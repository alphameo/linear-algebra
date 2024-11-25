package com.github.ia1phai.linear_algebra.vec;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Vec2
 */
public class Vec2 implements Vector2, Equatable<Vector2>, Copyable<Vec2> {

    float[] entries;

    public Vec2() {
        entries = new float[2];
    }

    public Vec2(final float x, final float y) {
        this();
        entries[0] = x;
        entries[1] = y;
    }

    @Override
    public float get(final int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec2 bounds", i));
        }

        return entries[i];
    }

    @Override
    public float x() {
        return entries[0];
    }

    @Override
    public float y() {
        return entries[1];
    }

    @Override
    public void set(final int i, final float value) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec2 bounds", i));
        }

        entries[i] = value;
    }

    @Override
    public void setX(final float value) {
        entries[0] = value;
    }

    @Override
    public void setY(final float value) {
        entries[1] = value;
    }

    public int size() {
        return 2;
    }

    public float length() {
        return Vec2Math.length(this);
    }

    public Vector2 multiply(final float multiplier) {
        Vec2Math.multiply(this, multiplier);

        return this;
    }

    public Vector2 divide(final float divisor) {
        Vec2Math.divide(this, divisor);

        return this;
    }

    public Vector2 add(final Vector2 v) {
        Vec2Math.add(this, v);

        return this;
    }

    public Vector2 plus(final Vector2 v) {
        return this.copy().add(v);
    }

    public Vector2 subtract(final Vector2 v) {
        Vec2Math.subtract(this, v);

        return this;
    }

    public Vector2 minus(final Vector2 v) {
        return this.copy().add(v);
    }

    public float dot(final Vector2 v) {
        return Vec2Math.dot(this, v);
    }

    public Vector3 toVec3() {
        return Vec2Math.toVec3(this);
    }

    public static Vector2 zeroVec() {
        return Vec2Math.zeroVec();
    }

    public static Vector2 unitVec() {
        return Vec2Math.unitVec();
    }

    public static Vector2 zeroVector() {
        return Vec2Math.zeroVec();
    }

    public static Vector2 unitVector() {
        return Vec2Math.unitVec();
    }

    @Override
    public boolean equalsTo(final Vector2 v) {
        return Vec2Math.equals(this, v);
    }

    @Override
    public Vec2 copy() {
        return new Vec2(this.x(), this.y());
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", x(), y());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(entries);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return VecMath.equals(this, (Vector) obj);
    }
}
