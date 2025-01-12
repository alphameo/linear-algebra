package io.github.alphameo.linear_algebra.mat;

import static io.github.alphameo.linear_algebra.mat.Matrix4Row.*;
import static io.github.alphameo.linear_algebra.mat.Matrix4Col.*;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.vec.Vec4;
import io.github.alphameo.linear_algebra.vec.Vector4;

/**
 * Class with static functions for matrices 4x4.
 *
 * @since 1.0.0
 */
public final class Matrix4Math {

    /**
     * Constant array of enums for fast and safe access to matrix 4x4 rows
     *
     * @since 1.0.0
     */
    public static final Matrix4Row[] ROWS = Matrix4Row.values();

    /**
     * Constant array of enums for fast and safe access to matrix 4x4 columns
     *
     * @since 1.0.0
     */
    public static final Matrix4Col[] COLS = Matrix4Col.values();

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public Matrix4Math() {
    }

    /**
     * Transposes given matrix 4x4
     *
     * @param m matrix 4x4 for transpose
     * @return given matrix 4x4, which is transposed
     *
     * @since 1.0.0
     */
    public static Matrix4 transpose(final Matrix4 m) {
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
     * Copies given matrix 4x4 and transpose it.
     * 
     * @param m matrix 4x4 for transpose
     * @return new matrix 4x4, which is result of transposing of given matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 transposed(final Matrix4 m) {
        return transpose(m.clone());
    }

    /**
     * Safely swaps rows of matrix 4x4
     *
     * @param m  matrix 4x4 for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return given matrix 4x4 with swapped rows
     *
     * @since 1.0.0
     */
    public static Matrix4 swapRows(final Matrix4 m, final Matrix4Row r1, final Matrix4Row r2) {
        float tmp;
        for (final Matrix4Col c : COLS) {
            tmp = m.get(r1, c);
            m.set(r1, c, m.get(r2, c));
            m.set(r2, c, tmp);
        }

        return m;
    }

    /**
     * Swaps rows of matrix 4x4
     *
     * @param m  matrix 4x4 for row swapping
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return given 4x4 matrix with swapped rows
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix4 swapRows(final Matrix4 m, final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        swapRows(m, ROWS[r1], ROWS[r2]);

        return m;
    }

    /**
     * Copies given matrix 4x4 and safely swaps its rows.
     * 
     * @param m  matrix 4x4 for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix 4x4 with swapped rows of given matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 swappedRows(final Matrix4 m, final Matrix4Row r1, final Matrix4Row r2) {
        return swapRows(m.clone(), r1, r2);
    }

    /**
     * Copies given matrix 4x4 and swaps its rows.
     * 
     * @param m  matrix 4x4 for row swapping
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return new matrix 4x4 with swapped rows of given matrix 4x4
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix4 swappedRows(final Matrix4 m, final int r1, final int r2)
            throws ArrayIndexOutOfBoundsException {
        return swappedRows(m, ROWS[r1], ROWS[r2]);
    }

    /**
     * Safely swaps columns of matrix 4x4
     *
     * @param m  matrix 4x4 for column swapping
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return given matrix 4x4 with swapped columns
     *
     * @since 1.0.0
     */
    public static Matrix4 swapCols(final Matrix4 m, final Matrix4Col c1, final Matrix4Col c2) {
        float tmp;
        for (final Matrix4Row r : ROWS) {
            tmp = m.get(r, c1);
            m.set(r, c1, m.get(r, c2));
            m.set(r, c2, tmp);
        }

        return m;
    }

    /**
     * Swaps columns of matrix 4x4
     *
     * @param m  matrix 4x4 for column swapping
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return given matrix 4x4 with swapped columns
     *
     * @since 1.0.0
     */
    public static Matrix4 swapCols(final Matrix4 m, final int c1, final int c2) {
        return swapCols(m, COLS[c1], COLS[c2]);
    }

    /**
     * Copies given matrix 4x4 and safely swaps columns
     *
     * @param m  matrix 4x4 for column swapping
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return new matrix 4x4 with swapped columns of given matrix 4x4
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix4 swappedCols(final Matrix4 m, final Matrix4Col c1, final Matrix4Col c2)
            throws ArrayIndexOutOfBoundsException {
        return swapCols(m.clone(), c1, c2);
    }

    /**
     * Copies given matrix 4x4 and safely swaps columns
     *
     * @param m  matrix 4x4 for column swapping
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return new matrix 4x4 with swapped columns of given matrix 4x4
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix4 swappedCols(final Matrix4 m, final int c1, final int c2)
            throws ArrayIndexOutOfBoundsException {
        return swappedCols(m, COLS[c1], COLS[c2]);
    }

    /**
     * Multiplies matrix 4x4 elements by a scalar value.
     * 
     * @param m          matrix 4x4 for multiplication
     * @param multiplier scalar value
     * @return given matrix 4x4 with multiplied elements
     *
     * @since 1.0.0
     */
    public static Matrix4 mult(final Matrix4 m, final float multiplier) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
                m.set(r, c, m.get(r, c) * multiplier);
            }
        }

        return m;
    }

    /**
     * Copies given matrix 4x4 and multiplies its components by a scalar value.
     * 
     * @param m          matrix for multiplication
     * @param multiplier scalar value
     * @return new matrix 4x4 with multiplied elements of given matrix
     *
     * @since 1.0.0
     */
    public static Matrix4 multiplied(final Matrix4 m, final float multiplier) {
        return mult(m.clone(), multiplier);
    }

    /**
     * Divides matrix 4x4 elements by a scalar value.
     * 
     * @param m       matrix 4x4 for division
     * @param divisor scalar value
     * @return given matrix 4x4 with divided elements
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    public static Matrix4 divide(final Matrix4 m, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
                m.set(r, c, m.get(r, c) / divisor);
            }
        }

        return m;
    }

    /**
     * Copies given matrix 4x4 and divides its components by a scalar value.
     *
     * @param m       matrix 4x4 for division
     * @param divisor scalar value
     * @return new matrix 4x4 with divided elements of given matrix
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    public static Matrix4 divided(final Matrix4 m, final float divisor) throws ArithmeticException {
        return divide(m.clone(), divisor);
    }

    /**
     * Adds the {@code addendum} matrix 4x4 elements to the {@code target} matrix
     * 4x4 elements.
     * 
     * @param target   matrix 4x4 to be added
     * @param addendum matrix 4x4 to add
     * @return {@code target} matrix 4x4 increased by {@code addendum} matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 addIncr(final Matrix4 target, final Matrix4 addendum) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
                target.set(r, c, target.get(r, c) + addendum.get(r, c));
            }
        }

        return target;
    }

    /**
     * Copies {@code target} matrix 4x4 and adds the {@code addendum} matrix 4x4
     * elements to its elements.
     * 
     * @param target   matrix 4x4 to be added
     * @param addendum matrix 4x4 to add
     * @return new matrix 4x4 with sum of elements of {@code target} matrix 4x4 and
     *         {@code addendum} matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 add(final Matrix4 target, final Matrix4 addendum) {
        return addIncr(target.clone(), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} matrix 4x4 elements from the {@code target}
     * matrix 4x4 elements.
     * 
     * @param target     matrix 4x4 to be subtracted
     * @param subtrahend matrix 4x4 to subtract
     * @return {@code target} matrix 4x4 subtracted by {@code addendum} matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 subIncr(final Matrix4 target, final Matrix4 subtrahend) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
            }
        }

        return target;
    }

    /**
     * Copies {@code target} matrix 4x4 and subtracts the {@code subtrahend} matrix
     * 4x4 elements from its elements.
     * 
     * @param target     matrix 4x4 to be subtracted
     * @param subtrahend matrix 4x4 to subtract
     * @return new matrix 4x4 with components resulting {@code target} matrix 4x4
     *         subtracted by {@code subtrahend} matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 subtracted(final Matrix4 target, final Matrix4 subtrahend) {
        return subIncr(target.clone(), subtrahend);
    }

    /**
     * Calculates product of matrices 4x4.
     *
     * @param m1 first (left) matrix 4x4
     * @param m2 second (right) matrix 4x4
     * @return matrix 4x4, which represents product of given matrices
     *
     * @since 1.0.0
     */
    public static Matrix4 prod(final Matrix4 m1, final Matrix4 m2) {
        final Matrix4 result = new Mat4();
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
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
     * Calculates product of matrix 4x4 and vector of size 4.
     *
     * @param m    matrix 4x4 (left)
     * @param vCol column vector of size 4 (right)
     * @return vector of size 4, which represents product of given matrix and vector
     *
     * @since 1.0.0
     */
    public static Vector4 prodCol(final Matrix4 m, final Vector4 vCol) {
        final Vector4 result = new Vec4();

        result.setX(m.get(R0, C0) * vCol.x()
                + m.get(R0, C1) * vCol.y()
                + m.get(R0, C2) * vCol.z()
                + m.get(R0, C3) * vCol.w());

        result.setY(m.get(R1, C0) * vCol.x()
                + m.get(R1, C1) * vCol.y()
                + m.get(R1, C2) * vCol.z()
                + m.get(R1, C3) * vCol.w());

        result.setZ(m.get(R2, C0) * vCol.x()
                + m.get(R2, C1) * vCol.y()
                + m.get(R2, C2) * vCol.z()
                + m.get(R2, C3) * vCol.w());

        result.setW(m.get(R3, C0) * vCol.x()
                + m.get(R3, C1) * vCol.y()
                + m.get(R3, C2) * vCol.z()
                + m.get(R3, C3) * vCol.w());

        return result;
    }

    public static Vector4 prodColIncr(final Matrix4 m, final Vector4 vCol) {
        float x, y, z, w;

        x = m.get(R0, C0) * vCol.x()
                + m.get(R0, C1) * vCol.y()
                + m.get(R0, C2) * vCol.z()
                + m.get(R0, C3) * vCol.w();

        y = m.get(R1, C0) * vCol.x()
                + m.get(R1, C1) * vCol.y()
                + m.get(R1, C2) * vCol.z()
                + m.get(R1, C3) * vCol.w();

        z = m.get(R2, C0) * vCol.x()
                + m.get(R2, C1) * vCol.y()
                + m.get(R2, C2) * vCol.z()
                + m.get(R2, C3) * vCol.w();

        w = m.get(R3, C0) * vCol.x()
                + m.get(R3, C1) * vCol.y()
                + m.get(R3, C2) * vCol.z()
                + m.get(R3, C3) * vCol.w();

        vCol.setY(x);
        vCol.setY(y);
        vCol.setZ(z);
        vCol.setW(w);

        return vCol;
    }

    public static Vector4 prodRow(final Matrix4 m, final Vector4 vRow) {
        final Vector4 result = new Vec4();

        result.setX(m.get(R0, C0) * vRow.x()
                + m.get(R1, C0) * vRow.y()
                + m.get(R2, C0) * vRow.z()
                + m.get(R3, C0) * vRow.w());

        result.setY(m.get(R0, C1) * vRow.x()
                + m.get(R1, C1) * vRow.y()
                + m.get(R2, C1) * vRow.z()
                + m.get(R3, C1) * vRow.w());

        result.setZ(m.get(R0, C2) * vRow.x()
                + m.get(R1, C2) * vRow.y()
                + m.get(R2, C2) * vRow.z()
                + m.get(R3, C2) * vRow.w());

        result.setW(m.get(R0, C3) * vRow.x()
                + m.get(R1, C3) * vRow.y()
                + m.get(R2, C3) * vRow.z()
                + m.get(R3, C3) * vRow.w());

        return result;
    }

    public static Vector4 prodRowIncr(final Matrix4 m, final Vector4 vRow) {
        float x, y, z, w;

        x = m.get(R0, C0) * vRow.x()
                + m.get(R0, C1) * vRow.y()
                + m.get(R0, C2) * vRow.z()
                + m.get(R0, C3) * vRow.w();

        y = m.get(R1, C0) * vRow.x()
                + m.get(R1, C1) * vRow.y()
                + m.get(R1, C2) * vRow.z()
                + m.get(R1, C3) * vRow.w();

        z = m.get(R2, C0) * vRow.x()
                + m.get(R2, C1) * vRow.y()
                + m.get(R2, C2) * vRow.z()
                + m.get(R2, C3) * vRow.w();

        w = m.get(R3, C0) * vRow.x()
                + m.get(R3, C1) * vRow.y()
                + m.get(R3, C2) * vRow.z()
                + m.get(R3, C3) * vRow.w();

        vRow.setY(x);
        vRow.setY(y);
        vRow.setZ(z);
        vRow.setW(w);

        return vRow;
    }

    /**
     * Triangulates given matrix 4x4.
     * 
     * @param m matrix 4x4 to be triangulated
     * @return given matrix 4x4, which is triangulated
     *
     * @since 1.0.0
     */
    public static Matrix4 triangulate(final Matrix4 m) {
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
     * Copies given matrix 4x4 and triangulates it.
     * 
     * @param m matrix 4x4 to be triangulated
     * @return new matrix 4x4, which is result of triangulating of given matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 triangulated(final Matrix4 m) {
        return triangulate(m.clone());
    }

    /**
     * Calculates matrix 4x4 determinant.
     * 
     * @param m matrix 4x4 for determinant calculation
     * @return matrix 4x4 determinant
     *
     * @since 1.0.0
     */
    public static float det(final Matrix4 m) {
        float determinant = 0;
        for (final Matrix4Col c : Matrix4Col.values()) {
            determinant += m.get(R0, c) * cofactor(m, R0, c);
        }
        return determinant;
    }

    /**
     * Constructs invertible matrix 4x4 from given matrix 4x4.
     *
     * @param m matrix 4x4 for invertible matrix 4x4 construction
     * @return invertible matrix 4x4
     * @throws RuntimeException if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    public static Matrix4 invertible(final Matrix4 m) throws RuntimeException {
        final Matrix4 result = cofactorMatrix(m);
        final float determinant = det(m);

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exist: determinant is 0");
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
     *
     * @since 1.0.0
     */
    public static Matrix3 minorMatrix(final Matrix4 m, final Matrix4Row r, final Matrix4Col c) {
        final Matrix3 result = new Mat3();
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

                result.set(
                        Matrix3Row.values()[destRow],
                        Matrix3Col.values()[destCol],
                        m.get(ROWS[i], COLS[j]));
                destCol++;
            }
            destCol = 0;
            destRow++;
        }

        return result;
    }

    /**
     * Constructs minor matrix excluding given row and column from given matrix 4x4.
     * 
     * @param m matrix 4x4 for minor matrix construction
     * @param r row index to exclude
     * @param c column index to exclude
     * @return minor matrix excluding given row and column
     *
     * @since 1.0.0
     */
    public static Matrix3 minorMatrix(final Matrix4 m, final int r, final int c) {
        return minorMatrix(m, ROWS[r], COLS[c]);
    }

    /**
     * Calculates cofactor (algebraic complement) from given matrix 4x4 for position
     * of given row and column.
     * 
     * @param m matrix for cofactor calculation
     * @param r row for cofactor calculation
     * @param c column for cofactor calculation
     * @return cofactor value from given positions in given matrix 4x4
     *
     * @since 1.0.0
     */
    public static float cofactor(final Matrix4 m, final Matrix4Row r, final Matrix4Col c) {
        final int coefficient = (r.ordinal() + c.ordinal()) % 2 == 0 ? 1 : -1;
        return coefficient * Matrix3Math.det(minorMatrix(m, r, c));
    }

    /**
     * Calculates cofactor (algebraic complement) from given matrix 4x4 for position
     * of given row and column.
     * 
     * @param m matrix 4x4 for cofactor calculation
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from given positions in given matrix 4x4
     *
     * @since 1.0.0
     */
    public static float cofactor(final Matrix4 m, final int r, final int c) {
        return cofactor(m, ROWS[r], COLS[c]);
    }

    /**
     * Constructs matrix 4x4 of cofactors (algebraic complements)
     * 
     * @param m matrix 4x4 for matrix of cofactors construction
     * @return matrix 4x4 of cofactors
     *
     * @since 1.0.0
     */
    public static Matrix4 cofactorMatrix(final Matrix4 m) {
        final Matrix4 result = new Mat4();
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
                result.set(r, c, cofactor(m, r, c));
            }
        }

        return result;
    }

    /**
     * Returns {@code true} if elements of matrices 4x4 are equal within
     * {@code epsilon} tolerance
     * 
     * @param m1  first matrix 4x4 for comparison
     * @param m2  second matrix 4x4 for comparison
     * @param eps tolerance
     * @return {@code true} if all elements of matrices 4x4 are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equalsEpsilon(final Matrix4 m1, final Matrix4 m2, final float eps) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
                if (!Validator.equalsEpsilon(m1.get(r, c), m2.get(r, c), eps)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if elements of matrices 4x4 are approximately equal
     * 
     * @param m1 first matrix 4x4 for comparison
     * @param m2 second matrix 4x4 for comparison
     * @return {@code true} if all elements of matrices 4x4 are approximately equal,
     *         and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equals(final Matrix4 m1, final Matrix4 m2) {
        return equalsEpsilon(m1, m2, Validator.EPS);
    }

    /**
     * Returns {@code true} if matrix 4x4 elements are approximately equal 0.
     * 
     * @param m matrix 4x4 for analysis
     * @return {@code true} if matrix elements are approximately equal 0, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean isZeroed(final Matrix4 m) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
                if (m.get(r, c) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if matrix 4x4 is diagonal.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix is square diagonal, and {@code false}
     *         otherwise
     *
     * @since 1.0.0
     */
    public static boolean diagonal(final Matrix4 m) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
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

    /**
     * Constructs matrix 4x4 of with all 0 elements.
     * 
     * @return matrix 4x4 with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix4 zeroMatrix() {
        return new Mat4();
    }

    /**
     * Constructs square matrix 4x4 with 1 on main diagonal.
     * 
     * @return square matrix 4x4 with 1 on main diagonal
     *
     * @since 1.0.0
     */
    public static Matrix4 unitMatrix() {
        final Matrix4 result = new Mat4();
        for (int i = 0; i < result.width(); i++) {
            result.set(ROWS[i], COLS[i], 1);
        }

        return result;
    }

    /**
     * Constructs matrix 4x4 from given vector-rows of size 4.
     * 
     * @param v1 of size 4 for matrix 4x4 construction taken as first row
     * @param v2 of size 4 for matrix 4x4 construction taken as second row
     * @param v3 of size 4 for matrix 4x4 construction taken as third row
     * @param v4 of size 4 for matrix 4x4 construction taken as fourth row
     * @return matrix 4x4 with values from vectors of size 4
     *
     * @since 2.1.0
     */
    public static Matrix4 fromVecRows(Vector4 v1, Vector4 v2, Vector4 v3, Vector4 v4) {
        Mat4 result = new Mat4();

        result.set(R0, C0, v1.x());
        result.set(R0, C1, v1.y());
        result.set(R0, C2, v1.z());
        result.set(R0, C3, v1.w());

        result.set(R1, C0, v2.x());
        result.set(R1, C1, v2.y());
        result.set(R1, C2, v2.z());
        result.set(R1, C3, v2.w());

        result.set(R2, C0, v3.x());
        result.set(R2, C1, v3.y());
        result.set(R2, C2, v3.z());
        result.set(R2, C3, v3.w());

        result.set(R3, C0, v4.x());
        result.set(R3, C1, v4.y());
        result.set(R3, C2, v4.z());
        result.set(R3, C3, v4.w());

        return result;
    }

    /**
     * Constructs matrix 4x4 from given vector-columns of size 4.
     * 
     * @param v1 of size 4 for matrix 4x4 construction taken as first column
     * @param v2 of size 4 for matrix 4x4 construction taken as second column
     * @param v3 of size 4 for matrix 4x4 construction taken as third column
     * @param v4 of size 4 for matrix 4x4 construction taken as fourth column
     * @return matrix 4x4 with values from vectors of size 4
     *
     * @since 2.1.0
     */
    public static Matrix4 fromVecCols(Vector4 v1, Vector4 v2, Vector4 v3, Vector4 v4) {
        Mat4 result = new Mat4();

        result.set(R0, C0, v1.x());
        result.set(R1, C0, v1.y());
        result.set(R2, C0, v1.z());
        result.set(R3, C0, v1.w());

        result.set(R0, C1, v2.x());
        result.set(R1, C1, v2.y());
        result.set(R2, C1, v2.z());
        result.set(R3, C1, v2.w());

        result.set(R0, C2, v3.x());
        result.set(R1, C2, v3.y());
        result.set(R2, C2, v3.z());
        result.set(R3, C2, v3.w());

        result.set(R0, C3, v4.x());
        result.set(R1, C3, v4.y());
        result.set(R2, C3, v4.z());
        result.set(R3, C3, v4.w());

        return result;
    }
}
