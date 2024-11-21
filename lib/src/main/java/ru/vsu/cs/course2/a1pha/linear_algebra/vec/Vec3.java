package ru.vsu.cs.course2.a1pha.linear_algebra.vec;

public final class Vec3 implements Vector3 {

    private final float[] values = new float[3];

    public Vec3(final float x, final float y, final float z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    @Override
    public float get(final int index) {
        if (index < 0 || index > 2) {
            throw new IllegalArgumentException("Vec3::get: index out of bounds");
        }

        return values[index];
    }

    @Override
    public void set(final int index, final float value) {
        if (index < 0 || index > 2) {
            throw new IllegalArgumentException("Vec3::set: index out of bounds");
        }

        values[index] = value;
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public float x() {
        return values[0];
    }

    @Override
    public void setX(final float value) {
        values[0] = value;
    }

    @Override
    public float y() {
        return values[1];
    }

    @Override
    public void setY(final float value) {
        values[1] = value;
    }

    @Override
    public float z() {
        return values[2];
    }

    @Override
    public void setZ(final float value) {
        values[2] = value;
    }
}
