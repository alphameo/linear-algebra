package io.github.alphameo.linear_algebra.vec;

/**
 * Interface for arbitrary vector.
 *
 * @since 1.0.0
 */
public interface Vector {

    /**
     * Returns component at given position inside vector.
     * 
     * @param i position index of component
     * @return component at given position
     *
     * @since 1.0.0
     */
    public float get(int i);

    /**
     * Sets value into given position inside vector.
     *
     * @param i     position index for putting value
     * @param value component value to be put
     *
     * @since 1.0.0
     */
    public void set(int i, final float value);

    /**
     * Returns size (components count) of vector.
     * 
     * @return size of vector
     *
     * @since 1.0.0
     */
    public int size();
}
