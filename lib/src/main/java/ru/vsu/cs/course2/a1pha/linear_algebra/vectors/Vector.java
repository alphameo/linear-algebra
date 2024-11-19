package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vector
 */
public interface Vector<VecType> extends VectorOperatable<VecType> {

    float get(int i);

    void set(int i, float value);

    int size();
}
