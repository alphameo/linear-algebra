package io.github.alphameo.linear_algebra.mat;

import static io.github.alphameo.linear_algebra.mat.Matrix3Col.*;
import static io.github.alphameo.linear_algebra.mat.Matrix3Row.*;

import io.github.alphameo.linear_algebra.Validator;
import io.github.alphameo.linear_algebra.vec.Vec3;
import io.github.alphameo.linear_algebra.vec.Vector3;

/**
 * Class with static functions for 3x3 matrices.
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
     * Transposes the given matrix and returns it.
     *
     * @param m square matrix for transpose
     * @return transposed square matrix {@code m}
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
     * Returns the result of the transpose operation of the given matrix.
     *
     * @param m matrix for transpose
     * @return new matrix with elements of transposed matrix {@code m}
     *
     * @since 1.0.0
     */
    public static Matrix3 transposed(final Matrix3 m) {
        return transpose(m.clone());
    }

    /**
     * Swaps the rows of the given matrix and returns it.
     *
     * @param m  matrix for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return matrix {@code m} with swapped rows
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
     * Returns the result of row swapping of the given matrix.
     * 
     * @param m  matrix for row swapping
     * @param r1 first row for swapping
     * @param r2 second row for swapping
     * @return new matrix with elements of matrix {@code m} after swapping rows
     *
     * @since 1.0.0
     */
    public static Matrix3 swappedRows(final Matrix3 m, final Matrix3Row r1, final Matrix3Row r2) {
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
     * Returns the result of column swapping of the given matrix.
     *
     * @param m  matrix for column swapping
     * @param c1 first column for swapping
     * @param c2 second column for swapping
     * @return new matrix with elements of matrix {@code m} after swapping columns
     *
     * @since 1.0.0
     */
    public static Matrix3 swappedCols(final Matrix3 m, final Matrix3Col c1, final Matrix3Col c2) {
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
    public static Matrix3 mulAsgn(final Matrix3 m, final float multiplier) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
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
    public static Matrix3 mul(final Matrix3 m, final float multiplier) {
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
    public static Matrix3 divAsgn(final Matrix3 m, final float divisor) throws ArithmeticException {
        Validator.validateDivisor(divisor);
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
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
    public static Matrix3 div(final Matrix3 m, final float divisor) throws ArithmeticException {
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
    public static Matrix3 addAsgn(final Matrix3 target, final Matrix3 addendum) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
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
    public static Matrix3 add(final Matrix3 target, final Matrix3 addendum) {
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
    public static Matrix3 subAsgn(final Matrix3 target, final Matrix3 subtrahend) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
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
    public static Matrix3 sub(final Matrix3 target, final Matrix3 subtrahend) {
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
     * Returns the result of product of the given matrix and the given
     * vector-column.
     *
     * @param m    matrix for product
     * @param vCol vector-column for product
     * @return new vector, which represents product of matrix {@code m} and
     *         vector-column {@code vCol}
     *
     * @since 1.0.0
     */
    public static Vector3 prod(final Matrix3 m, final Vector3 vCol) {
        return Matrix3Math.prodCol(m, vCol);
    }

    /**
     * Returns the result of the product of the given vector-column and the given
     * matrix.
     *
     * @param m    matrix (left)
     * @param vCol vector-column (right)
     * @return new vector with result of product of matrix {@code m} and vector
     *         {@code vCol}
     *
     * @since 3.0.0
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

    /**
     * Triangulates given matrix and returns it.
     * 
     * @param m matrix to be triangulated
     * @return triangulated matrix {@code m}
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
     * Returns result of triangulation of the given matrix.
     * 
     * @param m matrix to be triangulated
     * @return new matrix, with elements of triangulated matrix {@code m}
     *
     * @since 1.0.0
     */
    public static Matrix3 triangulated(final Matrix3 m) {
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
    public static float det(final Matrix3 m) {
        return m.get(R0, C0) * m.get(R1, C1) * m.get(R2, C2)
                + m.get(R0, C1) * m.get(R1, C2) * m.get(R2, C0)
                + m.get(R0, C2) * m.get(R1, C0) * m.get(R2, C1)
                - m.get(R0, C2) * m.get(R1, C1) * m.get(R2, C0)
                - m.get(R0, C0) * m.get(R1, C2) * m.get(R2, C1)
                - m.get(R0, C1) * m.get(R1, C0) * m.get(R2, C2);
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
    public static Matrix3 inv(final Matrix3 m) throws RuntimeException {
        final Matrix3 result = cofactorMatrix(m);
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
    public static float cofactor(final Matrix3 m, final Matrix3Row r, final Matrix3Col c) {
        final int coefficient = (r.ordinal() + c.ordinal()) % 2 == 0 ? 1 : -1;
        return coefficient * MatrixMath.detCof(minorMatrix(m, r, c));
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
     * Returns {@code true} if elements of the given matrix are approximately equal
     * 0.
     * 
     * @param m matrix for analysis
     * @return {@code true} if elements of matrix {@code m} are approximately equal
     *         0, and {@code false} otherwise
     *
     * @since 1.0.0
     */
    public static boolean zeroed(final Matrix3 m) {
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
     * Returns {@code true} if the given matrix is diagonal.
     * 
     * @param m matrix for analysis
     * @return {@code true} if matrix {@code m} is square diagonal, and
     *         {@code false}
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
    public static boolean equals(final Matrix3 m1, final Matrix3 m2) {
        return equalsEpsilon(m1, m2, Validator.EPS);
    }

    /**
     * Constructs new 4x4 matrix with elements of given 3x3 matrix and 0 on
     * inserted row and column, 1 on intersection of row and column.
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
     * Constructs {@code height}x{@code width}vector with all 0 components.
     * 
     * @return new matrix 3x3 with all 0 elements
     *
     * @since 1.0.0
     */
    public static Matrix3 zeroMatrix() {
        return new Mat3();
    }

    /**
     * Constructs 3x3 matrix with all 1 on main iagonal.
     * 
     * @return new square 3x3 matrix with 1 on main diagonal
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
     * Constructs 3x3 matrix from the given 3-dimensional vector-rows.
     * 
     * @param v1 3-dimensional vector for 3x3 matrix construction taken as first
     *           row
     * @param v2 3-dimensional vector for 3x3 matrix construction taken as second
     *           row
     * @param v3 3-dimensional vector for 3x3 matrix construction taken as third
     *           row
     * @return new 3x3 matrix with values from 3-dimensional vectors
     *         {@code v1}, {@code v2}, {@code v3} as rows
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
     * Constructs 3x3 matrix from the given 3-dimensional vector-columns.
     * 
     * @param v1 3-dimensional vector for 3x3 matrix construction taken as first
     *           column
     * @param v2 3-dimensional vector for 3x3 matrix construction taken as second
     *           column
     * @param v3 3-dimensional vector for 3x3 matrix construction taken as third
     *           column
     * @return new 3x3 matrix with values from 3-dimensional vectors
     *         {@code v1}, {@code v2}, {@code v3} as columns
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
