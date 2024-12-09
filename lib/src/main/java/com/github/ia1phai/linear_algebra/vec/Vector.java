package com.github.ia1phai.linear_algebra.vec;

/**
 * Interface for arbitrary vector.
 */
public interface Vector {

    /**
     * Returns component at given position inside vector.
     * 
     * @param i position index of component
     * @return component at given position
     * @throws Exception if {@code index} out of bounds
     */
    public float get(int i);

    /**
     * Sets value into given position inside vector.
     *
     * @param i     position index for putting value
     * @param value component value to be put
     * @throws Exception if {@code index} out of bounds
     */
    public void set(int i, final float value);

    /**
     * Returns size (components count) of vector.
     * 
     * @return size of vector
     */
    public int size();
}
