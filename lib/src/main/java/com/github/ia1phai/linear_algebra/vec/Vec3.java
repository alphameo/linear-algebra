package com.github.ia1phai.linear_algebra.vec;

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
    public void set(int index, float value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void setX(float value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setX'");
    }

    @Override
    public void setY(float value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setY'");
    }

    @Override
    public void setZ(float value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setZ'");
    }

    @Override
    public Vector3 cross(Vector3 other) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cross'");
    }

    @Override
    public Vector4 toVec4() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toVec4'");
    }
