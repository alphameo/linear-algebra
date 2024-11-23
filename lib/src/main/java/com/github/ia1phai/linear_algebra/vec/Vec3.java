package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Vec2
 */
public class Vec3 implements Vector3, Equatable<Vector3>, Copyable<Vec3> {
    private final Vec vector;

    public Vec3() {
        vector = new Vec(3);
    }

    public Vec3(final float x, final float y, final float z) {
        vector = new Vec(x, y, z);
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
    public void setZ(float value) {
        vector.set(2, value);
    }

    public int size() {
        return 2;
    }

    public float length() {
        return vector.length();
    }

    public Vector3 multiply(final float multiplier) {
        UncheckedVectorOperations.multiply(this, multiplier);

        return this;
    }

    public Vector3 divide(final float divisor) {
        UncheckedVectorOperations.divide(this, divisor);

        return this;
    }

    public Vector3 add(final Vector3 other) {
        UncheckedVectorOperations.add(this, other);

        return this;
    }

    public Vector3 plus(final Vector3 vec) {
        return this.copy().add(vec);
    }

    public Vector3 subtract(final Vector3 other) {
        UncheckedVectorOperations.subtract(this, other);

        return this;
    }

    public Vector3 minus(final Vector3 vec) {
        return this.copy().add(vec);
    }

    public float dot(final Vector3 other) {
        return UncheckedVectorOperations.dot(this, other);
    }

    public Vector3 cross(final Vector3 vec) {
        Vector3 result = new Vec3();
        UncheckedVectorOperations.cross(this, vec, result);

        return result;
    }

    @Override
    public boolean equalsTo(final Vector3 other) {
        return UncheckedVectorOperations.equals(this, other);
    }

    @Override
    public Vec3 copy() {
        return new Vec3(this.x(), this.y(), this.y());
    }

    public Vector4 toVec4() {
        return new Vec4(x(), y(), z(), 1);
    }

    @Override
    public String toString() {
        return vector.toString();
    }

    public static Vector3 zeroVector() {
        return new Vec3();
    }

    public static Vector3 unitVector() {
        return new Vec3(1, 1, 1);
    }
}
