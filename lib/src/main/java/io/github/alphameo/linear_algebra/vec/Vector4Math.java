package io.github.alphameo.linear_algebra.vec;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.mat.Matrix4;
import io.github.alphameo.linear_algebra.mat.Matrix4Math;

/**
 * Class with static functions for vectors of size 4.
 *
 * @since 1.0.0
 */
public final class Vector4Math {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public Vector4Math() {
    }

    /**
     * Returns the square of the length of the given vector.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @param v vector for square length calculation
     * @return squared length of vector {@code v}
     *
     * @since 1.0.0
     */
    public static float len2(final Vector4 v) {
        return v.x() * v.x() + v.y() * v.y() + v.z() * v.z() + v.w() * v.w();
    }

    /**
     * Returns length of the given vector.
     * 
     * @param v vector for length calculation
     * @return length of vector {@code v}
     *
     * @since 1.0.0
     */
    public static float len(final Vector4 v) {
        return (float) Math.sqrt(len2(v));
    }

    /**
     * Multiplies components of given vector by a scalar value and returns it.
     *
     * @param v          vector for multiplication
     * @param multiplier scalar value
     * @return vector {@code v} multiplied by {@code multiplier}
     *
     * @since 1.0.0
     */
    public static Vector4 mulAsgn(final Vector4 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);
        v.setZ(v.z() * multiplier);
        v.setW(v.w() * multiplier);

        return v;
    }

    /**
     * Returns the result of multiplying the components of the given vector by a
     * scalar value.
     *
     * @param v          vector for multiplication
     * @param multiplier scalar value
     * @return new vector with components of vector {@code v} multiplied by
     *         {@code multiplier}
     *
     * @since 1.0.0
     */
    public static Vector4 mul(final Vector4 v, final float multiplier) {
        return mulAsgn(v.clone(), multiplier);
    }

    /**
     * Divides components of given vector by a scalar value and returns it.
     * 
     * @param v       vector for division
     * @param divisor scalar value
     * @return vector {@code v} divided by {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Vector4 divAsgn(final Vector4 v, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);
        v.setZ(v.z() / divisor);
        v.setW(v.w() / divisor);

        return v;
    }

    /**
     * Returns the result of dividing the components of the given vector by a scalar
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
    public static Vector4 div(final Vector4 v, final float divisor) throws ArithmeticException {
        return divAsgn(v.clone(), divisor);
    }

    /**
     * Normalize components of given vector (divide each component by vector length)
     * and returns it.
     * 
     * @param v vector to be normalized
     * @return vector {@code v} with normalized components
     * @throws ArithmeticException if length of the given vector is approximately
     *                             equal 0
     *
     * @since 1.0.0
     */
    public static Vector4 normalize(final Vector4 v) throws ArithmeticException {
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
    public static Vector4 normalized(final Vector4 v) throws ArithmeticException {
        return div(v.clone(), len(v));
    }

    /**
     * Adds the components of the addendum vector to the components of the target
     * vector and returns it.
     *
     * @param target   vector to be added
     * @param addendum vector to add
     * @return vector {@code target} increased by vector {@code addendum}
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    public static Vector4 addAsgn(final Vector4 target, final Vector4 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());
        target.setZ(target.z() + addendum.z());
        target.setW(target.w() + addendum.w());

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
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    public static Vector4 add(final Vector4 target, final Vector4 addendum) {
        return addAsgn(target.clone(), addendum);
    }

    /**
     * Subtracts components of the subtrahend vector from the components of the
     * target vector and returns it.
     * 
     * @param target     vector to be subtracted
     * @param subtrahend vector to subtract
     * @return vector {@code target} reduced by vector {@code subtrahend}
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    public static Vector4 subAsgn(final Vector4 target, final Vector4 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());
        target.setZ(target.z() - subtrahend.z());
        target.setW(target.w() - subtrahend.w());

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
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    public static Vector4 sub(final Vector4 target, final Vector4 subtrahend) {
        return subAsgn(target.clone(), subtrahend);
    }

    /**
     * Returns dot product (scalar product) of the given vectors.
     *
     * @param v1 first vector for dot product
     * @param v2 second vector for dot product
     * @return dot product of the given vectors
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    public static float dot(final Vector4 v1, final Vector4 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z() + v1.w() * v2.w();
    }

    /**
     * Transforms the given vector-column by the given transformation operator
     * matrix and returns it.
     *
     * @param vCol     vector-column to be transformed
     * @param operator transformation matrix
     * @return vector {@code vCol} transformed by matrix {@code operator}
     * @throws IllegalArgumentException if width of the given matrix is not equal
     *                                  to dimension of the given vector-column
     *
     * @since 3.0.0
     */
    public static Vector4 transformCol(final Vector4 vCol, final Matrix4 operator) {
        return Matrix4Math.prodColIncr(operator, vCol);
    }

    /**
     * Returns the result of transforming the given vector-column by the given
     * transformation operator matrix.
     *
     * @param vCol     vector-column to be transformed
     * @param operator transformation matrix
     * @return new vector with result of transforming vector {@code vCol} by matrix
     *         {@code operator}
     * @throws IllegalArgumentException if width of the given matrix is not equal
     *                                  to dimension of the given vector-column
     *
     * @since 3.0.0
     */
    public static Vector4 transformedCol(final Vector4 vCol, final Matrix4 operator) {
        return Matrix4Math.prodCol(operator, vCol);
    }

    /**
     * Transforms the given vector-row by the given transformation operator
     * matrix and returns it.
     *
     * @param vRow     vector-row to be transformed
     * @param operator transformation matrix
     * @return vector {@code vRow} transformed by matrix {@code operator}
     * @throws IllegalArgumentException if height of the given matrix is not equal
     *                                  to the dimension of the given vector-row
     *
     * @since 3.0.0
     */
    public static Vector4 transformRow(final Vector4 vRow, final Matrix4 operator) {
        return Matrix4Math.prodRowIncr(operator, vRow);
    }

    /**
     * Returns the result of transforming the given vector-row by the given
     * transformation operator matrix.
     *
     * @param vRow     vector-column to be transformed
     * @param operator transformation matrix
     * @return new vector with result of transforming vector {@code vRow} by matrix
     *         {@code operator}
     * @throws IllegalArgumentException if height of the given matrix is not equal
     *                                  to dimension of the given vector-row
     *
     * @since 3.0.0
     */
    public static Vector4 transformedRow(final Vector4 vRow, final Matrix4 operator) {
        return Matrix4Math.prodRow(operator, vRow);
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
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    public static boolean equalsEpsilon(final Vector4 v1, final Vector4 v2, final float eps) {
        return Validator.equalsEpsilon(v1.x(), v2.x(), eps)
                && Validator.equalsEpsilon(v1.y(), v2.y(), eps)
                && Validator.equalsEpsilon(v1.z(), v2.z(), eps)
                && Validator.equalsEpsilon(v1.w(), v2.w(), eps);
    }

    /**
     * Returns {@code true} if the components of two vectors are approximately
     * equal.
     * 
     * @param v1 first vector for comparison
     * @param v2 second vector for comparison
     * @return {@code true} if all components of vectors are approximately equal,
     *         and {@code false} otherwise
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    public static boolean equals(final Vector4 v1, final Vector4 v2) {
        return equalsEpsilon(v1, v2, Validator.EPS);
    }

    /**
     * Constructs 4-dimensional vector with all 0 components.
     * 
     * @return new zero 4-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector4 zeroVector() {
        return new Vec4();
    }

    /**
     * Constructs 4-dimensional vector with all 1 components.
     * 
     * @return new unit 4-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector4 unitVector() {
        return new Vec4(1, 1, 1, 1);
    }
}
