plugins {
    id("base")
    id("java-library")
    id("java-library-distribution")

    id("maven-publish")
}

version = "0.1.1"
group = "com.github.ia1phai"

base {
    archivesName.set(rootProject.name)
}

repositories {
    mavenCentral()
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
        create<MavenPublication>("maven") {
            artifactId = rootProject.name

            pom {
                name.set(rootProject.name)
                description.set("Java Linear Algebra Library.")
                url.set("https://github.com/ia1phai/lenear-algebra")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/ia1phai/linear-algebra/blob/main/LICENSE")
                    }
                }
            }

            from(components["java"])
        }
    }
}
