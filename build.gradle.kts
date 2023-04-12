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
    website.set(metadata.url)
    vcsUrl.set(metadata.scm.get().url)
    plugins {
        create("defaults") {
            id = "$group.$name"
            implementationClass = "$group.$name.DefaultsPlugin"
            displayName = metadata.readableName.get()
            description = project.description
            tags.set(listOf("defaults", "normalization", "utf8"))
        }
    }
}
