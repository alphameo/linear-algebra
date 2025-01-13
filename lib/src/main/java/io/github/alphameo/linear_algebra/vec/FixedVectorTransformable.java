package io.github.alphameo.linear_algebra.vec;

public interface FixedVectorTransformable<V, M> {

    V transformCol(final M operator);

    V transformedCol(final M operator);

    V transformRow(final M operator);

    V transformedRow(final M operator);

}
