package io.github.alphameo.linear_algebra.vec;

import java.util.Arrays;

/**
 * Default implementation of 4-dimensional vector ({@link Vector4}).
 *
 * @since 1.0.0
 */
public class Vec4 implements Vector4 {

    private final float[] entries;

    /**
     * Constructs new 4-dimensional vector with all 0.
     *
     * @since 1.0.0
     */
    public Vec4() {
        entries = new float[4];
    }

    /**
     * Constructs new 4-dimensional vector using values
     * {@code x}, {@code y}, {@code z} and {@code w}.
     * 
     * @param x first component of vector
     * @param y second component of vector
     * @param z third component of vector
     * @param w fourth component of vector
     *
     * @since 1.0.0
     */
    public Vec4(final float x, final float y, final float z, final float w) {
        this();
        entries[0] = x;
        entries[1] = y;
        entries[2] = z;
        entries[3] = w;
    }

    /**
     * Copies values of the given 4-dimensional vector into the new 4-dimensional
     * vector.
     * 
     * @param v 4-dimensional vector of for copying
     *
     * @since 1.0.0
     */
    public Vec4(final Vector4 v) {
        this(v.x(), v.y(), v.z(), v.w());
    }

    @Override
    public float get(final int i) throws IllegalArgumentException {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec4 bounds", i));
        }

        return entries[i];
    }

    @Override
    public float x() {
        return entries[0];
    }

    @Override
    public float y() {
        return entries[1];
    }

    @Override
    public float z() {
        return entries[2];
    }

    @Override
    public float w() {
        return entries[3];
    }

    @Override
    public void set(final int i, final float value) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec4 bounds", i));
        }

        entries[i] = value;
    }

    @Override
    public void setX(final float value) {
        entries[0] = value;
    }

    @Override
    public void setY(final float value) {
        entries[1] = value;
    }

    @Override
    public void setZ(final float value) {
        entries[2] = value;
    }

    @Override
    public void setW(final float value) {
        entries[3] = value;
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    public Vec4 clone() {
        return new Vec4(this.x(), this.y(), this.z(), this.w());
    }

    @Override
    public String toString() {
        return String.format("[%f, %f, %f, %f]", x(), y(), z(), w());
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
     * Constructs 4-dimensional vector with all 0 components.
     * 
     * @return new zero 4-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector4 zeroVector() {
        return Vector4Math.zeroVector();
    }

    /**
     * Constructs 4-dimensional vector with all 1 components.
     * 
     * @return new unit 4-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector4 unitVector() {
        return Vector4Math.unitVector();
    }
}
