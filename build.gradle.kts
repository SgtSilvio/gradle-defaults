plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
}

group = "com.github.sgtsilvio.gradle"
description = "Gradle plugin that automatically configures tasks to use UTF-8"

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

gradlePlugin {
    plugins {
        create("utf8") {
            id = "${group}.${name}"
            displayName = "Gradle UTF-8 plugin"
            description = project.description
            implementationClass = "${group}.utf8.Utf8Plugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/SgtSilvio/gradle-utf8"
    vcsUrl = "https://github.com/SgtSilvio/gradle-utf8.git"
    tags = listOf("utf8", "compile-utf8", "javadoc-utf8")
}
