package io.github.alphameo.linear_algebra.mat;

/**
 * MathUtils
 *
 * @since 1.0.0
 */
class MatrixStringer {

    /**
     * Constructs string interpretation of the given matrix.
     *
     * @param m matrix to be interpreted as string
     * @return string interpretation of matrix {@code m}
     */
    public static String matrixToString(Matrix m) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.height(); i++) {
            if (i == 0) {
                sb.append("⎡");
            } else if (i == m.height() - 1) {
                sb.append("⎣");
            } else {
                sb.append("⎢");
            }
            for (int j = 0; j < m.width(); j++) {
                sb.append(String.format("%-5f ", m.get(i, j)));
            }
            if (i == 0) {
                sb.append("⎤\n");
            } else if (i == m.height() - 1) {
                sb.append("⎦");
            } else {
                sb.append("⎥\n");
            }
        }
        return sb.toString();
    }
}
