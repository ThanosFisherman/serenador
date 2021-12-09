package io.github.thanosfisherman.serenador.dependencies

object Deps {

    private const val kotlinVersion = "1.6.0"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val compilerEmbeddable = "org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion"

    object Test {
        const val common = "org.jetbrains.kotlin:kotlin-test-common:$kotlinVersion"
        const val junit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
        const val annotationsCommon = "org.jetbrains.kotlin:kotlin-test-annotations-common:$kotlinVersion"
    }
}