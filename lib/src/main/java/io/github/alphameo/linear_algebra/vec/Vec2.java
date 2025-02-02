package io.github.alphameo.linear_algebra.vec;

import java.util.Arrays;

/**
 * Default implementation of 2-dimensional vector ({@link Vector2}).
 *
 * @since 1.0.0
 */
public class Vec2 implements Vector2 {

    private final float[] entries;

    /**
     * Constructs new 2-dimensional vector with all 0.
     *
     * @since 1.0.0
     */
    public Vec2() {
        entries = new float[2];
    }

    /**
     * Constructs new 2-dimensional vector using values {@code x} and {@code y}.
     * 
     * @param x first component of vector
     * @param y second component of vector
     *
     * @since 1.0.0
     */
    public Vec2(final float x, final float y) {
        this();
        entries[0] = x;
        entries[1] = y;
    }

    /**
     * Copies values of the given 2-dimensional vector into the new 2-dimensional
     * vector.
     * 
     * @param v 2-dimensional vector for copying
     *
     * @since 1.0.0
     */
    public Vec2(final Vector2 v) {
        this(v.x(), v.y());
    }

    @Override
    public float get(final int i) throws IllegalArgumentException {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec2 bounds", i));
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
    public void set(final int i, final float value) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException(String.format("Index %d is out of Vec2 bounds", i));
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
    public int size() {
        return 2;
    }

    @Override
    public Vector2 clone() {
        return new Vec2(this.x(), this.y());
    }

    @Override
    public String toString() {
        return String.format("[%f, %f]", x(), y());
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
     * Constructs 2-dimensional vector with all 0 components.
     * 
     * @return new zero 2-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector2 zeroVector() {
        return Vector2Math.zeroVector();
    }

    /**
     * Constructs 2-dimensional vector with all 1 components.
     * 
     * @return new unit 2-dimensional vector
     *
     * @since 1.0.0
     */
    public static Vector2 unitVector() {
        return Vector2Math.unitVector();
    }
}
