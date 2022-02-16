package io.github.sgtsilvio.gradle.defaults

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.bundling.AbstractArchiveTask
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.javadoc.Javadoc
import org.gradle.api.tasks.testing.Test
import org.gradle.external.javadoc.StandardJavadocDocletOptions
import org.gradle.kotlin.dsl.withType

/**
 * @author Silvio Giebl
 */
class DefaultsPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        configureUtf8(project)
        configureReproducibleArtifacts(project)
        configureGranularTestReports(project)
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

    private fun configureGranularTestReports(project: Project) {
        project.tasks.withType<Test>().configureEach {
            reports {
                junitXml.isOutputPerTestCase = true
            }
        }
    }
}