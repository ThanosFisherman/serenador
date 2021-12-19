import io.github.thanosfisherman.serenador.dependencies.Deps

plugins {
    kotlin("jvm")
    id("dependencies")
    id("io.github.thanosfisherman.serenador")
}

dependencies {
    implementation(Deps.kotlin)
    testImplementation(Deps.Test.common)
    testImplementation(Deps.Test.junit5)
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
serenadorExtension {
    shutTheFuckUp(false)

    /*   phraseBook {
              addSuccessPhrase("Success1")
              addSuccessPhrase("Success2")
              addFailPhrase("EPIC FAIL 1")
              addFailPhrase("EPIC FAIL 2")
       }*/
}
