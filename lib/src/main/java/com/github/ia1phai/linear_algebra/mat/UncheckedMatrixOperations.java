package com.github.ia1phai.linear_algebra.mat;

import com.github.ia1phai.linear_algebra.NumberChecker;
import com.github.ia1phai.linear_algebra.vec.Vector;

/**
 * UncheckedMatrixOperations
 */
public class UncheckedMatrixOperations {

    public static void transposeSquare(final Matrix m) {
        for (int i = 0; i < m.width(); i++) {
            for (int j = i + 1; j < m.width(); j++) {
                final float tmp = m.get(i, j);
                m.set(i, j, m.get(j, i));
                m.set(j, i, tmp);
            }
        }
    }

    public static void swapRows(final Matrix m, final int r1, final int r2) {
        float tmp;
        for (int i = 0; i < m.width(); i++) {
            tmp = m.get(r1, i);
            m.set(r1, i, m.get(r2, i));
            m.set(r2, i, tmp);
        }
    }

    public static void swapColumns(final Matrix m, final int c1, final int c2) {
        float tmp;
        for (int i = 0; i < m.height(); i++) {
            tmp = m.get(i, c1);
            m.set(i, c1, m.get(i, c2));
            m.set(i, c2, tmp);
        }
    }

    public static void multiply(final Matrix m, final float multiplier) {
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                m.set(i, j, m.get(i, j) * multiplier);
            }
        }
    }

    public static void divide(final Matrix m, final float divisor) {
        NumberChecker.checkDivisor(divisor);
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                m.set(i, j, m.get(i, j) / divisor);
            }
        }
    }

    public static void add(final Matrix target, final Matrix addendum) {
        for (int i = 0; i < target.height(); i++) {
            for (int j = 0; i < addendum.width(); j++) {
                target.set(i, j, target.get(i, j) + addendum.get(i, j));
            }
        }
    }

    public static void subtract(final Matrix target,
            final Matrix subtrahend) {
        for (int i = 0; i < target.height(); i++) {
            for (int j = 0; i < subtrahend.width(); j++) {
                target.set(i, j, target.get(i, j) - subtrahend.get(i, j));
            }
        }
    }

    public static void product(final Matrix m1,
            final Matrix m2, final Matrix outM) {
        for (int i = 0; i < m1.height(); i++) {
            for (int j = 0; j < m2.width(); j++) {
                float value = 0;
                for (int elem = 0; elem < m1.height(); elem++) {
                    value += m1.get(i, elem) * m2.get(elem, j);
                }

                outM.set(i, j, value);
            }
        }
    }

    public static void product(final Matrix m,
            final Vector v, final Vector outV) {
        for (int i = 0; i < m.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < v.size(); elem++) {
                value += m.get(i, elem) * v.get(elem);
            }

            outV.set(i, value);
        }
    }

    public static void triangulate(final Matrix m, final int maxSize) {
        int countOfSwaps = 0;

        for (int i = 0; i < maxSize; i++) {
            if (Math.abs(m.get(i, i)) < NumberChecker.EPS) {
                boolean isNonZeroFound = false;

                for (int row = i + 1; row < m.height(); row++) {
                    if (m.get(row, i) != 0) {
                        swapRows(m, i, row);
                        countOfSwaps++;
                        isNonZeroFound = true;
                        break;
                    }
                }

                if (!isNonZeroFound)
                    continue;
            }

            for (int row = i + 1; row < m.height(); row++) {
                final float coefficient = -(m.get(row, i) / m.get(i, i));

                for (int col = i; col < m.width(); col++) {
                    m.set(row, col, m.get(row, col) + coefficient * m.get(i, col));
                }
            }
        }

        if (countOfSwaps % 2 == 1) {
            for (int i = 0; i < m.width(); i++) {
                m.set(0, i, m.get(0, i) * -1);
            }
        }

    }

    public static float determinant2(final Matrix m) {
        return m.get(0, 0) * m.get(1, 1)
                - m.get(0, 1) * m.get(1, 0);
    }

    public static float determinant3(final Matrix m) {
        return m.get(0, 0) * m.get(1, 1) * m.get(2, 2)
                + m.get(0, 1) * m.get(1, 2) * m.get(2, 0)
                + m.get(0, 2) * m.get(1, 0) * m.get(2, 1)
                - m.get(0, 2) * m.get(1, 1) * m.get(2, 0)
                - m.get(0, 0) * m.get(1, 2) * m.get(2, 1)
                - m.get(0, 1) * m.get(1, 0) * m.get(2, 2);
    }

    public static float determinant(final Matrix m) {
        if (m.width() == 1) {
            return m.get(0, 0);
        } else if (m.width() == 2) {
            return UncheckedMatrixOperations.determinant2(m);
        } else if (m.width() == 3) {
            return UncheckedMatrixOperations.determinant3(m);
        }

        float determinant = 0;

        for (int i = 0; i < m.width(); i++) {
            determinant += m.get(0, i) * cofactor(m, 0, i);
        }

        return determinant;
    }

    public static Matrix invertibleMatrix(final Matrix m, final Matrix outM) {
        cofactorMatrix(m, outM);
        float determinant = 0;

        for (int i = 0; i < m.width(); i++) {
            determinant += m.get(0, i) * outM.get(0, i);
        }

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exitst: determinant is 0");
        }
        transposeSquare(outM);
        multiply(outM, 1 / determinant);
        return outM;
    }

    public static Matrix minorMatrix(final Matrix m, final int row, final int col) {
        final Matrix result = new Mat(m.width() - 1);
        int destRow = 0;
        int destCol = 0;
        for (int i = 0; i < m.width(); i++) {
            if (i == row) {
                continue;
            }
            for (int j = 0; j < m.width(); j++) {
                if (j == col) {
                    continue;
                }

                result.set(destRow, destCol, m.get(i, j));
                destCol++;
            }
            destRow++;
        }
        return result;
    }

    public static float cofactor(final Matrix m, final int row, final int col) {
        final int coefficient = (row + col) % 2 == 0 ? 1 : -1;
        return coefficient * determinant(minorMatrix(m, row, col));
    }

    public static Matrix cofactorMatrix(final Matrix m, final Matrix outM) {
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                outM.set(i, j, cofactor(m, i, j));
            }
        }

        return outM;
    }

    public static void minorMatrix(final Matrix m, final int row, final int col, final Matrix outM) {
        int destRow = 0;
        int destCol = 0;
        for (int i = 0; i < m.width(); i++) {
            if (i == row) {
                continue;
            }
            for (int j = 0; j < m.width(); j++) {
                if (j == col) {
                    continue;
                }
                outM.set(destRow, destCol, m.get(i, j));
                destCol++;
            }
            destRow++;
        }
    }

    public static boolean equals(final Matrix targetM, final Matrix subtrahend) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahend.width(); j++) {
                if (Math.abs(targetM.get(i, j) - subtrahend.get(i, j)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
    }

}
