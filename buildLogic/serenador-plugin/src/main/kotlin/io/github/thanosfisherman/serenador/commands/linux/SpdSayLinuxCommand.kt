package io.github.thanosfisherman.serenador.commands.linux

import io.github.thanosfisherman.serenador.commands.Command

class SpdSayLinuxCommand(private val text: String, var voice: String? = null) : Command() {
    override val arguments: String
        get() = voice?.let { "spd-say -w -t \"$it\" \"$text\"" } ?: "spd-say \"$text\""
}
