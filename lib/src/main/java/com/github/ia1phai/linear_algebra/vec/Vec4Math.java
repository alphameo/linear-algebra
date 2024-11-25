package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * UncheckedVectorOperations
 */
public class Vec4Math {

    public static float len2(final Vector4 v) {
        return v.x() * v.x() + v.y() * v.y() + v.z() * v.z() + v.w() * v.w();
    }

    public static float len(final Vector4 v) {
        return (float) Math.sqrt(len2(v));
    }

    public static Vector4 mult(final Vector4 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);
        v.setZ(v.z() * multiplier);
        v.setW(v.w() * multiplier);

        return v;
    }

    public static Vector4 multiplied(final Vector4 v, final float multiplier) {
        return mult(new Vec4(v), multiplier);
    }

    public static Vector4 divide(final Vector4 v, final float divisor) {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);
        v.setZ(v.z() / divisor);
        v.setW(v.w() / divisor);

        return v;
    }

    public static Vector4 divided(final Vector4 v, final float divisor) {
        return divide(new Vec4(v), divisor);
    }

    public static Vector4 add(final Vector4 target, final Vector4 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());
        target.setZ(target.z() + addendum.z());
        target.setW(target.w() + addendum.w());

        return target;
    }

    public static Vector4 added(final Vector4 target, final Vector4 addendum) {
        return add(new Vec4(target), addendum);
    }

    public static Vector4 sub(final Vector4 target, final Vector4 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());
        target.setZ(target.z() - subtrahend.z());
        target.setW(target.w() - subtrahend.w());

        return target;
    }

    public static Vector4 subtracted(final Vector4 target, final Vector4 subtrahend) {
        return sub(new Vec4(target), subtrahend);
    }

    public static Vector4 normalize(final Vector4 v) {
        return divide(v, len(v));
    }

    public static Vector4 normalized(final Vector4 v) {
        return divided(v, len(v));
    }

    public static float dot(final Vector4 v1, final Vector4 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z() + v1.w() * v2.w();
    }

    public static boolean equals(final Vector4 v1, final Vector4 v2) {
        return v1.x() == v2.x() && v1.y() == v2.y() && v1.z() == v2.z() && v1.w() == v2.w();
    }

    public static Vector4 zeroVec() {
        return new Vec4();
    }

    public static Vector4 unitVec() {
        return new Vec4(1, 1, 1, 1);
    }
}
