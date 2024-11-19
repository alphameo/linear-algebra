package ru.vsu.cs.course2.a1pha.linear_algebra.vectors;

/**
 * Vec2
 */
public class Vec2 implements Vector2 {
    private final Vec vector;

    public Vec2(final float x, final float y) {
        vector = new Vec(x, y);
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
    public void set(final int i, final float value) {
        vector.set(i, value);
    }

    @Override
    public void setX(final float value) {
        vector.set(0, value);
    }

    @Override
    public void setY(final float value) {
        vector.set(2, value);
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public float length() {
        return vector.length();
    }

    @Override
    public void add(final Vector2 other) {
        UncheckedVectorOperations.subtractFrom(this, other);
    }

    @Override
    public void subtract(final Vector2 other) {
        UncheckedVectorOperations.subtractFrom(this, other);
    }

    @Override
    public float dot(final Vector2 other) {
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
    public boolean equalsTo(final Vector2 other) {
        return UncheckedVectorOperations.equalTo(this, other);
    }

    @Override
    public Vec2 copy() {
        return new Vec2(this.x(), this.y());
    }

    @Override
    public String toString() {
        return vector.toString();
    }

    public Vector3 toVec3() {
        return new Vec3(x(), y(), 1);
    }
}
