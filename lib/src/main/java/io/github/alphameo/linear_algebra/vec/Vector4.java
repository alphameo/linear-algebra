package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for 4-dimensional vector.
 *
 * @since 1.0.0
 */
public interface Vector4 extends Vector, FixedVectorOperatable<Vector4> {

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

    @Override
    Vector4 clone();

    @Override
    default float len2() {
        return Vector4Math.len2(this);
    }

    @Override
    default float len() {
        return Vector4Math.len(this);
    }

    @Override
    default Vector mulIncr(float multiplier) {
        return Vector4Math.mult(this, multiplier);
    }

    @Override
    default Vector mul(float multiplier) {
        return Vector4Math.multiplied(this, multiplier);
    }

    @Override
    default Vector divIncr(float divisor) throws ArithmeticException {
        return Vector4Math.divide(this, divisor);
    }

    @Override
    default Vector div(float divisor) throws ArithmeticException {
        return Vector4Math.divided(this, divisor);
    }

    @Override
    default Vector normalize() throws ArithmeticException {
        return Vector4Math.normalize(this);
    }

    @Override
    default Vector normalized() throws ArithmeticException {
        return Vector4Math.normalized(this);
    }

    @Override
    default Vector4 add(final Vector4 addendum) {
        return Vector4Math.add(this, addendum);
    }

    @Override
    default Vector4 added(final Vector4 addendum) {
        return Vector4Math.added(this, addendum);
    }

    @Override
    default Vector4 sub(final Vector4 subtrahend) {
        return Vector4Math.sub(this, subtrahend);
    }

    @Override
    default Vector4 subtracted(final Vector4 subtrahend) {
        return Vector4Math.subtracted(this, subtrahend);
    }

    @Override
    default float dot(final Vector4 v) {
        return Vector4Math.dot(this, v);
    }

    @Override
    default boolean equalsEpsilon(final Vector4 other, final float eps) {
        return Vector4Math.equalsEpsilon(this, other, eps);
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
    default boolean equals(final Vector4 other) {
        return Vector4Math.equals(this, other);
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
}
