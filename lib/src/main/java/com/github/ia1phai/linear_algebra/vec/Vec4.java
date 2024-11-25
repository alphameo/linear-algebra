package com.github.ia1phai.linear_algebra.vec;

import java.util.Arrays;

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
        this();
        entries[0] = x;
        entries[1] = y;
        entries[2] = z;
        entries[3] = w;
    }

    public Vec4(Vector4 v) {
        this(v.x(), v.y(), v.z(), v.w());
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

    public float len() {
        return Vec4Math.len(this);
    }

    public Vector4 mult(final float multiplier) {
        return Vec4Math.mult(this, multiplier);
    }

    public Vector4 multiplied(final float multiplier) {
        return Vec4Math.multiplied(this, multiplier);
    }

    public Vector4 divide(final float divisor) {
        return Vec4Math.divide(this, divisor);
    }

    public Vector4 divided(final float divisor) {
        return Vec4Math.divided(this, divisor);
    }

    public Vector4 add(final Vector4 other) {
        return Vec4Math.add(this, other);
    }

    public Vector4 added(final Vector4 other) {
        return Vec4Math.added(this, other);
    }

    public Vector4 sub(final Vector4 other) {
        return Vec4Math.sub(this, other);
    }

    public Vector4 subtracted(final Vector4 other) {
        return Vec4Math.subtracted(this, other);
    }

    public static Vector4 normalize(final Vector4 v) {
        return Vec4Math.normalize(v);
    }

    public static Vector4 normalized(final Vector4 v) {
        return Vec4Math.normalized(v);
    }

    public float dot(final Vector4 other) {
        return Vec4Math.dot(this, other);
    }

    public static Vector4 zeroVector() {
        return new Vec4();
    }

    public static Vector4 unitVector() {
        return Vec4Math.unitVec();
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
