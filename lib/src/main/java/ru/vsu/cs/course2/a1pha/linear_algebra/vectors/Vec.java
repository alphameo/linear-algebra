package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import java.util.Arrays;

import ru.vsu.cs.course2.a1pha.linear_algebra.NumberChecker;
import ru.vsu.cs.course2.a1pha.linear_algebra.Copyable;

/**
 * Vector
 */
public class Vec implements ArbitraryVector, Copyable<Vec> {

    private float[] entries;

    public Vec(final float... entries) {
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
    public void normalize() {
        divide(length());
    }

    @Override
    public void add(final ArbitraryVector other) {
        checkSameVectorLength(this, other, "Addition denied");

        UncheckedVectorOperations.addTo(this, other);
    }

    @Override
    public ArbitraryVector plus(final ArbitraryVector other) {
        final ArbitraryVector result = copy();
        result.add(other);

        return result;
    }

    @Override
    public void subtract(final ArbitraryVector other) {
        checkSameVectorLength(this, other, "Subtraction denied");

        UncheckedVectorOperations.subtractFrom(this, other);
    }

    @Override
    public ArbitraryVector minus(final ArbitraryVector other) {
        final ArbitraryVector result = copy();
        result.subtract(other);

        return result;
    }

    @Override
    public float dot(final ArbitraryVector other) {
        checkSameVectorLength(this, other, "Scalar product denied");

        return UncheckedVectorOperations.dot(this, other);
    }

    @Override
    public void divide(final float divisor) throws ArithmeticException {
        NumberChecker.checkDivisor(divisor);
        for (int i = 0; i < entries.length; i++) {
            entries[i] /= divisor;
        }
    }

    @Override
    public void multiply(final float multiplier) {
        for (int i = 0; i < entries.length; i++) {
            entries[i] *= multiplier;
        }
    }

    @Override
    public boolean equalsTo(final ArbitraryVector other) {
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
        final ArbitraryVector other = (Vec) obj;
        return equalsTo(other);
    }

    private static void checkSameVectorLength(final ArbitraryVector v1, final ArbitraryVector v2, final String errMessage) {
        if (v1.length() != v2.length()) {
            throw new IllegalArgumentException(String.format("%s: vectors with different lengths (%d and %d)",
                    errMessage, v1.length(), v2.length()));
        }
    }
}
