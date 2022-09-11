@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    alias(libs.plugins.plugin.publish)
    alias(libs.plugins.defaults)
    alias(libs.plugins.metadata)
}

group = "io.github.sgtsilvio.gradle"
description = "Gradle plugin that configures sensible defaults"

metadata {
    readableName.set("Gradle Defaults Plugin")
    license {
        apache2()
    }
    developers {
        register("SgtSilvio") {
            fullName.set("Silvio Giebl")
        }
    }
    github {
        org.set("SgtSilvio")
        repo.set("gradle-defaults")
        issues()
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("defaults") {
            id = "$group.$name"
            displayName = metadata.readableName.get()
            description = project.description
            implementationClass = "$group.$name.DefaultsPlugin"
        }
    }
}

pluginBundle {
    website = metadata.url.get()
    vcsUrl = metadata.scm.get().url.get()
    tags = listOf("defaults", "normalization", "utf8")
}
