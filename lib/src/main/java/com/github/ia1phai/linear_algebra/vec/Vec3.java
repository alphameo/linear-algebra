package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Vec2
 */
public class Vec3 implements Vector3, Equatable<Vector3>, Copyable<Vec3> {

    float[] entries;

    public Vec3() {
        entries = new float[3];
    }

    public Vec3(final float x, final float y, final float z) {
        entries[0] = x;
        entries[1] = y;
        entries[2] = z;
    }

    @Override
    public float get(final int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec3 bounds", i));
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
    public void set(final int i, final float value) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec3 bounds", i));
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

    public int size() {
        return 3;
    }

    public float length() {
        return Vec3Math.length(this);
    }

    public Vector3 multiply(final float multiplier) {
        Vec3Math.multiply(this, multiplier);

        return this;
    }

    public Vector3 divide(final float divisor) {
        Vec3Math.divide(this, divisor);

        return this;
    }

    public Vector3 add(final Vector3 other) {
        Vec3Math.add(this, other);

        return this;
    }

    public Vector3 plus(final Vector3 vec) {
        return this.copy().add(vec);
    }

    public Vector3 subtract(final Vector3 other) {
        Vec3Math.subtract(this, other);

        return this;
    }

    public Vector3 minus(final Vector3 vec) {
        return this.copy().add(vec);
    }

    public float dot(final Vector3 other) {
        return Vec3Math.dot(this, other);
    }

    public Vector3 cross(final Vector3 vec) {
        final Vector3 result = new Vec3();
        Vec3Math.cross(this, vec, result);

        return result;
    }

    @Override
    public boolean equalsTo(final Vector3 other) {
        return Vec3Math.equals(this, other);
    }

    @Override
    public Vec3 copy() {
        return new Vec3(this.x(), this.y(), this.y());
    }

    public Vector4 toVec4() {
        return new Vec4(x(), y(), z(), 1);
    }

    public static Vector3 zeroVector() {
        return new Vec3();
    }

    public static Vector3 unitVector() {
        return new Vec3(1, 1, 1);
    }

    @Override
    public String toString() {
        return String.format("[%d, %d, %d]", x(), y(), z());
    }
}
