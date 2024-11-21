package ru.vsu.cs.course2.a1pha.linear_algebra.vec;

public final class Vector2Math {

    public static void add(final Vector2 target, final Vector2 term) {
        target.setX(target.x() + term.x());
        target.setY(target.y() + term.y());
    }

    public static void subtract(final Vector2 target, final Vector2 term) {
        target.setX(target.x() - term.x());
        target.setY(target.y() - term.y());
    }

    public static float dot(final Vector2 v1, final Vector2 v2) {
        float sum = 0;

        sum += v1.x() * v2.x();
        sum += v1.y() * v2.y();

        return sum;
    }
}
