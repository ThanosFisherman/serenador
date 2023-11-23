
plugins {
    java
    kotlin("jvm") version Deps.kotlinVersion
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