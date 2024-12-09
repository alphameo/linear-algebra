package com.github.ia1phai.linear_algebra.vec;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Default implementation of arbitrary vector ({@code Vector interface}).
 */
public class Vec implements Vector, Equatable<Vector>, Copyable<Vec> {

    private final float[] entries;

    /**
     * Constructs new vector of given size with all 0.
     * 
     * @param size size of vector for construction
     */
    public Vec(final int size) {
        this.entries = new float[size];
    }

    /**
     * Constructs new vector using values from {@code entries}.
     * 
     * @param entries values for vector components
     */
    public Vec(final float... entries) {
        this(entries.length);
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = entries[i];
        }
    }

    /**
     * Copies given vector values into new vector.
     * 
     * @param v vector for copying
     */
    public Vec(final Vector v) {
        this(v.size());
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = v.get(i);
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

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @return square length of vector
     */
    public float len2() {
        return VecMath.len2(this);
    }

    /**
     * Calculates length of vector.
     * 
     * @return length of vector
     */
    public float len() {
        return VecMath.len(this);
    }

    /**
     * Multiplies the components of vector by a scalar value.
     *
     * @param multiplier scalar value
     * @return current vector with multiplied components
     */
    public Vector mult(final float multiplier) {
        return VecMath.mult(this, multiplier);
    }

    /**
     * Copies vector and multiplies its components by a scalar.
     * value.
     *
     * @param multiplier scalar value
     * @return new vector with multiplied components of current vector
     */
    public Vector multiplied(final float multiplier) {
        return VecMath.multiplied(this, multiplier);
    }

    /**
     * Divides the components of vector by a scalar value.
     * 
     * @param divisor scalar value
     * @return current vector with divided components
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     */
    public Vector divide(final float divisor) throws ArithmeticException {
        return VecMath.divide(this, divisor);
    }

    /**
     * Copies vector and divides its components by a scalar value.
     *
     * @param divisor scalar value
     * @return new vector with divided components of current vector
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     */
    public Vector divided(final float divisor) throws ArithmeticException {
        return VecMath.divided(this, divisor);
    }

    /**
     * Normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components
     * @throws ArithmeticException if length of vector equals 0
     */
    public Vector normalize() throws ArithmeticException {
        return VecMath.normalize(this);
    }

    /**
     * Copies and normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components of given vector
     * @throws ArithmeticException if length of vector equals 0
     */
    public Vector normalized() throws ArithmeticException {
        return VecMath.normalized(new Vec(this));
    }

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     * @throws IllegalArgumentException if vectors have different sizes
     */
    public Vector add(final Vector addendum) {
        return VecMath.add(this, addendum);
    }

    /**
     * Copies currnet vector and adds the {@code addendum} vector components to its
     * components.
     *
     * @param addendum vector to add
     * @return new vector with sum of components of current vector and
     *         {@code addendum} vector
     * @throws IllegalArgumentException if vectors have different sizes
     */
    public Vector added(final Vector addendum) {
        return VecMath.added(this, addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the current vector
     * components.
     * 
     * @param subtrahend vector to subtract
     * @return current vector subtracted by {@code subtrahend} vector
     * @throws IllegalArgumentException if vectors have different sizes
     */
    public Vector sub(final Vector subtrahend) {
        return VecMath.sub(this, subtrahend);
    }

    /**
     * Copies current vector and subtracts the {@code subtrahend} vector components
     * from its components.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with components resulting current vector subtracted
     *         by {@code subtrahend} vector
     * @throws IllegalArgumentException if vectors have different sizes
     */
    public Vector subtracted(final Vector subtrahend) {
        return VecMath.subtracted(this, subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of vectors.
     *
     * @param v second vector
     * @return dot (scalar) product of vectors
     */
    public float dot(final Vector v) {
        return VecMath.dot(this, v);
    }

    /**
     * Calculates cross product (vector product) of vectors.
     *
     * @param v second vector
     * @return vector, which represents cross (vector) product of vectors
     * @throws IllegalArgumentException if vectors' sizes are not equal 3
     */
    public Vector cross(final Vector v) {
        return VecMath.cross(this, v);
    }

    @Override
    public boolean equalsEpsilonTo(final Vector v, final float eps) {
        return VecMath.equalsEpsilon(this, v, eps);
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

    /**
     * Constructs new vector of given {@code size} with all 0 components.
     * 
     * @param size size of vector to be constructed
     * @return new zero vector of given {@code size}
     */
    public static Vector zeroVec(final int size) {
        return VecMath.zeroVec(size);
    }

    /**
     * Constructs new vector of given {@code size} with all 1 components.
     * 
     * @param size size of vector to be constructed
     * @return new unit vector of given {@code size}
     */
    public static Vector unitVec(final int size) {
        return VecMath.unitVec(size);
    }
}
