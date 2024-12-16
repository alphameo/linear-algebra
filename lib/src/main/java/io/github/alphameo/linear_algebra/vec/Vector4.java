package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for vector of size 4.
 *
 * @since 1.0.0
 */
public interface Vector4 extends Vector {

    /**
     * Returns x component (index = 0).
     * 
     * @return x component of vector
     *
     * @since 1.0.0
     */
    float x();

    /**
     * Returns y component (index = 1).
     * 
     * @return y component of vector
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
     * Returns w component (index = 3).
     * 
     * @return w component of vector
     *
     * @since 1.0.0
     */
    float w();

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
     * Sets value of w component (index = 3) inside vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setW(float value);
}
