package io.github.alphameo.linear_algebra.vec;

import io.github.alphameo.linear_algebra.Validator;

/**
 * Class with static functions for 2-dimensional vectors.
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
     * Returns the square of the length of the the given vector.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @param v vector for square length calculation
     * @return squared length of vector {@code v}
     *
     * @since 1.0.0
     */
    public static float len2(final Vector2 v) {
        return v.x() * v.x() + v.y() * v.y();
    }

    /**
     * Returns length of the the given vector.
     * 
     * @param v vector for length calculation
     * @return length of vector {@code v}
     *
     * @since 1.0.0
     */
    public static float len(final Vector2 v) {
        return (float) Math.sqrt(len2(v));
    }

    /**
     * Multiplies components of the the given vector by a scalar value and returns it.
     *
     * @param v          vector for multiplication
     * @param multiplier scalar value
     * @return vector {@code v} multiplied by {@code multiplier}
     *
     * @since 1.0.0
     */
    public static Vector2 mulAsgn(final Vector2 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);

        return v;
    }

    /**
     * Returns the result of multiplying the components of the the given vector by a
     * scalar value.
     *
     * @param v          vector for multiplication
     * @param multiplier scalar value
     * @return new vector with components of vector {@code v} multiplied by
     *         {@code multiplier}
     *
     * @since 1.0.0
     */
    public static Vector2 mul(final Vector2 v, final float multiplier) {
        return mulAsgn(v.clone(), multiplier);
    }

    /**
     * Divides components of the the given vector by a scalar value and returns it.
     * 
     * @param v       vector for division
     * @param divisor scalar value
     * @return vector {@code v} divided by {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Vector2 divAsgn(final Vector2 v, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);

        return v;
    }

    /**
     * Returns the result of dividing the components of the the given vector by a scalar
     * value.
     *
     * @param v       vector for division
     * @param divisor scalar value
     * @return new vector with components of vector {@code v} divided by
     *         {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Vector2 div(final Vector2 v, final float divisor) throws ArithmeticException {
        return divAsgn(v.clone(), divisor);
    }

    /**
     * Normalize components of the given vector (divide each component by vector
     * length)
     * and returns it.
     * 
     * @param v vector to be normalized
     * @return vector {@code v} with normalized components
     * @throws ArithmeticException if length of the given vector is approximately
     *                             equal 0
     *
     * @since 1.0.0
     */
    public static Vector2 normalize(final Vector2 v) throws ArithmeticException {
        return divAsgn(v, len(v));
    }

    /**
     * Returns the result of normalization of the given vector (divide each
     * component by vector length)
     * 
     * @param v vector to be normalized
     * @return new vector with normalized components of the given vector
     * @throws ArithmeticException if length of the given vector is approximately
     *                             equal 0
     *
     * @since 1.0.0
     */
    public static Vector2 normalized(final Vector2 v) throws ArithmeticException {
        return div(v.clone(), len(v));
    }

    /**
     * Adds the components of the addendum vector to the components of the target
     * vector and returns it.
     *
     * @param target   vector to be added
     * @param addendum vector to add
     * @return vector {@code target} increased by vector {@code addendum}
     *
     * @since 1.0.0
     */
    public static Vector2 addAsgn(final Vector2 target, final Vector2 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());

        return target;
    }

    /**
     * Returns the result of adding the components of the addendum vector to the
     * components of the target vector.
     *
     * @param target   vector to be added
     * @param addendum vector to add
     * @return new vector with the sum of vector {@code target} and vector
     *         {@code addendum}
     *
     *
     * @since 1.0.0
     */
    public static Vector2 add(final Vector2 target, final Vector2 addendum) {
        return addAsgn(target.clone(), addendum);
    }

    /**
     * Subtracts components of the subtrahend vector from the components of the
     * target vector and returns it.
     * 
     * @param target     vector to be subtracted
     * @param subtrahend vector to subtract
     * @return vector {@code target} reduced by vector {@code subtrahend}
     *
     * @since 1.0.0
     */
    public static Vector2 subAsgn(final Vector2 target, final Vector2 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());

        return target;
    }

    /**
     * Returns the result of subtracting the components of the subtrahend vector
     * from the components of the target vector.
     * 
     * @param target     vector to be subtracted
     * @param subtrahend vector to subtract
     * @return new vector with result of subtracting vector {@code subtrahend} from
     *         vector {@code target}
     *
     * @since 1.0.0
     */
    public static Vector2 sub(final Vector2 target, final Vector2 subtrahend) {
        return subAsgn(target.clone(), subtrahend);
    }

    /**
     * Returns dot product (scalar product) of the given vectors.
     *
     * @param v1 first vector for dot product
     * @param v2 second vector for dot product
     * @return dot product of the given vectors
     *
     * @since 1.0.0
     */
    public static float dot(final Vector2 v1, final Vector2 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y();
    }

    /**
     * Returns {@code true} if the components of two vectors are equal within
     * {@code epsilon} tolerance.
     * 
     * @param v1  first vector for comparison
     * @param v2  second vector for comparison
     * @param eps tolerance
     * @return {@code true} if all components of vectors are equal within
     *         {@code eps} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equalsEpsilon(final Vector2 v1, final Vector2 v2, final float eps) {
        return Validator.equalsEpsilon(v1.x(), v2.x(), eps)
                && Validator.equalsEpsilon(v1.y(), v2.y(), eps);
    }

    /**
     * Returns {@code true} if the components of two vectors are approximately
     * equal.
     * 
     * @param v1 first vector for comparison
     * @param v2 second vector for comparison
     * @return {@code true} if all components of vectors are approximately equal,
     *         and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equals(final Vector2 v1, final Vector2 v2) {
        return equalsEpsilon(v1, v2, Validator.EPS);
    }

    /**
     * Constructs 3-dimensional vector with components of the given vector and 1 as
     * last
     * component
     * <p>
     * (x, y, 1)
     *
     * @param v 2-dimensional vector
     * @return new 3-dimensional vector including components of the given vector and
     *         1
     *
     * @since 1.0.0
     */
    public static Vector3 toVector3(final Vector2 v) {
        return new Vec3(v.x(), v.y(), 1);
    }

    /**
     * Constructs 2-dimensional vector with all 0 components.
     * 
     * @return new zero 2-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector2 zeroVector() {
        return new Vec2();
    }

    /**
     * Constructs 2-dimensional vector with all 1 components.
     * 
     * @return new unit 2-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector2 unitVector() {
        return new Vec2(1, 1);
    }
}
