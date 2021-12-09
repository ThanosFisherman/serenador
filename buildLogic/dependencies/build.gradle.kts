plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

// To make it available as direct dependency
group = "io.github.thanosfisherman.serenador.dependencies"
version = "SNAPSHOT"

repositories {
    gradlePluginPortal()
    mavenCentral()
}
configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

gradlePlugin {
    plugins.create("dependencies") {
        id = "dependencies"
        implementationClass = "io.github.thanosfisherman.serenador.dependencies.DependenciesPlugin"
    }
}
