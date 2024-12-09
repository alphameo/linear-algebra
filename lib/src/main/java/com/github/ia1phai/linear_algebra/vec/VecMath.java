package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * Class with static functions for arbitrary vectors.
 */
public class VecMath {

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @param v vector for square length calculation
     * @return square length of given vector
     */
    public static float len2(final Vector v) {
        float sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.get(i) * v.get(i);
        }

        return sum;
    }

    /**
     * Calculates length of vector.
     * 
     * @param v vector for length calculation
     * @return Length of given vector
     */
    public static float len(final Vector v) {
        return (float) Math.sqrt(len2(v));
    }

    /**
     * Multiplies the components of vector by a scalar value.
     *
     * @param v          vector for multiplication
     * @param multiplier scalar value
     * @return given vector with multiplied components
     */
    public static Vector mult(final Vector v, final float multiplier) {
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) * multiplier);
        }

        return v;
    }

    /**
     * Copies given vector and multiplies its components by a scalar.
     * value.
     *
     * @param v          vector for multiplication
     * @param multiplier scalar value
     * @return new vector with multiplied components of given vector
     */
    public static Vector multiplied(final Vector v, final float multiplier) {
        return mult(new Vec(v), multiplier);
    }

    /**
     * Divides the components of vector by a scalar value.
     * 
     * @param v       vector for division
     * @param divisor scalar value
     * @return given vector with divided components
     * @throws IllegalArgumentException if {@code divisor} approximately equal to 0
     */
    public static Vector divide(final Vector v, final float divisor) {
        Validator.validateDivisor(divisor);
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) / divisor);
        }

        return v;
    }

    /**
     * Copies given vector and divides its the components of vector by a scalar
     * value.
     *
     * @param v       vector for division
     * @param divisor scalar value
     * @return new vector with divided components of given vector
     * @throws IllegalArgumentException if {@code divisor} approximately equal to 0
     */
    public static Vector divided(final Vector v, final float divisor) {
        return divide(new Vec(v), divisor);
    }

    /**
     * Normalizes given vector (divide each component by vector length)
     * 
     * @param v vector to be normalized
     * @return given vector with normalized components
     * @throws IllegalArgumentException if length of given vector equals 0
     */
    public static Vector normalize(final Vector v) {
        return divide(v, len(v));
    }

    /**
     * Copies and normalizes given vector (divide each component by vector length)
     * 
     * @param v vector to be normalized
     * @return given vector with normalized components of given vector
     * @throws IllegalArgumentException if length of given vector equals 0
     */
    public static Vector normalized(final Vector v) {
        return divided(v, len(v));
    }

    /**
     * Adds the {@code addendum} vector components to the {@code target} vector
     * components.
     *
     * @param target   vector to be added
     * @param addendum vector to add
     * @return {@code target} vector increased by {@code addendum} vector
     * @throws IllegalArgumentException if given vectors have different sizes
     */
    public static Vector add(final Vector target, final Vector addendum) {
        Validator.validateVectorSizes(target, addendum, "Addition denied");
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) + addendum.get(i));
        }

        return target;
    }

    /**
     * Copies {@code target} vector and adds the {@code addendum} vector components
     * to its components.
     *
     * @param target   vector to be added
     * @param addendum vector to add
     * @return new vector with sum of components of {@code target} vector and
     *         {@code addendum} vector
     * @throws IllegalArgumentException if given vectors have different sizes
     */
    public static Vector added(final Vector target, final Vector addendum) {
        return add(new Vec(target), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the {@code target}
     * vector components.
     * 
     * @param target     vector to be subtracted
     * @param subtrahend vector to subtract
     * @return {@code target} vector subtracted by {@code subtrahend} vector
     * @throws IllegalArgumentException if given vectors have different sizes
     */
    public static Vector sub(final Vector target, final Vector subtrahend) {
        Validator.validateVectorSizes(target, subtrahend, "Subtraction denied");
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) - subtrahend.get(i));
        }

        return target;
    }

    /**
     * Copies {@code target} vector and subtracts the {@code subtrahend} vector
     * components from its components.
     * 
     * @param target     vector to be subtracted
     * @param subtrahend vector to subtract
     * @return new vector with components resulting {@code target} vector subtracted
     *         by {@code subtrahend} vector
     */
    public static Vector subtracted(final Vector target, final Vector subtrahend) {
        return sub(new Vec(target), subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of given vectors.
     *
     * @param v1 first vector
     * @param v2 second vector
     * @return dot (scalar) product of given vectors
     */
    public static float dot(final Vector v1, final Vector v2) {
        Validator.validateVectorSizes(v1, v2, "Scalar product denied");
        float sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }

    /**
     * Calculates cross product (vector product) of given vectors.
     *
     * @param v1 first vector
     * @param v2 second vector
     * @return vector, which represents cross (vector) product of given vectors
     */
    public static Vector cross(final Vector v1, final Vector v2) {
        if (v1.size() != 3 || v2.size() != 3) {
            throw new IllegalArgumentException(
                    String.format(String.format("Cross product denien: vector size must be 3, but given are %d, %d"),
                            v1.size(), v2.size()));
        }
        final Vector result = new Vec(3);
        result.set(0, v1.get(1) * v2.get(2) - v1.get(2) * v2.get(1));
        result.set(1, v1.get(2) * v2.get(0) - v1.get(0) * v2.get(2));
        result.set(2, v1.get(0) * v2.get(1) - v1.get(1) * v2.get(0));

        return result;
    }

    /**
     * Returns {@code true} if components of vectors are equal within
     * {@code epsilon} tolerance
     * 
     * @param v1  first vector for comparison
     * @param v2  second vector for comparison
     * @param eps tolerance
     * @return {@code true} if all components of vectors are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     */
    public static boolean equalsEpsilon(final Vector v1, final Vector v2, final float eps) {
        Validator.validateVectorSizes(v1, v2, "Equalization denied");
        for (int i = 0; i < v1.size(); i++) {
            if (!Validator.equalsEpsilon(v1.get(i), v2.get(i), eps)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if components of vectors are approximately equal
     * 
     * @param v1 first vector for comparison
     * @param v2 second vector for comparison
     * @return {@code true} if all components of vectors are approximately equal,
     *         and {@code false} otherwise
     */
    public static boolean equals(final Vector v1, final Vector v2) {
        return equalsEpsilon(v1, v2, Validator.EPS);
    }

    /**
     * Constructs new vector of given {@code size} with all 0 components.
     * 
     * @param size size of vector to be constructed
     * @return new zero vector of given {@code size}
     */
    public static Vector zeroVec(final int size) {
        return new Vec(size);
    }

    /**
     * Constructs new vector of given {@code size} with all 1 components.
     * 
     * @param size size of vector to be constructed
     * @return new unit vector of given {@code size}
     */
    public static Vector unitVec(final int size) {
        final Vector result = new Vec(size);
        for (int i = 0; i < size; i++) {
            result.set(i, 1);
        }

        return result;
    }
}
