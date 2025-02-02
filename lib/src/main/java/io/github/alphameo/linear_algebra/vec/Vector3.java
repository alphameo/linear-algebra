package io.github.alphameo.linear_algebra.vec;

import io.github.alphameo.linear_algebra.mat.Matrix3;

/**
 * Interface for 3-dimensional vector.
 *
 * @since 1.0.0
 */
public interface Vector3
        extends Vector, FixedVectorOperatable<Vector3>, FixedVectorTransformable<Vector3, Matrix3> {

    /**
     * Returns x component (index = 0) of 3-dimensional vector.
     * 
     * @return x component of vector
     *
     * @since 1.0.0
     */
    float x();

    /**
     * Returns y component (index = 1) of 3-dimensional vector.
     * 
     * @return y component of vector
     *
     * @since 1.0.0
     */
    float y();

    /**
     * Returns z component (index = 1) of 3-dimensional vector.
     * 
     * @return z component of vector
     *
     * @since 1.0.0
     */
    float z();

    /**
     * Sets value of x component (index = 0) inside 3-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setX(float value);

    /**
     * Sets value of y component (index = 1) inside 3-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setY(float value);

    /**
     * Sets value of z component (index = 2) inside 3-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setZ(float value);

    /**
     * @since 1.0.0
     */
    @Override
    Vector3 clone();

    /**
     * @since 1.0.0
     */
    @Override
    default float len2() {
        return Vector3Math.len2(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float len() {
        return Vector3Math.len(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector3 mulAsgn(float multiplier) {
        return Vector3Math.mulAsgn(this, multiplier);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector3 mul(float multiplier) {
        return Vector3Math.mul(this, multiplier);
    }

    /**
     * @throws ArithmeticException if length of the given vector is approximately
     *
     * @since 1.0.0
     */
    @Override
    default Vector3 divAsgn(float divisor) throws ArithmeticException {
        return Vector3Math.divAsgn(this, divisor);
    }

    /**
     * @throws ArithmeticException if length of the given vector is approximately
     *
     * @since 1.0.0
     */
    @Override
    default Vector3 div(float divisor) throws ArithmeticException {
        return Vector3Math.div(this, divisor);
    }

    /**
     * @throws ArithmeticException if length of the given vector is approximately
     *
     * @since 1.0.0
     */
    @Override
    default Vector3 normalize() throws ArithmeticException {
        return Vector3Math.normalize(this);
    }

    /**
     * @throws ArithmeticException if length of the given vector is approximately
     *
     * @since 1.0.0
     */
    @Override
    default Vector3 normalized() throws ArithmeticException {
        return Vector3Math.normalized(this);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector3 addAsgn(final Vector3 addendum) {
        return Vector3Math.addAsgn(this, addendum);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector3 add(final Vector3 addendum) {
        return Vector3Math.add(this, addendum);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector3 subAsgn(final Vector3 subtrahend) {
        return Vector3Math.subAsgn(this, subtrahend);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default Vector3 sub(final Vector3 subtrahend) {
        return Vector3Math.sub(this, subtrahend);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default float dot(final Vector3 v) {
        return Vector3Math.dot(this, v);
    }

    /**
     * @since 1.0.0
     */
    @Override
    default boolean equalsEpsilon(final Vector3 other, final float eps) {
        return Vector3Math.equalsEpsilon(this, other, eps);
    }

    /**
     * Returns {@code true} if components of current and the given vectors are
     * approximately equal.
     * 
     * @param v vector for comparison
     * @return {@code true} if all components of current and the given vectors are
     *         approximately equal, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equals(final Vector3 v) {
        return Vector3Math.equals(this, v);
    }

    /**
     * Calculates cross product (vector product) of vectors.
     *
     * @param v second vector
     * @return vector, which represents cross (vector) product of vectors
     *
     * @since 1.0.0
     */
    default Vector3 cross(final Vector3 v) {
        final Vector3 result = new Vec3();
        Vector3Math.cross(this, v);

        return result;
    }

    /**
     * @since 3.0.0
     */
    @Override
    default Vector3 prod(Matrix3 m) {
        return Vector3Math.prod(this, m);
    }

    /**
     * @since 3.0.0
     */
    @Override
    default Vector3 transformCol(Matrix3 operator) {
        return Vector3Math.transformCol(this, operator);
    }

    /**
     * @since 3.0.0
     */
    @Override
    default Vector3 transformRow(Matrix3 operator) {
        return Vector3Math.transformRow(this, operator);
    }

    /**
     * @since 3.0.0
     */
    @Override
    default Vector3 transformedCol(Matrix3 operator) {
        return Vector3Math.transformedCol(this, operator);
    }

    /**
     * @since 3.0.0
     */
    @Override
    default Vector3 transformedRow(Matrix3 operator) {
        return Vector3Math.transformedRow(this, operator);
    }

    /**
     * Constructs 4-dimensional vector with components of the the given vector and 1
     * as last
     * component
     * <p>
     * (x, y, z, 1)
     *
     * @return new 4-dimensional vector including components of the the given vector
     *         and 1
     *
     * @since 1.0.0
     */
    default Vector4 toVector4() {
        return Vector3Math.toVector4(this);
    }
}
