rootProject.name = "gradle-defaults"

pluginManagement {
    plugins {
        id("com.gradle.plugin-publish") version "${extra["plugin.plugin-publish.version"]}"
    }
}