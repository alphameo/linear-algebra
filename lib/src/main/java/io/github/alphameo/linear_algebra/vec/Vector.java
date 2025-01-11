package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for N-dimensional vector.
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
     * @param value component value to be put
     *
     * @since 1.0.0
     */
    void set(int i, final float value);

    /**
     * Returns size (components count) of vector.
     * 
     * @return size of vector
     *
     * @since 1.0.0
     */
    int size();

    /**
     * Creates and returns a copy of current vector.
     * 
     * @return copy of vector
     */
    Vector clone();

    /**
     * Calculates square of vector length.
     * <p>
     * You can use it if you need fast comparison.
     * 
     * @return square length of vector
     *
     * @since 1.0.0
     */
    default float len2() {
        return VecMath.len2(this);
    }

    /**
     * Calculates length of vector.
     * 
     * @return length of vector
     *
     * @since 1.0.0
     */
    default float len() {
        return VecMath.len(this);
    }

    /**
     * Multiplies the components of vector by a scalar value.
     *
     * @param multiplier scalar value
     * @return current vector with multiplied components
     *
     * @since 1.0.0
     */
    default Vector mult(final float multiplier) {
        return VecMath.mult(this, multiplier);
    }

    /**
     * Copies vector and multiplies its components by a scalar.
     * value.
     *
     * @param multiplier scalar value
     * @return new vector with multiplied components of current vector
     *
     * @since 1.0.0
     */
    default Vector multiplied(final float multiplier) {
        return VecMath.multiplied(this, multiplier);
    }

    /**
     * Divides the components of vector by a scalar value.
     * 
     * @param divisor scalar value
     * @return current vector with divided components
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     *
     * @since 1.0.0
     */
    default Vector divide(final float divisor) throws ArithmeticException {
        return VecMath.divide(this, divisor);
    }

    /**
     * Copies vector and divides its components by a scalar value.
     *
     * @param divisor scalar value
     * @return new vector with divided components of current vector
     * @throws ArithmeticException if {@code divisor} approximately equal to 0
     *
     * @since 1.0.0
     */
    default Vector divided(final float divisor) throws ArithmeticException {
        return VecMath.divided(this, divisor);
    }

    /**
     * Normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components
     * @throws ArithmeticException if length of vector equals 0
     *
     * @since 1.0.0
     */
    default Vector normalize() throws ArithmeticException {
        return VecMath.normalize(this);
    }

    /**
     * Copies and normalizes vector (divide each component by vector length)
     * 
     * @return current vector with normalized components of given vector
     * @throws ArithmeticException if length of vector equals 0
     *
     * @since 1.0.0
     */
    default Vector normalized() throws ArithmeticException {
        return VecMath.normalized(new Vec(this));
    }

    /**
     * Adds the {@code addendum} vector components to the current vector components.
     *
     * @param addendum vector to add
     * @return current vector increased by {@code addendum} vector
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default Vector add(final Vector addendum) {
        return VecMath.add(this, addendum);
    }

    /**
     * Copies current vector and adds the {@code addendum} vector components to its
     * components.
     *
     * @param addendum vector to add
     * @return new vector with sum of components of current vector and
     *         {@code addendum} vector
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default Vector added(final Vector addendum) {
        return VecMath.added(this, addendum);
    }

    /**
     * Subtracts the {@code subtrahend} vector components from the current vector
     * components.
     * 
     * @param subtrahend vector to subtract
     * @return current vector subtracted by {@code subtrahend} vector
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default Vector sub(final Vector subtrahend) {
        return VecMath.sub(this, subtrahend);
    }

    /**
     * Copies current vector and subtracts the {@code subtrahend} vector components
     * from its components.
     * 
     * @param subtrahend vector to subtract
     * @return new vector with components resulting current vector subtracted
     *         by {@code subtrahend} vector
     * @throws IllegalArgumentException if vectors have different sizes
     *
     * @since 1.0.0
     */
    default Vector subtracted(final Vector subtrahend) {
        return VecMath.subtracted(this, subtrahend);
    }

    /**
     * Calculates dot product (scalar product) of vectors.
     *
     * @param v second vector
     * @return dot (scalar) product of vectors
     *
     * @since 1.0.0
     */
    default float dot(final Vector v) {
        return VecMath.dot(this, v);
    }

    /**
     * Calculates cross product (vector product) of vectors.
     *
     * @param v second vector
     * @return vector, which represents cross (vector) product of vectors
     * @throws IllegalArgumentException if vectors' sizes are not equal 3
     *
     * @since 1.0.0
     */
    default Vector cross(final Vector v) {
        return VecMath.cross(this, v);
    }

    /**
     * Returns {@code true} if components of current and given vectors are equal
     * within {@code epsilon} tolerance.
     * 
     * @param v   vector for comparison
     * @param eps tolerance
     * @return {@code true} if all components of current and given vectors are equal
     *         within {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equalsEpsilonTo(final Vector v, final float eps) {
        return VecMath.equalsEpsilon(this, v, eps);
    }

    /**
     * Returns {@code true} if components of current and given vectors are
     * approximately equal.
     * 
     * @param v vector for comparison
     * @return {@code true} if all components of current and given vectors are
     *         approximately equal, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    default boolean equalsTo(final Vector v) {
        return VecMath.equals(this, v);
    }

    /**
     * Constructs new vector of given {@code size} with all 0 components.
     * 
     * @param size size of vector to be constructed
     * @return new zero vector of given {@code size}
     *
     * @since 1.0.0
     */
    static Vector zeroVec(final int size) {
        return VecMath.zeroVec(size);
    }

    /**
     * Constructs new vector of given {@code size} with 1 as components.
     * 
     * @param size size of vector to be constructed
     * @return new unit vector of given {@code size}
     *
     * @since 1.0.0
     */
    static Vector unitVec(final int size) {
        return VecMath.unitVec(size);
    }
}
