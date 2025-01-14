package io.github.alphameo.linear_algebra.vec;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.mat.Matrix;
import io.github.alphameo.linear_algebra.mat.MatrixMath;

/**
 * Class with static functions for arbitrary-dimensional vectors.
 *
 * @since 1.0.0
 */
public final class VectorMath {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public VectorMath() {
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
    public static float len2(final Vector v) {
        float sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.get(i) * v.get(i);
        }

        return sum;
    }

    /**
     * Returns length of the the given vector.
     * 
     * @param v vector for length calculation
     * @return length of vector {@code v}
     *
     * @since 1.0.0
     */
    public static float len(final Vector v) {
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
    public static Vector mulAsgn(final Vector v, final float multiplier) {
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) * multiplier);
        }

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
    public static Vector mul(final Vector v, final float multiplier) {
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
    public static Vector divAsgn(final Vector v, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) / divisor);
        }

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
    public static Vector div(final Vector v, final float divisor) throws ArithmeticException {
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
    public static Vector normalize(final Vector v) throws ArithmeticException {
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
    public static Vector normalized(final Vector v) throws ArithmeticException {
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
    public static Vector addAsgn(final Vector target, final Vector addendum) throws IllegalArgumentException {
        Validator.validateVectorSizes(target, addendum, "Addition denied");
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) + addendum.get(i));
        }

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
    public static Vector add(final Vector target, final Vector addendum) throws IllegalArgumentException {
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
    public static Vector subAsgn(final Vector target, final Vector subtrahend) {
        Validator.validateVectorSizes(target, subtrahend, "Subtraction denied");
        for (int i = 0; i < target.size(); i++) {
            target.set(i, target.get(i) - subtrahend.get(i));
        }

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
    public static Vector sub(final Vector target, final Vector subtrahend) {
        return subAsgn(target.clone(), subtrahend);
    }

    /**
     * Returns the result of dot product (scalar product) of the given vectors.
     *
     * @param v1 first vector for dot product
     * @param v2 second vector for dot product
     * @return dot product of vector {@code v1} and vector {@code v2}
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    public static float dot(final Vector v1, final Vector v2) throws IllegalArgumentException {
        Validator.validateVectorSizes(v1, v2, "Scalar product denied");
        float sum = 0;
        for (int i = 0; i < v1.size(); i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }

    /**
     * Returns the result of cross product (vector product) of the given vectors.
     *
     * @param v1 first vector for cross product
     * @param v2 second vector for cross product
     * @return new vector, which represents cross product of vector {@code v1} and
     *         vector {@code v2}
     * @throws IllegalArgumentException if vectors' sizes are not equal 3
     *
     * @since 1.0.0
     */
    public static Vector cross(final Vector v1, final Vector v2) throws IllegalArgumentException {
        if (v1.size() != 3 || v2.size() != 3) {
            throw new IllegalArgumentException(
                    String.format(String.format("Cross product denied: vector size must be 3, but given are %d, %d"),
                            v1.size(), v2.size()));
        }
        final Vector result = new Vec(3);
        result.set(0, v1.get(1) * v2.get(2) - v1.get(2) * v2.get(1));
        result.set(1, v1.get(2) * v2.get(0) - v1.get(0) * v2.get(2));
        result.set(2, v1.get(0) * v2.get(1) - v1.get(1) * v2.get(0));

        return result;
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
    public static Vector transformCol(final Vector vCol, final Matrix operator) throws IllegalArgumentException {
        return MatrixMath.prodColIncr(operator, vCol);
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
    public static Vector transformedCol(final Vector vCol, final Matrix operator) throws IllegalArgumentException {
        return MatrixMath.prodCol(operator, vCol);
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
    public static Vector transformRow(final Vector vRow, final Matrix operator) throws IllegalArgumentException {
        return MatrixMath.prodRowIncr(operator, vRow);
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
    public static Vector transformedRow(final Vector vRow, final Matrix operator) throws IllegalArgumentException {
        return MatrixMath.prodRow(operator, vRow);
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
    public static boolean equalsEpsilon(final Vector v1, final Vector v2, final float eps)
            throws IllegalArgumentException {
        Validator.validateVectorSizes(v1, v2, "Equalization denied");
        for (int i = 0; i < v1.size(); i++) {
            if (!Validator.equalsEpsilon(v1.get(i), v2.get(i), eps)) {
                return false;
            }
        }

        return true;
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
    public static boolean equals(final Vector v1, final Vector v2) throws IllegalArgumentException {
        return equalsEpsilon(v1, v2, Validator.EPS);
    }

    /**
     * Constructs {@code size}-dimensional vector with all 0 components.
     * 
     * @param size dimension of vector to be constructed
     * @return new zero {@code size}-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector zeroVector(final int size) {
        return new Vec(size);
    }

    /**
     * Constructs {@code size}-dimensional vector with all 1 components.
     * 
     * @param size dimension of vector to be constructed
     * @return new unit {@code size}-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector unitVector(final int size) {
        final Vector result = new Vec(size);
        for (int i = 0; i < size; i++) {
            result.set(i, 1);
        }

        return result;
    }
}
