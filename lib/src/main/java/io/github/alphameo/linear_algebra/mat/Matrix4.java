package io.github.alphameo.linear_algebra.mat;

/**
 * Interface for matrix 4x4.
 */
public interface Matrix4 extends Matrix {

    /**
     * Safely returns element at given row and column inside vector.
     * 
     * @param r row of element
     * @param c column of element
     * @return element at given position
     */
    float get(Matrix4Row r, Matrix4Col c);

    /**
     * Safely sets value into given row index and column index inside matrix.
     *
     * @param r     row for putting value
     * @param c     column for putting value
     * @param value component value to be put
     */
    void set(Matrix4Row r, Matrix4Col c, float value);
}
