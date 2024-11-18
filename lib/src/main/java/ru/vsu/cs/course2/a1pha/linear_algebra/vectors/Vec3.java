package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

import ru.vsu.cs.course2.a1pha.linear_algebra.Checker;

/**
 * Vec3
 */
public class Vec3 implements Vector3<Vec3> {

    public float x;
    public float y;
    public float z;

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    public void setX(float value) {
        x = value;
    }

    @Override
    public void setY(float value) {
        y = value;
    }

    @Override
    public void setZ(float value) {
        y = value;
    }

    @Override
    public void divide(float divisor) {
        Checker.checkDivisor(divisor);

        x /= divisor;
        y /= divisor;
        z /= divisor;
    }

    @Override
    public void multiply(float multiplier) {
        x *= multiplier;
        y *= multiplier;
        z *= multiplier;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public void add(Vec3 other) {
        x += other.x;
        y += other.y;
        z += other.z;
    }

    @Override
    public Vec3 plus(Vec3 other) {
        Vec3 result = this.copy();
        result.add(other);

        return result;
    }

    @Override
    public void subtract(Vec3 other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
    }

    @Override
    public Vec3 minus(Vec3 other) {
        Vec3 result = this.copy();
        result.subtract(other);

        return result;
    }

    @Override
    public float dot(Vec3 other) {
        return (float) Math.sqrt(this.x * other.x + this.y * other.y + this.z * other.z);
    }

    @Override
    public Vec3 copy() {
        return new Vec3(x, y, z);
    }

    @Override
    public Vec3 cross(Vec3 other) {
        return new Vec3(
                this.z * other.y - this.y * other.z,
                this.x * other.z - this.z * other.x,
                this.y * other.x - this.x * other.y);
    }
}
