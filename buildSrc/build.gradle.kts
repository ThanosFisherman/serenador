import io.github.thanosfisherman.serenador.dependencies.Deps

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("serenador.dependencies")
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("io.github.thanosfisherman.serenador.dependencies:dependencies:1.0")
}

tasks.withType<Test>().configureEach {
    testLogging { showStandardStreams = true }
}

gradlePlugin {
}
