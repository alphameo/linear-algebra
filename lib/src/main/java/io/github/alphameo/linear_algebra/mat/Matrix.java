package io.github.alphameo.linear_algebra.mat;

/**
 * Interface for arbitrary matrix.
 *
 * @since 1.0.0
 */
public interface Matrix extends Cloneable {

    /**
     * Returns element at given row index and column index inside matrix.
     * 
     * @param r row index of element
     * @param c column index of element
     * @return element at given position
     *
     * @since 1.0.0
     */
    float get(int r, int c);

    /**
     * Sets value into given row index and column index inside matrix.
     *
     * @param r     row index for putting value
     * @param c     column index for putting value
     * @param value component value to be put
     *
     * @since 1.0.0
     */
    void set(int r, int c, float value);

    /**
     * Returns width (column count) of matrix.
     * 
     * @return width of matrix
     *
     * @since 1.0.0
     */
    int width();

    /**
     * Returns height (row count) of matrix.
     * 
     * @return height of matrix
     *
     * @since 1.0.0
     */
    int height();

    /**
     * Creates and returns a copy of current matrix.
     * 
     * @return copy of matrix
     */
    Matrix clone();
}
