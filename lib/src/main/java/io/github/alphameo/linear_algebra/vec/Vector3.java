package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for 3-dimensional vector.
 *
 * @since 1.0.0
 */
public interface Vector3 extends Vector {

    /**
     * Returns x component (index = 0) of 3-dimensional vector.
     * 
     * @return x component of vector
     *
     * @since 1.0.0
     */
    float x();

    /**
     * Returns y component (index = 1) of 3-dimensional vector.
     * 
     * @return y component of vector
     *
     * @since 1.0.0
     */
    float y();

    /**
     * Returns z component (index = 1) of 3-dimensional vector.
     * 
     * @return z component of vector
     *
     * @since 1.0.0
     */
    float z();

    /**
     * Sets value of x component (index = 0) inside 3-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setX(float value);

    /**
     * Sets value of y component (index = 1) inside 3-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setY(float value);

    /**
     * Sets value of z component (index = 2) inside 3-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setZ(float value);

    /**
     * Creates and returns a copy of current 3-dimensional vector.
     * 
     * @return copy of 3-dimensional vector
     */
    Vector3 clone();

    @Override
    default float len2() {
        return Vec3Math.len2(this);
    }

    @Override
    default float len() {
        return Vec3Math.len(this);
    }

    @Override
    default Vector mult(float multiplier) {
        return Vec3Math.mult(this, multiplier);
    }

    @Override
    default Vector multiplied(float multiplier) {
        return Vec3Math.multiplied(this, multiplier);
    }

    @Override
    default Vector divide(float divisor) throws ArithmeticException {
        return Vec3Math.divide(this, divisor);
    }

    @Override
    default Vector divided(float divisor) throws ArithmeticException {
        return Vec3Math.divided(this, divisor);
    }

    @Override
    default Vector normalize() throws ArithmeticException {
        return Vec3Math.normalize(this);
    }

    @Override
    default Vector normalized() throws ArithmeticException {
        return Vec3Math.normalized(this);
    }

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     *
     * @since 1.0.0
     */
    default Vector3 add(final Vector3 addendum) {
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
    default Vector3 added(final Vector3 addendum) {
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
    default Vector3 sub(final Vector3 subtrahend) {
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
    default Vector3 subtracted(final Vector3 subtrahend) {
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
    default float dot(final Vector3 v) {
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
    default Vector3 cross(final Vector3 v) {
        final Vector3 result = new Vec3();
        Vec3Math.cross(this, v);

        return result;
    }

    /**
     * Returns {@code true} if components of current and given vectors are equal
     * within {@code epsilon} tolerance.
     * 
     * @param v   vector for comparison
     * @param eps tolerance
     * @return {@code true} if all components of current and given vectors are equal
     *         within {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equalsEpsilonTo(final Vector3 other, final float eps) {
        return Vec3Math.equalsEpsilon(this, other, eps);
    }

    /**
     * Returns {@code true} if components of current and given vectors are
     * approximately equal.
     * 
     * @param v vector for comparison
     * @return {@code true} if all components of current and given vectors are
     *         approximately equal, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equalsTo(final Vector3 other) {
        return Vec3Math.equals(this, other);
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
    default Vector4 toVec4() {
        return Vec3Math.toVec4(this);
    }

    /**
     * Constructs new vector of size 3 with all 0 components.
     * 
     * @return new zero vector of size 3
     *
     * @since 1.0.0
     */
    static Vector3 zeroVec() {
        return Vec3Math.zeroVec();
    }

    /**
     * Constructs new vector of size 4 with 1 as components.
     * 
     * @return new unit vector of size 4
     *
     * @since 1.0.0
     */
    static Vector3 unitVec() {
        return Vec3Math.unitVec();
    }
}
