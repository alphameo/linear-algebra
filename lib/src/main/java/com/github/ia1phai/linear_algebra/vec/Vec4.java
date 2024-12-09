package com.github.ia1phai.linear_algebra.vec;

import java.util.Arrays;

import com.github.ia1phai.linear_algebra.Copyable;
import com.github.ia1phai.linear_algebra.Equatable;

/**
 * Default implementation of vector with size 2 ({@code Vector2 interface}).
 */
public class Vec4 implements Vector4, Equatable<Vector4>, Copyable<Vec4> {

    private final float[] entries;

    /**
     * Constructs new vector of size 4 with all 0.
     */
    public Vec4() {
        entries = new float[4];
    }

    /**
     * Constructs new vector of size 3 using values {@code x}, {@code y}, {@code z}
     * and {@code w}.
     * 
     * @param x first component of vector
     * @param y second component of vector
     * @param z third component of vector
     * @param w fourth component of vector
     */
    public Vec4(final float x, final float y, final float z, final float w) {
        this();
        entries[0] = x;
        entries[1] = y;
        entries[2] = z;
        entries[3] = w;
    }

    /**
     * Copies given vector of size 4 values into new vector of size 2.
     * 
     * @param v vector of size 4 for copying
     */
    public Vec4(final Vector4 v) {
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

    @Override
    public int size() {
        return 4;
    }

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @return square length of vector
     */
    public float len2() {
        return Vec4Math.len2(this);
    }

    /**
     * Calculates length of vector.
     * 
     * @return length of vector
     */
    public float len() {
        return Vec4Math.len(this);
    }

    /**
     * Multiplies the components of vector by a scalar value.
     *
     * @param multiplier scalar value
     * @return current vector with multiplied components
     */
    public Vector4 mult(final float multiplier) {
        return Vec4Math.mult(this, multiplier);
    }

    /**
     * Copies vector and multiplies its components by a scalar.
     * value.
     *
     * @param multiplier scalar value
     * @return new vector with multiplied components of current vector
     */
    public Vector4 multiplied(final float multiplier) {
        return Vec4Math.multiplied(this, multiplier);
    }

    /**
     * Divides the components of vector by a scalar value.
     * 
     * @param divisor scalar value
     * @return current vector with divided components
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     */
    public Vector4 divide(final float divisor) throws ArithmeticException {
        return Vec4Math.divide(this, divisor);
    }

    /**
     * Copies vector and divides its components by a scalar value.
     *
     * @param divisor scalar value
     * @return new vector with divided components of current vector
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     */
    public Vector4 divided(final float divisor) throws ArithmeticException {
        return Vec4Math.divided(this, divisor);
    }

    /**
     * Normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components
     * @throws ArithmeticException if length of vector equals 0
     */
    public Vector4 normalize() throws ArithmeticException {
        return Vec4Math.normalize(this);
    }

    /**
     * Copies and normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components of given vector
     * @throws ArithmeticException if length of vector equals 0
     */
    public Vector4 normalized() throws ArithmeticException {
        return Vec4Math.normalized(new Vec4(this));
    }

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     */
    public Vector4 add(final Vector4 addendum) {
        return Vec4Math.add(this, addendum);
    }

    /**
     * Copies currnet vector and adds the {@code addendum} vector components to its
     * components.
     *
     * @param addendum vector to add
     * @return new vector with sum of components of current vector and
     *         {@code addendum} vector
     */
    public Vector4 added(final Vector4 addendum) {
        return Vec4Math.added(this, addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the current vector
     * components.
     * 
     * @param subtrahend vector to subtract
     * @return current vector subtracted by {@code subtrahend} vector
     */
    public Vector4 sub(final Vector4 subtrahend) {
        return Vec4Math.sub(this, subtrahend);
    }

    /**
     * Copies current vector and subtracts the {@code subtrahend} vector components
     * from its components.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with components resulting current vector subtracted
     *         by {@code subtrahend} vector
     */
    public Vector4 subtracted(final Vector4 subtrahend) {
        return Vec4Math.subtracted(this, subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of vectors.
     *
     * @param v second vector
     * @return dot (scalar) product of vectors
     */
    public float dot(final Vector4 v) {
        return Vec4Math.dot(this, v);
    }

    @Override
    public boolean equalsEpsilonTo(final Vector4 other, final float eps) {
        return Vec4Math.equalsEpsilon(this, other, eps);
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
        return String.format("[%f, %f, %f, %f]", x(), y(), z(), w());
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

    /**
     * Constructs new vector of size 4 with all 0 components.
     * 
     * @return new zero vector of size 4
     */
    public static Vector4 zeroVector() {
        return new Vec4();
    }

    /**
     * Constructs new vector of size 4 with all 1 components.
     * 
     * @return new unit vector of size 4
     */
    public static Vector4 unitVector() {
        return Vec4Math.unitVec();
    }
}
