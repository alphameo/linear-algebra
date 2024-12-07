package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * UncheckedVectorOperations
 */
public class Vec3Math {

    public static float len2(final Vector3 v) {
        return v.x() * v.x() + v.y() * v.y() + v.z() * v.z();
    }

    public static float len(final Vector3 v) {
        return (float) Math.sqrt(len2(v));
    }

    public static Vector3 mult(final Vector3 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);
        v.setZ(v.z() * multiplier);

        return v;
    }

    public static Vector3 multiplied(final Vector3 v, final float multiplier) {
        return mult(new Vec3(v), multiplier);
    }

    public static Vector3 divide(final Vector3 v, final float divisor) {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);
        v.setZ(v.z() / divisor);

        return v;
    }

    public static Vector3 divided(final Vector3 v, final float divisor) {
        return divide(new Vec3(v), divisor);
    }

    public static Vector3 normalize(final Vector3 v) {
        return divide(v, len(v));
    }

    public static Vector3 normalized(final Vector3 v) {
        return divided(v, len(v));
    }

    public static Vector3 add(final Vector3 target, final Vector3 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());
        target.setZ(target.z() + addendum.z());

        return target;
    }

    public static Vector3 added(final Vector3 target, final Vector3 addendum) {
        return add(target, addendum);
    }

    public static Vector3 sub(final Vector3 target, final Vector3 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());
        target.setZ(target.z() - subtrahend.z());

        return target;
    }

    public static Vector3 subtracted(final Vector3 target, final Vector3 subtrahend) {
        return sub(new Vec3(target), subtrahend);
    }

    public static float dot(final Vector3 v1, final Vector3 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z();
    }

    public static Vector3 cross(final Vector3 v1, final Vector3 v2) {
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
