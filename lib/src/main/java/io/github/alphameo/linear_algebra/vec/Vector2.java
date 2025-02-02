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

    /**
     * @since 1.0.0
     */
    @Override
    Vector2 clone();

    /**
     * @since 1.0.0
     */
    @Override
    default float len2() {
        return Vector2Math.len2(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float len() {
        return Vector2Math.len(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector2 mulAsgn(float multiplier) {
        return Vector2Math.mulAsgn(this, multiplier);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector2 mul(float multiplier) {
        return Vector2Math.mul(this, multiplier);
    }

    /**
     * @throws ArithmeticException if length of the given vector is approximately
     *
     * @since 1.0.0
     */
    @Override
    default Vector2 divAsgn(float divisor) throws ArithmeticException {
        return Vector2Math.divAsgn(this, divisor);
    }

    /**
     * @throws ArithmeticException if length of the given vector is approximately
     *
     * @since 1.0.0
     */
    @Override
    default Vector2 div(float divisor) throws ArithmeticException {
        return Vector2Math.div(this, divisor);
    }

    /**
     * @throws ArithmeticException if length of the given vector is approximately
     *
     * @since 1.0.0
     */
    @Override
    default Vector2 normalize() throws ArithmeticException {
        return Vector2Math.normalize(this);
    }

    /**
     * @throws ArithmeticException if length of the given vector is approximately
     *
     * @since 1.0.0
     */
    @Override
    default Vector2 normalized() throws ArithmeticException {
        return Vector2Math.normalized(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector2 addAsgn(final Vector2 addendum) {
        return Vector2Math.addAsgn(this, addendum);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector2 add(final Vector2 addendum) {
        return Vector2Math.add(this, addendum);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector2 subAsgn(final Vector2 subtrahend) {
        return Vector2Math.subAsgn(this, subtrahend);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector2 sub(final Vector2 subtrahend) {
        return Vector2Math.sub(this, subtrahend);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float dot(final Vector2 v) {
        return Vector2Math.dot(this, v);
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
     * @since 1.0.0
     */
    @Override
    default boolean equalsEpsilon(final Vector2 v, final float eps) {
        return Vector2Math.equalsEpsilon(this, v, eps);
    }

    /**
     * Returns {@code true} if components of current and the given vectors are
     * approximately equal.
     * 
     * @param v vector for comparison
     * @return {@code true} if all components of current and the given vectors are
     *         approximately equal, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equals(final Vector2 v) {
        return Vector2Math.equals(this, v);
    }

    /**
     * Constructs 3-dimensional vector with components of the the given vector and 1
     * as last component
     * <p>
     * (x, y, 1)
     *
     * @return new 3-dimensional vector including components of the the given vector
     *         and 1
     *
     * @since 1.0.0
     */
    default Vector3 toVector3() {
        return Vector2Math.toVector3(this);
    }
}
