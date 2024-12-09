package com.github.ia1phai.linear_algebra.vec;

/**
 * Interface for vector of size 2.
 */
public interface Vector2 extends Vector {

    /**
     * Returns x component (index = 0) of vector with size 2.
     * 
     * @return x component of vector with size 2
     */
    float x();

    /**
     * Returns x component (index = 1) of vector with size 2.
     * 
     * @return x component of vector with size 2
     */
    float y();

    /**
     * Sets value of x component (index = 0) inside vector.
     *
     * @param value component value to be set
     */
    void setX(float value);

    /**
     * Sets value of x component (index = 1) inside vector.
     *
     * @param value component value to be set
     */
    void setY(float value);
}
