import io.github.thanosfisherman.serenador.dependencies.Deps

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("dependencies")
}

group = "io.github.thanosfisherman.serenador.plugin"
version = "SNAPSHOT"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

tasks.getByName<Test>("test") {
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
    testImplementation(Deps.Test.common)
    testImplementation(Deps.Test.junit)
}


gradlePlugin {
    plugins.register("serenador") {
        id = "serenador"
        implementationClass = "io.github.thanosfisherman.serenador.plugin.SerenadorPlugin"
    }
}
