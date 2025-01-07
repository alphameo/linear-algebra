package io.github.alphameo.linear_algebra.vec;

import io.github.alphameo.linear_algebra.Validator;

/**
 * Class with static functions for vectors of size 3.
 *
 * @since 1.0.0
 */
public final class Vec3Math {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public Vec3Math() {
    }

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @param v vector of size 3 for square length calculation
     * @return square length of given vector
     *
     * @since 1.0.0
     */
    public static float len2(final Vector3 v) {
        return v.x() * v.x() + v.y() * v.y() + v.z() * v.z();
    }

    /**
     * Calculates length of vector.
     * 
     * @param v vector of size 3 for length calculation
     * @return length of given vector
     *
     * @since 1.0.0
     */
    public static float len(final Vector3 v) {
        return (float) Math.sqrt(len2(v));
    }

    /**
     * Multiplies the components of vector with size 3 by a scalar value.
     *
     * @param v          vector of size 3 for multiplication
     * @param multiplier scalar value
     * @return given vector with multiplied components
     *
     * @since 1.0.0
     */
    public static Vector3 mult(final Vector3 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);
        v.setZ(v.z() * multiplier);

        return v;
    }

    /**
     * Copies given vector and multiplies its components by a scalar.
     * value.
     *
     * @param v          vector of size 3 for multiplication
     * @param multiplier scalar value
     * @return new vector of size 3 with multiplied components of given vector
     *
     * @since 1.0.0
     */
    public static Vector3 multiplied(final Vector3 v, final float multiplier) {
        return mult(v.clone(), multiplier);
    }

    /**
     * Divides the components of given vector by a scalar value.
     * 
     * @param v       vector of size 3 for division
     * @param divisor scalar value
     * @return given vector with divided components
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Vector3 divide(final Vector3 v, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);
        v.setZ(v.z() / divisor);

        return v;
    }

    /**
     * Copies given vector and divides its components by a scalar value.
     *
     * @param v       vector of size 3 for division
     * @param divisor scalar value
     * @return new vector of size 3 with divided components of given vector
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Vector3 divided(final Vector3 v, final float divisor) throws ArithmeticException {
        return divide(v.clone(), divisor);
    }

    /**
     * Normalizes given vector (divide each component by vector length)
     * 
     * @param v vector of size 3 to be normalized
     * @return given vector with normalized components
     * @throws ArithmeticException if length of given vector equals 0
     *
     * @since 1.0.0
     */
    public static Vector3 normalize(final Vector3 v) throws ArithmeticException {
        return divide(v, len(v));
    }

    /**
     * Copies and normalizes given vector (divide each component by vector length)
     * 
     * @param v vector of size 3 to be normalized
     * @return new vector of size 3 with normalized components of given vector
     * @throws IllegalArgumentException if length of given vector equals 0
     *
     * @since 1.0.0
     */
    public static Vector3 normalized(final Vector3 v) {
        return divided(v.clone(), len(v));
    }

    /**
     * Adds the {@code addendum} vector components to the {@code target} vector
     * components.
     *
     * @param target   vector of size 3 to be added
     * @param addendum vector of size 3 to add
     * @return {@code target} vector increased by {@code addendum} vector
     *
     * @since 1.0.0
     */
    public static Vector3 add(final Vector3 target, final Vector3 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());
        target.setZ(target.z() + addendum.z());

        return target;
    }

    /**
     * Copies {@code target} vector and adds the {@code addendum} vector components
     * to its components.
     *
     * @param target   vector of size 3 to be added
     * @param addendum vector of size 3 to add
     * @return new vector of size 3 with sum of components of {@code target} vector
     *         and
     *         {@code addendum} vector
     *
     * @since 1.0.0
     */
    public static Vector3 added(final Vector3 target, final Vector3 addendum) {
        return add(target.clone(), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the {@code target}
     * vector components.
     * 
     * @param target     vector of size 3 to be subtracted
     * @param subtrahend vector of size 3 to subtract
     * @return {@code target} vector subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    public static Vector3 sub(final Vector3 target, final Vector3 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());
        target.setZ(target.z() - subtrahend.z());

        return target;
    }

    /**
     * Copies {@code target} vector and subtracts the {@code subtrahend} vector
     * components from its components.
     * 
     * @param target     vector of size 3 to be subtracted
     * @param subtrahend vector of size 3 to subtract
     * @return new vector of size 3 with components resulting {@code target} vector
     *         subtracted by {@code subtrahend} vector
     *
     * @since 1.0.0
     */
    public static Vector3 subtracted(final Vector3 target, final Vector3 subtrahend) {
        return sub(target.clone(), subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of given vectors.
     *
     * @param v1 first vector of size 3
     * @param v2 second vector of size 3
     * @return dot (scalar) product of given vectors
     *
     * @since 1.0.0
     */
    public static float dot(final Vector3 v1, final Vector3 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z();
    }

    /**
     * Calculates cross product (vector product) of given vectors.
     *
     * @param v1 first vector of size 3
     * @param v2 second vector of size 3
     * @return vector of size 3, which represents cross (vector) product of given
     *         vectors
     *
     * @since 1.0.0
     */
    public static Vector3 cross(final Vector3 v1, final Vector3 v2) {
        final float x = v1.y() * v2.z() - v1.z() * v2.y();
        final float y = v1.z() * v2.x() - v1.x() * v2.z();
        final float z = v1.x() * v2.y() - v1.y() * v2.x();

        return new Vec3(x, y, z);
    }

    /**
     * Returns {@code true} if components of vectors are equal within
     * {@code epsilon} tolerance
     * 
     * @param v1  first vector of size 3 for comparison
     * @param v2  second vector of size 3 for comparison
     * @param eps tolerance
     * @return {@code true} if all components of vectors are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equalsEpsilon(final Vector3 v1, final Vector3 v2, final float eps) {
        return Validator.equalsEpsilon(v1.x(), v2.x(), eps)
                && Validator.equalsEpsilon(v1.y(), v2.y(), eps)
                && Validator.equalsEpsilon(v1.z(), v2.z(), eps);
    }

    /**
     * Returns {@code true} if components of vectors are approximately equal
     * 
     * @param v1 first vector of size 3 for comparison
     * @param v2 second vector of size 3 for comparison
     * @return {@code true} if all components of vectors are approximately equal,
     *         and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equals(final Vector3 v1, final Vector3 v2) {
        return equalsEpsilon(v1, v2, Validator.EPS);
    }

    /**
     * Constructs new vector of size 3 with components of given vector and 1
     * <p>
     * (x, y, z, 1)
     *
     * @param v vector of size 3
     * @return new vector of size 4 including components of given vector and 1 as
     *         last component
     *
     * @since 1.0.0
     */
    public static Vector4 toVec4(final Vector3 v) {
        return new Vec4(v.x(), v.y(), v.z(), 1);
    }

    /**
     * Constructs new vector of size 3 with all 0 components.
     * 
     * @return new zero vector of size 3
     *
     * @since 1.0.0
     */
    public static Vector3 zeroVec() {
        return new Vec3();
    }

    /**
     * Constructs new vector of size 3 with 1 as components.
     * 
     * @return new unit vector of size 3
     *
     * @since 1.0.0
     */
    public static Vector3 unitVec() {
        return new Vec3(1, 1, 1);
    }
}
