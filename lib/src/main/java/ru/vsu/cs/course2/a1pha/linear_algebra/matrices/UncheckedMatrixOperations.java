package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.NumberChecker;
import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * UncheckedMatrixOperations
 */
public class UncheckedMatrixOperations {

    public static <M extends MatrixInterface<M>> void addTo(final M targetM, final M subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                targetM.set(i, j, targetM.get(i, j) + subtrahendM.get(i, j));
            }
        }
    }

    public static <M extends MatrixInterface<M>> void subtractFrom(final M targetM,
            final M subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                targetM.set(i, j, targetM.get(i, j) - subtrahendM.get(i, j));
            }
        }
    }

    public static <M extends MatrixInterface<M>> void product(final M matr1,
            final M matr2, final M outMatr) {
        for (int i = 0; i < matr1.height(); i++) {
            for (int j = 0; j < matr2.width(); j++) {
                float value = 0;
                for (int elem = 0; elem < matr1.height(); elem++) {
                    value += matr1.get(i, elem) * matr2.get(elem, j);
                }

                outMatr.set(i, j, value);
            }
        }
    }

    public static <M extends MatrixInterface<M>, V extends VectorInterface<V>> void product(final M matr,
            final V vec, final V outVec) {
        for (int i = 0; i < matr.height(); i++) {
            float value = 0;
            for (int elem = 0; elem < vec.size(); elem++) {
                value += matr.get(i, elem) * vec.get(elem);
            }

            outVec.set(i, value);
        }
    }

    public static <SM extends SquareMatrixInterface<SM>> void cofactorMatrix(final SM matr,
            final SM outMatr) {
        for (int i = 0; i < matr.height(); i++) {
            for (int j = 0; j < matr.width(); j++) {
                outMatr.set(i, j, matr.cofactor(i, j));
            }
        }
    }

    public static <SM extends SquareMatrixInterface<SM>> SM invertibleMatrix(SM matr) {
        SM cofactorMatrix = matr.cofactorMatrix();
        double determinant = 0;

        for (int i = 0; i < matr.width(); i++) {
            determinant += matr.get(0, i) * cofactorMatrix.get(0, i);
        }

        if (determinant == 0) {
            throw new RuntimeException("Invertible matrix does not exitst: determinant is 0");
        }

        return cofactorMatrix.transpose().multiply(1 / determinant);
    }

    public static <M extends MatrixInterface<M>> boolean equalTo(final M targetM, final M subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                if (Math.abs(targetM.get(i, j) - subtrahendM.get(i, j)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
    }

    public static <M extends MatrixInterface<M>> float determinant2(final M matr) {
        return matr.get(0, 0) * matr.get(1, 1)
                - matr.get(0, 1) * matr.get(1, 0);
    }

    public static <M extends MatrixInterface<M>> float determinant3(final M matr) {
        return matr.get(0, 0) * matr.get(1, 1) * matr.get(2, 2)
                + matr.get(0, 1) * matr.get(1, 2) * matr.get(2, 0)
                + matr.get(0, 2) * matr.get(1, 0) * matr.get(2, 1)
                - matr.get(0, 2) * matr.get(1, 1) * matr.get(2, 0)
                - matr.get(0, 0) * matr.get(1, 2) * matr.get(2, 1)
                - matr.get(0, 1) * matr.get(1, 0) * matr.get(2, 2);
    }
}
