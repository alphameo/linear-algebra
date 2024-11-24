package com.github.ia1phai.linear_algebra.mat;

import com.github.ia1phai.linear_algebra.NumberChecker;
import com.github.ia1phai.linear_algebra.vec.Vec4;
import com.github.ia1phai.linear_algebra.vec.Vector4;

import static com.github.ia1phai.linear_algebra.mat.Matrix4Row.*;
import static com.github.ia1phai.linear_algebra.mat.Matrix4Col.*;

/**
 * UncheckedMatrixOperations
 */
public class Mat4Math {

    public static Matrix4Row[] ROWS = Matrix4Row.values();
    public static Matrix4Col[] COLS = Matrix4Col.values();

    public static void transpose(final Matrix4 m) {
        for (int i = 0; i < m.width(); i++) {
            for (int j = i + 1; j < m.width(); j++) {
                final float tmp = m.get(ROWS[i], COLS[j]);
                m.set(ROWS[i], COLS[j], m.get(ROWS[j], COLS[i]));
                m.set(ROWS[j], COLS[i], tmp);
            }
        }
    }

    public static void swapRows(final Matrix4 m, final Matrix4Row r1, final Matrix4Row r2) {
        float tmp;
        for (Matrix4Col c : COLS) {
            tmp = m.get(r1, c);
            m.set(r1, c, m.get(r2, c));
            m.set(r2, c, tmp);
        }
    }

    public static void swapCols(final Matrix4 m, final Matrix4Col c1, final Matrix4Col c2) {
        float tmp;
        for (Matrix4Row r : ROWS) {
            tmp = m.get(r, c1);
            m.set(r, c1, m.get(r, c2));
            m.set(r, c2, tmp);
        }
    }

    public static void multiply(final Matrix4 m, final float multiplier) {
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
                m.set(r, c, m.get(r, c) * multiplier);
            }
        }
    }

    public static void divide(final Matrix4 m, final float divisor) {
        NumberChecker.checkDivisor(divisor);
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
                m.set(r, c, m.get(r, c) / divisor);
            }
        }
    }

    public static void add(final Matrix4 target, final Matrix4 addendum) {
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
                target.set(r, c, target.get(r, c) + addendum.get(r, c));
            }
        }
    }

    public static void subtract(final Matrix4 target, final Matrix4 subtrahend) {
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
            }
        }
    }

    public static Matrix4 product(final Matrix4 m1, final Matrix4 m2) {
        Matrix4 result = new Mat4();
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
                float value = 0;
                for (int i = 0; i < m1.height(); i++) {
                    value += m1.get(r, COLS[i]) * m2.get(ROWS[i], c);
                }
                result.set(r, c, value);
            }
        }

        return result;
    }

    public static Vector4 product(final Matrix4 m, final Vector4 v) {
        Vector4 result = new Vec4();
        for (int i = 0; i < m.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < v.size(); elem++) {
                value += m.get(ROWS[i], COLS[elem]) * v.get(elem);
            }

            result.set(i, value);
        }

        return result;
    }

    public static void triangulate(final Matrix4 m) {
        int countOfSwaps = 0;

        for (int i = 0; i < m.width(); i++) {
            if (Math.abs(m.get(ROWS[i], COLS[i])) < NumberChecker.EPS) {
                boolean isNonZeroFound = false;

                for (Matrix4Row r : ROWS) {
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

            for (Matrix4Row r : ROWS) {
                final float coefficient = -(m.get(r, COLS[i]) / m.get(ROWS[i], COLS[i]));

                for (Matrix4Col c : COLS) {
                    m.set(r, c, m.get(r, c) + coefficient * m.get(ROWS[i], c));
                }
            }
        }

        if (countOfSwaps % 2 == 1) {
            for (int i = 0; i < m.width(); i++) {
                m.set(R0, COLS[i], m.get(R0, COLS[i]) * -1);
            }
        }
    }

    public static float det(final Matrix4 m) {
        // TODO: Determinant
        return m.get(R0, C0) * m.get(R1, C1) * m.get(R2, C2)
                + m.get(R0, C1) * m.get(R1, C2) * m.get(R2, C0)
                + m.get(R0, C2) * m.get(R1, C0) * m.get(R2, C1)
                - m.get(R0, C2) * m.get(R1, C1) * m.get(R2, C0)
                - m.get(R0, C0) * m.get(R1, C2) * m.get(R2, C1)
                - m.get(R0, C1) * m.get(R1, C0) * m.get(R2, C2);
    }

    public static Matrix4 invertibleMatrix(final Matrix4 m) {
        Matrix4 result = cofactorMatrix(m);
        float determinant = det(m);

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exitst: determinant is 0");
        }
        transpose(result);
        multiply(result, 1 / determinant);
        return result;
    }

    public static Matrix minorMatrix(final Matrix4 m, final Matrix4Row row, final Matrix4Col col) {
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

    public static float cofactor(final Matrix4 m, final Matrix4Row r, final Matrix4Col c) {
        final int coefficient = (r.ordinal() + c.ordinal()) % 2 == 0 ? 1 : -1;
        return coefficient * MatMath.determinant(minorMatrix(m, r, c));
    }

    public static Matrix4 cofactorMatrix(final Matrix4 m) {
        Matrix4 result = new Mat4();
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
                result.set(r, c, cofactor(m, r, c));
            }
        }

        return result;
    }

    public static boolean equals(final Matrix4 target, final Matrix4 subtrahend) {
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
                if (Math.abs(target.get(r, c) - subtrahend.get(r, c)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isSquare(Matrix4 m) {
        return true;
    }

    public static boolean isZeroed(Matrix4 m) {
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
                if (m.get(r, c) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isDiagonal(Matrix4 m) {
        for (Matrix4Row r : ROWS) {
            for (Matrix4Col c : COLS) {
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
}
