package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * Class with static functions for arbitrary vectors.
 */
public class Vec2Math {

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @param v vector of size 2 for square length calculation
     * @return square length of given vector
     */
    public static float len2(final Vector2 v) {
        return v.x() * v.x() + v.y() * v.y();
    }

    /**
     * Calculates length of vector.
     * 
     * @param v vector of size 2 for length calculation
     * @return Length of given vector
     */
    public static float len(final Vector2 v) {
        return (float) Math.sqrt(len2(v));
    }

    /**
     * Multiplies the components of vector with size 2 by a scalar value.
     *
     * @param v          vector of size 2 for multiplication
     * @param multiplier scalar value
     * @return given vector with multiplied components
     */
    public static Vector2 mult(final Vector2 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);

        return v;
    }

    /**
     * Copies given vector and multiplies its components by a scalar.
     * value.
     *
     * @param v          vector of size 2 for multiplication
     * @param multiplier scalar value
     * @return new vector of size 2 with multiplied components of given vector
     */
    public static Vector2 multiplied(final Vector2 v, final float multiplier) {
        return mult(new Vec2(v), multiplier);
    }

    /**
     * Divides the components of vector by a scalar value.
     * 
     * @param v       vector of size 2 for division
     * @param divisor scalar value
     * @return given vector with divided components
     * @throws IllegalArgumentException if divisor equals 0
     */
    public static Vector2 divide(final Vector2 v, final float divisor) {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);

        return v;
    }

    /**
     * Copies given vector and divides its the components of vector by a scalar
     * value.
     *
     * @param v       vector of size 2 for division
     * @param divisor scalar value
     * @return new vector of size 2 with divided components of given vector
     * @throws IllegalArgumentException if divisor equals 0
     */
    public static Vector2 divided(final Vector2 v, final float divisor) {
        return divide(new Vec2(v), divisor);
    }

    /**
     * Normalizes given vector (divide each component by vector length)
     * 
     * @param v vector of size 2 to be normalized
     * @return given vector with normalized components
     * @throws IllegalArgumentException if vector length equals 0
     */
    public static Vector2 normalize(final Vector2 v) {
        return divide(v, len(v));
    }

    /**
     * Copies and normalizes given vector (divide each component by vector length)
     * 
     * @param v vector of size 2 to be normalized
     * @return new vector of size 2 with normalized components of given vector
     * @throws IllegalArgumentException if vector length equals 0
     */
    public static Vector2 normalized(final Vector2 v) {
        return divided(v, len(v));
    }

    /**
     * Adds the {@code addendum} vector components to the {@code target} vector
     * components.
     *
     * @param target   vector of size 2 to be added
     * @param addendum vector of size 2 to add
     * @return {@code target} vector increased by {@code addendum} vector
     */
    public static Vector2 add(final Vector2 target, final Vector2 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());

        return target;
    }

    /**
     * Sums up the {@code addendum} vector and the {@code target} vector.
     *
     * @param target   vector of size 2 to be added
     * @param addendum vector of size 2 to add
     * @return new vector of size 2 with sum of components of {@code target} vector
     *         and
     *         {@code addendum} vector
     */
    public static Vector2 added(final Vector2 target, final Vector2 addendum) {
        return add(new Vec2(target), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the {@code target}
     * vector components.
     * 
     * @param target     vector of size 2 to be subtracted
     * @param subtrahend vector of size 2 to subtract
     * @return {@code target} vector subtracted by {@code subtrahend} vector
     */
    public static Vector2 sub(final Vector2 target, final Vector2 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());

        return target;
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the {@code target}
     * vector components.
     * 
     * @param target     vector of size 2 to be subtracted
     * @param subtrahend vector of size 2 to subtract
     * @return new vector of size 2 with components resulting {@code target} vector
     *         subtracted by {@code subtrahend} vector
     */
    public static Vector2 subtracted(final Vector2 target, final Vector2 subtrahend) {
        return sub(new Vec2(target), subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of given vectors.
     *
     * @param v1 first vector of size 2
     * @param v2 second vector of size 2
     * @return dot (scalar) product of given vectors
     */
    public static float dot(final Vector2 v1, final Vector2 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y();
    }

    /**
     * Returns {@code true} if vector components are approximately equals.
     * 
     * @param v1 first vector of size 2 for comparison
     * @param v2 second vector of size 2 for comparison
     * @return {@code true} if all components are approximately equals, and
     *         {@code false} otherwise
     */
    public static boolean equals(final Vector2 v1, final Vector2 v2) {
        return Validator.equals(v1.x(), v2.x()) && Validator.equals(v1.y(), v2.y());
    }

    /**
     * Constructs new vector of size 3 with components of given vector and 1
     * <p>
     * (x, y, 1)
     *
     * @param v vector of size 2
     * @return new vector of size 3 including with of given vector
     */
    public static Vector3 toVec3(final Vector2 v) {
        return new Vec3(v.x(), v.y(), 1);
    }

    /**
     * Constructs new vector of size 2 with all 0 components.
     * 
     * @param size size of vector to be constructed
     * @return new zero vector of size 2
     */
    public static Vector2 zeroVec() {
        return new Vec2();
    }

    /**
     * Constructs new vector of size 2 with all 1 components.
     * 
     * @return new unit vector of size 2
     */
    public static Vector2 unitVec() {
        return new Vec2(1, 1);
    }
}
