package io.github.alphameo.linear_algebra.mat;

/**
 * Interface for matrix 3x3.
 *
 * @since 1.0.0
 */
public interface Matrix3 extends Matrix {

    /**
     * Safely returns element at given row and column inside matrix 3x3.
     * 
     * @param r row of element
     * @param c column of element
     * @return element at given position
     *
     * @since 1.0.0
     */
    float get(Matrix3Row r, Matrix3Col c);

    /**
     * Safely sets value into given row index and column index inside matrix.
     *
     * @param r     row for putting value
     * @param c     column for putting value
     * @param value component value to be put
     *
     * @since 1.0.0
     */
    void set(Matrix3Row r, Matrix3Col c, float value);

    /**
     * Creates and returns a copy of current matrix 3x3.
     * 
     * @return copy of matrix 3x3
     */
    Matrix3 clone();
}
