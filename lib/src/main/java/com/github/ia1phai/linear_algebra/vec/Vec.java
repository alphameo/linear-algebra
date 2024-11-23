package com.github.ia1phai.linear_algebra.vec;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;
import com.github.ia1phai.linear_algebra.NumberChecker;

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
        return UncheckedVectorOperations.length(this);
    }

    public Vector multiply(final float multiplier) {
        UncheckedVectorOperations.multiply(this, multiplier);
        return this;
    }

    public Vector divide(final float divisor) throws ArithmeticException {
        NumberChecker.checkDivisor(divisor);
        UncheckedVectorOperations.divide(this, divisor);

        return this;
    }

    public Vector add(final Vector vec) {
        checkSameVectorSizes(this, vec, "Addition denied");
        UncheckedVectorOperations.add(this, vec);

        return this;
    }

    public Vector plus(final Vector vec) {
        return this.copy().add(vec);
    }

    public Vector subtract(final Vector vec) {
        checkSameVectorSizes(this, vec, "Subtraction denied");
        UncheckedVectorOperations.subtract(this, vec);

        return this;
    }

    public Vector minus(final Vector vec) {
        return this.copy().subtract(vec);
    }

    public float dot(final Vector vec) {
        checkSameVectorSizes(this, vec, "Scalar product denied");

        return UncheckedVectorOperations.dot(this, vec);
    }

    public Vector cross(final Vector3 other) {
        if (size() != 3) {
            throw new IllegalArgumentException(
                    String.format(String.format("Cross product denien: vector size must be 3, but given are %d, %d"),
                            this.size(), other.size()));
        }

        Vector result = new Vec(3);

        UncheckedVectorOperations.cross(this, other, result);
        return result;
    }

    @Override
    public boolean equalsTo(final Vector other) {
        checkSameVectorSizes(this, other, "Equalization denied");

        return UncheckedVectorOperations.equals(this, other);
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

    private static void checkSameVectorSizes(final Vector v1, final Vector v2,
            final String errMessage) {
        if (v1.size() != v2.size()) {
            throw new IllegalArgumentException(String.format("%s: vectors with different lengths (%d and %d)",
                    errMessage, v1.size(), v2.size()));
        }
    }
}
