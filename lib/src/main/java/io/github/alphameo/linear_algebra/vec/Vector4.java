package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for 4-dimensional vector.
 *
 * @since 1.0.0
 */
public interface Vector4 extends Vector {

    /**
     * Returns x component (index = 0) of 4-dimensional vector.
     * 
     * @return x component of vector
     *
     * @since 1.0.0
     */
    float x();

    /**
     * Returns y component (index = 1) of 4-dimensional vector.
     * 
     * @return y component of vector
     *
     * @since 1.0.0
     */
    float y();

    /**
     * Returns z component (index = 1) of 4-dimensional vector.
     * 
     * @return z component of vector
     *
     * @since 1.0.0
     */
    float z();

    /**
     * Returns w component (index = 1) of 4-dimensional vector.
     * 
     * @return w component of vector
     *
     * @since 1.0.0
     */
    float w();

    /**
     * Sets value of x component (index = 0) inside 4-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setX(float value);

    /**
     * Sets value of y component (index = 1) inside 4-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setY(float value);

    /**
     * Sets value of z component (index = 2) inside 4-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setZ(float value);

    /**
     * Sets value of z component (index = 2) inside 4-dimensional vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setW(float value);

    /**
     * Creates and returns a copy of current 3-dimensional vector.
     * 
     * @return copy of 4-dimensional vector
     */
    Vector4 clone();
}
