package com.github.sgtsilvio.gradle.utf8

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.external.javadoc.StandardJavadocDocletOptions
import org.gradle.kotlin.dsl.withType

/**
 * @author Silvio Giebl
 */
class Utf8Plugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.tasks.withType<JavaCompile>().configureEach {
            options.encoding = "UTF-8"
        }
        project.tasks.withType<Javadoc>().configureEach {
            options.encoding = "UTF-8"
            (options as StandardJavadocDocletOptions).docEncoding = "UTF-8"
            (options as StandardJavadocDocletOptions).charSet = "UTF-8"
        }
    }
}