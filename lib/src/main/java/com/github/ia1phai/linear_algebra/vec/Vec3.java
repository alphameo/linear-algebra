package com.github.ia1phai.linear_algebra.vec;

import java.util.Arrays;

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
        this();
        entries[0] = x;
        entries[1] = y;
        entries[2] = z;
    }

    public Vec3(Vector3 v) {
        this(v.x(), v.y(), v.z());
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

    public float len() {
        return Vec3Math.len(this);
    }

    public Vector3 mult(final float multiplier) {
        return Vec3Math.mult(this, multiplier);
    }

    public Vector3 multiplied(final float multiplier) {
        return Vec3Math.multiplied(this, multiplier);
    }

    public Vector3 divided(final float divisor) {
        return Vec3Math.divided(this, divisor);
    }

    public Vector3 add(final Vector3 other) {
        return Vec3Math.add(this, other);
    }

    public Vector3 added(final Vector3 other) {
        return Vec3Math.added(this, other);
    }

    public Vector3 sub(final Vector3 other) {
        return Vec3Math.sub(this, other);
    }

    public Vector3 subtracted(final Vector3 other) {
        return Vec3Math.subtracted(this, other);
    }

    public static Vector3 normalize(final Vector3 v) {
        return Vec3Math.normalize(v);
    }

    public static Vector3 normalized(final Vector3 v) {
        return Vec3Math.normalized(v);
    }

    public float dot(final Vector3 other) {
        return Vec3Math.dot(this, other);
    }

    public Vector3 cross(final Vector3 vec) {
        final Vector3 result = new Vec3();
        Vec3Math.cross(this, vec);

        return result;
    }

    public Vector4 toVec3() {
        return Vec3Math.toVec4(this);
    }

    public static Vector3 zeroVec() {
        return Vec3Math.zeroVec();
    }

    public static Vector3 unitVec() {
        return Vec3Math.unitVec();
    }

    public Vector4 toVec4() {
        return new Vec4(x(), y(), z(), 1);
    }

    public static Vector3 zeroVector() {
        return Vec3Math.zeroVec();
    }

    public static Vector3 unitVector() {
        return Vec3Math.zeroVec();
    }

    @Override
    public boolean equalsTo(final Vector3 other) {
        return Vec3Math.equals(this, other);
    }

    @Override
    public Vec3 copy() {
        return new Vec3(this.x(), this.y(), this.y());
    }

    @Override
    public String toString() {
        return String.format("[%d, %d, %d]", x(), y(), z());
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
