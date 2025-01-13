package io.github.alphameo.linear_algebra.mat;

import static io.github.alphameo.linear_algebra.mat.Matrix3Col.*;
import static io.github.alphameo.linear_algebra.mat.Matrix3Row.*;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.vec.Vec3;
import io.github.alphameo.linear_algebra.vec.Vector3;

/**
 * Class with static functions for matrices 3x3.
 *
 * @since 1.0.0
 */
public final class Matrix3Math {

    /**
     * Default empty constructor
     *
     * @since 1.0.0
     */
    public Matrix3Math() {
    }

    /**
     * Constant array of enums for fast and safe access to matrix 3x3 rows
     *
     * @since 1.0.0
     */
    public static final Matrix3Row[] ROWS = Matrix3Row.values();

    /**
     * Constant array of enums for fast and safe access to matrix 3x3 columns
     *
     * @since 1.0.0
     */
    public static final Matrix3Col[] COLS = Matrix3Col.values();

    /**
     * Transposes the given matrix 3x3
     *
     * @param m matrix 3x3 for transpose
     * @return the given matrix 3x3, which is transposed
     *
     * @since 1.0.0
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
     * Copies the given matrix 3x3 and transpose it.
     * 
     * @param m matrix 3x3 for transpose
     * @return new matrix 3x3, which is result of transposing of the given matrix 3x3
     *
     * @since 1.0.0
     */
    public static Matrix3 transposed(final Matrix3 m) {
        return transpose(m.clone());
    }

    /**
     * Safely swaps rows of matrix 3x3
     *
     * @param m  matrix 3x3 for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return the given matrix 3x3 with swapped rows
     *
     * @since 1.0.0
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
     * @return the given 3x3 matrix with swapped rows
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix3 swapRows(final Matrix3 m, final int r1, final int r2) throws ArrayIndexOutOfBoundsException {
        return swapRows(m, ROWS[r1], ROWS[r2]);
    }

    /**
     * Copies the given matrix 3x3 and safely swaps its rows.
     * 
     * @param m  matrix 3x3 for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix 3x3 with swapped rows of given matrix 3x3
     *
     * @since 1.0.0
     */
    public static Matrix3 swappedRows(final Matrix3 m, final Matrix3Row r1, final Matrix3Row r2) {
        return swapRows(m.clone(), r1, r2);
    }

    /**
     * Copies given matrix 3x3 and swaps its rows.
     * 
     * @param m  matrix 3x3 for row swapping
     * @param r1 first index of row for swapping
     * @param r2 second index of row for swapping
     * @return new matrix 3x3 with swapped rows of given matrix 3x3
     * @throws ArrayIndexOutOfBoundsException if any row index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix3 swappedRows(final Matrix3 m, final int r1, final int r2)
            throws ArrayIndexOutOfBoundsException {
        return swappedRows(m, ROWS[r1], ROWS[r2]);
    }

    /**
     * Safely swaps columns of matrix 3x3
     *
     * @param m  matrix 3x3 for column swapping
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return given matrix 3x3 with swapped columns
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
     */
    public static Matrix3 swappedCols(final Matrix3 m, final Matrix3Col c1, final Matrix3Col c2) {
        return swapCols(m.clone(), c1, c2);
    }

    /**
     * Copies given matrix 3x3 and safely swaps columns
     *
     * @param m  matrix 3x3 for column swapping
     * @param c1 first index of column for swapping
     * @param c2 second index of column for swapping
     * @return new matrix 3x3 with swapped columns of given matrix 3x3
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix3 swappedCols(final Matrix3 m, final int c1, final int c2)
            throws ArrayIndexOutOfBoundsException {
        return swappedCols(m, COLS[c1], COLS[c2]);
    }

    /**
     * Multiplies matrix 3x3 elements by a scalar value.
     * 
     * @param m          matrix 3x3 for multiplication
     * @param multiplier scalar value
     * @return given matrix 3x3 with multiplied elements
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
     */
    public static Matrix3 multiplied(final Matrix3 m, final float multiplier) {
        return mult(m.clone(), multiplier);
    }

    /**
     * Divides matrix 3x3 elements by a scalar value.
     * 
     * @param m       matrix 3x3 for division
     * @param divisor scalar value
     * @return given matrix 3x3 with divided elements
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    public static Matrix3 divide(final Matrix3 m, final float divisor) throws ArithmeticException {
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
     * @throws ArithmeticException if {@code divisor} approximately equals 0
     *
     * @since 1.0.0
     */
    public static Matrix3 divided(final Matrix3 m, final float divisor) throws ArithmeticException {
        return divide(m.clone(), divisor);
    }

    /**
     * Adds the {@code addendum} matrix 3x3 elements to the {@code target} matrix
     * 3x3 elements.
     * 
     * @param target   matrix 3x3 to be added
     * @param addendum matrix 3x3 to add
     * @return {@code target} matrix 3x3 increased by {@code addendum} matrix 3x3
     *
     * @since 1.0.0
     */
    public static Matrix3 addIncr(final Matrix3 target, final Matrix3 addendum) {
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
     *
     * @since 1.0.0
     */
    public static Matrix3 add(final Matrix3 target, final Matrix3 addendum) {
        return addIncr(target.clone(), addendum);
    }

    /**
     * Subtracts the {@code subtrahend} matrix 3x3 elements from the {@code target}
     * matrix 3x3 elements.
     * 
     * @param target     matrix 3x3 to be subtracted
     * @param subtrahend matrix 3x3 to subtract
     * @return {@code target} matrix 3x3 subtracted by {@code addendum} matrix 3x3
     *
     * @since 1.0.0
     */
    public static Matrix3 subIncr(final Matrix3 target, final Matrix3 subtrahend) {
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
     * @return new matrix 4x4 with components resulting {@code target} matrix 4x4
     *         subtracted by {@code subtrahend} matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix3 sub(final Matrix3 target, final Matrix3 subtrahend) {
        return subIncr(target.clone(), subtrahend);
    }

    /**
     * Calculates product of matrices 3x3.
     *
     * @param m1 first (left) matrix 3x3
     * @param m2 second (right) matrix 3x3
     * @return matrix 3x3, which represents product of given matrices
     *
     * @since 1.0.0
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
     * @param m    matrix 3x3 (left)
     * @param vCol column vector of size 3 (right)
     * @return vector of size 3, which represents product of given matrix and vector
     *
     * @since 1.0.0
     */
    public static Vector3 prodCol(final Matrix3 m, final Vector3 vCol) {
        final Vector3 result = new Vec3();

        result.setX(m.get(R0, C0) * vCol.x()
                + m.get(R0, C1) * vCol.y()
                + m.get(R0, C2) * vCol.z());

        result.setY(m.get(R1, C0) * vCol.x()
                + m.get(R1, C1) * vCol.y()
                + m.get(R1, C2) * vCol.z());

        result.setZ(m.get(R2, C0) * vCol.x()
                + m.get(R2, C1) * vCol.y()
                + m.get(R2, C2) * vCol.z());

        return result;
    }

    public static Vector3 prodColIncr(final Matrix3 m, final Vector3 vCol) {
        float x, y, z;
        x = m.get(R0, C0) * vCol.x()
                + m.get(R0, C1) * vCol.y()
                + m.get(R0, C2) * vCol.z();

        y = m.get(R1, C0) * vCol.x()
                + m.get(R1, C1) * vCol.y()
                + m.get(R1, C2) * vCol.z();

        z = m.get(R2, C0) * vCol.x()
                + m.get(R2, C1) * vCol.y()
                + m.get(R2, C2) * vCol.z();

        vCol.setX(x);
        vCol.setY(y);
        vCol.setZ(z);

        return vCol;
    }

    public static Vector3 prodRow(final Matrix3 m, final Vector3 vRow) {
        final Vector3 result = new Vec3();

        result.setX(m.get(R0, C0) * vRow.x()
                + m.get(R1, C0) * vRow.y()
                + m.get(R2, C0) * vRow.z());

        result.setY(m.get(R0, C1) * vRow.x()
                + m.get(R1, C1) * vRow.y()
                + m.get(R2, C1) * vRow.z());

        result.setZ(m.get(R0, C2) * vRow.x()
                + m.get(R1, C2) * vRow.y()
                + m.get(R2, C2) * vRow.z());

        return result;
    }

    public static Vector3 prodRowIncr(final Matrix3 m, final Vector3 vRow) {
        float x, y, z;
        x = m.get(R0, C0) * vRow.x()
                + m.get(R1, C0) * vRow.y()
                + m.get(R2, C0) * vRow.z();

        y = m.get(R0, C1) * vRow.x()
                + m.get(R1, C1) * vRow.y()
                + m.get(R2, C1) * vRow.z();

        z = m.get(R0, C2) * vRow.x()
                + m.get(R1, C2) * vRow.y()
                + m.get(R2, C2) * vRow.z();

        vRow.setX(x);
        vRow.setY(y);
        vRow.setZ(z);

        return vRow;
    }

    /**
     * Triangulates given matrix 3x3.
     * 
     * @param m matrix 3x3 to be triangulated
     * @return given matrix 3x3, which is triangulated
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
     */
    public static Matrix3 triangulated(final Matrix3 m) {
        return triangulate(m.clone());
    }

    /**
     * Calculates matrix 3x3 determinant.
     * 
     * @param m matrix 3x3 for determinant calculation
     * @return matrix 3x3 determinant
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
     */
    public static Matrix3 invertible(final Matrix3 m) throws RuntimeException {
        final Matrix3 result = cofactorMatrix(m);
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
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
     */
    public static float cofactor(final Matrix3 m, final Matrix3Row r, final Matrix3Col c) {
        final int coefficient = (r.ordinal() + c.ordinal()) % 2 == 0 ? 1 : -1;
        return coefficient * MatrixMath.detThroughCofactors(minorMatrix(m, r, c));
    }

    /**
     * Calculates cofactor (algebraic complement) from given matrix 3x3 for position
     * of given row and column.
     * 
     * @param m matrix 3x3 for cofactor calculation
     * @param r index of row for cofactor calculation
     * @param c index of column for cofactor calculation
     * @return cofactor value from given positions in given matrix 3x3
     *
     * @since 1.0.0
     */
    public static float cofactor(final Matrix3 m, final int r, final int c) {
        return cofactor(m, ROWS[r], COLS[c]);
    }

    /**
     * Constructs matrix 3x3 of cofactors (algebraic complements)
     * 
     * @param m matrix 3x3 for matrix of cofactors construction
     * @return matrix 3x3 of cofactors
     *
     * @since 1.0.0
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
     * Returns {@code true} if matrix 3x3 elements are approximately equal 0.
     * 
     * @param m matrix 3x3 for analysis
     * @return {@code true} if matrix elements are approximately equal 0, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
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
     *
     * @since 1.0.0
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

    /**
     * Safely constructs new matrix 4x4 with elements of given matrix 3x3 and 0 on
     * inserted
     * row and column, 1 on intersection of row and column.
     * <p>
     * example for insertionRow = 2, insertionCol = 2:
     * 
     * <pre>
     * ⎡ m00 m01 0 m02 ⎤
     *⎢  0   0  1  0  ⎥
     *⎢ m10 m11 0 m12 ⎥
     *⎣ m20 m21 0 m22 ⎦
     * </pre>
     * 
     * @param m            matrix 3x3
     * @param insertionRow row for insertion 0
     * @param insertionCol column for insertion 0
     * @return new matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 toMatrix4(final Matrix3 m, final Matrix4Row insertionRow, final Matrix4Col insertionCol) {
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

    /**
     * Constructs new matrix 4x4 with elements of given matrix 3x3 and 0 on inserted
     * row and column, 1 at intersection of row and column.
     * <p>
     * example for insertionRow = R2, insertionCol = C2:
     * 
     * <pre>
     * ⎡ m00 m01 0 m02 ⎤
     *⎢  0   0  1  0  ⎥
     *⎢ m10 m11 0 m12 ⎥
     *⎣ m20 m21 0 m22 ⎦
     * </pre>
     * 
     * @param m            matrix 3x3
     * @param insertionRow row index for insertion 0
     * @param insertionCol column index for insertion 0
     * @return new matrix 4x4
     * @throws ArrayIndexOutOfBoundsException if any column index is out of bounds
     *
     * @since 1.0.0
     */
    public static Matrix4 toMat4(final Matrix3 m, final int insertionRow, final int insertionCol)
            throws ArrayIndexOutOfBoundsException {
        return toMatrix4(
                m,
                Matrix4Row.values()[insertionRow],
                Matrix4Col.values()[insertionCol]);
    }

    /**
     * Constructs new matrix 4x4 with elements of given matrix 3x3 and 0 on last
     * row and last column, 1 at right down corner.
     * <p>
     * example for insertionRow = 2, insertionCol = 2:
     * 
     * <pre>
     * ⎡ m00 m01 m02 0 ⎤
     *⎢ m10 m11 m12 0 ⎥
     *⎢ m20 m21 m22 0 ⎥ 
     *⎣  0   0   0  1 ⎦
     * </pre>
     * 
     * @param m matrix 3x3
     * @return new matrix 4x4
     *
     * @since 1.0.0
     */
    public static Matrix4 toMatrix4(final Matrix3 m) {
        return toMatrix4(m, Matrix4Row.R3, Matrix4Col.C3);
    }

    /**
     * Returns {@code true} if elements of matrices 3x3 are equal within
     * {@code epsilon} tolerance
     * 
     * @param m1  first matrix 3x3 for comparison
     * @param m2  second matrix 3x3 for comparison
     * @param eps tolerance
     * @return {@code true} if all elements of matrices 3x3 are equal within
     *         {@code epsilon} tolerance, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equalsEpsilon(final Matrix3 m1, final Matrix3 m2, final float eps) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                if (!Validator.equalsEpsilon(m1.get(r, c), m2.get(r, c), eps)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns {@code true} if elements of matrices 3x3 are approximately equal
     * 
     * @param m1 first matrix 3x3 for comparison
     * @param m2 second matrix 3x3 for comparison
     * @return {@code true} if all elements of matrices 3x3 are approximately equal,
     *         and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equals(final Matrix3 m1, final Matrix3 m2) {
        return equalsEpsilon(m1, m2, Validator.EPS);
    }

    /**
     * Constructs matrix 3x3 of with all 0 elements.
     * 
     * @return matrix 3x3 with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix3 zeroMatrix() {
        return new Mat3();
    }

    /**
     * Constructs square matrix 3x3 with 1 on main diagonal.
     * 
     * @return square matrix 3x3 with 1 on main diagonal
     *
     * @since 1.0.0
     */
    public static Matrix3 unitMatrix() {
        final Matrix3 result = new Mat3();
        for (int i = 0; i < result.width(); i++) {
            result.set(ROWS[i], COLS[i], 1);
        }

        return result;
    }

    /**
     * Constructs matrix 3x3 from given vector-rows of size 3.
     * 
     * @param v1 of size 3 for matrix 3x3 construction taken as first row
     * @param v2 of size 3 for matrix 3x3 construction taken as second row
     * @param v3 of size 3 for matrix 3x3 construction taken as third row
     * @return matrix 3x3 with values from vectors of size 3
     *
     * @since 2.1.0
     */
    public static Matrix3 fromVecRows(Vector3 v1, Vector3 v2, Vector3 v3) {
        Mat3 result = new Mat3();

        result.set(R0, C0, v1.x());
        result.set(R0, C1, v1.y());
        result.set(R0, C2, v1.z());

        result.set(R1, C0, v2.x());
        result.set(R1, C1, v2.y());
        result.set(R1, C2, v2.z());

        result.set(R2, C0, v3.x());
        result.set(R2, C1, v3.y());
        result.set(R2, C2, v3.z());

        return result;
    }

    /**
     * Constructs matrix 3x3 from given vector-columns of size 3.
     * 
     * @param v1 of size 3 for matrix 3x3 construction taken as first column
     * @param v2 of size 3 for matrix 3x3 construction taken as second column
     * @param v3 of size 3 for matrix 3x3 construction taken as third column
     * @return matrix 3x3 with values from vectors of size 3
     *
     * @since 2.1.0
     */
    public static Matrix3 fromVecCols(Vector3 v1, Vector3 v2, Vector3 v3) {
        Mat3 result = new Mat3();

        result.set(R0, C0, v1.x());
        result.set(R1, C0, v1.y());
        result.set(R2, C0, v1.z());

        result.set(R0, C1, v2.x());
        result.set(R1, C1, v2.y());
        result.set(R2, C1, v2.z());

        result.set(R0, C2, v3.x());
        result.set(R1, C2, v3.y());
        result.set(R2, C2, v3.z());

        return result;
    }
}
