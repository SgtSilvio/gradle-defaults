rootProject.name = "gradle-utf8"

pluginManagement {
    plugins {
        kotlin("jvm") version "${extra["plugin.kotlin.version"]}"
        id("com.gradle.plugin-publish") version "${extra["plugin.plugin-publish.version"]}"
    }
}
