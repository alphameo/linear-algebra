package ru.vsu.cs.course2.a1pha.linear_algebra.vec;

public final class Vec implements Vector {

    private final float[] values;

    public Vec(final float... values) {
        this.values = new float[values.length];

        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }
    }

    @Override
    public float get(final int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Vec::get: index out of bounds");
        }

        return values[index];
    }

    @Override
    public void set(final int index, final float value) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Vec::set: index out of bounds");
        }

        values[index] = value;
    }

    @Override
    public int size() {
        return values.length;
    }
}
