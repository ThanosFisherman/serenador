import io.github.thanosfisherman.serenador.dependencies.Deps

plugins {
    //id("org.gradle.kotlin.kotlin-dsl") version "2.1.7"
    //id("org.jetbrains.kotlin.jvm") version "1.6.0"
    `kotlin-dsl`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "0.18.0"
    `maven-publish`
    id("dependencies")
}

group = "io.github.thanosfisherman.serenador.plugin"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
tasks.test {
    useJUnitPlatform()
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
dependencies {
    implementation(Deps.kotlinPlugin)
    testImplementation(gradleTestKit())
    testImplementation(Deps.Test.junit5)
}


gradlePlugin {
    plugins.create("serenador") {
        id = "serenador"
        implementationClass = "io.github.thanosfisherman.serenador.plugin.SerenadorPlugin"
    }
}
