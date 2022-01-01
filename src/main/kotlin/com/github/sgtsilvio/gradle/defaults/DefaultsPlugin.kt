package com.github.sgtsilvio.gradle.defaults

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.jvm.JvmTestSuite
import org.gradle.api.tasks.bundling.AbstractArchiveTask
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.external.javadoc.StandardJavadocDocletOptions
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.gradle.plugins.ide.idea.model.IdeaModel
import org.gradle.testing.base.TestingExtension

/**
 * @author Silvio Giebl
 */
class DefaultsPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        configureUtf8(project)
        configureReproducibleArtifacts(project)
        project.plugins.withId("org.gradle.idea") {
            project.plugins.withId("org.gradle.jvm-test-suite") {
                configureIdeaTestSources(project)
            }
        }
    }

    private fun configureUtf8(project: Project) {
        project.tasks.withType<JavaCompile>().configureEach {
            options.encoding = "UTF-8"
        }
        project.tasks.withType<Javadoc>().configureEach {
            options.encoding = "UTF-8"
            (options as StandardJavadocDocletOptions).apply {
                docEncoding = "UTF-8"
                charSet = "UTF-8"
            }
        }
    }

    private fun configureReproducibleArtifacts(project: Project) {
        project.tasks.withType<AbstractArchiveTask>().configureEach {
            isPreserveFileTimestamps = false
            isReproducibleFileOrder = true
        }
    }

    private fun configureIdeaTestSources(project: Project) {
        val ideaModel = project.extensions.getByType<IdeaModel>()
        project.extensions.configure<TestingExtension> {
            suites.withType<JvmTestSuite>().configureEach {
                ideaModel.module {
                    testSourceDirs = testSourceDirs + sources.java.srcDirs
                    testResourceDirs = testResourceDirs + sources.resources.srcDirs
                }
            }
        }
    }
}