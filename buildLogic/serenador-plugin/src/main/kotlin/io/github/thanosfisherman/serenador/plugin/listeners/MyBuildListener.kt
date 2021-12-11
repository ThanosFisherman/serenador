package io.github.thanosfisherman.serenador.plugin.listeners

import io.github.thanosfisherman.serenador.plugin.CommandExecutor
import io.github.thanosfisherman.serenador.plugin.executeFailure
import io.github.thanosfisherman.serenador.plugin.executeSuccess
import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle

class MyBuildListener(private val project: Project) : BuildListener {
    override fun settingsEvaluated(settings: Settings) {
    }

    override fun projectsLoaded(gradle: Gradle) {
    }

    override fun projectsEvaluated(gradle: Gradle) {
    }

    override fun buildFinished(result: BuildResult) {
        val executor = CommandExecutor(project)
        if (result.failure != null) {
            executor.executeFailure()
        } else {
            executor.executeSuccess()
        }
    }
}
