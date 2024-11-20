package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import ru.vsu.cs.course2.a1pha.linear_algebra.vectors.VectorInterface;

/**
 * Matr3
 */
public class Matr3 implements Matrix3 {

    SqMatr matrix;

    public Matr3() {
        matrix = new SqMatr(3);
    }

    @Override
    public boolean isDiagonal() {
        return matrix.isDiagonal();
    }

    @Override
    public float determinatn() {
        return UncheckedMatrixOperations.determinant3(matrix);
    }

    @Override
    public Matrix3 invertible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invertible'");
    }

    @Override
    public float get(int row, int col) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void set(int row, int col, float value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void transpose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transpose'");
    }

    @Override
    public void add(Matrix3 matr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void subtract(Matrix3 matr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subtract'");
    }

    @Override
    public Matrix3 product(Matrix3 matr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'product'");
    }

    @Override
    public <T extends VectorInterface<T>> T product(VectorInterface<T> vec) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'product'");
    }

    @Override
    public boolean isZeroed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isZeroed'");
    }

    @Override
    public void divide(float divisor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'divide'");
    }

    @Override
    public void multiply(float multiplier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multiply'");
    }

    @Override
    public Matrix3 copy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copy'");
    }

    @Override
    public boolean equalsTo(Matrix3 other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equalsTo'");
    }
}
