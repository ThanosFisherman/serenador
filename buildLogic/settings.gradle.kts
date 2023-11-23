dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "buildLogic"
includeBuild("dependencies")
include("serenador-plugin")
