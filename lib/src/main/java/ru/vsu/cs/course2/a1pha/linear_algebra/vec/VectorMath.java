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
            throw new IllegalArgumentException("VectorMath::subtract: vector sizes are not equal");
        }

        float sum = 0;

        for (int i = 0; i < size; i++) {
            sum += v1.get(i) * v2.get(i);
        }

        return sum;
    }
}
