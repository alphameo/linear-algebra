package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Vec4
 */
public class Vec4 implements Vector4, Equatable<Vector4>, Copyable<Vec4> {
    private final Vec vector;

    public Vec4() {
        vector = new Vec(4);
    }

    public Vec4(final float x, final float y, final float z, final float w) {
        vector = new Vec(x, y, z, w);
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
    public float z() {
        return vector.get(2);
    }

    @Override
    public float w() {
        return vector.get(3);
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

    @Override
    public void setZ(final float value) {
        vector.set(2, value);
    }

    @Override
    public void setW(final float value) {
        vector.set(3, value);
    }

    public int size() {
        return 2;
    }

    public float length() {
        return vector.length();
    }

    public Vector4 multiply(final float multiplier) {
        UncheckedVectorMath.multiply(this, multiplier);

        return this;
    }

    public Vector4 divide(final float divisor) {
        UncheckedVectorMath.divide(this, divisor);

        return this;
    }

    public Vector4 add(final Vector4 other) {
        UncheckedVectorMath.add(this, other);

        return this;
    }

    public Vector4 plus(final Vector4 vec) {
        return this.copy().add(vec);
    }

    public Vector4 subtract(final Vector4 other) {
        UncheckedVectorMath.subtract(this, other);

        return this;
    }

    public Vector4 minus(final Vector4 vec) {
        return this.copy().add(vec);
    }

    public float dot(final Vector4 other) {
        return UncheckedVectorMath.dot(this, other);
    }

    public Vector4 cross(final Vector4 vec) {
        final Vector4 result = new Vec4();
        UncheckedVectorMath.cross(this, vec, result);

        return result;
    }

    @Override
    public boolean equalsTo(final Vector4 other) {
        return UncheckedVectorMath.equals(this, other);
    }

    @Override
    public Vec4 copy() {
        return new Vec4(this.x(), this.y(), this.y(), this.w());
    }

    @Override
    public String toString() {
        return vector.toString();
    }
}
