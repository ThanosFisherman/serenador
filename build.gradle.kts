plugins {
    java
    kotlin("jvm") version "1.6.0"
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