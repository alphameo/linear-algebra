package com.github.ia1phai.linear_algebra.vec;

import com.github.ia1phai.linear_algebra.Validator;

/**
 * UncheckedVectorOperations
 */
public class Vec2Math {

    public static float len(final Vector2 v) {
        return (float) Math.sqrt(v.x() * v.x() + v.y() * v.y());
    }

    public static Vector2 mult(final Vector2 v, final float multiplier) {
        v.setX(v.x() * multiplier);
        v.setY(v.y() * multiplier);

        return v;
    }

    public static Vector2 divide(final Vector2 v, final float divisor) {
        Validator.validateDivisor(divisor);

        v.setX(v.x() / divisor);
        v.setY(v.y() / divisor);

        return v;
    }

    public static Vector2 add(final Vector2 target, final Vector2 addendum) {
        target.setX(target.x() + addendum.x());
        target.setY(target.y() + addendum.y());

        return target;
    }

    public static Vector2 sub(final Vector2 target, final Vector2 subtrahend) {
        target.setX(target.x() - subtrahend.x());
        target.setY(target.y() - subtrahend.y());

        return target;
    }

    public static float dot(final Vector2 v1, final Vector2 v2) {
        return v1.x() * v2.x() + v1.y() * v2.y();
    }

    public static boolean equals(final Vector2 v1, final Vector2 v2) {
        return v1.x() == v2.x() && v1.y() == v2.y();
    }

    public static Vector3 toVec3(final Vector2 v) {
        return new Vec3(v.x(), v.y(), 1);
    }

    public static Vector2 zeroVec() {
        return new Vec2();
    }

    public static Vector2 unitVec() {
        return new Vec2(1, 1);
    }
}
