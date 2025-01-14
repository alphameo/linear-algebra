package io.github.alphameo.linear_algebra.mat;

import static io.github.alphameo.linear_algebra.mat.Matrix4Row.*;
import static io.github.alphameo.linear_algebra.mat.Matrix4Col.*;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.vec.Vec4;
import io.github.alphameo.linear_algebra.vec.Vector4;

/**
 * Class with static functions for 4x4 matrices.
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
     * Transposes the given matrix and returns it.
     *
     * @param m square matrix for transpose
     * @return transposed square matrix {@code m}
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
     * Transposes the given matrix and returns it.
     *
     * @param m square matrix for transpose
     * @return transposed square matrix {@code m}
     *
     * @since 1.0.0
     */
    public static Matrix4 transposed(final Matrix4 m) {
        return transpose(m.clone());
    }

    /**
     * Swaps the rows of the given matrix and returns it.
     *
     * @param m  matrix for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return the given matrix with swapped rows
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
     * Returns the result of row swapping of the given matrix.
     * 
     * @param m  matrix for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix with elements of matrix {@code m} after swapping rows
     *
     * @since 1.0.0
     */
    public static Matrix4 swappedRows(final Matrix4 m, final Matrix4Row r1, final Matrix4Row r2) {
        return swapRows(m.clone(), r1, r2);
    }

    /**
     * Swaps the columns of the given matrix and returns it.
     *
     * @param m  matrix for column swapping
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return matrix {@code m} with swapped columns
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
     * Returns the result of column swapping of the given matrix.
     *
     * @param m  matrix for column swapping
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return new matrix with elements of matrix {@code m} after swapping columns
     *
     * @since 1.0.0
     */
    public static Matrix4 swappedCols(final Matrix4 m, final Matrix4Col c1, final Matrix4Col c2)
            throws ArrayIndexOutOfBoundsException {
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
    public static Matrix4 mulAsgn(final Matrix4 m, final float multiplier) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
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
    public static Matrix4 mul(final Matrix4 m, final float multiplier) {
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
    public static Matrix4 divAsgn(final Matrix4 m, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
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
    public static Matrix4 div(final Matrix4 m, final float divisor) throws ArithmeticException {
        return divAsgn(m.clone(), divisor);
    }

    /**
     * Adds the components of the addendum matrix to the components of the target
     * matrix and returns it.
     * 
     * @param target   matrix to be added
     * @param addendum matrix to add
     * @return matrix {@code target} increased by matrix {@code addendum}
     *
     * @since 1.0.0
     */
    public static Matrix4 addAsgn(final Matrix4 target, final Matrix4 addendum) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
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
     *
     * @since 1.0.0
     */
    public static Matrix4 add(final Matrix4 target, final Matrix4 addendum) {
        return addAsgn(target.clone(), addendum);
    }

    /**
     * Subtracts elements of the subtrahend matrix from the elements of the
     * target matrix and returns it.
     * 
     * @param target     matrix to be subtracted
     * @param subtrahend matrix to subtract
     * @return matrix {@code target} reduced by matrix {@code subtrahend}
     *
     * @since 1.0.0
     */
    public static Matrix4 subAsgn(final Matrix4 target, final Matrix4 subtrahend) {
        for (final Matrix4Row r : ROWS) {
            for (final Matrix4Col c : COLS) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
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
     *
     * @since 1.0.0
     */
    public static Matrix4 sub(final Matrix4 target, final Matrix4 subtrahend) {
        return subAsgn(target.clone(), subtrahend);
    }

    /**
     * Returns the result of product of the given matrices.
     *
     * @param m1 left matrix for product
     * @param m2 right matrix for product
     * @return product of matrix {@code m1} and matrix {@code m2}
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
     * Returns the result of the product of the given matrix and the given
     * vector-column.
     *
     * @param m    matrix (left)
     * @param vCol vector-column (right)
     * @return new vector with result of product of matrix {@code m} and vector
     *         {@code vCol}
     *
     * @since 3.0.0
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

    /**
     * Returns the result of product of the given vector-row and the given matrix.
     *
     * @param m    matrix (right)
     * @param vRow vector-row (left)
     * @return new vector with result of product of vector {@code vCol} and matrix
     *         {@code m}
     *
     * @since 3.0.0
     */
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

    /**
     * Triangulates given matrix and returns it.
     * 
     * @param m matrix to be triangulated
     * @return triangulated matrix {@code m}
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
     * Returns result of triangulation of the given matrix.
     * 
     * @param m matrix to be triangulated
     * @return new matrix, with elements of triangulated matrix {@code m}
     *
     * @since 1.0.0
     */
    public static Matrix4 triangulated(final Matrix4 m) {
        return triangulate(m.clone());
    }

    /**
     * Returns determinant of the given matrix.
     * 
     * @param m matrix for determinant calculation
     * @return determinant of matrix {@code m}
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
     * Returns invertible matrix of the given matrix.
     *
     * @param m matrix for invertible matrix construction
     * @return new invertible matrix for matrix {@code m}
     * @throws RuntimeException if matrix determinant equals to 0
     *
     * @since 1.0.0
     */
    public static Matrix4 inv(final Matrix4 m) throws RuntimeException {
        final Matrix4 result = cofactorMatrix(m);
        final float determinant = det(m);

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exist: determinant is 0");
        }
        transpose(result);
        mulAsgn(result, 1 / determinant);
        return result;
    }

    /**
     * Returns minor matrix from the given matrix excluding given row and column
     * from given matrix.
     * 
     * @param m matrix for minor matrix construction
     * @param r row to exclude
     * @param c column to exclude
     * @return new minor matrix excluding row {@code r} and column {@code c}
     *         from matrix {@code m}
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
     * Returns cofactor (algebraic complement) from the given matrix for position of
     * given row and column.
     * 
     * @param m matrix for cofactor calculation
     * @param r row for cofactor calculation
     * @param c column for cofactor calculation
     * @return cofactor value for row {@code r} and column {@code c} for the given
     *         positions in the given matrix
     *
     * @since 1.0.0
     */
    public static float cofactor(final Matrix4 m, final Matrix4Row r, final Matrix4Col c) {
        final int coefficient = (r.ordinal() + c.ordinal()) % 2 == 0 ? 1 : -1;
        return coefficient * Matrix3Math.det(minorMatrix(m, r, c));
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
     * Returns {@code true} if elements of the given matrix are approximately equal
     * 0.
     * 
     * @param m matrix for analysis
     * @return {@code true} if elements of matrix {@code m} are approximately equal
     *         0, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean zeroed(final Matrix4 m) {
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
     * Returns {@code true} if the given matrix is diagonal.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix {@code m} is square diagonal, and
     *         {@code false}
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
     * Returns {@code true} if elements of matrices are equal within
     * {@code epsilon} tolerance.
     * 
     * @param m1  first matrix for comparison
     * @param m2  second matrix for comparison
     * @param eps tolerance
     * @return {@code true} if all elements of matrices are equal within
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
     * Returns {@code true} if the elements of the given matrices are approximately
     * equal.
     * 
     * @param m1 first matrix for comparison
     * @param m2 second matrix for comparison
     * @return {@code true} if all elements of matrices are approximately equal, and
     *         {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean equals(final Matrix4 m1, final Matrix4 m2) {
        return equalsEpsilon(m1, m2, Validator.EPS);
    }

    /**
     * Constructs {@code height}x{@code width}vector with all 0 components.
     * 
     * @return new matrix 3x3 with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix4 zeroMatrix() {
        return new Mat4();
    }

    /**
     * Constructs 4x4 matrix with all 1 on main iagonal.
     * 
     * @return new 4x4 matrix with 1 on main diagonal
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
     * Constructs 4x4 matrix from the given 4-dimensional vector-rows.
     * 
     * @param v1 4-dimensional vector for 4x4 matrix construction taken as first
     *           row
     * @param v2 4-dimensional vector for 4x4 matrix construction taken as second
     *           row
     * @param v3 4-dimensional vector for 4x4 matrix construction taken as third
     *           row
     * @param v4 4-dimensional vector for 4x4 matrix construction taken as fourth
     *           row
     * @return new 4x4 matrix with values from 4-dimensional vectors
     *         {@code v1}, {@code v2}, {@code v3}, {@code v4} as rows
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
     * Constructs 4x4 matrix from the given 4-dimensional vector-columns.
     * 
     * @param v1 4-dimensional vector for 4x4 matrix construction taken as first
     *           column
     * @param v2 4-dimensional vector for 4x4 matrix construction taken as second
     *           column
     * @param v3 4-dimensional vector for 4x4 matrix construction taken as third
     *           column
     * @param v4 4-dimensional vector for 4x4 matrix construction taken as fourth
     *           column
     * @return new 4x4 matrix with values from 4-dimensional vectors
     *         {@code v1}, {@code v2}, {@code v3}, {@code v4} as columns
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
