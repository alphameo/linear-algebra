package ru.vsu.cs.course2.a1pha.linear_algebra;

import java.util.Arrays;

/**
 * Vector
 */
public class Vector {

    private float[] entries;

    public Vector(int size) {
        this.entries = new float[size];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = 0;
        }
    }

    public Vector(float[] entries) {
        this.entries = Arrays.copyOf(entries, entries.length);
    }

    public float get(int index) {
        return entries[index];
    }

    public void set(int index, float value) {
        this.entries[index] = value;
    }

    public int size() {
        return entries.length;
    }

    public void multiply(float multiplier) {
        for (int i = 0; i < entries.length; i++) {
            entries[i] *= multiplier;
        }
    }

    public void divide(float divider) throws ArithmeticException {
        if (Float.compare(divider, 0f) == 0) {
            throw new ArithmeticException("Division denied: division by 0");
        }

        for (int i = 0; i < entries.length; i++) {
            entries[i] /= divider;
        }
    }

    public void add(Vector other) throws IllegalArgumentException {
        if (this.size() != other.size()) {
            throw new IllegalArgumentException(
                    String.format("Addition denied: vectors with sizes %d and %d", this.size(), other.size()));
        }

        for (int i = 0; i < entries.length; i++) {
            entries[i] += other.get(i);
        }
    }

    public Vector plus(Vector other) throws IllegalArgumentException {
        Vector result = this.copy();
        result.add(other);

        return result;
    }

    public void subtract(Vector other) throws IllegalArgumentException {
        if (this.size() != other.size()) {
            throw new IllegalArgumentException(
                    String.format("Subtraction denied: vectors with sizes %d and %d", this.size(), other.size()));
        }

        for (int i = 0; i < entries.length; i++) {
            entries[i] -= other.get(i);
        }
    }

    public Vector minus(Vector other) throws IllegalArgumentException {
        Vector result = this.copy();
        result.subtract(other);

        return result;
    }

    public float scalarProduct(Vector other) throws IllegalArgumentException {
        if (this.size() != other.size()) {
            throw new IllegalArgumentException(
                    String.format("Scalar product denied: vectors with sizes %d and %d", this.size(), other.size()));
        }
        float result = 0;

        for (int i = 0; i < this.size(); i++) {
            result += this.get(i) * other.get(i);
        }

        return result;
    }

    public float length() {
        float sum = 0;

        for (int i = 0; i < entries.length; i++) {
            sum += entries[i] * entries[i];
        }

        return (float) Math.sqrt(sum);
    }

    public void normalize() {
        this.divide(this.length());
    }

    public Vector copy() {
        return new Vector(Arrays.copyOf(entries, entries.length));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.copy();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(entries);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vector other = (Vector) obj;
        return Arrays.equals(entries, other.entries);
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}
