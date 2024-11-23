package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.NumberChecker;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vec;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.Vector;

/**
 * UncheckedMatrixOperations
 */
public class UncheckedMatrixOperations {

    public static void multiply(final Matrix m, float multiplier) {
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                m.set(i, j, m.get(i, j) * multiplier);
            }
        }
    }

    public static void divide(final Matrix m, float divisor) {
        NumberChecker.checkDivisor(divisor);
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                m.set(i, j, m.get(i, j) / divisor);
            }
        }
    }

    public static void addTo(final Matrix targetM, final Matrix subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                targetM.set(i, j, targetM.get(i, j) + subtrahendM.get(i, j));
            }
        }
    }

    public static void subtractFrom(final Matrix targetM,
            final Matrix subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                targetM.set(i, j, targetM.get(i, j) - subtrahendM.get(i, j));
            }
        }
    }

    public static <M extends Matrix> M product(final M m1,
            final M m2, final M outM) {
        for (int i = 0; i < m1.height(); i++) {
            for (int j = 0; j < m2.width(); j++) {
                float value = 0;
                for (int elem = 0; elem < m1.height(); elem++) {
                    value += m1.get(i, elem) * m2.get(elem, j);
                }

                outM.set(i, j, value);
            }
        }

        return outM;
    }

    public static <V extends Vector> V product(final Matrix m,
            final V v, V outV) {
        for (int i = 0; i < m.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < v.size(); elem++) {
                value += m.get(i, elem) * v.get(elem);
            }

            outV.set(i, value);
        }

        return outV;
    }

    public static float cofactor(Matrix m, int row, int col) {
        int coefficient = (row + col) % 2 == 0 ? 1 : -1;
        return coefficient * determinant(minorMatrix(m, row, col));
    }

    public static Matrix minorMatrix(Matrix m, int row, int col) {
        Matrix result = new Matr(m.width() - 1);
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

    public static Matrix cofactorMatrix(final Matrix m) {
        Matrix result = new Matr(m.height(), m.width());
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                result.set(i, j, cofactor(m, i, j));
            }
        }

        return result;
    }

    public static void minor(final Matrix m, int row, int col, Matrix outM) {
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

    public static Matrix invertibleMatrix(Matrix m) {
        Matrix cofactorMatrix = cofactorMatrix(m);
        float determinant = 0;

        for (int i = 0; i < m.width(); i++) {
            determinant += m.get(0, i) * cofactorMatrix.get(0, i);
        }

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exitst: determinant is 0");
        }
        transposeSquare(cofactorMatrix);
        multiply(cofactorMatrix, 1 / determinant);
        return cofactorMatrix;
    }

    public static void transposeSquare(Matrix m) {
        for (int i = 0; i < m.width(); i++) {
            for (int j = i + 1; j < m.width(); j++) {
                float tmp = m.get(i, j);
                m.set(i, j, m.get(j, i));
                m.set(j, i, tmp);
            }
        }
    }

    public static void triangulate(Matrix m, int maxSize) {
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
                float coefficient = -(m.get(row, i) / m.get(i, i));

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

    public static void swapRows(Matrix m, int r1, int r2) {
        float tmp;
        for (int i = 0; i < m.width(); i++) {
            tmp = m.get(r1, i);
            m.set(r1, i, m.get(r2, i));
            m.set(r2, i, tmp);
        }
    }

    public static void swapColumns(Matrix m, int c1, int c2) {
        float tmp;
        for (int i = 0; i < m.height(); i++) {
            tmp = m.get(i, c1);
            m.set(i, c1, m.get(i, c2));
            m.set(i, c2, tmp);
        }
    }

    public static boolean equals(final Matrix targetM, final Matrix subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                if (Math.abs(targetM.get(i, j) - subtrahendM.get(i, j)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
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
}
