package io.github.thanosfisherman.serenador.listeners

import io.github.thanosfisherman.serenador.commandexecutors.CommandExecutor
import io.github.thanosfisherman.serenador.extensions.SerenadorExtension
import io.github.thanosfisherman.serenador.repositories.PhraseRepo
import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle

class MyBuildListener constructor(
    private val commandExecutor: CommandExecutor,
    private val phraseRepo: PhraseRepo,
    private val serenadorExt: SerenadorExtension
) : BuildListener {
    override fun settingsEvaluated(settings: Settings) {
    }

    override fun projectsLoaded(gradle: Gradle) {
    }

    override fun projectsEvaluated(gradle: Gradle) {
    }

    override fun buildFinished(result: BuildResult) {

        if (result.failure != null) {
            customOrDefault(serenadorExt.phraseBook.failPhrases, true, commandExecutor)
        } else {
            customOrDefault(serenadorExt.phraseBook.successPhrases, false, commandExecutor)
        }
    }

    private fun customOrDefault(phrases: List<String>, isFail: Boolean, executor: CommandExecutor) {
        if (phrases.isEmpty() && isFail) {
            val result = executor.execute(phraseRepo.getFailPhrasesWithVoice().random())
            if (result.exitValue == 1) {
                executor.execute(phraseRepo.getFailPhrases().random())
            }
        } else if (phrases.isEmpty()) {
            val result = executor.execute(phraseRepo.getSuccessPhrasesWithVoice().random())
            if (result.exitValue == 1) {
                executor.execute(phraseRepo.getSuccessPhrases().random())
            }
        } else {
            executor.execute(phraseRepo.getCustomPhrases(phrases).random())
        }
    }
}
