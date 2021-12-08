import io.github.thanosfisherman.serenador.dependencies.Deps
plugins {
    kotlin("jvm")
    id("dependencies")
    id("serenador")
}

dependencies {
    implementation(Deps.kotlin)
    testImplementation(Deps.Test.common)
    testImplementation(Deps.Test.junit)
}

tasks.getByName<Test>("test") {
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