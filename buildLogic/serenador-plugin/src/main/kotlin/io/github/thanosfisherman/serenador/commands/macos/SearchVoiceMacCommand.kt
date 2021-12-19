package io.github.thanosfisherman.serenador.commands.macos

import io.github.thanosfisherman.serenador.commands.Command

class SearchVoiceMacCommand(private val voice: String) : Command() {
    override val arguments: String
        get() = "say -v '?' | grep -o \"$voice\""
}
