package io.github.alphameo.linear_algebra.mat;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.vec.Vec;
import io.github.alphameo.linear_algebra.vec.Vector;

/**
 * Class with static functions for arbitrary matrices.
 *
 * @since 1.0.0
 */
public final class MatrixMath {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public MatrixMath() {
    }

    /**
     * Transposes the given square matrix and returns it.
     *
     * @param m square matrix for transpose
     * @return transposed square matrix {@code m}
     * @throws IllegalArgumentException if the given matrix is not square
     *
     * @since 1.0.0
     */
    public static Matrix transposeSquare(final Matrix m) throws IllegalArgumentException {
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
     * Returns the result of the transpose operation of the given matrix.
     *
     * @param m matrix for transpose
     * @return new matrix with elements of transposed matrix {@code m}
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
     * Swaps the rows of the given matrix with the given indices and returns it.
     *
     * @param m  matrix for row swapping
     * @param r1 first row index for swapping
     * @param r2 second row index for swapping
     * @return matrix {@code m} with swapped rows
     *
     * @since 1.0.0
     */
    public static Matrix swapRows(final Matrix m, final int r1, final int r2) {
        float tmp;
        for (int c = 0; c < m.width(); c++) {
            tmp = m.get(r1, c);
            m.set(r1, c, m.get(r2, c));
            m.set(r2, c, tmp);
        }

        return m;
    }

    /**
     * Returns the result of row swapping of the given matrix with the given
     * indices.
     * 
     * @param m  matrix for row swapping
     * @param r1 first row index for swapping
     * @param r2 second row index for swapping
     * @return new matrix with elements of matrix {@code m} after swapping rows
     *
     * @since 1.0.0
     */
    public static Matrix swappedRows(final Matrix m, final int r1, final int r2) {
        return swapRows(m.clone(), r1, r2);
    }

    /**
     * Swaps the columns of the given matrix with the given indices and returns it.
     *
     * @param m  matrix for column swapping
     * @param c1 first column index for swapping
     * @param c2 second column index for swapping
     * @return matrix {@code m} with swapped columns
     *
     * @since 1.0.0
     */
    public static Matrix swapCols(final Matrix m, final int c1, final int c2) {
        float tmp;
        for (int r = 0; r < m.height(); r++) {
            tmp = m.get(r, c1);
            m.set(r, c1, m.get(r, c2));
            m.set(r, c2, tmp);
        }

        return m;
    }

    /**
     * Returns the result of column swapping of the given matrix with the given
     * indices.
     *
     * @param m  matrix for column swapping
     * @param c1 first column index for swapping
     * @param c2 second column index for swapping
     * @return new matrix with elements of matrix {@code m} after swapping columns
     *
     * @since 1.0.0
     */
    public static Matrix swappedCols(final Matrix m, final int c1, final int c2) {
        return swapCols(m.clone(), c1, c2);
    }

    /**
     * Multiplies elements of the given matrix by a scalar value and returns it.
     * 
     * @param m          matrix for multiplication
     * @param multiplier scalar value
     * @return matrix {@code m} multiplied by {@code multiplier}
     *
     * @since 1.0.0
     */
    public static Matrix mulAsgn(final Matrix m, final float multiplier) {
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                m.set(r, c, m.get(r, c) * multiplier);
            }
        }

        return m;
    }

    /**
     * Returns the result of multiplying the elements of the given matrix by a
     * scalar value.
     * 
     * @param m          matrix for multiplication
     * @param multiplier scalar value
     * @return new matrix with components of matrix {@code m} multiplied by
     *         {@code multiplier}
     *
     * @since 1.0.0
     */
    public static Matrix mul(final Matrix m, final float multiplier) {
        return mulAsgn(m.clone(), multiplier);
    }

    /**
     * Divides elements of the given matrix by a scalar value and returns it.
     * 
     * @param m       matrix for division
     * @param divisor scalar value
     * @return matrix {@code m} divided by {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Matrix divAsgn(final Matrix m, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                m.set(r, c, m.get(r, c) / divisor);
            }
        }

        return m;
    }

    /**
     * Returns the result of dividing the elements of the given matrix by a scalar
     * value.
     *
     * @param m       matrix for division
     * @param divisor scalar value
     * @return new matrix with elements of matrix {@code m} divided by
     *         {@code divisor}
     * @throws ArithmeticException if {@code divisor} is approximately equal to 0
     *
     * @since 1.0.0
     */
    public static Matrix div(final Matrix m, final float divisor) throws ArithmeticException {
        return divAsgn(m.clone(), divisor);
    }

    /**
     * Adds the components of the addendum matrix to the components of the target
     * matrix and returns it.
     * 
     * @param target   matrix to be added
     * @param addendum matrix to add
     * @return matrix {@code target} increased by matrix {@code addendum}
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static Matrix addAsgn(final Matrix target, final Matrix addendum) throws IllegalArgumentException {
        Validator.validateMatrixSizes(target, addendum, "Addition denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < addendum.width(); c++) {
                target.set(r, c, target.get(r, c) + addendum.get(r, c));
            }
        }

        return target;
    }

    /**
     * Returns the result of adding the elements of the addendum matrix to the
     * elements of the target matrix.
     * 
     * @param target   matrix to be added
     * @param addendum matrix to add
     * @return new matrix with the sum of matrix {@code target} and matrix
     *         {@code addendum}
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static Matrix add(final Matrix target, final Matrix addendum) throws IllegalArgumentException {
        return addAsgn(target.clone(), addendum);
    }

    /**
     * Subtracts elements of the subtrahend matrix from the elements of the
     * target matrix and returns it.
     * 
     * @param target     matrix to be subtracted
     * @param subtrahend matrix to subtract
     * @return matrix {@code target} reduced by matrix {@code subtrahend}
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static Matrix subAsgn(final Matrix target, final Matrix subtrahend) throws IllegalArgumentException {
        Validator.validateMatrixSizes(target, subtrahend, "Subtraction denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < subtrahend.width(); c++) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
            }
        }

        return target;
    }

    /**
     * Returns the result of subtracting the elements of the subtrahend matrix
     * from the elements of the target matrix.
     * 
     * @param target     matrix to be subtracted
     * @param subtrahend matrix to subtract
     * @return new matrix with result of subtracting matrix {@code subtrahend} from
     *         matrix {@code target}
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static Matrix sub(final Matrix target, final Matrix subtrahend) throws IllegalArgumentException {
        return subAsgn(target.clone(), subtrahend);
    }

    /**
     * Returns the result of product of the given matrices.
     *
     * @param m1 left matrix for product
     * @param m2 right matrix for product
     * @return product of matrix {@code m1} and matrix {@code m2}
     * @throws IllegalArgumentException if the left matrix width is not equal to
     *                                  the right matrix height
     *
     * @since 1.0.0
     */
    public static Matrix prod(final Matrix m1, final Matrix m2) throws IllegalArgumentException {
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
     * Returns the result of product of the given matrix and the given
     * vector-column.
     *
     * @param m    matrix for product
     * @param vCol vector-column for product
     * @return new vector, which represents product of matrix {@code m} and
     *         vector-column {@code vCol}
     * @throws IllegalArgumentException if width of the given matrix is not equal
     *                                  to dimension of the given vector-column
     *
     * @since 1.0.0
     */
    public static Vector prod(final Matrix m, final Vector vCol) throws IllegalArgumentException {
        return MatrixMath.prodCol(m, vCol);
    }

    /**
     * Returns the result of the product of the given matrix and the given
     * vector-column.
     *
     * @param m    matrix (left)
     * @param vCol vector-column (right)
     * @return new vector with result of product of matrix {@code m} and vector
     *         {@code vCol}
     * @throws IllegalArgumentException if width of the given matrix is not equal
     *                                  to dimension of the given vector-column
     *
     * @since 3.0.0
     */
    public static Vector prodCol(final Matrix m, final Vector vCol) throws IllegalArgumentException {
        if (m.width() != vCol.size()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Matrix and vector-column product denied: matrix with size %dx%d and %d-dimensional vector",
                            m.height(), m.width(), vCol.size()));
        }

        final Vector result = new Vec(m.height());
        for (int i = 0; i < m.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < vCol.size(); elem++) {
                value += m.get(i, elem) * vCol.get(elem);
            }

            result.set(i, value);
        }

        return result;
    }

    /**
     * Returns the result of product of the given vector-row and the given matrix.
     *
     * @param m    matrix (right)
     * @param vRow vector-row (left)
     * @return new vector with result of product of vector {@code vCol} and matrix
     *         {@code m}
     * @throws IllegalArgumentException if height of the given matrix is not equal
     *                                  to the dimension of the given vector-row
     *
     * @since 3.0.0
     */
    public static Vector prodRow(final Matrix m, final Vector vRow) throws IllegalArgumentException {
        if (m.height() != vRow.size()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Matrix and vector-row product denied: matrix with size %dx%d and %d-dimensional vector",
                            m.height(), m.width(), vRow.size()));
        }

        final Vector result = new Vec(m.width());
        for (int i = 0; i < m.width(); i++) {
            float value = 0;
            for (int elem = 0; elem < vRow.size(); elem++) {
                value += m.get(elem, i) * vRow.get(elem);
            }

            result.set(i, value);
        }

        return result;
    }

    /**
     * Triangulates given matrix and returns it.
     * 
     * @param m matrix to be triangulated
     * @return triangulated matrix {@code m}
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
     * Returns result of triangulation of the given matrix.
     * 
     * @param m matrix to be triangulated
     * @return new matrix, with elements of triangulated matrix {@code m}
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
     * Returns determinant of the given square matrix calculated via cofactors
     * (not blazingly fast).
     * 
     * @param m matrix for determinant calculation
     * @return determinant of matrix {@code m}
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static float detCof(final Matrix m) throws UnsupportedOperationException {
        if (!square(m)) {
            throw new UnsupportedOperationException("Determinant does not exists: matrix is not square");
        }

        if (m.width() == 1) {
            return m.get(0, 0);
        } else if (m.width() == 2) {
            return MatrixMath.det2(m);
        } else if (m.width() == 3) {
            return MatrixMath.det3(m);
        }

        float determinant = 0;

        for (int i = 0; i < m.width(); i++) {
            determinant += m.get(0, i) * cofactor(m, 0, i);
        }

        return determinant;
    }

    /**
     * Returns determinant of the given matrix calculated via triangular table
     * (blazingly fast).
     * 
     * @param m matrix for determinant calculation
     * @return determinant of matrix {@code m}
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static float det(final Matrix m) throws UnsupportedOperationException {
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
     * Returns invertible matrix of the given matrix.
     *
     * @param m matrix for invertible matrix construction
     * @return new invertible matrix for matrix {@code m}
     * @throws UnsupportedOperationException if matrix is not square
     * @throws RuntimeException              if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    public static Matrix inv(final Matrix m) throws UnsupportedOperationException, RuntimeException {
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
        mulAsgn(result, 1 / determinant);

        return result;
    }

    /**
     * Returns minor matrix from the given matrix excluding given row and column
     * from given matrix.
     * 
     * @param m matrix for minor matrix construction
     * @param r row index to exclude
     * @param c column index to exclude
     * @return new minor matrix excluding row {@code r} and column {@code c}
     *         from matrix {@code m}
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static Matrix minorMatrix(final Matrix m, final int r, final int c) throws UnsupportedOperationException {
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
     * Returns cofactor (algebraic complement) from the given matrix for position of
     * given row and column.
     * 
     * @param m matrix for cofactor calculation
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value for row {@code r} and column {@code c} for the given
     *         positions in the given matrix
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static float cofactor(final Matrix m, final int r, final int c) throws UnsupportedOperationException {
        if (!square(m)) {
            throw new UnsupportedOperationException("Can not find cofactor: matrix is not square");
        }

        final int coefficient = (r + c) % 2 == 0 ? 1 : -1;
        return coefficient * detCof(minorMatrix(m, r, c));
    }

    /**
     * Returns matrix of cofactors (algebraic complements) for the given matrix.
     * 
     * @param m matrix for matrix of cofactors construction
     * @return new matrix of cofactors for matrix {@code m}
     * @throws UnsupportedOperationException if matrix is not square
     *
     * @since 1.0.0
     */
    public static Matrix cofactorMatrix(final Matrix m) throws UnsupportedOperationException {
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
     * Returns {@code true} if the given matrix is square.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix {@code m} is square, and {@code false}
     *         otherwise.
     *
     * @since 1.0.0
     */
    public static boolean square(final Matrix m) {
        return m.width() == m.height();
    }

    /**
     * Returns {@code true} if elements of the given matrix are approximately equal
     * 0.
     * 
     * @param m matrix for analysis
     * @return {@code true} if elements of matrix {@code m} are approximately equal
     *         0, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean zeroed(final Matrix m) {
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
     * Returns {@code true} if the given matrix is diagonal.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix {@code m} is square diagonal, and
     *         {@code false} otherwise
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
     * {@code epsilon} tolerance.
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
    public static boolean equalsEpsilon(final Matrix m1, final Matrix m2, final float eps)
            throws IllegalArgumentException {
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
     * Returns {@code true} if the elements of the given matrices are approximately
     * equal.
     * 
     * @param m1 first matrix for comparison
     * @param m2 second matrix for comparison
     * @return {@code true} if all elements of matrices are approximately equal, and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if matrices have different sizes
     *
     * @since 1.0.0
     */
    public static boolean equals(final Matrix m1, final Matrix m2) throws IllegalArgumentException {
        return equalsEpsilon(m1, m2, Validator.EPS);
    }

    /**
     * Constructs {@code height}x{@code width}vector with all 0 components.
     * 
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     * @param height height of matrix to be constructed
     * @param width  width of matrix to be constructed
     * @return new {@code height}-x-{@code width} matrix with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix zeroMatrix(final int height, final int width) {
        return new Mat(height, width);
    }

    /**
     * Constructs {@code size}-x-{@code size} matrix with all 1 on main iagonal.
     * 
     * @param size height and width of matrix to be constructed
     * @return new square {@code size}x{@code size} matrix with 1 on main diagonal
     *
     * @since 1.0.0
     */
    public static Matrix unitMatrix(final int size) {
        final Matrix result = new Mat(size);
        for (int i = 0; i < size; i++) {
            result.set(i, i, 1);
        }

        return result;
    }

    /**
     * Constructs matrix from the given vector-rows.
     * 
     * @param vs vectors for matrix construction taken as rows
     * @return new matrix with values from vectors {@code vsCEyy}
     * @throws IllegalArgumentException if vectors have different lengths
     *
     * @since 2.1.0
     */
    public static Matrix fromVecRows(Vector... vs) throws IllegalArgumentException {
        Mat result = new Mat(vs.length, vs[0].size());
        for (int r = 0; r < vs.length; r++) {
            if (vs[r].size() != vs[0].size()) {
                throw new IllegalArgumentException("Matrix creation denied: vectors with different sizes");
            }
            for (int c = 0; c < vs[0].size(); c++) {
                result.set(r, c, vs[r].get(c));
            }
        }

        return result;
    }

    /**
     * Constructs matrix from the given vector-columns.
     * 
     * @param vs vectors for matrix construction taken as columns
     * @return new matrix with values from vectors {@code vsCEyy}
     * @throws IllegalArgumentException if vectors have different lengths
     *
     * @since 2.1.0
     */
    public static Matrix fromVecCols(Vector... vs) throws IllegalArgumentException {
        Mat result = new Mat(vs[0].size(), vs.length);
        for (int c = 0; c < vs.length; c++) {
            if (vs[c].size() != vs[0].size()) {
                throw new IllegalArgumentException("Matrix creation denied: vectors with different sizes");
            }
            for (int r = 0; r < vs[0].size(); r++) {
                result.set(r, c, vs[c].get(r));
            }
        }

        return result;
    }
}
