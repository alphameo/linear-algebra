package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for vector of size 3.
 *
 * @since 1.0.0
 */
public interface Vector3 extends Vector {

    /**
     * Returns x component (index = 0).
     * 
     * @return x component of vector
     *
     * @since 1.0.0
     */
    float x();

    /**
     * Returns x component (index = 1).
     * 
     * @return x component of vector
     *
     * @since 1.0.0
     */
    float y();

    /**
     * Returns z component (index = 2).
     * 
     * @return z component of vector
     *
     * @since 1.0.0
     */
    float z();

    /**
     * Sets value of x component (index = 0) inside vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setX(float value);

    /**
     * Sets value of y component (index = 1) inside vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setY(float value);

    /**
     * Sets value of z component (index = 2) inside vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setZ(float value);

    /**
     * Creates and returns a copy of current vector of size 3.
     * 
     * @return copy of vector of size 3
     */
    Vector3 clone();
}
