plugins {
    `kotlin-dsl`
    signing
    alias(libs.plugins.pluginPublish)
    alias(libs.plugins.defaults)
    alias(libs.plugins.metadata)
}

group = "io.github.sgtsilvio.gradle"
description = "Gradle plugin that configures sensible defaults"

metadata {
    readableName = "Gradle Defaults Plugin"
    license {
        apache2()
    }
    developers {
        register("SgtSilvio") {
            fullName = "Silvio Giebl"
        }
    }
    github {
        org = "SgtSilvio"
        issues()
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
}

repositories {
    mavenCentral()
}

gradlePlugin {
    website = metadata.url
    vcsUrl = metadata.scm.get().url
    plugins {
        create("defaults") {
            id = "$group.$name"
            implementationClass = "$group.$name.DefaultsPlugin"
            displayName = metadata.readableName.get()
            description = project.description
            tags = listOf("defaults", "normalization", "utf8")
        }
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
}
