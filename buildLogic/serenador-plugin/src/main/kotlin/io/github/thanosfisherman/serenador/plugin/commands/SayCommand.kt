package io.github.thanosfisherman.serenador.plugin.commands

class SayCommand(private val text: String, private val voice: String? = null) : Command() {
    override val arguments: String
        get() = voice?.let { "say -v \"$it\" \"$text\"" } ?: "say \"$text\""
}
