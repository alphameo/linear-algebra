package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for vector of size 4.
 */
public interface Vector4 extends Vector {

    /**
     * Returns x component (index = 0).
     * 
     * @return x component of vector
     */
    float x();

    /**
     * Returns y component (index = 1).
     * 
     * @return y component of vector
     */
    float y();

    /**
     * Returns z component (index = 2).
     * 
     * @return z component of vector
     */
    float z();

    /**
     * Returns w component (index = 3).
     * 
     * @return w component of vector
     */
    float w();

    /**
     * Sets value of x component (index = 0) inside vector.
     *
     * @param value component value to be set
     */
    void setX(float value);

    /**
     * Sets value of y component (index = 1) inside vector.
     *
     * @param value component value to be set
     */
    void setY(float value);

    /**
     * Sets value of z component (index = 2) inside vector.
     *
     * @param value component value to be set
     */
    void setZ(float value);

    /**
     * Sets value of w component (index = 3) inside vector.
     *
     * @param value component value to be set
     */
    void setW(float value);
}
