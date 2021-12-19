package io.github.thanosfisherman.serenador.repositories

import io.github.thanosfisherman.serenador.commands.Command

interface PhraseRepo {
    fun getSuccessPhrases(): List<Command>
    fun getSuccessPhrasesWithVoice(): List<Command>
    fun getFailPhrases(): List<Command>
    fun getFailPhrasesWithVoice(): List<Command>
    fun getCustomPhrases(customPhrases: List<String>): List<Command>
}
