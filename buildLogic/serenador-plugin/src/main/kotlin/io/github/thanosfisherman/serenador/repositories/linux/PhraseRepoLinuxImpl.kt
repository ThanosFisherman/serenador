package io.github.thanosfisherman.serenador.repositories.linux

import io.github.thanosfisherman.serenador.commands.Command
import io.github.thanosfisherman.serenador.commands.linux.SpdSayLinuxCommand
import io.github.thanosfisherman.serenador.repositories.PhraseRepo
import io.github.thanosfisherman.serenador.sources.PhrasesSource

internal class PhraseRepoLinuxImpl(private val source: PhrasesSource) : PhraseRepo {


    override fun getSuccessPhrases(): List<Command> {
        return source.getSuccessPhrasesList().map { SpdSayLinuxCommand(it) }.toList()
    }

    override fun getSuccessPhrasesWithVoice(): List<Command> {
        val phrases = getSuccessPhrases().map { it as SpdSayLinuxCommand }
        phrases.getOrNull(0)?.voice = "male1"
        phrases.getOrNull(1)?.voice = "female2"
        phrases.getOrNull(2)?.voice = "child_male"
        phrases.getOrNull(3)?.voice = "child_female"
        return phrases
    }

    override fun getFailPhrases(): List<Command> {
        return source.getFailPhrasesList().map { SpdSayLinuxCommand(it) }.toList()
    }

    override fun getFailPhrasesWithVoice(): List<Command> {
        val phrases = getFailPhrases().map { it as SpdSayLinuxCommand }

        phrases.getOrNull(0)?.voice = "male1"
        phrases.getOrNull(1)?.voice = "male1"
        phrases.getOrNull(2)?.voice = "male1"
        phrases.getOrNull(3)?.voice = "male2"
        phrases.getOrNull(4)?.voice = "male2"
        phrases.getOrNull(5)?.voice = "male2"
        phrases.getOrNull(6)?.voice = "male2"
        return phrases
    }

    override fun getCustomPhrases(customPhrases: List<String>): List<Command> {
        return customPhrases.map { SpdSayLinuxCommand(it) }
    }
}
