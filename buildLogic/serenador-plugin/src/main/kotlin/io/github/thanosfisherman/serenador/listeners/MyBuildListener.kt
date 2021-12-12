package io.github.thanosfisherman.serenador.listeners

import io.github.thanosfisherman.serenador.CommandExecutor
import io.github.thanosfisherman.serenador.executeCustom
import io.github.thanosfisherman.serenador.executeFailure
import io.github.thanosfisherman.serenador.executeSuccess
import io.github.thanosfisherman.serenador.extensions.SerenadorExtension
import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle

class MyBuildListener(private val project: Project, private val serenadorExt: SerenadorExtension) : BuildListener {
    override fun settingsEvaluated(settings: Settings) {
    }

    override fun projectsLoaded(gradle: Gradle) {
    }

    override fun projectsEvaluated(gradle: Gradle) {
    }

    override fun buildFinished(result: BuildResult) {
        val executor = CommandExecutor(project)
        if (result.failure != null) {
            customOrDefault(serenadorExt.phraseBook.failPhrases, true, executor)
        } else {
            customOrDefault(serenadorExt.phraseBook.successPhrases, false, executor)
        }
    }

    private fun customOrDefault(phrases: List<String>, isFail: Boolean, executor: CommandExecutor) {
        if (phrases.isEmpty() && isFail) {
            executor.executeFailure()
        } else if (phrases.isEmpty()) {
            executor.executeSuccess()
        } else {
            executor.executeCustom(phrases)
        }
    }
}
