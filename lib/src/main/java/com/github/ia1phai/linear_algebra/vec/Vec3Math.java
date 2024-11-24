package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.NumberChecker;

/**
 * UncheckedVectorOperations
 */
public class Vec3Math {

    public static float length(final Vector3 v) {
        return (float) Math.sqrt(v.x() * v.x() + v.y() * v.y() + v.z() * v.z());
    }

    public static void multiply(final Vector3 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);
        v.setZ(v.z() * multiplier);
    }

    public static void divide(final Vector3 v, final float divisor) {
        NumberChecker.checkDivisor(divisor);
        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);
        v.setZ(v.z() / divisor);
    }

    public static void add(final Vector3 target,
            final Vector3 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());
        target.setZ(target.z() + addendum.z());
    }

    public static void subtract(final Vector3 target,
            final Vector3 subtrahend) {
        target.setX(target.x() + subtrahend.x());
        target.setY(target.y() + subtrahend.y());
        target.setZ(target.z() + subtrahend.z());
    }

    public static float dot(final Vector3 v1, final Vector3 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z();
    }

    public static Vector3 cross(final Vector3 v1, final Vector3 v2, final Vector3 out) {
        final float x = v1.y() * v2.z() - v1.z() * v2.y();
        final float y = v1.z() * v2.x() - v1.x() * v2.z();
        final float z = v1.x() * v2.y() - v1.y() * v2.x();
        return new Vec3(x, y, z);
    }

    public static boolean equals(final Vector3 v1, final Vector3 v2) {
        return v1.x() == v2.x() && v1.y() == v2.y() && v1.z() == v2.z();
    }

    public static Vector4 toVec4(final Vector3 v) {
        return new Vec4(v.x(), v.y(), v.z(), 1);
    }

    public static Vector3 zeroVec() {
        return new Vec3();
    }

    public static Vector3 unitVec() {
        return new Vec3(1, 1, 1);
    }
}
