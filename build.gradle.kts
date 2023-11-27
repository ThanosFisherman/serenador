
plugins {
    java
    kotlin("jvm") version Dependencies.kotlinVersion
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {}
}
allprojects {
    group = "io.github.thanosfisherman.serenador.sample"
    version = "1.0-SNAPSHOT"
}