dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

pluginManagement {
    includeBuild("buildLogic")
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {}
}

rootProject.name = "serenador"
include(":serenador-sample")

