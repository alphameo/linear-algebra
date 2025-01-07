# linear-algebra

Java 21+ library for linear algebra.

1. The library uses JDK21. You can try to downgrade the JDK, but do it at your own risk.
2. The architecture is not final. Some methods are planned to be overriden (but potom).

## Installation

### Using Maven Central Repository

#### All possible ways to connect the library to your project are located at:

https://central.sonatype.com/artifact/io.github.alphameo/linear_algebra

Maven example for `pom.xml`:

```xml
<dependency>
  <groupId>io.github.alphameo</groupId>
  <artifactId>linear_algebra</artifactId>
  <version>2.1.1</version>
</dependency>
```

Gradle (Kotlin) example for `build.gradle.kts`:

```kts
implementation("io.github.alphameo:linear_algebra:2.1.1")
```

### Manual Build

#### Download

If you want to build the library by yourself or just download the JAR files.

##### Release

Just download the release. It includes the compiled classes, source files and Javadoc JARs.

##### Git

You can clone the repository:

```sh
# https
git clone https://github.com/alphameo/linear-algebra.git

# ssh
git clone git@github.com:alphameo/linear-algebra.git
```

##### Source ZIP

You can download the ZIP with "Code" > "Download ZIP" button. Then unzip where you need it.

#### Build

If you have cloned the repository or downloaded the source code, you can build the library with the Gradle wrapper.

After downloading the repository, go into the root directory of the project. Then do:

Linux and MacOS:

```sh
./gradlew :lib:build
```

Windows:

```powershell
.\gradlew.bat :lib:build
```

All JAR files are located at `lib/build/libs`.

#### Import

##### Maven artifact

It's the recommended way. It includes all the JARs, so Javadocs are included for the usage with the LSPs. Also, it's the easiest and most convenient approach.

Publish the library as a Maven artifact to the local repository (`.m2` directory in the home directory):

Linux and MacOS:

```sh
./gradlew :lib:deployLocalM2
```

Windows:

```powershell
.\gradlew.bat :lib:deployLocalM2
```

The artifact includes all the JARs.

Then use your IDE or add the following to the `build.gradle.kts` in case of using Gradle with the Kotlin DSL:

```kts
repositories {
    // other repositories

    mavenLocal()
}

dependencies {
    // other dependencies

    implementation("io.github.alphameo.linear_algebra:2.1.1")
    // implementation() or api() - read the gradle documentation
    // 2.1.1 is version that you want to use
}
```

##### JARs

Put all JARs into the `libs` folder in the root directory of your project.

Then you can connect it to project using IDE

If you are using Gradle with the Kotlin DSL, you can do this by yourself. Add to the `build.gradle.kts`:

```kts
dependencies {
    // other dependencies

    implementation(files("../libs/linear_algebra-2.1.1.jar"))
    // implementation() or api() - read the gradle documentation
    // 2.1.1 is version that you want to use
}
```

As the path, valid relative path to the JAR with the respect to `build.gradle.kts` file should be specified.

Instead of the `file()` call, `files()` can be used.

## Usage

For the intended usage, you can use the `Vector` and `Matrix` interfaces for your current vector or matrix classes.

- `Vector` is an interface for an arbitrary vector, and `VectorN` (where N is a number) is a fixed length vector.
- `Matrix` is an interface for an arbitrary matrix, and `MatrixN` (where N is a number) is a square-shaped with a fixed size matrix.

Fixed-sized vectors have element-access methods by index (from the arbitrary interface) and by letter (recommended). Fixed-sized matrices have element-access methods by indexes (from the arbitrary interface as well), but also by enums (recommended).

All functionality is located in the classes with static methods (functions). `VecMath` for `Vector`, `Mat3Math` for `Matrix3` and so on.

Although you can use `Vector2` in `VecMath`, it's recommended to use `Vec2Math` (or other corresponding class) just in case. The reason is the way how classes access the interfaces: the classes always try to use the most of the interface.

You can notice some "duplicated" methods such as `.divide()` and `.divided()`. The difference is that method without `-ed` changes the object while the other returns new object.

You also have default interface implementations. `Vec` for `Vector`, `Mat3` for `Matrix3` and so on.

Aside from the interface implementation factor, they have functions from the corresponding classes as methods.

Here is an example of the library usage:

```java
// arbitrary vectors

final Vector v1 = new Vec(1, 2, 3, 4, 5);
final Vector v2 = new Vec(6, 7, 8, 9, 10);
final Vector v3 = VecMath.added(v1, v3);

// fixed vectors

final Vector2 v4 = new Vec2();
v4.setX(11);
v4.setY(12);

final Vector2 v5 = new Vec2();
v5.setX(2);
v6.setY(2);

Vec2Math.mult(v4, v5);

// arbitrary matrices with methods

final Mat m1 = new Mat(2, 3);
m1.set(0, 0, 13);
m1.set(1, 1, 14);

final Mat m2 = new Mat(2, 3);
m2.add(m1);

// square matrices

final Matrix3 m3 = new Mat3();
m3.set(Matrix3Row.R0, Matrix3Col.C0, 15);
m3.set(Matrix3Row.R1, Matrix3Col.C1, 16);
m3.set(Matrix3Row.R2, Matrix3Col.C2, 17);

final float det = Mat3Math.det(m3);
```

## Credit

For the reference and help with the README: https://github.com/shimeoki
