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
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

gradlePlugin {
    plugins.create("dependencies") {
        id = "serenador.dependencies"
        implementationClass = "io.github.thanosfisherman.serenador.dependencies.DependenciesPlugin"
    }
}
