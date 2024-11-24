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

    public float length() {
        return VecMath.length(this);
    }

    public Vector multiply(final float multiplier) {
        VecMath.multiply(this, multiplier);
        return this;
    }

    public Vector divide(final float divisor) throws ArithmeticException {
        VecMath.divide(this, divisor);

        return this;
    }

    public Vector add(final Vector v) {
        VecMath.add(this, v);

        return this;
    }

    public Vector plus(final Vector v) {
        return this.copy().add(v);
    }

    public Vector subtract(final Vector v) {
        VecMath.subtract(this, v);

        return this;
    }

    public Vector minus(final Vector v) {
        return this.copy().subtract(v);
    }

    public float dot(final Vector v) {

        return VecMath.dot(this, v);
    }

    public Vector cross(final Vector v) {
        return VecMath.cross(this, v);
    }

    public static Vector zeroVector(int size) {
        return VecMath.zeroVec(size);
    }

    public static Vector unitVector(int size) {
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
        return String.format("[%s]", Arrays.toString(entries));
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
        final Vector other = (Vector) obj;
        return equalsTo(other);
    }
}
