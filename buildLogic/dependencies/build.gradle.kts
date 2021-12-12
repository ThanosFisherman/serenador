plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "io.github.thanosfisherman.serenador.dependencies"
version = "1.0"

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
