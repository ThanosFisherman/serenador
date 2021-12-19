package io.github.thanosfisherman.serenador.commands.macos

import io.github.thanosfisherman.serenador.commands.Command

class SayMacCommand(private val text: String, var voice: String? = null) : Command() {
    override val arguments: String
        get() = voice?.let { "say -v \"$it\" \"$text\"" } ?: "say \"$text\""
}
