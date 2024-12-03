# linear-algebra

Java21+ library for linear algebra

## Main info

1. Library has written on `jdk21`. You can downgrade it but do it on your own risk and by yourself.

2. Main building tool is `Gradle`.
3. Javadocs are in progress.
4. Maybe methods will be overridden in such way (for returning realization of interface):

```java
/ #old
public static Vector divided(final Vector v, final float divisor) {
    return divide(new Vec(v), divisor);
}

// #1
interface VectoryFactory<T> { T create(T other); }

public static <T extends Vector> T divided(T v, float divisor, VectorFactory<T> vf) {
    // impl
}
// #2
public static <T extends Vector & Clonable> T divided(final T v, float divisor) {
    v.clone();
    // impl
}
```

## How to get

### Download

#### Release

Just download release.

#### For self building

- HTTPS:

```sh
git clone https://github.com/IA1phaI/linear-algebra.git
```

- SSH:

```sh
git clone git@github.com:IA1phaI/linear-algebra.git
```

- Download ZIP from `CODE` button

---

After downloading the repository, go into the root directory of the project. And build library files:

- Linux and MacOS:

```sh
./gradlew :lib:build
```

- Windows:

```powershell
.\gradlew.bat :lib:build
```

All JAR files will be located at `lib/build/libs`.

### Setup

#### Local JAR

Put all JARs into `libs` directory in the root.

Then you can connect it to project using IDE.

OR

Add to the `build.gradle.kts`:

```kts
dependencies {
    // other dependencies

    implementation(file("../libs/linear-algebra-0.1.0.jar"))
    // 0.1.0 is version that you want to use
    // and other jars with src and docs if you want
}
```

As the path, valid relative path to the JAR with the respect to `build.gradle.kts` file should be specified.

Instead of the `file()` call, `files()` can be used.

#### Import Maven artifact

The recommended way. It includes all the JARs, so Javadocs are included for the usage with the LSPs. Also, it's the easiest and most convenient approach.

1. Put the library as a Maven artifact to the local repository (`.m2` directory in the home directory):

Linux and MacOS:

```sh
./gradlew :lib:publishToMavenLocal
```

Windows:

```powershell
.\gradlew.bat :lib:publishToMavenLocal
```

The artifact includes all the JARs.

2. Use your IDE or add the following to the `build.gradle.kts`:

```kts
repositories {
    // other repositories

    mavenLocal()
}

dependencies {
    // other dependencies

    implementation("com.github.ia1phai.linear_algebra:0.1.0")
    // implementation() or api() -- read gradle docs
    // 0.1.0 is version that you want to use
}
```

## Usage

### You have following mathematical entities to operate:

- Arbitrary vector
- Fixed-sized vector
- Arbitrary matrix
- Square fixed-sized matrices

---

### Core of library is interface usage

###### Vectors:

- interface `Vector`

```java
public interface Vector {

    public float get(int index);

    public void set(int index, final float value);

    public int size();
}

```

- interface `Vector2`

```java
public interface Vector2 extends Vector {

    float x();

    float y();

    void setX(float value);

    void setY(float value);
}
```

- interface `Vector3`

```java
public interface Vector3 extends Vector {

    float x();

    float y();

    float z();

    void setX(float value);

    void setY(float value);

    void setZ(float value);
}
```

- interface `Vector4`

```java
public interface Vector4 extends Vector {

    float x();

    float y();

    float z();

    float w();

    void setX(float value);

    void setY(float value);

    void setZ(float value);

    void setW(float value);
```

Fixed-sized vectors have element-access methods by index and by letter: `.x()`, `y()`, `.z()`, `.w()` (better use them for stability and speed)

###### Matrices:

- interface `Matrix`

```java
public interface Matrix {

    float get(int row, int col);

    void set(int row, int col, float value);

    int width();

    int height();
}
```

- interface `Matrix3` (extends interface `Matrix`)

```java
public interface Matrix3 extends Matrix {

    float get(Matrix3Row row, Matrix3Col col);

    void set(Matrix3Row row, Matrix3Col col, float value);
}
public enum Matrix3Col {
    C0, C1, C2;
}
public enum Matrix3Row {
    R0, R1, R2;
}
```

- interface `Matrix4` (extends interface `Matrix`)

```java
public interface Matrix4 extends Matrix {

    float get(Matrix4Row row, Matrix4Col col);

    void set(Matrix4Row row, Matrix4Col col, float value);
}
public enum Matrix4Col {
    C0, C1, C2, C3;
}

public enum Matrix4Row {
    R0, R1, R2, R3;
}
```

Fix-sized matrices has element-access methods by indexes, but also length-safe by Enums `Matrix{N}Col`/`Matrix{N}Row` (it is recommended to use them)

---

### All math functionality is located in classes with static functions

###### Vectors:

- `VecMath` works with all `Vector`s, but has a lot more validation processes (not blazingly fast)
- `Vec2Math` works with `Vector2`
- `Vec3Math` works with `Vector3`
- `Vec4Math` works with `Vector4`

###### Matrices

- `MatMath` works with all `Matrix`s, but also has a lot more validation processes (not blazingly fast)
- `Mat3Math` works with all `Matrix3` + has methods with `Vector3`
- `Mat4Math` works with all `Matrix4` + methods with `Vector4`

So, if you want to operate with your own vector/matrix just implement corresponding interface

All methods returns used interface for chaining reasons.

There is some duplicated methods, such as `.divide()` and `.divided()`. The difference is that method without `-ed` changes given object, when method with `-ed` returns `new`.

---

### You also have default Vector classes:

###### Vectors:

- `Vec`
- `Vec2`
- `Vec3`
- `Vec4`

###### Matrices

- `Mat`
- `Mat3`
- `Mat4`

They have all powers of static functions, but you must transfer your data every time (not blazingly fast)
