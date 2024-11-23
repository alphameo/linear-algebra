package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Vec4
 */
public class Vec4 implements Vector4, Equatable<Vector4>, Copyable<Vec4> {

    float[] entries;

    public Vec4() {
        entries = new float[4];
    }

    public Vec4(final float x, final float y, final float z, final float w) {
        entries[0] = x;
        entries[1] = y;
        entries[2] = z;
        entries[3] = w;
    }

    @Override
    public float get(final int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec4 bounds", i));
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
    public float z() {
        return entries[2];
    }

    @Override
    public float w() {
        return entries[3];
    }

    @Override
    public void set(final int i, final float value) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec4 bounds", i));
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

    @Override
    public void setZ(final float value) {
        entries[2] = value;
    }

    @Override
    public void setW(final float value) {
        entries[3] = value;
    }

    public int size() {
        return 4;
    }

    public float length() {
        return Vec4Math.length(this);
    }

    public Vector4 multiply(final float multiplier) {
        Vec4Math.multiply(this, multiplier);

        return this;
    }

    public Vector4 divide(final float divisor) {
        Vec4Math.divide(this, divisor);

        return this;
    }

    public Vector4 add(final Vector4 other) {
        Vec4Math.add(this, other);

        return this;
    }

    public Vector4 plus(final Vector4 vec) {
        return this.copy().add(vec);
    }

    public Vector4 subtract(final Vector4 other) {
        Vec4Math.subtract(this, other);

        return this;
    }

    public Vector4 minus(final Vector4 vec) {
        return this.copy().add(vec);
    }

    public float dot(final Vector4 other) {
        return Vec4Math.dot(this, other);
    }

    public static Vector4 zeroVector() {
        return new Vec4();
    }

    public static Vector4 unitVector() {
        return new Vec4(1, 1, 1, 1);
    }

    @Override
    public boolean equalsTo(final Vector4 other) {
        return Vec4Math.equals(this, other);
    }

    @Override
    public Vec4 copy() {
        return new Vec4(this.x(), this.y(), this.y(), this.w());
    }

    @Override
    public String toString() {
        return String.format("[%d, %d, %d, %d]", x(), y(), z(), w());
    }
}
