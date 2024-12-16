package io.github.alphameo.linear_algebra.mat;

/**
 * MatUtils
 *
 * @since 1.0.0
 */
class MatStringer {

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
