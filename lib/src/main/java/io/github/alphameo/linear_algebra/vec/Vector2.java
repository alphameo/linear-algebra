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
        return Vec2Math.normalized(new Vec2(this));
    }

    @Override
    default Vector cross(Vector v) {
        throw new IllegalArgumentException(
                String.format("Cross product denied: vectors must be 3-dimensional"));
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
     * Subtracts the {@code subtrahend} vector components from the current vector
     * components.
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
     * Copies current vector and subtracts the {@code subtrahend} vector components
     * from its components.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with components resulting current vector subtracted
     *         by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    default Vector2 subtracted(final Vector2 subtrahend) {
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
    default float dot(final Vector2 v) {
        return Vec2Math.dot(this, v);
    }

    /**
     * Constructs new vector of size 3 with components of current vector and 1
     * <p>
     * (x, y, 1)
     *
     * @return new vector of size 3 including components of current vector and 1 as
     *         last component
     *
     * @since 1.0.0
     */
    default Vector3 toVec3() {
        return Vec2Math.toVec3(this);
    }

    default boolean equalsEpsilonTo(final Vector2 other, final float eps) {
        return Vec2Math.equalsEpsilon(this, other, eps);
    }

    default boolean equalsTo(final Vector2 v) {
        return Vec2Math.equals(this, v);
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
     * Constructs new vector of size 2 with 1 as components.
     * 
     * @return new unit vector of size 2
     *
     * @since 1.0.0
     */
    public static Vector2 unitVec() {
        return Vec2Math.unitVec();
    }
}
