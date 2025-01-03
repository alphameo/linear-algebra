package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for vector of size 2.
 *
 * @since 1.0.0
 */
public interface Vector2 extends Vector {

    /**
     * Returns x component (index = 0) of vector with size 2.
     * 
     * @return x component of vector with size 2
     *
     * @since 1.0.0
     */
    float x();

    /**
     * Returns x component (index = 1) of vector with size 2.
     * 
     * @return x component of vector with size 2
     *
     * @since 1.0.0
     */
    float y();

    /**
     * Sets value of x component (index = 0) inside vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setX(float value);

    /**
     * Sets value of x component (index = 1) inside vector.
     *
     * @param value component value to be set
     *
     * @since 1.0.0
     */
    void setY(float value);

    /**
     * Creates and returns a copy of current vector of size 2.
     * 
     * @return copy of vector of size 2
     */
    Vector2 clone();
}
