package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for 2-dimensional vector.
 *
 * @since 1.0.0
 */
public interface Vector2 extends Vector {

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
     * Creates and returns a copy of current 2-dimensional vector.
     * 
     * @return copy of 2-dimensional vector
     */
    Vector2 clone();

    @Override
    default float len2() {
        return Vec2Math.len2(this);
    }

    @Override
    default float len() {
        return Vec2Math.len(this);
    }

    @Override
    default Vector mult(float multiplier) {
        return Vec2Math.mult(this, multiplier);
    }

    @Override
    default Vector multiplied(float multiplier) {
        return Vec2Math.multiplied(this, multiplier);
    }

    @Override
    default Vector divide(float divisor) throws ArithmeticException {
        return Vec2Math.divide(this, divisor);
    }

    @Override
    default Vector divided(float divisor) throws ArithmeticException {
        return Vec2Math.divided(this, divisor);
    }

    @Override
    default Vector normalize() throws ArithmeticException {
        return Vec2Math.normalize(this);
    }

    @Override
    default Vector normalized() throws ArithmeticException {
        return Vec2Math.normalized(this);
    }

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     *
     * @since 1.0.0
     */
    default Vector2 add(final Vector2 addendum) {
        return Vec2Math.add(this, addendum);
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
    default Vector2 added(final Vector2 addendum) {
        return Vec2Math.added(this, addendum);
    }

    /**
     * Subtracts components of 2-dimensional {@code subtrahend} vector from the
     * components of 2-dimensional current vector.
     * 
     * @param subtrahend vector to subtract
     * @return current vector subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    default Vector2 sub(final Vector2 subtrahend) {
        return Vec2Math.sub(this, subtrahend);
    }

    /**
     * Copies current 2-dimensional vector and subtracts the 2-dimensional
     * {@code subtrahend} vector components from its components.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with components resulting current vector
     *         subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    default Vector2 subtracted(final Vector2 subtrahend) {
        return Vec2Math.subtracted(this, subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of 2-dimensional vectors.
     *
     * @param v second vector for dot product
     * @return dot (scalar) product of vectors
     *
     * @since 1.0.0
     */
    default float dot(final Vector2 v) {
        return Vec2Math.dot(this, v);
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
     * Returns {@code true} if components of current and given 2-dimensional vectors
     * are equal within {@code epsilon} tolerance.
     * 
     * @param v   vector for comparison
     * @param eps tolerance
     * @return {@code true} if all components of current and given vectors are equal
     *         within {@code epsilon} tolerance, and {@code false}
     *         otherwise
     *
     * @since 1.0.0
     */
    default boolean equalsEpsilonTo(final Vector2 v, final float eps) {
        return Vec2Math.equalsEpsilon(this, v, eps);
    }

    /**
     * Returns {@code true} if components of current and given 2-dimensional vectors
     * are approximately equal.
     * 
     * @param v vector for comparison
     * @return {@code true} if all components of current and given vectors are
     *         approximately equal, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equalsTo(final Vector2 v) {
        return Vec2Math.equals(this, v);
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
        return Vec2Math.toVec3(this);
    }

    /**
     * Constructs new 2-dimensional vector with all 0 components.
     * 
     * @return new 2-dimensional zero vector
     *
     * @since 1.0.0
     */
    public static Vector2 zeroVec() {
        return Vec2Math.zeroVec();
    }

    /**
     * Constructs new 2-dimensional vector with 1 as components.
     * 
     * @return new 2-dimensional unit vector
     *
     * @since 1.0.0
     */
    public static Vector2 unitVec() {
        return Vec2Math.unitVec();
    }
}
