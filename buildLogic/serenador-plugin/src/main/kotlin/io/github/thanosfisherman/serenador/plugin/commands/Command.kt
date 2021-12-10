package io.github.thanosfisherman.serenador.plugin.commands

import io.github.thanosfisherman.serenador.plugin.failPhraseList
import io.github.thanosfisherman.serenador.plugin.successPhraseList


abstract class Command {
    abstract val arguments: String

    override fun toString() = arguments

    companion object {
        val sayCommandsSuccessList: List<Command> = successPhraseList.map { SayCommand(it.text, it.voice) }
        val sayCommandsFailList: List<Command> = failPhraseList.map { SayCommand(it.text, it.voice) }
    }
}

class SearchVoicesCommand(private val voice: String) : Command() {
    override val arguments: String
        get() = "say -v '?' | grep -o \"$voice\""
}

class SayCommand(private val text: String, private val voice: String? = null) : Command() {
    override val arguments: String
        get() = voice?.let { "say -v \"$it\" \"$text\"" } ?: "say \"$text\""
}
