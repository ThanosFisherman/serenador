package io.github.thanosfisherman.serenador.plugin.commands

class SearchVoiceCommand(private val voice: String) : Command() {
    override val arguments: String
        get() = "say -v '?' | grep -o \"$voice\""
}
