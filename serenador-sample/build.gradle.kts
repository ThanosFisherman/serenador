import io.github.thanosfisherman.serenador.dependencies.Deps

plugins {
    kotlin("jvm")
    id("serenador.dependencies")
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
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
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
