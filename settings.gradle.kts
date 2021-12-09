dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.buildFileName = "build.gradle.kts"
include(":serenador-sample")
includeBuild("buildLogic/dependencies")
includeBuild("buildLogic/serenador-plugin")
