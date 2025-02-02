package io.github.alphameo.linear_algebra.vec;

import java.util.Arrays;

/**
 * Default implementation of 3-dimensional vector ({@link Vector3}).
 *
 * @since 1.0.0
 */
public class Vec3 implements Vector3 {

    /**
     * Constructs 3-dimensional vector with all 0 components.
     * 
     * @return new zero 3-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector3 zeroVector() {
        return Vector3Math.zeroVector();
    }

    /**
     * Constructs 3-dimensional vector with all 1 components.
     * 
     * @return new unit 3-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector3 unitVector() {
        return Vector3Math.unitVector();
    }

    private final float[] entries;

    /**
     * Constructs new 3-dimensional vector with all 0.
     *
     * @since 1.0.0
     */
    public Vec3() {
        entries = new float[3];
    }

    /**
     * Constructs new 3-dimensional vector using values {@code x}, {@code y} and
     * {@code z}.
     * 
     * @param x first component of vector
     * @param y second component of vector
     * @param z third component of vector
     *
     * @since 1.0.0
     */
    public Vec3(final float x, final float y, final float z) {
        this();
        entries[0] = x;
        entries[1] = y;
        entries[2] = z;
    }

    /**
     * Copies values of the given 3-dimensional vector into the new 3-dimensional
     * vector.
     * 
     * @param v 3-dimensional vector for copying
     *
     * @since 1.0.0
     */
    public Vec3(final Vector3 v) {
        this(v.x(), v.y(), v.z());
    }

    @Override
    public float get(final int i) throws IllegalArgumentException {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec3 bounds", i));
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
    public void set(final int i, final float value) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec3 bounds", i));
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
    public int size() {
        return 3;
    }

    @Override
    public Vector3 clone() {
        return new Vec3(this.x(), this.y(), this.z());
    }

    @Override
    public String toString() {
        return String.format("[%f, %f, %f]", x(), y(), z());
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
}
