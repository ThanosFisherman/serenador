dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {}
}

rootProject.buildFileName = "build.gradle.kts"
include(":serenador-sample")
includeBuild("buildLogic/dependencies")
includeBuild("buildLogic/serenador-plugin")
