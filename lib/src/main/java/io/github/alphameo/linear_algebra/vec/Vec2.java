package io.github.alphameo.linear_algebra.vec;

import java.util.Arrays;

import io.github.alphameo.linear_algebra.Copyable;
import io.github.alphameo.linear_algebra.Equatable;

/**
 * Default implementation of vector with size 2 ({@code Vector2 interface}).
 *
 * @since 1.0.0
 */
public class Vec2 implements Vector2, Equatable<Vector2>, Copyable<Vec2> {

    private final float[] entries;

    /**
     * Constructs new vector of size 2 with all 0.
     *
     * @since 1.0.0
     */
    public Vec2() {
        entries = new float[2];
    }

    /**
     * Constructs new vector of size 2 using values {@code x} and {@code y}.
     * 
     * @param x first component of vector
     * @param y second component of vector
     *
     * @since 1.0.0
     */
    public Vec2(final float x, final float y) {
        this();
        entries[0] = x;
        entries[1] = y;
    }

    /**
     * Copies given vector of size 2 values into new vector of size 2.
     * 
     * @param v vector of size 2 for copying
     *
     * @since 1.0.0
     */
    public Vec2(final Vector2 v) {
        this(v.x(), v.y());
    }

    @Override
    public float get(final int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec2 bounds", i));
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
    public void set(final int i, final float value) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec2 bounds", i));
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
    public int size() {
        return 2;
    }

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @return square length of vector
     *
     * @since 1.0.0
     */
    public float len2() {
        return Vec2Math.len2(this);
    }

    /**
     * Calculates length of vector.
     * 
     * @return length of vector
     *
     * @since 1.0.0
     */
    public float len() {
        return Vec2Math.len(this);
    }

    /**
     * Multiplies the components of vector by a scalar value.
     *
     * @param multiplier scalar value
     * @return current vector with multiplied components
     *
     * @since 1.0.0
     */
    public Vector2 mult(final float multiplier) {
        return Vec2Math.mult(this, multiplier);
    }

    /**
     * Copies vector and multiplies its components by a scalar.
     * value.
     *
     * @param multiplier scalar value
     * @return new vector with multiplied components of current vector
     *
     * @since 1.0.0
     */
    public Vector2 multiplied(final float multiplier) {
        return Vec2Math.multiplied(this, multiplier);
    }

    /**
     * Divides the components of vector by a scalar value.
     * 
     * @param divisor scalar value
     * @return current vector with divided components
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     *
     * @since 1.0.0
     */
    public Vector2 divide(final float divisor) throws ArithmeticException {
        return Vec2Math.divide(this, divisor);
    }

    /**
     * Copies vector and divides its components by a scalar value.
     *
     * @param divisor scalar value
     * @return new vector with divided components of current vector
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     *
     * @since 1.0.0
     */
    public Vector2 divided(final float divisor) throws ArithmeticException {
        return Vec2Math.divided(this, divisor);
    }

    /**
     * Normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components
     * @throws ArithmeticException if length of vector equals 0
     *
     * @since 1.0.0
     */
    public Vector2 normalize() throws ArithmeticException {
        return Vec2Math.normalize(this);
    }

    /**
     * Copies and normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components of given vector
     * @throws ArithmeticException if length of vector equals 0
     *
     * @since 1.0.0
     */
    public Vector2 normalized() throws ArithmeticException {
        return Vec2Math.normalized(new Vec2(this));
    }

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     *
     * @since 1.0.0
     */
    public Vector2 add(final Vector2 addendum) {
        return Vec2Math.add(this, addendum);
    }

    /**
     * Copies currnet vector and adds the {@code addendum} vector components to its
     * components.
     *
     * @param addendum vector to add
     * @return new vector with sum of components of current vector and
     *         {@code addendum} vector
     *
     * @since 1.0.0
     */
    public Vector2 added(final Vector2 addendum) {
        return Vec2Math.added(this, addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the current vector
     * components.
     * 
     * @param subtrahend vector to subtract
     * @return current vector subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    public Vector2 sub(final Vector2 subtrahend) {
        return Vec2Math.sub(this, subtrahend);
    }

    /**
     * Copies current vector and subtracts the {@code subtrahend} vector components
     * from its components.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with components resulting current vector subtracted
     *         by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    public Vector2 subtracted(final Vector2 subtrahend) {
        return Vec2Math.subtracted(this, subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of vectors.
     *
     * @param v second vector
     * @return dot (scalar) product of vectors
     *
     * @since 1.0.0
     */
    public float dot(final Vector2 v) {
        return Vec2Math.dot(this, v);
    }

    /**
     * Constructs new vector of size 3 with components of curren vector and 1
     * <p>
     * (x, y, 1)
     *
     * @return new vector of size 3 including components of current vector and 1 as
     *         last component
     *
     * @since 1.0.0
     */
    public Vector3 toVec3() {
        return Vec2Math.toVec3(this);
    }

    @Override
    public boolean equalsEpsilonTo(final Vector2 other, final float eps) {
        return Vec2Math.equalsEpsilon(this, other, eps);
    }

    @Override
    public boolean equalsTo(final Vector2 v) {
        return Vec2Math.equals(this, v);
    }

    @Override
    public Vec2 copy() {
        return new Vec2(this.x(), this.y());
    }

    @Override
    public String toString() {
        return String.format("[%f, %f]", x(), y());
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
     * Constructs new vector of size 2 with all 0 components.
     * 
     * @return new zero vector of size 2
     *
     * @since 1.0.0
     */
    public static Vector2 zeroVec() {
        return Vec2Math.zeroVec();
    }

    /**
     * Constructs new vector of size 2 with all 1 components.
     * 
     * @return new unit vector of size 2
     *
     * @since 1.0.0
     */
    public static Vector2 unitVec() {
        return Vec2Math.unitVec();
    }
}
