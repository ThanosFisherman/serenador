dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.buildFileName = "build.gradle.kts"
include(":serenador-sample")
includeBuild("includedBuild/dependencies")
includeBuild("includedBuild/serenador-plugin")
