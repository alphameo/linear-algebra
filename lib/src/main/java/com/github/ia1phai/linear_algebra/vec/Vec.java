package com.github.ia1phai.linear_algebra.vec;

import java.util.Arrays;


/**
 * Vector
 */
public class Vec implements Vector {

    private float[] entries;

    public Vec(int size) {
        this.entries = new float[entries.length];
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

    @Override
    public float length() {
        float sum = 0;
        for (int i = 0; i < entries.length; i++) {
            sum += entries[i] * entries[i];
        }

        return (float) Math.sqrt(sum);
    }

    @Override
    public Vector add(final Vector other) {
        checkSameVectorLength(this, other, "Addition denied");
        UncheckedVectorOperations.add(this, other);

        return this;
    }

    @Override
    public Vector subtract(final Vector other) {
        checkSameVectorLength(this, other, "Subtraction denied");
        UncheckedVectorOperations.subtractFrom(this, other);

        return this;
    }

    @Override
    public float dot(final Vector other) {
        checkSameVectorLength(this, other, "Scalar product denied");

        return UncheckedVectorOperations.dot(this, other);
    }

    @Override
    public Vector divide(final float divisor) throws ArithmeticException {
        NumberChecker.checkDivisor(divisor);
        for (int i = 0; i < entries.length; i++) {
            entries[i] /= divisor;
        }

        return this;
    }

    @Override
    public Vector multiply(final float multiplier) {
        for (int i = 0; i < entries.length; i++) {
            entries[i] *= multiplier;
        }

        return this;
    }

    @Override
    public boolean equalsTo(final Vector other) {
        checkSameVectorLength(this, other, "Equalization denied");
        return UncheckedVectorOperations.equalTo(this, other);
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

    private static void checkSameVectorLength(final Vector v1, final Vector v2,
            final String errMessage) {
        if (v1.length() != v2.length()) {
            throw new IllegalArgumentException(String.format("%s: vectors with different lengths (%d and %d)",
                    errMessage, v1.length(), v2.length()));
        }
    }
}
