package io.github.alphameo.linear_algebra.vec;

import java.util.Arrays;

import io.github.alphameo.linear_algebra.Equatable;

/**
 * Default implementation of vector with size 3 ({@code Vector3 interface}).
 *
 * @since 1.0.0
 */
public class Vec3 implements Vector3, Equatable<Vector3> {

    private final float[] entries;

    /**
     * Constructs new vector of size 3 with all 0.
     *
     * @since 1.0.0
     */
    public Vec3() {
        entries = new float[3];
    }

    /**
     * Constructs new vector of size 3 using values {@code x}, {@code y} and
     * {@code z}.
     * 
     * @param x first component of vector
     * @param y second component of vector
     * @param z third component of vector
     *
     * @since 1.0.0
     */
    public Vec3(final float x, final float y, final float z) {
        this();
        entries[0] = x;
        entries[1] = y;
        entries[2] = z;
    }

    /**
     * Copies given vector of size 3 values into new vector of size 3.
     * 
     * @param v vector of size 3 for copying
     *
     * @since 1.0.0
     */
    public Vec3(final Vector3 v) {
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

    @Override
    public int size() {
        return 3;
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
        return Vec3Math.len2(this);
    }

    /**
     * Calculates length of vector.
     * 
     * @return length of vector
     *
     * @since 1.0.0
     */
    public float len() {
        return Vec3Math.len(this);
    }

    /**
     * Multiplies the components of vector by a scalar value.
     *
     * @param multiplier scalar value
     * @return current vector with multiplied components
     *
     * @since 1.0.0
     */
    public Vector3 mult(final float multiplier) {
        return Vec3Math.mult(this, multiplier);
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
    public Vector3 multiplied(final float multiplier) {
        return Vec3Math.multiplied(this, multiplier);
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
    public Vector3 divide(final float divisor) throws ArithmeticException {
        return Vec3Math.divide(this, divisor);
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
    public Vector3 divided(final float divisor) throws ArithmeticException {
        return Vec3Math.divided(this, divisor);
    }

    /**
     * Normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components
     * @throws ArithmeticException if length of vector equals 0
     *
     * @since 1.0.0
     */
    public Vector3 normalize() throws ArithmeticException {
        return Vec3Math.normalize(this);
    }

    /**
     * Copies and normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components of given vector
     * @throws ArithmeticException if length of vector equals 0
     *
     * @since 1.0.0
     */
    public Vector3 normalized() throws ArithmeticException {
        return Vec3Math.normalized(new Vec3(this));
    }

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     *
     * @since 1.0.0
     */
    public Vector3 add(final Vector3 addendum) {
        return Vec3Math.add(this, addendum);
    }

    /**
     * Copies current vector and adds the {@code addendum} vector components to its
     * components.
     *
     * @param addendum vector to add
     * @return new vector with sum of components of current vector and
     *         {@code addendum} vector
     *
     * @since 1.0.0
     */
    public Vector3 added(final Vector3 addendum) {
        return Vec3Math.added(this, addendum);
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
    public Vector3 sub(final Vector3 subtrahend) {
        return Vec3Math.sub(this, subtrahend);
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
    public Vector3 subtracted(final Vector3 subtrahend) {
        return Vec3Math.subtracted(this, subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of vectors.
     *
     * @param v second vector
     * @return dot (scalar) product of vectors
     *
     * @since 1.0.0
     */
    public float dot(final Vector3 v) {
        return Vec3Math.dot(this, v);
    }

    /**
     * Calculates cross product (vector product) of vectors.
     *
     * @param v second vector
     * @return vector, which represents cross (vector) product of vectors
     *
     * @since 1.0.0
     */
    public Vector3 cross(final Vector3 v) {
        final Vector3 result = new Vec3();
        Vec3Math.cross(this, v);

        return result;
    }

    /**
     * Constructs new vector of size 4 with components of current vector and 1
     * <p>
     * (x, y, z, 1)
     *
     * @return new vector of size 3 including components of current vector and 1 as
     *         last component
     *
     * @since 1.0.0
     */
    public Vector4 toVec4() {
        return Vec3Math.toVec4(this);
    }

    @Override
    public boolean equalsEpsilonTo(final Vector3 other, final float eps) {
        return Vec3Math.equalsEpsilon(this, other, eps);
    }

    @Override
    public boolean equalsTo(final Vector3 other) {
        return Vec3Math.equals(this, other);
    }

    @Override
    public Vector3 clone() {
        return new Vec3(this.x(), this.y(), this.z());
    }

    @Override
    public String toString() {
        return String.format("[%f, %f, %f]", x(), y(), z());
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
     * Constructs new vector of size 3 with all 0 components.
     * 
     * @return new zero vector of size 3
     *
     * @since 1.0.0
     */
    public static Vector3 zeroVec() {
        return Vec3Math.zeroVec();
    }

    /**
     * Constructs new vector of size 4 with 1 as components.
     * 
     * @return new unit vector of size 4
     *
     * @since 1.0.0
     */
    public static Vector3 unitVec() {
        return Vec3Math.unitVec();
    }
}
