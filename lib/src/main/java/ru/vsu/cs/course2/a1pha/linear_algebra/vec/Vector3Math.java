package ru.vsu.cs.course2.a1pha.linear_algebra.vec;

public final class Vector3Math {

    public static void add(final Vector3 target, final Vector3 term) {
        target.setX(target.x() + term.x());
        target.setY(target.y() + term.y());
        target.setZ(target.z() + term.z());
    }

    public static void subtract(final Vector3 target, final Vector3 term) {
        target.setX(target.x() - term.x());
        target.setY(target.y() - term.y());
        target.setZ(target.z() - term.z());
    }

    public static float dot(final Vector3 v1, final Vector3 v2) {
        float sum = 0;

        sum += v1.x() * v2.x();
        sum += v1.y() * v2.y();
        sum += v1.z() * v2.z();

        return sum;
    }
}
