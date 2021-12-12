import io.github.thanosfisherman.serenador.dependencies.Deps
import java.util.*

plugins {
    //id("org.gradle.kotlin.kotlin-dsl") version "2.1.7"
    //id("org.jetbrains.kotlin.jvm") version "1.6.0"
    `kotlin-dsl`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "0.18.0"
    `maven-publish`
    id("dependencies")
}

group = "io.github.thanosfisherman.serenador"
version = PluginArtifact.VERSION_NAME

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

// Configuration Block for the Plugin Marker artifact on Plugin Central
pluginBundle {
    website = PluginArtifact.WEBSITE
    vcsUrl = PluginArtifact.VCS_URL
    description = PluginArtifact.DESCRIPTION
    tags = PluginArtifact.TAGS

    mavenCoordinates {
        groupId = MavenArtifact.ARTIFACT_GROUP
        artifactId = MavenArtifact.ARTIFACT_NAME
        version = MavenArtifact.VERSION_NAME
    }
}

// for Maven local publication only
publishing {
    repositories {
        maven {
            name = "serenadorLocalRepo"
            url = uri("../serenador-uri-repo")
        }
    }
}
gradlePlugin {
    plugins.create(PluginArtifact.PLUGIN_NAME) {
        id = PluginArtifact.PLUGIN_ID
        displayName = PluginArtifact.DISPLAY_NAME
        description = PluginArtifact.DESCRIPTION
        implementationClass = "io.github.thanosfisherman.serenador.SerenadorPlugin"
    }
}
tasks.register("setupPluginKeys") {
    println(rootProject.projectDir.toString())
    val propertiesFile = rootProject.file("local.properties")
    if (propertiesFile.exists() && propertiesFile.canRead()) {
        val properties = Properties()
        properties.load(propertiesFile.inputStream())
        val key = properties.getProperty("gradle.publish.key")
        val secret = properties.getProperty("gradle.publish.secret")
        System.setProperty("gradle.publish.key", key)
        System.setProperty("gradle.publish.secret", secret)
    } else {
        throw GradleException("Couldn't find local.properties file in path")
    }
}
tasks.named("publishPlugins") {
    dependsOn("setupPluginKeys")
}
