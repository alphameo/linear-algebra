package io.github.alphameo.linear_algebra.vec;

import io.github.alphameo.linear_algebra.mat.Matrix;

/**
 * Interface for Arbitrary-dimensional vector.
 *
 * @since 1.0.0
 */
public interface Vector extends Cloneable {

    /**
     * Returns component at given position inside vector.
     * 
     * @param i position index of component
     * @return component at given position
     *
     * @since 1.0.0
     */
    float get(int i);

    /**
     * Sets value into given position inside vector.
     *
     * @param i     position index for putting value
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void set(int i, final float value);

    /**
     * Returns size (or dimension or components count) of vector.
     * 
     * @return size | dimension | components count of vector
     *
     * @since 1.0.0
     */
    int size();

    /**
     * Creates and returns a copy of {@code this} vector.
     * 
     * @return copy of vector
     */
    Vector clone();

    /**
     * Returns the square of the length of this vector.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @return squared length of vector {@code this}
     *
     * @since 1.0.0
     */
    default float len2() {
        return VectorMath.len2(this);
    }

    /**
     * Calculates length (or norm) of vector.
     * 
     * @return length | norm of vector
     *
     * @since 1.0.0
     */
    default float len() {
        return VectorMath.len(this);
    }

    /**
     * Multiplies components of this vector by a scalar value and returns it.
     *
     * @param multiplier scalar value
     * @return vector {@code this} multiplied by {@code multiplier}
     *
     * @since 1.0.0
     */
    default Vector mulAsgn(final float multiplier) {
        return VectorMath.mulAsgn(this, multiplier);
    }

    /**
     * Returns the result of multiplying the components of this vector by a
     * scalar value.
     *
     * @param multiplier scalar value
     * @return new vector with components of vector {@code v} multiplied by
     *         {@code multiplier}
     *
     * @since 1.0.0
     */
    default Vector mul(final float multiplier) {
        return VectorMath.mul(this, multiplier);
    }

    /**
     * Divides components of this vector by a scalar value and returns it.
     * 
     * @param divisor scalar value
     * @return vector {@code this} divided by {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    default Vector divAsgn(final float divisor) throws ArithmeticException {
        return VectorMath.divAsgn(this, divisor);
    }

    /**
     * Returns the result of dividing the components of this vector by a scalar
     * value.
     *
     * @param divisor scalar value
     * @return new vector with components of vector {@code v} divided by
     *         {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    default Vector div(final float divisor) throws ArithmeticException {
        return VectorMath.div(this, divisor);
    }

    /**
     * Normalize components of this vector (divide each component by vector length)
     * and returns it.
     * 
     * @return vector {@code this} with normalized components
     * @throws ArithmeticException if length of this vector is approximately
     *                             equal 0
     *
     * @since 1.0.0
     */
    default Vector normalize() throws ArithmeticException {
        return VectorMath.normalize(this);
    }

    /**
     * Returns the result of normalization of this vector (divide each
     * component by vector length)
     * 
     * @return new vector with normalized components of this vector
     * @throws ArithmeticException if length of this vector is approximately
     *                             equal 0
     *
     * @since 1.0.0
     */
    default Vector normalized() throws ArithmeticException {
        return VectorMath.normalized(new Vec(this));
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
    default Vector addAsgn(final Vector addendum) {
        return VectorMath.addAsgn(this, addendum);
    }

    /**
     * Copies {@code this} vector and adds the {@code addendum} vector components to
     * its components.
     *
     * @param addendum vector to add
     * @return new vector with sum of components of {@code this} vector and
     *         {@code addendum} vector
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default Vector add(final Vector addendum) {
        return VectorMath.add(this, addendum);
    }

    /**
     * Subtracts components of the subtrahend vector from the components of the
     * target vector and returns it.
     * 
     * @param subtrahend vector to subtract
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default Vector subAsgn(final Vector subtrahend) throws IllegalArgumentException {
        return VectorMath.subAsgn(this, subtrahend);
    }

    /**
     * Returns the result of subtracting the components of the subtrahend vector
     * from the components of this vector.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with result of subtracting vector {@code subtrahend} from
     *         vector {@code target}
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default Vector sub(final Vector subtrahend) throws IllegalArgumentException {
        return VectorMath.sub(this, subtrahend);
    }

    /**
     * Returns dot product (scalar product) of this and given vectors.
     *
     * @param v vector for dot product
     * @return dot product of vector {@code this} and vector {@code v}
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default float dot(final Vector v) throws IllegalArgumentException {
        return VectorMath.dot(this, v);
    }

    /**
     * Returns result of cross product (vector product) of this and given vectors.
     *
     * @param v second vector for cross product
     * @return new vector, which represents cross product of vector {@code this} and
     *         vector {@code v}
     * @throws IllegalArgumentException if vectors' sizes are not equal 3
     *
     * @since 1.0.0
     */
    default Vector cross(final Vector v) throws IllegalArgumentException {
        return VectorMath.cross(this, v);
    }

    /**
     * Transforms this vector-column by the given transformation operator
     * matrix and returns it.
     *
     * @param operator transformation matrix
     * @return vector {@code this} transformed by matrix {@code operator}
     * @throws IllegalArgumentException if width of the given matrix is not equal
     *                                  to dimension of this vector-column
     *
     * @since 3.0.0
     */
    default Vector transformCol(final Matrix operator) throws IllegalArgumentException {
        return VectorMath.transformColumn(this, operator);
    }

    /**
     * Returns the result of transforming this vector-column by the given
     * transformation operator matrix.
     *
     * @param operator transformation matrix
     * @return new vector with result of transforming vector {@code this} by matrix
     *         {@code operator}
     * @throws IllegalArgumentException if width of the given matrix is not equal
     *                                  to dimension of this vector-column
     *
     * @since 3.0.0
     */
    default Vector transformedCol(final Matrix operator) throws IllegalArgumentException {
        return VectorMath.transformedColumn(this, operator);
    }

    /**
     * Transforms this vector-row by the given transformation operator
     * matrix and returns it.
     *
     * @param operator transformation matrix
     * @return vector {@code this} transformed by matrix {@code operator}
     * @throws IllegalArgumentException if height of the given matrix is not equal
     *                                  to the dimension of this vector-row
     *
     * @since 3.0.0
     */
    default Vector transformRow(final Matrix operator) throws IllegalArgumentException {
        return VectorMath.transformRow(this, operator);
    }

    /**
     * Returns the result of transforming this vector-row by the given
     * transformation operator matrix.
     *
     * @param operator transformation matrix
     * @return new vector with result of transforming vector {@code this} by matrix
     *         {@code operator}
     * @throws IllegalArgumentException if height of the given matrix is not equal
     *                                  to dimension of this vector-row
     *
     * @since 3.0.0
     */
    default Vector transformedRow(final Matrix operator) throws IllegalArgumentException {
        return VectorMath.transformedRow(this, operator);
    }

    /**
     * Returns {@code true} if the components of this vector and the components of
     * the given vector are equal within {@code epsilon} tolerance.
     * 
     * @param v   vector for comparison
     * @param eps tolerance
     * @return {@code true} if all components of vector {@code this} and vector
     *         {@code v} are equal within {@code eps} tolerance, and {@code false}
     *         otherwise
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default boolean equalsEpsilon(final Vector v, final float eps) throws IllegalArgumentException {
        return VectorMath.equalsEpsilon(this, v, eps);
    }

    /**
     * Returns {@code true} if the components of this vector and the components the
     * diven vector are approximately equal.
     * 
     * @param v vector for comparison
     * @return {@code true} if all components of vector {@code this} and vector
     *         {@code v} are approximately equal, and {@code false} otherwise
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default boolean equals(final Vector v) {
        return VectorMath.equals(this, v);
    }
}
