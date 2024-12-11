plugins {
    id("base")
    `kotlin-dsl`

    id("java-library")
    id("java-library-distribution")

    id("io.deepmedia.tools.deployer") version "0.15.0"
}

version = "1.0.0"
group = "io.github.alphameo"

base {
    archivesName = rootProject.name
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
        distributionBaseName = rootProject.name
    }
}

tasks.test {
    useJUnitPlatform()
}

deployer {
    content {
        component {
            fromJava()
        }
    }

    projectInfo {
        name.set(rootProject.name)
        description.set("A Java Linear Algebra Library")
        url.set("https://github.com/alphameo/linear-algebra")

        artifactId.set(rootProject.name)

        scm {
            fromGithub("alphameo", "linear-algebra")
        }

        license(MIT)

        developer("alphameo", "pavel.2014.play.gmail.com")
    }

    localSpec("m2") {
    }

    localSpec("artifact") {
        directory.set(file("build/artifact"))
    }

    centralPortalSpec {
        auth.user.set(secret("CENTRAL_PORTAL_USERNAME"))
        auth.password.set(secret("CENTRAL_PORTAL_PASSWORD"))

        signing {
            key.set(secret("GPG_KEY"))
            password.set(secret("GPG_PASSWORD"))
        }
    }

    githubSpec {
        owner.set("alphameo")
        repository.set("linear-algebra")

        auth.user.set(secret("GITHUB_ACTOR"))
        auth.token.set(secret("GITHUB_TOKEN"))
    }
}
