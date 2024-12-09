package com.github.ia1phai.linear_algebra.mat;

import com.github.ia1phai.linear_algebra.Validator;
import com.github.ia1phai.linear_algebra.vec.Vec3;
import com.github.ia1phai.linear_algebra.vec.Vector3;

import static com.github.ia1phai.linear_algebra.mat.Matrix3Row.*;
import static com.github.ia1phai.linear_algebra.mat.Matrix3Col.*;

/**
 * Class with static functions for matrices 3x3.
 */
public class Mat3Math {

    /**
     * Constant array of enums for fast and safe access to matrix 3x3 rows
     */
    public static final Matrix3Row[] ROWS = Matrix3Row.values();

    /**
     * Constant array of enums for fast and safe access to matrix 3x3 columns
     */
    public static final Matrix3Col[] COLS = Matrix3Col.values();

    /**
     * Transposes given matrix 3x3
     *
     * @param m matrix 3x3 for transpose
     * @return given matrix 3x3, which is transposed
     */
    public static Matrix3 transpose(final Matrix3 m) {
        float tmp;
        for (int i = 0; i < m.width(); i++) {
            for (int j = i + 1; j < m.width(); j++) {
                tmp = m.get(ROWS[i], COLS[j]);
                m.set(ROWS[i], COLS[j], m.get(ROWS[j], COLS[i]));
                m.set(ROWS[j], COLS[i], tmp);
            }
        }

        return m;
    }

    /**
     * Copies given matrix 3x3 and transpose it.
     * 
     * @param m matrix 3x3 for transpose
     * @return new matrix 3x3, which is result of transposing of given matrix 3x3
     */
    public static Matrix3 transposed(final Matrix3 m) {
        return transpose(new Mat3(m));
    }

    /**
     * Safely swaps rows of matrix 3x3
     *
     * @param m  matrix 3x3 for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return given matrix 3x3 with swapped rows
     */
    public static Matrix3 swapRows(final Matrix3 m, final Matrix3Row r1, final Matrix3Row r2) {
        float tmp;
        for (final Matrix3Col c : COLS) {
            tmp = m.get(r1, c);
            m.set(r1, c, m.get(r2, c));
            m.set(r2, c, tmp);
        }

        return m;
    }

    /**
     * Swaps rows of matrix 3x3
     *
     * @param m  matrix 3x3 for row swapping
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return given 3x3 matrix with swapped rows
     * @throws Exception if any row index is out of bounds
     */
    public static Matrix3 swapRows(final Matrix3 m, final int r1, final int r2) {
        return swapRows(m, ROWS[r1], ROWS[r2]);
    }

    /**
     * Copies given matrix 3x3 and safely swaps its rows.
     * 
     * @param m  matrix 3x3 for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix 3x3 with swapped rows of given matrix 3x3
     */
    public static Matrix3 swappedRows(final Matrix3 m, final Matrix3Row r1, final Matrix3Row r2) {
        return swapRows(new Mat3(m), r1, r2);
    }

    /**
     * Copies given matrix 3x3 and swaps its rows.
     * 
     * @param m  matrix 3x3 for row swapping
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return new matrix 3x3 with swapped rows of given matrix 3x3
     * @throws Exception if any row index is out of bounds
     */
    public static Matrix3 swappedRows(final Matrix3 m, final int r1, final int r2) {
        return swappedRows(m, ROWS[r1], ROWS[r2]);
    }

    /**
     * Safely swaps columns of matrix 3x3
     *
     * @param m  matrix 3x3 for column swapping
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return given matrix 3x3 with swapped columns
     */
    public static Matrix3 swapCols(final Matrix3 m, final Matrix3Col c1, final Matrix3Col c2) {
        float tmp;
        for (final Matrix3Row r : ROWS) {
            tmp = m.get(r, c1);
            m.set(r, c1, m.get(r, c2));
            m.set(r, c2, tmp);
        }

        return m;
    }

    /**
     * Swaps columns of matrix 3x3
     *
     * @param m  matrix 3x3 for column swapping
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return given matrix 3x3 with swapped columns
     */
    public static Matrix3 swapCols(final Matrix3 m, final int c1, final int c2) {
        return swapCols(m, COLS[c1], COLS[c2]);
    }

    /**
     * Copies given matrix 3x3 and safely swaps columns
     *
     * @param m  matrix 3x3 for column swapping
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return new matrix 3x3 with swapped columns of given matrix 3x3
     * @throws Exception if any column index is out of bounds
     */
    public static Matrix3 swappedCols(final Matrix3 m, final Matrix3Col c1, final Matrix3Col c2) {
        return swapCols(new Mat3(m), c1, c2);
    }

    /**
     * Copies given matrix 3x3 and safely swaps columns
     *
     * @param m  matrix 3x3 for column swapping
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return new matrix 3x3 with swapped columns of given matrix 3x3
     * @throws Exception if any column index is out of bounds
     */
    public static Matrix3 swappedCols(final Matrix3 m, final int c1, final int c2) {
        return swapCols(new Mat3(m), c1, c2);
    }

    /**
     * Multiplies matrix 3x3 elements by a scalar value.
     * 
     * @param m          matrix 3x3 for multiplication
     * @param multiplier scalar value
     * @return given matrix 3x3 with multiplied elements
     */
    public static Matrix3 mult(final Matrix3 m, final float multiplier) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                m.set(r, c, m.get(r, c) * multiplier);
            }
        }

        return m;
    }

    /**
     * Copies given matrix 3x3 and multiplies its components by a scalar value.
     * 
     * @param m          matrix for multiplication
     * @param multiplier scalar value
     * @return new matrix 3x3 with multiplied elements of given matrix
     */
    public static Matrix3 multiplied(final Matrix3 m, final float multiplier) {
        return mult(new Mat3(m), multiplier);
    }

    /**
     * Divides matrix 3x3 elements by a scalar value.
     * 
     * @param m       matrix 3x3 for division
     * @param divisor scalar value
     * @return given matrix 3x3 with divided elements of given matrix
     * @throws IllegalArgumentException if {@code divisor} approximately equals 0
     */
    public static Matrix3 divide(final Matrix3 m, final float divisor) {
        Validator.validateDivisor(divisor);
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                m.set(r, c, m.get(r, c) / divisor);
            }
        }

        return m;
    }

    /**
     * Copies given matrix 3x3 and divides its components by a scalar value.
     *
     * @param m       matrix 3x3 for division
     * @param divisor scalar value
     * @return new matrix 3x3 with divided elements of given matrix
     * @throws IllegalArgumentException if {@code divisor} approximately equals 0
     */
    public static Matrix3 divided(final Matrix3 m, final float divisor) {
        return divide(new Mat3(m), divisor);
    }

    /**
     * Adds the {@code addendum} matrix 3x3 elements to the {@code target} matrix
     * 3x3 elements.
     * 
     * @param target   matrix 3x3 to be added
     * @param addendum matrix 3x3 to add
     * @return {@code target} matrix 3x3 increased by {@code addendum} matrix 3x3
     */
    public static Matrix3 add(final Matrix3 target, final Matrix3 addendum) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                target.set(r, c, target.get(r, c) + addendum.get(r, c));
            }
        }

        return target;
    }

    /**
     * Copies {@code target} matrix 3x3 and adds the {@code addendum} matrix 3x3
     * elements to its elements.
     * 
     * @param target   matrix 3x3 to be added
     * @param addendum matrix 3x3 to add
     * @return new matrix 3x3 with sum of elements of {@code target} matrix 3x3 and
     *         {@code addendum} matrix 3x3
     */
    public static Matrix3 added(final Matrix3 target, final Matrix3 addendum) {
        return add(new Mat3(target), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} matrix 3x3 elements from the {@code target}
     * matrix 3x3 elements.
     * 
     * @param target     matrix 3x3 to be subtracted
     * @param subtrahend matrix 3x3 to subtract
     * @return {@code target} matrix 3x3 subtracted by {@code addendum} matrix 3x3
     */
    public static Matrix3 sub(final Matrix3 target, final Matrix3 subtrahend) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
            }
        }

        return target;
    }

    /**
     * Copies {@code target} matrix 3x3 and subtracts the {@code subtrahend} matrix
     * 3x3 elements from its elements.
     * 
     * @param target     matrix 3x3 to be subtracted
     * @param subtrahend matrix 3x3 to subtract
     * @return {@code target} matrix 3x3 subtracted by {@code addendum} matrix 3x3
     */
    public static Matrix3 subtracted(final Matrix3 target, final Matrix3 subtrahend) {
        return sub(new Mat3(target), subtrahend);
    }

    /**
     * Calculates product of matrices 3x3.
     *
     * @param m1 first (left) matrix 3x3
     * @param m2 second (right) matrix 3x3
     * @return matrix 3x3, which represents product of given matrices
     */
    public static Matrix3 prod(final Matrix3 m1, final Matrix3 m2) {
        final Matrix3 result = new Mat3();
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                float value = 0;
                for (int i = 0; i < m1.width(); i++) {
                    value += m1.get(r, COLS[i]) * m2.get(ROWS[i], c);
                }
                result.set(r, c, value);
            }
        }

        return result;
    }

    /**
     * Calculates product of matrix 3x3 and vector of size 3.
     *
     * @param m matrix 3x3 (left)
     * @param v column vector of size 3 (right)
     * @return vector of size 3, which represents product of given matrix and vector
     */
    public static Vector3 prod(final Matrix3 m, final Vector3 v) {
        final Vector3 result = new Vec3();
        for (int i = 0; i < m.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < v.size(); elem++) {
                value += m.get(ROWS[i], COLS[elem]) * v.get(elem);
            }

            result.set(i, value);
        }

        return result;
    }

    /**
     * Triangulates given matrix 3x3.
     * 
     * @param m matrix 3x3 to be triangulated
     * @return given matrix 3x3, which is triangulated
     */
    public static Matrix3 triangulate(final Matrix3 m) {
        int countOfSwaps = 0;

        for (int i = 0; i < m.width(); i++) {
            if (Validator.equals(m.get(ROWS[i], COLS[i]), 0)) {
                boolean isNonZeroFound = false;

                for (int r = i + 1; r < m.height(); r++) {
                    if (!Validator.equals(m.get(ROWS[r], COLS[i]), 0)) {
                        swapRows(m, ROWS[i], ROWS[r]);
                        countOfSwaps++;
                        isNonZeroFound = true;
                        break;
                    }
                }

                if (!isNonZeroFound)
                    continue;
            }

            for (int r = i + 1; r < m.height(); r++) {
                final float coefficient = -(m.get(ROWS[r], COLS[i]) / m.get(ROWS[i], COLS[i]));

                for (int c = i; c < m.width(); c++) {
                    m.set(
                            ROWS[r],
                            COLS[c],
                            m.get(ROWS[r], COLS[c])
                                    + coefficient * m.get(ROWS[i], COLS[c]));
                }
            }
        }

        if (countOfSwaps % 2 == 1) {
            for (int i = 0; i < m.width(); i++) {
                m.set(R0, COLS[i], m.get(R0, COLS[i]) * -1);
            }
        }

        return m;
    }

    /**
     * Copies given matrix 3x3 and triangulates it.
     * 
     * @param m matrix 3x3 to be triangulated
     * @return new matrix 3x3, which is result of triangulating of given matrix 3x3
     */
    public static Matrix3 triangulated(final Matrix3 m) {
        return triangulate(new Mat3(m));
    }

    /**
     * Calculates matrix 3x3 determinant.
     * 
     * @param m matrix 3x3 for determinant calculation
     * @return matrix 3x3 determinant
     */
    public static float det(final Matrix3 m) {
        return m.get(R0, C0) * m.get(R1, C1) * m.get(R2, C2)
                + m.get(R0, C1) * m.get(R1, C2) * m.get(R2, C0)
                + m.get(R0, C2) * m.get(R1, C0) * m.get(R2, C1)
                - m.get(R0, C2) * m.get(R1, C1) * m.get(R2, C0)
                - m.get(R0, C0) * m.get(R1, C2) * m.get(R2, C1)
                - m.get(R0, C1) * m.get(R1, C0) * m.get(R2, C2);
    }

    /**
     * Constructs invertible matrix 3x3 from given matrix 3x3.
     *
     * @param m matrix 3x3 for invertible matrix 3x3 construction
     * @return invertible matrix 3x3
     * @throws RuntimeException if matrix determinant equals to 0
     */
    public static Matrix3 invertible(final Matrix3 m) {
        final Matrix3 result = cofactorMatrix(m);
        final float determinant = det(m);

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exitst: determinant is 0");
        }
        transpose(result);
        mult(result, 1 / determinant);
        return result;
    }

    /**
     * Constructs minor matrix excluding given row and column from given.
     * 
     * @param m matrix for minor matrix construction
     * @param r row to exclude
     * @param c column to exclude
     * @return minor matrix excluding given row and column
     */
    public static Matrix minorMatrix(final Matrix3 m, final Matrix3Row r, final Matrix3Col c) {
        final Matrix result = new Mat(2);
        int destRow = 0;
        int destCol = 0;
        for (int i = 0; i < m.width(); i++) {
            if (i == r.ordinal()) {
                continue;
            }
            for (int j = 0; j < m.width(); j++) {
                if (j == c.ordinal()) {
                    continue;
                }

                result.set(destRow, destCol, m.get(ROWS[i], COLS[j]));
                destCol++;
            }
            destCol = 0;
            destRow++;
        }

        return result;
    }

    /**
     * Constructs minor matrix excluding given row and column from given matrix 3x3.
     * 
     * @param m matrix 3x3 for minor matrix construction
     * @param r row index to exclude
     * @param c column index to exclude
     * @return minor matrix excluding given row and column
     */
    public static Matrix minorMatrix(final Matrix3 m, final int r, final int c) {
        return minorMatrix(m, ROWS[r], COLS[c]);
    }

    /**
     * Calculates cofactor (algebraic complement) from given matrix 3x3 for position
     * of given row and column.
     * 
     * @param m matrix for cofactor calculation
     * @param r row for cofactor calculation
     * @param c column for cofactor calculation
     * @return cofactor value from given positions in given matrix 3x3
     */
    public static float cofactor(final Matrix3 m, final Matrix3Row r, final Matrix3Col c) {
        final int coefficient = (r.ordinal() + c.ordinal()) % 2 == 0 ? 1 : -1;
        return coefficient * MatMath.detThroughCofactors(minorMatrix(m, r, c));
    }

    /**
     * Calculates cofactor (algebraic complement) from given matrix 3x3 for position
     * of given row and column.
     * 
     * @param m matrix 3x3 for cofactor calculation
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from given positions in given matrix 3x3
     */
    public static float cofactor(final Matrix3 m, final int r, final int c) {
        return cofactor(m, ROWS[r], COLS[c]);
    }

    /**
     * Constructs matrix 3x3 of cofactors (algebraic complements)
     * 
     * @param m matrix 3x3 for matrix of cofactors construction
     * @return matrix 3x3 of cofactors
     */
    public static Matrix3 cofactorMatrix(final Matrix3 m) {
        final Matrix3 result = new Mat3();
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                result.set(r, c, cofactor(m, r, c));
            }
        }

        return result;
    }

    /**
     * Returns {@code true} if elements of matrices 3x3 are approximately equal
     * 
     * @param m1 first matrix 3x3 for comparison
     * @param m2 second matrix 3x3 for comparison
     * @return {@code true} if all elements of matrices 3x3 are approximately equal,
     *         and {@code false} otherwise
     */
    public static boolean equals(final Matrix3 m1, final Matrix3 m2) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                if (!Validator.equals(m1.get(r, c), m2.get(r, c))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if matrix 3x3 is square.
     * 
     * @param m matrix 3x3 for analysis
     * @return {@code true} if matrix is square, and {@code false} otherwise
     */
    public static boolean square(final Matrix3 m) {
        return true;
    }

    /**
     * Returns {@code true} if matrix 3x3 elements are approximately equal 0.
     * 
     * @param m matrix 3x3 for analysis
     * @return {@code true} if matrix elements are approximately equal 0, and
     *         {@code false} otherwise
     */
    public static boolean isZeroed(final Matrix3 m) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                if (m.get(r, c) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if matrix 3x3 is diagonal.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix is square diagonal, and {@code false}
     *         otherwise
     */
    public static boolean diagonal(final Matrix3 m) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                if (r.ordinal() == c.ordinal()) {
                    continue;
                }
                if (!Validator.equals(m.get(r, c), 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Matrix4 toMat4(final Matrix3 m, final Matrix4Row insertionRow, final Matrix4Col insertionCol) {
        final Matrix4 result = new Mat4();
        int destRow = 0;
        int destCol = 0;
        for (int r = 0; r < m.width(); r++) {
            if (r == insertionCol.ordinal()) {
                destRow++;
            }
            for (int c = 0; c < m.width(); c++) {
                if (c == insertionCol.ordinal()) {
                    destCol++;
                }
                result.set(
                        Matrix4Row.values()[destRow],
                        Matrix4Col.values()[destCol],
                        m.get(ROWS[r], COLS[c]));
                destCol++;
            }
            destCol = 0;
            destRow++;
        }

        result.set(insertionRow, insertionCol, 1);

        return result;
    }

    public static Matrix4 toMat4(final Matrix3 m, final int insertionRow, final int insertionCol) {
        return toMat4(m, Matrix4Row.values()[insertionRow], Matrix4Col.values()[insertionCol]);
    }

    public static Matrix4 toMat4(final Matrix3 m) {
        return toMat4(m, Matrix4Row.R3, Matrix4Col.C3);
    }

    /**
     * Constructs matrix 3x3 of with all 0 elements.
     * 
     * @return matrix 3x3 with all 0 elements
     */
    public static Matrix3 zeroMat() {
        return new Mat3();
    }

    /**
     * Constructs square matrix of given size with 1 on main diagonal.
     * 
     * @return square matrix 3x3 with 1 on main diagonal
     */
    public static Matrix3 unitMat() {
        final Matrix3 result = new Mat3();
        for (int i = 0; i < result.width(); i++) {
            result.set(ROWS[i], COLS[i], 1);
        }

        return result;
    }
}
