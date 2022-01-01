plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish")
}

group = "com.github.sgtsilvio.gradle"
description = "Gradle plugin that automatically configures sensible defaults"

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
            displayName = "Gradle defaults plugin"
            description = project.description
            implementationClass = "$group.defaults.DefaultsPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/SgtSilvio/gradle-defaults"
    vcsUrl = "https://github.com/SgtSilvio/gradle-defaults.git"
    tags = listOf("defaults", "normalization", "utf8")
}