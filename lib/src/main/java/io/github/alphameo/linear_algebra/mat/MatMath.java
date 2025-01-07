package io.github.alphameo.linear_algebra.mat;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.vec.Vec;
import io.github.alphameo.linear_algebra.vec.Vector;

/**
 * Class with static functions for arbitrary matrices.
 *
 * @since 1.0.0
 */
public final class MatMath {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public MatMath() {
    }

    /**
     * Transposes given square matrix
     *
     * @param m square matrix for transpose
     * @return given square matrix, which is transposed
     *
     * @since 1.0.0
     */
    public static Matrix transposeSquare(final Matrix m) {
        if (!square(m)) {
            throw new IllegalArgumentException("Inapplicable method ::transposeSquare for non-square matrix");
        }

        float tmp;
        for (int i = 0; i < m.width(); i++) {
            for (int j = i + 1; j < m.width(); j++) {
                tmp = m.get(i, j);
                m.set(i, j, m.get(j, i));
                m.set(j, i, tmp);
            }
        }

        return m;
    }

    /**
     * Constructs transposed matrix from given matrix
     *
     * @param m square matrix for transpose
     * @return new matrix, which is result of transposing of given square matrix
     *
     * @since 1.0.0
     */
    public static Matrix transposed(final Matrix m) {
        Matrix result = new Mat(m.width(), m.height());
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                result.set(c, r, m.get(r, c));
            }
        }

        return result;
    }

    /**
     * Swaps rows of matrix
     *
     * @param m  matrix for row swapping
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return given matrix with swapped rows
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix swapRows(final Matrix m, final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        float tmp;
        for (int c = 0; c < m.width(); c++) {
            tmp = m.get(r1, c);
            m.set(r1, c, m.get(r2, c));
            m.set(r2, c, tmp);
        }

        return m;
    }

    /**
     * Copies given matrix and swaps its rows.
     * 
     * @param m  matrix for row swapping
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return new matrix with swapped rows of given matrix
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix swappedRows(final Matrix m, final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return swapRows(m.clone(), r1, r2);
    }

    /**
     * Swaps columns of matrix.
     *
     * @param m  matrix for row swapping
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return given matrix with swapped columns
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix swapCols(final Matrix m, final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        float tmp;
        for (int r = 0; r < m.height(); r++) {
            tmp = m.get(r, c1);
            m.set(r, c1, m.get(r, c2));
            m.set(r, c2, tmp);
        }

        return m;
    }

    /**
     * Copies given matrix and swaps its columns.
     *
     * @param m  matrix for column swapping
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return new matrix with swapped columns of given matrix
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix swappedCols(final Matrix m, final int c1, final int c2) throws ArrayIndexOutOfBoundsException {
        return swapCols(m.clone(), c1, c2);
    }

    /**
     * Multiplies matrix elements by a scalar value.
     * 
     * @param m          matrix for multiplication
     * @param multiplier scalar value
     * @return given matrix with multiplied elements
     *
     * @since 1.0.0
     */
    public static Matrix mult(final Matrix m, final float multiplier) {
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                m.set(r, c, m.get(r, c) * multiplier);
            }
        }

        return m;
    }

    /**
     * Copies given matrix and multiplies its components by a scalar value.
     * 
     * @param m          matrix for multiplication
     * @param multiplier scalar value
     * @return new matrix with multiplied elements of given matrix
     *
     * @since 1.0.0
     */
    public static Matrix multiplied(final Matrix m, final float multiplier) {
        return mult(m.clone(), multiplier);
    }

    /**
     * Divides matrix elements by a scalar value.
     * 
     * @param m       matrix for division
     * @param divisor scalar value
     * @return given matrix with divided elements
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    public static Matrix divide(final Matrix m, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                m.set(r, c, m.get(r, c) / divisor);
            }
        }

        return m;
    }

    /**
     * Copies given matrix and divides its components by a scalar value.
     *
     * @param m       matrix for division
     * @param divisor scalar value
     * @return new matrix with divided elements of given matrix
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    public static Matrix divided(final Matrix m, final float divisor) throws ArithmeticException {
        return mult(m.clone(), divisor);
    }

    /**
     * Adds the {@code addendum} matrix elements to the {@code target} matrix
     * elements.
     * 
     * @param target   matrix to be added
     * @param addendum matrix to add
     * @return {@code target} matrix increased by {@code addendum} matrix
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static Matrix add(final Matrix target, final Matrix addendum) {
        Validator.validateMatrixSizes(target, addendum, "Addition denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < addendum.width(); c++) {
                target.set(r, c, target.get(r, c) + addendum.get(r, c));
            }
        }

        return target;
    }

    /**
     * Copies {@code target} matrix and adds the {@code addendum} matrix elements to
     * its elements.
     * 
     * @param target   matrix to be added
     * @param addendum matrix to add
     * @return new matrix with sum of elements of {@code target} matrix and
     *         {@code addendum} matrix
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static Matrix added(final Matrix target, final Matrix addendum) {
        return add(target.clone(), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} matrix elements from the {@code target}
     * matrix elements.
     * 
     * @param target     matrix to be subtracted
     * @param subtrahend matrix to subtract
     * @return {@code target} matrix subtracted by {@code addendum} matrix
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static Matrix sub(final Matrix target, final Matrix subtrahend) {
        Validator.validateMatrixSizes(target, subtrahend, "Subtraction denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < subtrahend.width(); c++) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
            }
        }

        return target;
    }

    /**
     * Copies {@code target} matrix and subtracts the {@code subtrahend} matrix
     * elements from its elements.
     * 
     * @param target     matrix to be subtracted
     * @param subtrahend matrix to subtract
     * @return new matrix with components resulting current matrix subtracted
     *         by {@code subtrahend} matrix
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static Matrix subtracted(final Matrix target, final Matrix subtrahend) {
        return sub(target.clone(), subtrahend);
    }

    /**
     * Calculates product of matrices.
     *
     * @param m1 first (left) matrix
     * @param m2 second (right) matrix
     * @return matrix, which represents product of given matrices
     * @throws IllegalArgumentException if the first matrix width is not equal to
     *                                  the second matrix height
     *
     * @since 1.0.0
     */
    public static Matrix prod(final Matrix m1, final Matrix m2) {
        if (m1.width() != m2.height()) {
            throw new IllegalArgumentException(
                    String.format("Matrix product denied: matrices with sizes %dx%d and %dx%d", m1.height(),
                            m1.width(), m2.height(), m2.width()));
        }

        final Matrix result = new Mat(m1.height(), m2.width());
        for (int r = 0; r < m1.height(); r++) {
            for (int c = 0; c < m2.width(); c++) {
                float value = 0;
                for (int i = 0; i < m1.width(); i++) {
                    value += m1.get(r, i) * m2.get(i, c);
                }

                result.set(r, c, value);
            }
        }

        return result;
    }

    /**
     * Calculates product of matrix and vector.
     *
     * @param m matrix (left)
     * @param v column vector (right)
     * @return vector, which represents product of given matrix and vector
     * @throws IllegalArgumentException if width of the matrix is not equal to the
     *                                  vector size
     *
     * @since 1.0.0
     */
    public static Vector prod(final Matrix m, final Vector v) {
        if (m.width() != v.size()) {
            throw new IllegalArgumentException(
                    String.format("Matrix and vector product denied: matrix with size %dx%d and vector with size",
                            m.height(),
                            m.width(), v.size()));
        }

        final Vector result = new Vec(m.height());
        for (int i = 0; i < m.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < v.size(); elem++) {
                value += m.get(i, elem) * v.get(elem);
            }

            result.set(i, value);
        }

        return result;
    }

    /**
     * Triangulates given matrix.
     * 
     * @param m matrix to be triangulated
     * @return given matrix, which is triangulated
     *
     * @since 1.0.0
     */
    public static Matrix triangulate(final Matrix m) {
        int countOfSwaps = 0;
        final int maxSize = Math.min(m.height(), m.width());

        for (int i = 0; i < maxSize; i++) {
            if (Validator.equals(m.get(i, i), 0)) {
                boolean isNonZeroFound = false;

                for (int r = i + 1; r < m.height(); r++) {
                    if (!Validator.equals(m.get(r, i), 0)) {
                        swapRows(m, i, r);
                        countOfSwaps++;
                        isNonZeroFound = true;
                        break;
                    }
                }

                if (!isNonZeroFound)
                    continue;
            }

            for (int r = i + 1; r < m.height(); r++) {
                final float coefficient = -(m.get(r, i) / m.get(i, i));

                for (int c = i; c < m.width(); c++) {
                    m.set(r, c, m.get(r, c) + coefficient * m.get(i, c));
                }
            }
        }

        if (countOfSwaps % 2 == 1) {
            for (int i = 0; i < m.width(); i++) {
                m.set(0, i, m.get(0, i) * -1);
            }
        }

        return m;
    }

    /**
     * Copies given matrix and triangulates it.
     * 
     * @param m matrix to be triangulated
     * @return new matrix, which is result of triangulating of given matrix
     *
     * @since 1.0.0
     */
    public static Matrix triangulated(final Matrix m) {
        return triangulate(m.clone());
    }

    private static float det2(final Matrix m) {
        return m.get(0, 0) * m.get(1, 1)
                - m.get(0, 1) * m.get(1, 0);
    }

    private static float det3(final Matrix m) {
        return m.get(0, 0) * m.get(1, 1) * m.get(2, 2)
                + m.get(0, 1) * m.get(1, 2) * m.get(2, 0)
                + m.get(0, 2) * m.get(1, 0) * m.get(2, 1)
                - m.get(0, 2) * m.get(1, 1) * m.get(2, 0)
                - m.get(0, 0) * m.get(1, 2) * m.get(2, 1)
                - m.get(0, 1) * m.get(1, 0) * m.get(2, 2);
    }

    /**
     * Calculates matrix determinant using cofactors (not blazingly fast).
     * 
     * @param m matrix for determinant calculation
     * @return matrix determinant
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static float detThroughCofactors(final Matrix m) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Determinant does not exists: matrix is not square");
        }

        if (m.width() == 1) {
            return m.get(0, 0);
        } else if (m.width() == 2) {
            return MatMath.det2(m);
        } else if (m.width() == 3) {
            return MatMath.det3(m);
        }

        float determinant = 0;

        for (int i = 0; i < m.width(); i++) {
            determinant += m.get(0, i) * cofactor(m, 0, i);
        }

        return determinant;
    }

    /**
     * Calculates matrix determinant using triangular table (blazingly fast).
     * 
     * @param m matrix for determinant calculation
     * @return matrix determinant
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static float det(final Matrix m) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Determinant does not exists: matrix is not square");
        }
        Matrix triangularTable = triangulated(m);

        float determinant = 1;
        for (int i = 0; i < m.width(); i++) {
            determinant *= triangularTable.get(i, i);
        }

        return determinant;
    }

    /**
     * Constructs invertible matrix from given matrix.
     *
     * @param m matrix for invertible matrix construction
     * @return invertible matrix
     * @throws UnsupportedOperationException if matrix is not square
     * @throws RuntimeException              if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    public static Matrix invertible(final Matrix m) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Invertible matrix does not exists: matrix is not square");
        }
        final Matrix result = cofactorMatrix(m);
        float determinant = 0;

        for (int i = 0; i < m.width(); i++) {
            determinant += m.get(0, i) * result.get(0, i);
        }

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exist: determinant is 0");
        }
        transposeSquare(result);
        mult(result, 1 / determinant);

        return result;
    }

    /**
     * Constructs minor matrix excluding given row and column from given matrix.
     * 
     * @param m matrix for minor matrix construction
     * @param r row index to exclude
     * @param c column index to exclude
     * @return minor matrix excluding given row and column
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static Matrix minorMatrix(final Matrix m, final int r, final int c) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Minors do not exist: matrix is not square");
        }

        final Matrix result = new Mat(m.width() - 1);
        int destRow = 0;
        int destCol = 0;
        for (int i = 0; i < m.width(); i++) {
            if (i == r) {
                continue;
            }
            for (int j = 0; j < m.width(); j++) {
                if (j == c) {
                    continue;
                }

                result.set(destRow, destCol, m.get(i, j));
                destCol++;
            }
            destCol = 0;
            destRow++;
        }
        return result;
    }

    /**
     * Calculates cofactor (algebraic complement) from given matrix for position of
     * given row and column.
     * 
     * @param m matrix for cofactor calculation
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from given positions in given matrix
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static float cofactor(final Matrix m, final int r, final int c) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Can not find cofactor: matrix is not square");
        }

        final int coefficient = (r + c) % 2 == 0 ? 1 : -1;
        return coefficient * detThroughCofactors(minorMatrix(m, r, c));
    }

    /**
     * Constructs matrix of cofactors (algebraic complements)
     * 
     * @param m matrix for matrix of cofactors construction
     * @return matrix of cofactors
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static Matrix cofactorMatrix(final Matrix m) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Cofactor matrix does not exist: matrix is not square");
        }

        final Matrix result = new Mat(m.height(), m.width());
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                result.set(r, c, cofactor(m, r, c));
            }
        }

        return result;
    }

    /**
     * Returns {@code true} if matrix is square.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix is square, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean square(final Matrix m) {
        return m.width() == m.height();
    }

    /**
     * Returns {@code true} if matrix elements are approximately equal 0.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix elements are approximately equal 0, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean isZeroed(final Matrix m) {
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                if (m.get(i, j) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if matrix is diagonal.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix is square diagonal, and {@code false}
     *         otherwise
     *
     * @since 1.0.0
     */
    public static boolean diagonal(final Matrix m) {
        if (!square(m)) {
            return false;
        }

        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                if (i == j) {
                    continue;
                }
                if (!Validator.equals(m.get(i, j), 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if elements of matrices are equal within
     * {@code epsilon} tolerance
     * 
     * @param m1  first matrix for comparison
     * @param m2  second matrix for comparison
     * @param eps tolerance
     * @return {@code true} if all elements of matrices are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static boolean equalsEpsilon(final Matrix m1, final Matrix m2, final float eps) {
        Validator.validateMatrixSizes(m1, m2, "Equalization denied");
        for (int r = 0; r < m1.height(); r++) {
            for (int c = 0; c < m2.width(); c++) {
                if (!Validator.equalsEpsilon(m1.get(r, c), m2.get(r, c), eps)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if elements of matrices are approximately equal
     * 
     * @param m1 first matrix for comparison
     * @param m2 second matrix for comparison
     * @return {@code true} if all elements of matrices are approximately equal, and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static boolean equals(final Matrix m1, final Matrix m2) {
        return equalsEpsilon(m1, m2, Validator.EPS);
    }

    /**
     * Constructs matrix of given sizes with all 0 elements.
     * 
     * @param height height of matrix to be constructed
     * @param width  width of matrix to be constructed
     * @return matrix {@code height} x {@code width} with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix zeroMat(final int height, final int width) {
        return new Mat(height, width);
    }

    /**
     * Constructs square matrix of given size with 1 on main diagonal.
     * 
     * @param size height and width of matrix to be constructed
     * @return square matrix {@code size} x {@code size} with 1 on main diagonal
     *
     * @since 1.0.0
     */
    public static Matrix unitMat(final int size) {
        final Matrix result = new Mat(size);
        for (int i = 0; i < size; i++) {
            result.set(i, i, 1);
        }

        return result;
    }
}
