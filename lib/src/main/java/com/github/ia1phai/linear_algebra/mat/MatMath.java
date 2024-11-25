package com.github.ia1phai.linear_algebra.mat;

import com.github.ia1phai.linear_algebra.Validator;
import com.github.ia1phai.linear_algebra.vec.Vec;
import com.github.ia1phai.linear_algebra.vec.Vector;

/**
 * UncheckedMatrixOperations
 */
public class MatMath {

    public static void transposed(final Matrix m) {
        for (int r = 0; r < m.width(); r++) {
            for (int c = r + 1; c < m.width(); c++) {
                final float tmp = m.get(r, c);
                m.set(r, c, m.get(c, r));
                m.set(c, r, tmp);
            }
        }
    }

    public static void swapRows(final Matrix m, final int r1, final int r2) {
        float tmp;
        for (int r = 0; r < m.width(); r++) {
            tmp = m.get(r1, r);
            m.set(r1, r, m.get(r2, r));
            m.set(r2, r, tmp);
        }
    }

    public static void swapCols(final Matrix m, final int c1, final int c2) {
        float tmp;
        for (int c = 0; c < m.height(); c++) {
            tmp = m.get(c, c1);
            m.set(c, c1, m.get(c, c2));
            m.set(c, c2, tmp);
        }
    }

    public static void multiply(final Matrix m, final float multiplier) {
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                m.set(r, c, m.get(r, c) * multiplier);
            }
        }
    }

    public static void divide(final Matrix m, final float divisor) {
        Validator.validateDivisor(divisor);
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                m.set(r, c, m.get(r, c) / divisor);
            }
        }
    }

    public static void add(final Matrix target, final Matrix addendum) {
        Validator.validateMatrixSizes(target, addendum, "Addition denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < addendum.width(); c++) {
                target.set(r, c, target.get(r, c) + addendum.get(r, c));
            }
        }
    }

    public static void subtract(final Matrix target,
            final Matrix subtrahend) {
        Validator.validateMatrixSizes(target, subtrahend, "Subtraction denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < subtrahend.width(); c++) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
            }
        }
    }

    public static Matrix product(final Matrix m1,
            final Matrix m2) {
        if (m1.width() == m2.height()) {
            throw new IllegalArgumentException(
                    String.format("Matrix product denied: matrices with sizes %dx%d and %dx%d", m1.height(),
                            m1.width(), m2.height(), m2.width()));
        }
        final Matrix result = new Mat(m1.width(), m2.height());
        for (int r = 0; r < m1.height(); r++) {
            for (int c = 0; c < m2.width(); c++) {
                float value = 0;
                for (int i = 0; i < m1.height(); i++) {
                    value += m1.get(r, i) * m2.get(i, c);
                }

                result.set(r, c, value);
            }
        }

        return result;
    }

    public static Vector product(final Matrix m,
            final Vector v) {
        if (m.width() != v.size()) {
            throw new IllegalArgumentException(
                    String.format("Matrix and vector product denied: matrix with size %dx%d and vector with size",
                            m.height(),
                            m.width(), v.size()));
        }
        final Vector result = new Vec(v.size());
        for (int i = 0; i < m.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < v.size(); elem++) {
                value += m.get(i, elem) * v.get(elem);
            }

            result.set(i, value);
        }

        return result;
    }

    public static void triangulate(final Matrix m) {
        int countOfSwaps = 0;
        final int maxSize = Math.max(m.height(), m.width());

        for (int i = 0; i < maxSize; i++) {
            if (Validator.areEquals(m.get(i, i), 0)) {
                boolean isNonZeroFound = false;

                for (int r = i + 1; r < m.height(); r++) {
                    if (m.get(r, i) != 0) {
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

    }

    public static float det2(final Matrix m) {
        return m.get(0, 0) * m.get(1, 1)
                - m.get(0, 1) * m.get(1, 0);
    }

    public static float det3(final Matrix m) {
        return m.get(0, 0) * m.get(1, 1) * m.get(2, 2)
                + m.get(0, 1) * m.get(1, 2) * m.get(2, 0)
                + m.get(0, 2) * m.get(1, 0) * m.get(2, 1)
                - m.get(0, 2) * m.get(1, 1) * m.get(2, 0)
                - m.get(0, 0) * m.get(1, 2) * m.get(2, 1)
                - m.get(0, 1) * m.get(1, 0) * m.get(2, 2);
    }

    public static float det(final Matrix m) {
        if (!isSquare(m)) {
            throw new UnsupportedOperationException("Determinant does not exists: matrix is not square");
        }

        if (m.width() == 1) {
            return m.get(0, 0);
        } else if (m.width() == 2) {
            return MatMath.det2(m);
        } else if (m.width() == 3) {
            return MatMath.det3(m);
        }

        float determinant = 0;

        for (int i = 0; i < m.width(); i++) {
            determinant += m.get(0, i) * cofactor(m, 0, i);
        }

        return determinant;
    }

    public static Matrix invertibleMatrix(final Matrix m) {
        if (!isSquare(m)) {
            throw new UnsupportedOperationException("Invertible matrix does not exists: matrix is not square");
        }
        final Matrix result = cofactorMatrix(m);
        float determinant = 0;

        for (int i = 0; i < m.width(); i++) {
            determinant += m.get(0, i) * result.get(0, i);
        }

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exitst: determinant is 0");
        }
        transposed(result);
        multiply(result, 1 / determinant);
        return result;
    }

    public static Matrix minorMatrix(final Matrix m, final int r, final int c) {
        if (!isSquare(m)) {
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
            destRow++;
        }
        return result;
    }

    public static float cofactor(final Matrix m, final int r, final int c) {
        if (!isSquare(m)) {
            throw new UnsupportedOperationException("Can not find cofactor: matrix is not square");
        }

        final int coefficient = (r + c) % 2 == 0 ? 1 : -1;
        return coefficient * det(minorMatrix(m, r, c));
    }

    public static Matrix cofactorMatrix(final Matrix m) {
        if (!isSquare(m)) {
            throw new UnsupportedOperationException("Cofactor matrix does not exist: matrix is not square");
        }

        final Matrix result = new Mat(m.height(), m.width());
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                result.set(i, j, cofactor(m, i, j));
            }
        }

        return result;
    }

    public static void minorMatrix(final Matrix m, final int r, final int c, final Matrix outM) {
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
                outM.set(destRow, destCol, m.get(i, j));
                destCol++;
            }
            destRow++;
        }
    }

    public static boolean equals(final Matrix target, final Matrix subtrahend) {
        Validator.validateMatrixSizes(target, subtrahend, "Equalizationt denied");
        for (int i = 0; i < target.height(); i++) {
            for (int j = 0; i < subtrahend.width(); j++) {
                if (Validator.areEquals(target.get(i, j), subtrahend.get(i, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isSquare(final Matrix m) {
        return m.width() == m.height();
    }

    public static boolean isZeroed(final Matrix m) {
        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                if (m.get(i, j) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isDiagonal(final Matrix m) {
        if (m.width() != m.height()) {
            return false;
        }

        for (int i = 0; i < m.height(); i++) {
            for (int j = 0; j < m.width(); j++) {
                if (i == j) {
                    continue;
                }
                if (Validator.areEquals(m.get(i, j), 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Matrix zeroMat(final int height, final int width) {
        return new Mat(height, width);
    }

    public static Matrix unitMat(final int size) {
        final Matrix result = new Mat(size);
        for (int i = 0; i < size; i++) {
            result.set(i, i, 1);
        }

        return result;
    }
}
