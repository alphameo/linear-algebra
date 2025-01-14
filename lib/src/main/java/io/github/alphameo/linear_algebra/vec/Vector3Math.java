package io.github.alphameo.linear_algebra.vec;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.mat.Matrix3;
import io.github.alphameo.linear_algebra.mat.Matrix3Math;

/**
 * Class with static functions for 4-dimensional vectors.
 *
 * @since 1.0.0
 */
public final class Vector3Math {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public Vector3Math() {
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
    public static float len2(final Vector3 v) {
        return v.x() * v.x() + v.y() * v.y() + v.z() * v.z();
    }

    /**
     * Returns length of the given vector.
     * 
     * @param v vector for length calculation
     * @return length of vector {@code v}
     *
     * @since 1.0.0
     */
    public static float len(final Vector3 v) {
        return (float) Math.sqrt(len2(v));
    }

    /**
     * Multiplies components of the given vector by a scalar value and returns it.
     *
     * @param v          vector for multiplication
     * @param multiplier scalar value
     * @return vector {@code v} multiplied by {@code multiplier}
     *
     * @since 1.0.0
     */
    public static Vector3 mulAsgn(final Vector3 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);
        v.setZ(v.z() * multiplier);

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
    public static Vector3 mul(final Vector3 v, final float multiplier) {
        return mulAsgn(v.clone(), multiplier);
    }

    /**
     * Divides components of the given vector by a scalar value and returns it.
     * 
     * @param v       vector for division
     * @param divisor scalar value
     * @return vector {@code v} divided by {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Vector3 divAsgn(final Vector3 v, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);
        v.setZ(v.z() / divisor);

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
    public static Vector3 div(final Vector3 v, final float divisor) throws ArithmeticException {
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
    public static Vector3 normalize(final Vector3 v) throws ArithmeticException {
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
    public static Vector3 normalized(final Vector3 v) {
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
    public static Vector3 addAsgn(final Vector3 target, final Vector3 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());
        target.setZ(target.z() + addendum.z());

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
     * @since 1.0.0
     */
    public static Vector3 add(final Vector3 target, final Vector3 addendum) {
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
    public static Vector3 subAsgn(final Vector3 target, final Vector3 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());
        target.setZ(target.z() - subtrahend.z());

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
    public static Vector3 sub(final Vector3 target, final Vector3 subtrahend) {
        return subAsgn(target.clone(), subtrahend);
    }

    /**
     * Returns the result of dot product (scalar product) of the given vectors.
     *
     * @param v1 first vector for dot product
     * @param v2 second vector for dot product
     * @return dot product of vector {@code v1} and vector {@code v2}
     *
     * @since 1.0.0
     */
    public static float dot(final Vector3 v1, final Vector3 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z();
    }

    /**
     * Returns the result of cross product (vector product) of the given vectors.
     *
     * @param v1 first vector for cross product
     * @param v2 second vector for cross product
     * @return new vector, which represents cross product of vector {@code v1} and
     *         vector {@code v2}
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
     * Returns the result of product of the given vector-row and the given matrix.
     *
     * @param vRow vector-row for product
     * @param m    matrix for product
     * @return new vector, which represents product of {@code vCol} and matrix
     *         {@code m}
     * @throws IllegalArgumentException if height of the given matrix is not equal
     *                                  to the dimension of the given vector-row
     *
     * @since 3.0.0
     */
    public static Vector3 prod(final Vector3 vRow, final Matrix3 m) throws IllegalArgumentException {
        return Matrix3Math.prodRow(m, vRow);
    }

    /**
     * Transforms the given vector-column by the given transformation operator
     * matrix and returns it.
     *
     * @param vCol     vector-column to be transformed
     * @param operator transformation matrix
     * @return vector {@code vCol} transformed by matrix {@code operator}
     *
     * @since 3.0.0
     */
    public static Vector3 transformCol(final Vector3 vCol, final Matrix3 operator) {
        Vector3 v = Matrix3Math.prodCol(operator, vCol);
        vCol.setX(v.x());
        vCol.setY(v.y());
        vCol.setZ(v.z());

        return vCol;
    }

    /**
     * Returns the result of transforming the given vector-column by the given
     * transformation operator matrix.
     *
     * @param vCol     vector-column to be transformed
     * @param operator transformation matrix
     * @return new vector with result of transforming vector {@code vCol} by matrix
     *         {@code operator}
     *
     * @since 3.0.0
     */
    public static Vector3 transformedCol(final Vector3 vCol, final Matrix3 operator) {
        return Matrix3Math.prodCol(operator, vCol);
    }

    /**
     * Transforms the given vector-row by the given transformation operator
     * matrix and returns it.
     *
     * @param vRow     vector-row to be transformed
     * @param operator transformation matrix
     * @return vector {@code vRow} transformed by matrix {@code operator}
     *
     * @since 3.0.0
     */
    public static Vector3 transformRow(final Vector3 vRow, final Matrix3 operator) {
        Vector3 v = Matrix3Math.prodRow(operator, vRow);
        vRow.setX(v.x());
        vRow.setY(v.y());
        vRow.setZ(v.z());

        return vRow;
    }

    /**
     * Returns the result of transforming the given vector-row by the given
     * transformation operator matrix.
     *
     * @param vRow     vector-column to be transformed
     * @param operator transformation matrix
     * @return new vector with result of transforming vector {@code vRow} by matrix
     *         {@code operator}
     *
     * @since 3.0.0
     */
    public static Vector3 transformedRow(final Vector3 vRow, final Matrix3 operator) {
        return Matrix3Math.prodRow(operator, vRow);
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
    public static boolean equalsEpsilon(final Vector3 v1, final Vector3 v2, final float eps) {
        return Validator.equalsEpsilon(v1.x(), v2.x(), eps)
                && Validator.equalsEpsilon(v1.y(), v2.y(), eps)
                && Validator.equalsEpsilon(v1.z(), v2.z(), eps);
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
    public static boolean equals(final Vector3 v1, final Vector3 v2) {
        return equalsEpsilon(v1, v2, Validator.EPS);
    }

    /**
     * Constructs 4-dimensional vector with components of the given vector and 1 as
     * last
     * component
     * <p>
     * (x, y, z, 1)
     *
     * @param v 3-dimensional vector
     * @return new 4-dimensional vector including components of the given vector and
     *         1
     *         last component
     *
     * @since 1.0.0
     */
    public static Vector4 toVector4(final Vector3 v) {
        return new Vec4(v.x(), v.y(), v.z(), 1);
    }

    /**
     * Constructs 3-dimensional vector with all 0 components.
     * 
     * @return new zero 4-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector3 zeroVector() {
        return new Vec3();
    }

    /**
     * Constructs 3-dimensional vector with all 1 components.
     * 
     * @return new unit 3-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector3 unitVector() {
        return new Vec3(1, 1, 1);
    }
}
