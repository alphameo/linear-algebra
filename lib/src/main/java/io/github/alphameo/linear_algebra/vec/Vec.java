package io.github.alphameo.linear_algebra.vec;

import java.util.Arrays;

/**
 * Default implementation of arbitrary-dimensional vector ({@link Vector}).
 *
 * @since 1.0.0
 */
public class Vec implements Vector {

    private final float[] entries;

    /**
     * Constructs new {@code size}-dimensional vector  with all 0.
     * 
     * @param size size of vector for construction
     *
     * @since 1.0.0
     */
    public Vec(final int size) {
        this.entries = new float[size];
    }

    /**
     * Constructs new vector using values from {@code entries}.
     * 
     * @param entries values for vector components
     *
     * @since 1.0.0
     */
    public Vec(final float... entries) {
        this(entries.length);
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = entries[i];
        }
    }

    /**
     * Copies the given vector values into the new one.
     * 
     * @param v vector for copying
     *
     * @since 1.0.0
     */
    public Vec(final Vector v) {
        this(v.size());
        for (int i = 0; i < entries.length; i++) {
            this.entries[i] = v.get(i);
        }
    }

    @Override
    public float get(final int i) {
        return entries[i];
    }

    @Override
    public void set(final int i, final float value) {
        entries[i] = value;
    }

    @Override
    public int size() {
        return entries.length;
    }

    @Override
    public Vector clone() {
        return new Vec(entries);
    }

    @Override
    public String toString() {
        return String.format("%s", Arrays.toString(entries));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(entries);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return VectorMath.equals(this, (Vector) obj);
    }

    /**
     * Constructs {@code size}-dimensional vector with all 0 components.
     * 
     * @param size dimension of vector to be constructed
     * @return new zero {@code size}-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector zeroVector(final int size) {
        return VectorMath.zeroVector(size);
    }

    /**
     * Constructs {@code size}-dimensional vector with all 1 components.
     * 
     * @param size dimension of vector to be constructed
     * @return new unit {@code size}-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector unitVector(final int size) {
        return VectorMath.unitVector(size);
    }
}
