package ru.vsu.cs.course2.a1pha.linear_algebra.vec;

public final class VectorMath {

    public static void add(final Vector target, final Vector term) {
        final int size = target.size();

        if (size != term.size()) {
            throw new IllegalArgumentException("VectorMath::add: vector sizes are not equal");
        }

        for (int i = 0; i < size; i++) {
            target.set(i, target.get(i) + term.get(i));
        }
    }

    public static void subtract(final Vector target, final Vector term) {
        final int size = target.size();

        if (size != term.size()) {
            throw new IllegalArgumentException("VectorMath::subtract: vector sizes are not equal");
        }

        for (int i = 0; i < size; i++) {
            target.set(i, target.get(i) - term.get(i));
        }
    }

    public static float dot(final Vector v1, final Vector v2) {
        final int size = v1.size();

        if (size != v2.size()) {
            throw new IllegalArgumentException("VectorMath::dot: vector sizes are not equal");
        }

        float sum = 0;

        for (int i = 0; i < size; i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }

    public static Vector cross(final Vector v1, final Vector v2) {
        final int size = v1.size();

        if (size != v2.size()) {
            throw new IllegalArgumentException("VectorMath::cross: vector sizes are not equal");
        }

        // TODO
        // probably should be a OperationNotSupportedException.
        // also, more vector sizes can be supported (at least size == 2).
        if (size != 3) {
            throw new IllegalArgumentException("VectorMath::cross: vector sizes are not 3");
        }

        final float value1 = v1.get(2) * v2.get(1) - v1.get(1) * v2.get(2);
        final float value2 = v1.get(0) * v2.get(2) - v1.get(2) * v2.get(0);
        final float value3 = v1.get(1) * v2.get(0) - v1.get(0) * v2.get(1);

        return new Vec(value1, value2, value3);
    }
}
