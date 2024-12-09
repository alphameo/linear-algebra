package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * Class with static functions for arbitrary vectors.
 */
public class Vec4Math {

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @param v vector of size 4 for square length calculation
     * @return square length of given vector
     */
    public static float len2(final Vector4 v) {
        return v.x() * v.x() + v.y() * v.y() + v.z() * v.z() + v.w() * v.w();
    }

    /**
     * Calculates length of vector.
     * 
     * @param v vector of size 4 for length calculation
     * @return length of given vector
     */
    public static float len(final Vector4 v) {
        return (float) Math.sqrt(len2(v));
    }

    /**
     * Multiplies the components of vector with size 4 by a scalar value.
     *
     * @param v          vector of size 4 for multiplication
     * @param multiplier scalar value
     * @return given vector with multiplied components
     */
    public static Vector4 mult(final Vector4 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);
        v.setZ(v.z() * multiplier);
        v.setW(v.w() * multiplier);

        return v;
    }

    /**
     * Copies given vector and multiplies its components by a scalar.
     * value.
     *
     * @param v          vector of size 4 for multiplication
     * @param multiplier scalar value
     * @return new vector of size 4 with multiplied components of given vector
     */
    public static Vector4 multiplied(final Vector4 v, final float multiplier) {
        return mult(new Vec4(v), multiplier);
    }

    /**
     * Divides the components of given vector by a scalar value.
     * 
     * @param v       vector of size 4 for division
     * @param divisor scalar value
     * @return given vector with divided components
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     */
    public static Vector4 divide(final Vector4 v, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);
        v.setZ(v.z() / divisor);
        v.setW(v.w() / divisor);

        return v;
    }

    /**
     * Copies given vector and divides its components by a scalar value.
     *
     * @param v       vector of size 4 for division
     * @param divisor scalar value
     * @return new vector of size 4 with divided components of given vector
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     */
    public static Vector4 divided(final Vector4 v, final float divisor) throws ArithmeticException {
        return divide(new Vec4(v), divisor);
    }

    /**
     * Normalizes given vector (divide each component by vector length)
     * 
     * @param v vector of size 4 to be normalized
     * @return given vector with normalized components
     * @throws ArithmeticException if length of given vector equals 0
     */
    public static Vector4 normalize(final Vector4 v) throws ArithmeticException {
        return divide(v, len(v));
    }

    /**
     * Copies and normalizes given vector (divide each component by vector length)
     * 
     * @param v vector of size 4 to be normalized
     * @return new vector of size 4 with normalized components of given vector
     * @throws ArithmeticException if length of given vector equals 0
     */
    public static Vector4 normalized(final Vector4 v) throws ArithmeticException {
        return divided(v, len(v));
    }

    /**
     * Adds the {@code addendum} vector components to the {@code target} vector
     * components.
     *
     * @param target   vector of size 4 to be added
     * @param addendum vector of size 4 to add
     * @return {@code target} vector increased by {@code addendum} vector
     */
    public static Vector4 add(final Vector4 target, final Vector4 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());
        target.setZ(target.z() + addendum.z());
        target.setW(target.w() + addendum.w());

        return target;
    }

    /**
     * Copies {@code target} vector and adds the {@code addendum} vector components
     * to its components.
     *
     * @param target   vector of size 4 to be added
     * @param addendum vector of size 4 to add
     * @return new vector of size 4 with sum of components of {@code target} vector
     *         and
     *         {@code addendum} vector
     */
    public static Vector4 added(final Vector4 target, final Vector4 addendum) {
        return add(new Vec4(target), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the {@code target}
     * vector components.
     * 
     * @param target     vector of size 4 to be subtracted
     * @param subtrahend vector of size 4 to subtract
     * @return {@code target} vector subtracted by {@code subtrahend} vector
     */
    public static Vector4 sub(final Vector4 target, final Vector4 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());
        target.setZ(target.z() - subtrahend.z());
        target.setW(target.w() - subtrahend.w());

        return target;
    }

    /**
     * Copies {@code target} vector and subtracts the {@code subtrahend} vector
     * components from its components.
     * 
     * @param target     vector of size 4 to be subtracted
     * @param subtrahend vector of size 4 to subtract
     * @return new vector of size 4 with components resulting {@code target} vector
     *         subtracted by {@code subtrahend} vector
     */
    public static Vector4 subtracted(final Vector4 target, final Vector4 subtrahend) {
        return sub(new Vec4(target), subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of given vectors.
     *
     * @param v1 first vector of size 4
     * @param v2 second vector of size 4
     * @return dot (scalar) product of given vectors
     */
    public static float dot(final Vector4 v1, final Vector4 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z() + v1.w() * v2.w();
    }

    /**
     * Returns {@code true} if components of vectors are equal within
     * {@code epsilon} tolerance
     * 
     * @param v1  first vector of size 4 for comparison
     * @param v2  second vector of size 4 for comparison
     * @param eps tolerance
     * @return {@code true} if all components of vectors are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     */
    public static boolean equalsEpsilon(final Vector4 v1, final Vector4 v2, final float eps) {
        return Validator.equalsEpsilon(v1.x(), v2.x(), eps)
                && Validator.equalsEpsilon(v1.y(), v2.y(), eps)
                && Validator.equalsEpsilon(v1.z(), v2.z(), eps)
                && Validator.equalsEpsilon(v1.w(), v2.w(), eps);
    }

    /**
     * Returns {@code true} if components of vectors are approximately equal
     * 
     * @param v1 first vector of size 4 for comparison
     * @param v2 second vector of size 4 for comparison
     * @return {@code true} if all components of vectors are approximately equal,
     *         and {@code false} otherwise
     */
    public static boolean equals(final Vector4 v1, final Vector4 v2) {
        return equalsEpsilon(v1, v2, Validator.EPS);
    }

    /**
     * Constructs new vector of size 4 with all 0 components.
     * 
     * @return new zero vector of size 4
     */
    public static Vector4 zeroVec() {
        return new Vec4();
    }

    /**
     * Constructs new vector of size 4 with all 1 components.
     * 
     * @return new unit vector of size 4
     */
    public static Vector4 unitVec() {
        return new Vec4(1, 1, 1, 1);
    }
}
