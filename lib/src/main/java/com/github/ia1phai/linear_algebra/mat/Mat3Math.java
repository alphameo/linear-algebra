package com.github.ia1phai.linear_algebra.mat;

import com.github.ia1phai.linear_algebra.NumberChecker;
import com.github.ia1phai.linear_algebra.vec.Vec3;
import com.github.ia1phai.linear_algebra.vec.Vector3;

import static com.github.ia1phai.linear_algebra.mat.Matrix3Row.*;
import static com.github.ia1phai.linear_algebra.mat.Matrix3Col.*;

/**
 * UncheckedMatrixOperations
 */
public class Mat3Math {

    public static final Matrix3Row[] ROWS = Matrix3Row.values();
    public static final Matrix3Col[] COLS = Matrix3Col.values();

    public static void transpose(final Matrix3 m) {
        for (int i = 0; i < m.width(); i++) {
            for (int j = i + 1; j < m.width(); j++) {
                final float tmp = m.get(ROWS[i], COLS[j]);
                m.set(ROWS[i], COLS[j], m.get(ROWS[j], COLS[i]));
                m.set(ROWS[j], COLS[i], tmp);
            }
        }
    }

    public static void swapRows(final Matrix3 m, final Matrix3Row r1, final Matrix3Row r2) {
        float tmp;
        for (final Matrix3Col c : COLS) {
            tmp = m.get(r1, c);
            m.set(r1, c, m.get(r2, c));
            m.set(r2, c, tmp);
        }
    }

    public static void swapCols(final Matrix3 m, final Matrix3Col c1, final Matrix3Col c2) {
        float tmp;
        for (final Matrix3Row r : ROWS) {
            tmp = m.get(r, c1);
            m.set(r, c1, m.get(r, c2));
            m.set(r, c2, tmp);
        }
    }

    public static void multiply(final Matrix3 m, final float multiplier) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                m.set(r, c, m.get(r, c) * multiplier);
            }
        }
    }

    public static void divide(final Matrix3 m, final float divisor) {
        NumberChecker.checkDivisor(divisor);
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                m.set(r, c, m.get(r, c) / divisor);
            }
        }
    }

    public static void add(final Matrix3 target, final Matrix3 addendum) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                target.set(r, c, target.get(r, c) + addendum.get(r, c));
            }
        }
    }

    public static void subtract(final Matrix3 target, final Matrix3 subtrahend) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
            }
        }
    }

    public static Matrix3 product(final Matrix3 m1, final Matrix3 m2) {
        final Matrix3 result = new Mat3();
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                float value = 0;
                for (int i = 0; i < m1.height(); i++) {
                    value += m1.get(r, COLS[i]) * m2.get(ROWS[i], c);
                }
                result.set(r, c, value);
            }
        }

        return result;
    }

    public static Vector3 product(final Matrix3 m, final Vector3 v) {
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

    public static Matrix3 triangulate(final Matrix3 m) {
        int countOfSwaps = 0;

        for (int i = 0; i < m.width(); i++) {
            if (Math.abs(m.get(ROWS[i], COLS[i])) < NumberChecker.EPS) {
                boolean isNonZeroFound = false;

                for (final Matrix3Row r : ROWS) {
                    if (m.get(r, COLS[i]) != 0) {
                        swapRows(m, ROWS[i], r);
                        countOfSwaps++;
                        isNonZeroFound = true;
                        break;
                    }
                }

                if (!isNonZeroFound)
                    continue;
            }

            for (final Matrix3Row r : ROWS) {
                final float coefficient = -(m.get(r, COLS[i]) / m.get(ROWS[i], COLS[i]));

                for (final Matrix3Col c : COLS) {
                    m.set(r, c, m.get(r, c) + coefficient * m.get(ROWS[i], c));
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

    public static float det(final Matrix3 m) {
        return m.get(R0, C0) * m.get(R1, C1) * m.get(R2, C2)
                + m.get(R0, C1) * m.get(R1, C2) * m.get(R2, C0)
                + m.get(R0, C2) * m.get(R1, C0) * m.get(R2, C1)
                - m.get(R0, C2) * m.get(R1, C1) * m.get(R2, C0)
                - m.get(R0, C0) * m.get(R1, C2) * m.get(R2, C1)
                - m.get(R0, C1) * m.get(R1, C0) * m.get(R2, C2);
    }

    public static Matrix3 invertible(final Matrix3 m) {
        final Matrix3 result = cofactorMatrix(m);
        final float determinant = det(m);

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exitst: determinant is 0");
        }
        transpose(result);
        multiply(result, 1 / determinant);
        return result;
    }

    public static Matrix minorMatrix(final Matrix3 m, final Matrix3Row row, final Matrix3Col col) {
        final Matrix result = new Mat(2);
        int destRow = 0;
        int destCol = 0;
        for (int i = 0; i < m.width(); i++) {
            if (i == row.ordinal()) {
                continue;
            }
            for (int j = 0; j < m.width(); j++) {
                if (j == col.ordinal()) {
                    continue;
                }

                result.set(destRow, destCol, m.get(ROWS[i], COLS[j]));
                destCol++;
            }
            destRow++;
        }
        return result;
    }

    public static float cofactor(final Matrix3 m, final Matrix3Row r, final Matrix3Col c) {
        final int coefficient = (r.ordinal() + c.ordinal()) % 2 == 0 ? 1 : -1;
        return coefficient * MatMath.det(minorMatrix(m, r, c));
    }

    public static Matrix3 cofactorMatrix(final Matrix3 m) {
        final Matrix3 result = new Mat3();
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                result.set(r, c, cofactor(m, r, c));
            }
        }

        return result;
    }

    public static boolean equals(final Matrix3 target, final Matrix3 subtrahend) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                if (Math.abs(target.get(r, c) - subtrahend.get(r, c)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isSquare(final Matrix3 m) {
        return true;
    }

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

    public static boolean isDiagonal(final Matrix3 m) {
        for (final Matrix3Row r : ROWS) {
            for (final Matrix3Col c : COLS) {
                if (r.ordinal() == c.ordinal()) {
                    continue;
                }
                if (Math.abs(m.get(r, c)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Matrix4 toMat4(final Matrix3 m, final Matrix4Row insertionRow, final Matrix4Col insertionCol) {
        final Matrix4 result = new Mat4();
        for (int r = 0; r < 3; r++) {
            if (r == insertionCol.ordinal()) {
                continue;
            }
            for (int c = 0; c < 3; c++) {
                if (c == insertionCol.ordinal()) {
                    continue;
                }
                result.set(Matrix4Row.values()[r], Matrix4Col.values()[c], m.get(ROWS[r], COLS[c]));
            }
        }

        result.set(insertionRow, insertionCol, 1);

        return result;
    }

    public static Matrix4 toMat4(final Matrix3 m) {
        return toMat4(m, Matrix4Row.R3, Matrix4Col.C3);
    }

    public static Matrix3 zeroMat() {
        return new Mat3();
    }

    public static Matrix3 unitMat() {
        final Matrix3 result = new Mat3();
        for (int i = 0; i < 3; i++) {
            result.set(ROWS[i], COLS[i], 1);
        }

        return result;
    }
}
