package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Checker;

/**
 * Vec4
 */
public class Vec4 implements Vector4<Vec4> {

    public float x;
    public float y;
    public float z;
    public float w;

    public Vec4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public float x() {
        return x;
    }

    @Override
    public float y() {
        return y;
    }

    @Override
    public float z() {
        return z;
    }

    @Override
    public float w() {
        return w;
    }

    @Override
    public void setX(float value) {
        x = value;
    }

    @Override
    public void setY(float value) {
        y = value;
    }

    @Override
    public void setZ(float value) {
        z = value;
    }

    @Override
    public void setW(float value) {
        w = value;
    }

    @Override
    public void divide(float divisor) {
        Checker.checkDivisor(divisor);
        x /= divisor;
        y /= divisor;
        z /= divisor;
        w /= divisor;
    }

    @Override
    public void multiply(float multiplier) {
        x *= multiplier;
        y *= multiplier;
        z *= multiplier;
        w *= multiplier;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public void add(Vec4 other) {
        x += other.x;
        y += other.y;
        z += other.z;
        w += other.w;
    }

    @Override
    public Vec4 plus(Vec4 other) {
        Vec4 result = copy();
        result.add(other);

        return result;
    }

    @Override
    public void subtract(Vec4 other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
        w -= other.w;
    }

    @Override
    public Vec4 minus(Vec4 other) {
        Vec4 result = copy();
        result.subtract(other);

        return result;
    }

    @Override
    public float dot(Vec4 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z + this.w + other.w;
    }

    @Override
    public Vec4 copy() {
        return new Vec4(x, y, z, w);
    }

}
