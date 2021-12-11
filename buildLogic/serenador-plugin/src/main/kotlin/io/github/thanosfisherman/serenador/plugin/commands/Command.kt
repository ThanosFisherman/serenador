package io.github.thanosfisherman.serenador.plugin.commands

import io.github.thanosfisherman.serenador.plugin.failPhraseList
import io.github.thanosfisherman.serenador.plugin.successPhraseList


abstract class Command {
    abstract val arguments: String

    override fun toString() = arguments

    companion object {
        val sayCommandsSuccessList: List<Command> = successPhraseList.map { SayCommand(it.text, it.voice) }
        val sayCommandsFailList: List<Command> = failPhraseList.map { SayCommand(it.text, it.voice) }
        val sayCommandsSuccessDefaultVoiceList: List<Command> = successPhraseList.map { SayCommand(it.text) }
        val sayCommandsFailDefaultVoiceList: List<Command> = failPhraseList.map { SayCommand(it.text) }
    }
}
