package io.github.alphameo.linear_algebra.vec;

import io.github.alphameo.linear_algebra.Validator;

/**
 * Class with static functions for arbitrary vectors.
 *
 * @since 1.0.0
 */
public final class Vector2Math {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public Vector2Math() {
    }

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @param v vector of size 2 for square length calculation
     * @return square length of given vector
     *
     * @since 1.0.0
     */
    public static float len2(final Vector2 v) {
        return v.x() * v.x() + v.y() * v.y();
    }

    /**
     * Calculates length of vector.
     * 
     * @param v vector of size 2 for length calculation
     * @return length of given vector
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
     */
    public static Vector2 multiplied(final Vector2 v, final float multiplier) {
        return mult(v.clone(), multiplier);
    }

    /**
     * Divides the components of vector by a scalar value.
     * 
     * @param v       vector of size 2 for division
     * @param divisor scalar value
     * @return given vector with divided components
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Vector2 divide(final Vector2 v, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);

        return v;
    }

    /**
     * Copies given vector and divides its components by a scalar value.
     *
     * @param v       vector of size 2 for division
     * @param divisor scalar value
     * @return new vector of size 2 with divided components of given vector
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Vector2 divided(final Vector2 v, final float divisor) throws ArithmeticException {
        return divide(v.clone(), divisor);
    }

    /**
     * Normalizes given vector (divide each component by vector length)
     * 
     * @param v vector of size 2 to be normalized
     * @return given vector with normalized components
     * @throws ArithmeticException if length of given vector equals 0
     *
     * @since 1.0.0
     */
    public static Vector2 normalize(final Vector2 v) throws ArithmeticException {
        return divide(v, len(v));
    }

    /**
     * Copies and normalizes given vector (divide each component by vector length)
     * 
     * @param v vector of size 2 to be normalized
     * @return new vector of size 2 with normalized components of given vector
     * @throws ArithmeticException if length of given vector equals 0
     *
     * @since 1.0.0
     */
    public static Vector2 normalized(final Vector2 v) throws ArithmeticException {
        return divided(v.clone(), len(v));
    }

    /**
     * Adds the {@code addendum} vector components to the {@code target} vector
     * components.
     *
     * @param target   vector of size 2 to be added
     * @param addendum vector of size 2 to add
     * @return {@code target} vector increased by {@code addendum} vector
     *
     * @since 1.0.0
     */
    public static Vector2 add(final Vector2 target, final Vector2 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());

        return target;
    }

    /**
     * Copies {@code target} vector and adds the {@code addendum} vector components
     * to its components.
     *
     * @param target   vector of size 2 to be added
     * @param addendum vector of size 2 to add
     * @return new vector of size 2 with sum of components of {@code target} vector
     *         and
     *         {@code addendum} vector
     *
     * @since 1.0.0
     */
    public static Vector2 added(final Vector2 target, final Vector2 addendum) {
        return add(target.clone(), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the {@code target}
     * vector components.
     * 
     * @param target     vector of size 2 to be subtracted
     * @param subtrahend vector of size 2 to subtract
     * @return {@code target} vector subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    public static Vector2 sub(final Vector2 target, final Vector2 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());

        return target;
    }

    /**
     * Copies {@code target} vector and subtracts the {@code subtrahend} vector
     * components from its components.
     * 
     * @param target     vector of size 2 to be subtracted
     * @param subtrahend vector of size 2 to subtract
     * @return new vector of size 2 with components resulting {@code target} vector
     *         subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    public static Vector2 subtracted(final Vector2 target, final Vector2 subtrahend) {
        return sub(target.clone(), subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of given vectors.
     *
     * @param v1 first vector of size 2
     * @param v2 second vector of size 2
     * @return dot (scalar) product of given vectors
     *
     * @since 1.0.0
     */
    public static float dot(final Vector2 v1, final Vector2 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y();
    }

    /**
     * Returns {@code true} if components of vectors are equal within
     * {@code epsilon} tolerance.
     * 
     * @param v1  first vector of size 2 for comparison
     * @param v2  second vector of size 2 for comparison
     * @param eps tolerance
     * @return {@code true} if all components of vectors are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equalsEpsilon(final Vector2 v1, final Vector2 v2, final float eps) {
        return Validator.equalsEpsilon(v1.x(), v2.x(), eps)
                && Validator.equalsEpsilon(v1.y(), v2.y(), eps);
    }

    /**
     * Returns {@code true} if components of vectors are approximately equal.
     * 
     * @param v1 first vector of size 2 for comparison
     * @param v2 second vector of size 2 for comparison
     * @return {@code true} if all components of vectors are approximately equal,
     *         and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equals(final Vector2 v1, final Vector2 v2) {
        return equalsEpsilon(v1, v2, Validator.EPS);
    }

    /**
     * Constructs new vector of size 3 with components of given vector and 1
     * <p>
     * (x, y, 1)
     *
     * @param v vector of size 2
     * @return new vector of size 3 including components of given vector and 1 as
     *         last component
     *
     * @since 1.0.0
     */
    public static Vector3 toVec3(final Vector2 v) {
        return new Vec3(v.x(), v.y(), 1);
    }

    /**
     * Constructs new vector of size 2 with all 0 components.
     * 
     * @return new zero vector of size 2
     *
     * @since 1.0.0
     */
    public static Vector2 zeroVector() {
        return new Vec2();
    }

    /**
     * Constructs new vector of size 2 with 1 as components.
     * 
     * @return new unit vector of size 2
     *
     * @since 1.0.0
     */
    public static Vector2 unitVector() {
        return new Vec2(1, 1);
    }
}
