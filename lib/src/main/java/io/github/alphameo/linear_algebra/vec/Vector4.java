package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for 4-dimensional vector.
 *
 * @since 1.0.0
 */
public interface Vector4 extends Vector {

    /**
     * Returns x component (index = 0) of 4-dimensional vector.
     * 
     * @return x component of vector
     *
     * @since 1.0.0
     */
    float x();

    /**
     * Returns y component (index = 1) of 4-dimensional vector.
     * 
     * @return y component of vector
     *
     * @since 1.0.0
     */
    float y();

    /**
     * Returns z component (index = 1) of 4-dimensional vector.
     * 
     * @return z component of vector
     *
     * @since 1.0.0
     */
    float z();

    /**
     * Returns w component (index = 1) of 4-dimensional vector.
     * 
     * @return w component of vector
     *
     * @since 1.0.0
     */
    float w();

    /**
     * Sets value of x component (index = 0) inside 4-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setX(float value);

    /**
     * Sets value of y component (index = 1) inside 4-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setY(float value);

    /**
     * Sets value of z component (index = 2) inside 4-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setZ(float value);

    /**
     * Sets value of z component (index = 2) inside 4-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setW(float value);

    /**
     * Creates and returns a copy of current 3-dimensional vector.
     * 
     * @return copy of 4-dimensional vector
     */
    Vector4 clone();

    @Override
    default float len2() {
        return Vec4Math.len2(this);
    }

    @Override
    default float len() {
        return Vec4Math.len(this);
    }

    @Override
    default Vector mult(float multiplier) {
        return Vec4Math.mult(this, multiplier);
    }

    @Override
    default Vector multiplied(float multiplier) {
        return Vec4Math.multiplied(this, multiplier);
    }

    @Override
    default Vector divide(float divisor) throws ArithmeticException {
        return Vec4Math.divide(this, divisor);
    }

    @Override
    default Vector divided(float divisor) throws ArithmeticException {
        return Vec4Math.divided(this, divisor);
    }

    @Override
    default Vector normalize() throws ArithmeticException {
        return Vec4Math.normalize(this);
    }

    @Override
    default Vector normalized() throws ArithmeticException {
        return Vec4Math.normalized(this);
    }

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     *
     * @since 1.0.0
     */
    default Vector4 add(final Vector4 addendum) {
        return Vec4Math.add(this, addendum);
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
    default Vector4 added(final Vector4 addendum) {
        return Vec4Math.added(this, addendum);
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
    default Vector4 sub(final Vector4 subtrahend) {
        return Vec4Math.sub(this, subtrahend);
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
    default Vector4 subtracted(final Vector4 subtrahend) {
        return Vec4Math.subtracted(this, subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of vectors.
     *
     * @param v second vector
     * @return dot (scalar) product of vectors
     *
     * @since 1.0.0
     */
    default float dot(final Vector4 v) {
        return Vec4Math.dot(this, v);
    }

    /**
     * This operation is not supported due to wrong dimension of current vector
     *
     * @throws UnsupportedOperationException ALWAYS
     */
    @Override
    default Vector cross(Vector v) {
        throw new UnsupportedOperationException(
                String.format("Cross product denied: vectors must be 3-dimensional"));
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
    default boolean equalsEpsilonTo(final Vector4 other, final float eps) {
        return Vec4Math.equalsEpsilon(this, other, eps);
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
    default boolean equalsTo(final Vector4 other) {
        return Vec4Math.equals(this, other);
    }

    /**
     * Constructs new vector of size 4 with all 0 components.
     * 
     * @return new zero vector of size 4
     *
     * @since 1.0.0
     */
    static Vector4 zeroVector() {
        return new Vec4();
    }

    /**
     * Constructs new vector of size 4 with 1 as components.
     * 
     * @return new unit vector of size 4
     *
     * @since 1.0.0
     */
    static Vector4 unitVector() {
        return Vec4Math.unitVec();
    }
}
