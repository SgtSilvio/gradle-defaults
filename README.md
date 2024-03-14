# Gradle Defaults Plugin

[![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/io.github.sgtsilvio.gradle.defaults?color=brightgreen&style=for-the-badge)](https://plugins.gradle.org/plugin/io.github.sgtsilvio.gradle.defaults)
[![GitHub](https://img.shields.io/github/license/sgtsilvio/gradle-defaults?color=brightgreen&style=for-the-badge)](LICENSE)
[![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/sgtsilvio/gradle-defaults/check.yml?branch=main&style=for-the-badge)](https://github.com/SgtSilvio/gradle-defaults/actions/workflows/check.yml?query=branch%3Amain)

Gradle plugin that automatically configures sensible defaults:
- UTF 8 for Java compilation and Javadoc
- Reproducible artifacts
- Granular test reports per test case (method instead of class)

## How to Use

```kotlin
plugins {
    id("io.github.sgtsilvio.gradle.defaults") version "0.2.0"
}
```
