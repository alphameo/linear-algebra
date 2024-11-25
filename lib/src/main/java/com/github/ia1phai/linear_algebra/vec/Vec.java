package com.github.ia1phai.linear_algebra.vec;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Vector
 */
public class Vec implements Vector, Equatable<Vector>, Copyable<Vec> {

    private final float[] entries;

    public Vec(final Vector vec) {
        this(vec.size());
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = vec.get(i);
        }
    }

    public Vec(final int size) {
        this.entries = new float[size];
    }

    public Vec(final float... entries) {
        this(entries.length);
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = entries[i];
        }
    }

    @Override
    public float get(final int i) {
        return entries[i];
    }

    @Override
    public void set(final int i, final float value) {
        entries[i] = value;
    }

    @Override
    public int size() {
        return entries.length;
    }

    public float len() {
        return VecMath.len(this);
    }

    public Vector mult(final float multiplier) {
        return VecMath.mult(this, multiplier);
    }

    public Vector multiplied(final float multiplier) {
        return VecMath.multiplied(this, multiplier);
    }

    public Vector divide(final float divisor) {
        return VecMath.divide(this, divisor);
    }

    public Vector divided(final float divisor) {
        return VecMath.divided(this, divisor);
    }

    public Vector add(final Vector v) {
        return VecMath.add(this, v);
    }

    public Vector added(final Vector v) {
        return VecMath.added(this, v);
    }

    public Vector sub(final Vector v) {
        return VecMath.sub(this, v);
    }

    public Vector subtracted(final Vector v) {
        return VecMath.subtracted(this, v);
    }

    public static Vector normalize(final Vector v) {
        return VecMath.normalize(v);
    }

    public static Vector normalized(final Vector v) {
        return VecMath.normalized(v);
    }

    public float dot(final Vector v) {
        return VecMath.dot(this, v);
    }

    public Vector cross(final Vector v) {
        return VecMath.cross(this, v);
    }

    public static Vector zeroVector(final int size) {
        return VecMath.zeroVec(size);
    }

    public static Vector unitVector(final int size) {
        return VecMath.unitVec(size);
    }

    @Override
    public boolean equalsTo(final Vector v) {
        return VecMath.equals(this, v);
    }

    @Override
    public Vec copy() {
        return new Vec(entries);
    }

    @Override
    public String toString() {
        return String.format("%s", Arrays.toString(entries));
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
        return equalsTo((Vector) obj);
    }
}
