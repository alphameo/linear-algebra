package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.NumberChecker;

/**
 * UncheckedMatrixOperations
 */
public class UncheckedMatrixOperations {

    public static <M extends MatrixInterface<M>> void addTo(M targetM, M subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                targetM.set(i, j, targetM.get(i, j) + subtrahendM.get(i, j));
            }
        }
    }

    public static <M extends MatrixInterface<M>> void subtractFrom(M targetM,
            M subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                targetM.set(i, j, targetM.get(i, j) - subtrahendM.get(i, j));
            }
        }
    }

    public static <M extends MatrixInterface<M>> boolean equalTo(M targetM, M subtrahendM) {
        for (int i = 0; i < targetM.height(); i++) {
            for (int j = 0; i < subtrahendM.width(); j++) {
                if (Math.abs(targetM.get(i, j) - subtrahendM.get(i, j)) < NumberChecker.EPS) {
                    return false;
                }
            }
        }

        return true;
    }

    public static <M extends MatrixInterface<M>> float determinant2(M matrix) {
        return matrix.get(0, 0) * matrix.get(1, 1)
                - matrix.get(0, 1) * matrix.get(1, 0);
    }

    public static <M extends MatrixInterface<M>> float determinant3(M matrix) {
        return matrix.get(0, 0) * matrix.get(1, 1) * matrix.get(2, 2)
                + matrix.get(0, 1) * matrix.get(1, 2) * matrix.get(2, 0)
                + matrix.get(0, 2) * matrix.get(1, 0) * matrix.get(2, 1)
                - matrix.get(0, 2) * matrix.get(1, 1) * matrix.get(2, 0)
                - matrix.get(0, 0) * matrix.get(1, 2) * matrix.get(2, 1)
                - matrix.get(0, 1) * matrix.get(1, 0) * matrix.get(2, 2);
    }
}
