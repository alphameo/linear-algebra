package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vec4
 */
public class Vec4 implements Vector4 {

    private final Vec vector;

    public Vec4() {
        vector = new Vec(4);
    }

    public Vec4(final float x, final float y, final float z, final float w) {
        vector = new Vec(x, y, z, w);
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
    public float w() {
        return vector.get(3);
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
    public void setW(final float value) {
        vector.set(3, value);
    }

    @Override
    public int size() {
        return 4;
    }

    @Override
    public float length() {
        return vector.length();
    }

    @Override
    public Vector4 add(final Vector4 other) {
        UncheckedVectorOperations.addTo(this, other);

        return this;
    }

    @Override
    public Vector4 subtract(final Vector4 other) {
        UncheckedVectorOperations.subtractFrom(this, other);

        return this;
    }

    @Override
    public float dot(final Vector4 other) {
        return UncheckedVectorOperations.dot(this, other);
    }

    @Override
    public Vector4 divide(final float divisor) {
        vector.divide(divisor);

        return this;
    }

    @Override
    public Vector4 multiply(final float multiplier) {
        vector.multiply(multiplier);

        return this;
    }

    @Override
    public boolean equalsTo(final Vector4 other) {
        return UncheckedVectorOperations.equalTo(this, other);
    }

    @Override
    public Vector4 copy() {
        return new Vec4(this.x(), this.y(), this.z(), this.w());
    }

    @Override
    public Vector4 normalize() {
        vector.normalize();

        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
