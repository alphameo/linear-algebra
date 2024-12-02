package com.github.ia1phai.linear_algebra.mat;

import com.github.ia1phai.linear_algebra.Validator;
import com.github.ia1phai.linear_algebra.vec.Vec;
import com.github.ia1phai.linear_algebra.vec.Vector;

/**
 * UncheckedMatrixOperations
 */
public class MatMath {

    public static Matrix transposed(final Matrix m) {
        Matrix result = new Mat(m.width(), m.height());
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                result.set(c, r, m.get(r, c));
            }
        }

        return result;
    }

    public static Matrix swapRows(final Matrix m, final int r1, final int r2) {
        float tmp;
        for (int r = 0; r < m.width(); r++) {
            tmp = m.get(r1, r);
            m.set(r1, r, m.get(r2, r));
            m.set(r2, r, tmp);
        }

        return m;
    }

    public static Matrix swappedRows(final Matrix m, final int r1, final int r2) {
        return swapRows(new Mat(m), r1, r2);
    }

    public static Matrix swapCols(final Matrix m, final int c1, final int c2) {
        float tmp;
        for (int c = 0; c < m.height(); c++) {
            tmp = m.get(c, c1);
            m.set(c, c1, m.get(c, c2));
            m.set(c, c2, tmp);
        }

        return m;
    }

    public static Matrix swappedCols(final Matrix m, final int r1, final int r2) {
        return swapCols(new Mat(m), r1, r2);
    }

    public static Matrix mult(final Matrix m, final float multiplier) {
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                m.set(r, c, m.get(r, c) * multiplier);
            }
        }

        return m;
    }

    public static Matrix multiplied(final Matrix m, final float multiplier) {
        return mult(new Mat(m), multiplier);
    }

    public static Matrix divide(final Matrix m, final float divisor) {
        Validator.validateDivisor(divisor);
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                m.set(r, c, m.get(r, c) / divisor);
            }
        }

        return m;
    }

    public static Matrix divided(final Matrix m, final float divisor) {
        return mult(new Mat(m), divisor);
    }

    public static Matrix add(final Matrix target, final Matrix addendum) {
        Validator.validateMatrixSizes(target, addendum, "Addition denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < addendum.width(); c++) {
                target.set(r, c, target.get(r, c) + addendum.get(r, c));
            }
        }

        return target;
    }

    public static Matrix added(final Matrix target, final Matrix addendum) {
        return add(new Mat(target), addendum);
    }

    public static Matrix sub(final Matrix target, final Matrix subtrahend) {
        Validator.validateMatrixSizes(target, subtrahend, "Subtraction denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < subtrahend.width(); c++) {
                target.set(r, c, target.get(r, c) - subtrahend.get(r, c));
            }
        }

        return target;
    }

    public static Matrix subtracted(final Matrix target, final Matrix addendum) {
        return sub(new Mat(target), addendum);
    }

    public static Matrix prod(final Matrix m1, final Matrix m2) {
        if (m1.width() != m2.height()) {
            throw new IllegalArgumentException(
                    String.format("Matrix product denied: matrices with sizes %dx%d and %dx%d", m1.height(),
                            m1.width(), m2.height(), m2.width()));
        }

        final Matrix result = new Mat(m1.height(), m2.width());
        for (int r = 0; r < m1.height(); r++) {
            for (int c = 0; c < m2.width(); c++) {
                float value = 0;
                for (int i = 0; i < m1.width(); i++) {
                    value += m1.get(r, i) * m2.get(i, c);
                }

                result.set(r, c, value);
            }
        }

        return result;
    }

    public static Vector prod(final Matrix m, final Vector v) {
        if (m.width() != v.size()) {
            throw new IllegalArgumentException(
                    String.format("Matrix and vector product denied: matrix with size %dx%d and vector with size",
                            m.height(),
                            m.width(), v.size()));
        }

        final Vector result = new Vec(m.height());
        for (int i = 0; i < m.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < v.size(); elem++) {
                value += m.get(i, elem) * v.get(elem);
            }

            result.set(i, value);
        }

        return result;
    }

    public static Matrix triangulate(final Matrix m) {
        int countOfSwaps = 0;
        final int maxSize = Math.max(m.height(), m.width());

        for (int i = 0; i < maxSize; i++) {
            if (Validator.equals(m.get(i, i), 0)) {
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

        return m;
    }

    public static Matrix triangulated(final Matrix m) {
        return triangulate(new Mat(m));
    }

    private static float det2(final Matrix m) {
        return m.get(0, 0) * m.get(1, 1)
                - m.get(0, 1) * m.get(1, 0);
    }

    private static float det3(final Matrix m) {
        return m.get(0, 0) * m.get(1, 1) * m.get(2, 2)
                + m.get(0, 1) * m.get(1, 2) * m.get(2, 0)
                + m.get(0, 2) * m.get(1, 0) * m.get(2, 1)
                - m.get(0, 2) * m.get(1, 1) * m.get(2, 0)
                - m.get(0, 0) * m.get(1, 2) * m.get(2, 1)
                - m.get(0, 1) * m.get(1, 0) * m.get(2, 2);
    }

    public static float detThroughCofactors(final Matrix m) {
        if (!square(m)) {
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

    public static float det(final Matrix m) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Determinant does not exists: matrix is not square");
        }
        Matrix triangularTable = triangulated(m);

        float determinant = 1;
        for (int i = 0; i < m.width(); i++) {
            determinant *= triangularTable.get(i, i);
        }

        return determinant;
    }

    public static Matrix invertibleMatrix(final Matrix m) {
        if (!square(m)) {
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
        mult(result, 1 / determinant);

        return result;
    }

    public static Matrix minorMatrix(final Matrix m, final int r, final int c) {
        if (!square(m)) {
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
            destCol = 0;
            destRow++;
        }
        return result;
    }

    public static float cofactor(final Matrix m, final int r, final int c) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Can not find cofactor: matrix is not square");
        }

        final int coefficient = (r + c) % 2 == 0 ? 1 : -1;
        return coefficient * detThroughCofactors(minorMatrix(m, r, c));
    }

    public static Matrix cofactorMatrix(final Matrix m) {
        if (!square(m)) {
            throw new UnsupportedOperationException("Cofactor matrix does not exist: matrix is not square");
        }

        final Matrix result = new Mat(m.height(), m.width());
        for (int r = 0; r < m.height(); r++) {
            for (int c = 0; c < m.width(); c++) {
                result.set(r, c, cofactor(m, r, c));
            }
        }

        return result;
    }

    public static boolean equals(final Matrix target, final Matrix subtrahend) {
        Validator.validateMatrixSizes(target, subtrahend, "Equalizationt denied");
        for (int r = 0; r < target.height(); r++) {
            for (int c = 0; c < subtrahend.width(); c++) {
                if (!Validator.equals(target.get(r, c), subtrahend.get(r, c))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean square(final Matrix m) {
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
                if (Validator.equals(m.get(i, j), 0)) {
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
