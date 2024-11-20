package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vec3
 */
public class Vec3 implements Vector3 {

    Vec vector;

    public Vec3() {
        vector = new Vec(3);
    }

    public Vec3(final float x, final float y, final float z) {
        vector = new Vec(x, y, z);
    }

    @Override
    public float get(final int i) {
        return vector.get(i);
    }

    @Override
    public float x() {
        return vector.get(0);
    }

    @Override
    public float y() {
        return vector.get(1);
    }

    @Override
    public float z() {
        return vector.get(2);
    }

    @Override
    public void set(final int i, final float value) {
        vector.set(i, value);
    }

    @Override
    public void setX(final float value) {
        vector.set(0, value);
    }

    @Override
    public void setY(final float value) {
        vector.set(1, value);
    }

    @Override
    public void setZ(final float value) {
        vector.set(2, value);
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public float length() {
        return vector.size();
    }

    @Override
    public void add(final Vector3 other) {
        UncheckedVectorOperations.addTo(this, other);
    }

    @Override
    public void subtract(final Vector3 other) {
        UncheckedVectorOperations.subtractFrom(this, other);
    }

    @Override
    public float dot(final Vector3 other) {
        return UncheckedVectorOperations.dot(this, other);
    }

    @Override
    public void divide(final float divisor) {
        vector.divide(divisor);
    }

    @Override
    public void multiply(final float multiplier) {
        vector.multiply(multiplier);
    }

    @Override
    public boolean equalsTo(final Vector3 other) {
        return UncheckedVectorOperations.equalTo(this, other);
    }

    @Override
    public Vector3 copy() {
        return new Vec3(this.x(), this.y(), this.z());
    }

    @Override
    public Vector3 cross(final Vector3 other) {
        return new Vec3(
                this.z() * other.y() - this.y() * other.z(),
                this.x() * other.z() - this.z() * other.x(),
                this.y() * other.x() - this.x() * other.y());
    }

    @Override
    public String toString() {
        return vector.toString();
    }

    @Override
    public Vector4 toVec4() {
        return new Vec4(x(), y(), z(), 1);
    }
}
