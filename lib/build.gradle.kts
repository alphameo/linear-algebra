plugins {
    id("base")
    `kotlin-dsl`
    id("java-library")
    id("java-library-distribution")

    id("maven-publish")
    id("org.jreleaser") version "1.15.0"
}

version = "1.0.0"
group = "io.github.alphameo"

base {
    archivesName.set(rootProject.name)
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withJavadocJar()
    withSourcesJar()
}

distributions {
    main {
        distributionBaseName.set(rootProject.name)
    }
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            setUrl(layout.buildDirectory.dir("staging-deploy"))
        }
    }
}
