package ru.vsu.cs.course2.a1pha.linear_algebra.matrices;

import java.util.Vector;

import ru.vsu.cs.course2.a1pha.linear_algebra.Equatable;
import ru.vsu.cs.course2.a1pha.linear_algebra.ScalarOperatable;

/**
 * MatrixOperatable
 */
public interface MatrixOperatable<MatrType> extends ScalarOperatable, Equatable<MatrType> {

    void add(MatrType other);

    MatrType plus(MatrType other);

    void subtract(MatrType other);

    MatrType minus();

    MatrType product(MatrType other);

    void transpose();

    float product(Vector vector);
}
