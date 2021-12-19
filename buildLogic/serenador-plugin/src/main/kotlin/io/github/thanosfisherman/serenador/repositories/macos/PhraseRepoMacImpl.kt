package io.github.thanosfisherman.serenador.repositories.macos

import io.github.thanosfisherman.serenador.commands.Command
import io.github.thanosfisherman.serenador.commands.macos.SayMacCommand
import io.github.thanosfisherman.serenador.repositories.PhraseRepo
import io.github.thanosfisherman.serenador.sources.PhrasesSource


private const val BAD_NEWS = "Bad News"
private const val GOOD_NEWS = "Good News"
private const val CELLO = "Cello"
private const val BELLS = "Bells"

internal class PhraseRepoMacImpl(private val source: PhrasesSource) : PhraseRepo {

    override fun getSuccessPhrases(): List<Command> {
        return source.getSuccessPhrasesList().map { SayMacCommand(it) }.toList()
    }

    override fun getSuccessPhrasesWithVoice(): List<Command> {
        val phrases = getSuccessPhrases().map { it as SayMacCommand }
        phrases.getOrNull(0)?.voice = GOOD_NEWS
        phrases.getOrNull(1)?.voice = GOOD_NEWS
        phrases.getOrNull(2)?.voice = BELLS
        phrases.getOrNull(3)?.voice = BELLS
        return phrases
    }

    override fun getFailPhrases(): List<Command> {
        return source.getFailPhrasesList().map { SayMacCommand(it) }.toList()
    }

    override fun getFailPhrasesWithVoice(): List<Command> {
        val phrases = getFailPhrases().map { it as SayMacCommand }

        phrases.getOrNull(0)?.voice = BAD_NEWS
        phrases.getOrNull(1)?.voice = BAD_NEWS
        phrases.getOrNull(2)?.voice = BAD_NEWS
        phrases.getOrNull(3)?.voice = BAD_NEWS
        phrases.getOrNull(4)?.voice = CELLO
        phrases.getOrNull(5)?.voice = CELLO
        phrases.getOrNull(6)?.voice = CELLO
        return phrases
    }

    override fun getCustomPhrases(customPhrases: List<String>): List<Command> {
        return customPhrases.map { SayMacCommand(it) }
    }
}
