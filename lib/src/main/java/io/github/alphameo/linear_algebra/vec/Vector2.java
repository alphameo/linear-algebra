package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for 2-dimensional vector.
 *
 * @since 1.0.0
 */
public interface Vector2 extends Vector, FixedVectorOperatable<Vector2> {

    /**
     * Returns x component (index = 0) of 2-dimensional vector.
     * 
     * @return x component of vector
     *
     * @since 1.0.0
     */
    float x();

    /**
     * Returns y component (index = 1) of 2-dimensional vector.
     * 
     * @return y component of vector
     *
     * @since 1.0.0
     */
    float y();

    /**
     * Sets value of x component (index = 0) inside 2-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setX(float value);

    /**
     * Sets value of y component (index = 1) inside 2-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setY(float value);

    @Override
    Vector2 clone();

    @Override
    default float len2() {
        return Vector2Math.len2(this);
    }

    @Override
    default float len() {
        return Vector2Math.len(this);
    }

    @Override
    default Vector mulIncr(float multiplier) {
        return Vector2Math.mult(this, multiplier);
    }

    @Override
    default Vector mul(float multiplier) {
        return Vector2Math.multiplied(this, multiplier);
    }

    @Override
    default Vector divIncr(float divisor) throws ArithmeticException {
        return Vector2Math.divide(this, divisor);
    }

    @Override
    default Vector div(float divisor) throws ArithmeticException {
        return Vector2Math.divided(this, divisor);
    }

    @Override
    default Vector normalize() throws ArithmeticException {
        return Vector2Math.normalize(this);
    }

    @Override
    default Vector normalized() throws ArithmeticException {
        return Vector2Math.normalized(this);
    }

    @Override
    default Vector2 add(final Vector2 addendum) {
        return Vector2Math.add(this, addendum);
    }

    @Override
    default Vector2 added(final Vector2 addendum) {
        return Vector2Math.added(this, addendum);
    }

    @Override
    default Vector2 sub(final Vector2 subtrahend) {
        return Vector2Math.sub(this, subtrahend);
    }

    @Override
    default Vector2 subtracted(final Vector2 subtrahend) {
        return Vector2Math.subtracted(this, subtrahend);
    }

    @Override
    default float dot(final Vector2 v) {
        return Vector2Math.dot(this, v);
    }

    @Override
    default boolean equalsEpsilon(final Vector2 v, final float eps) {
        return Vector2Math.equalsEpsilon(this, v, eps);
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
    default boolean equals(final Vector2 v) {
        return Vector2Math.equals(this, v);
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
     * Constructs 3-dimensional vector with components of current vector and 1
     * <p>
     * (x, y, 1)
     *
     * @return 3-dimensional vector including components of current vector and 1
     *         as last component
     *
     * @since 1.0.0
     */
    default Vector3 toVec3() {
        return Vector2Math.toVec3(this);
    }
}
