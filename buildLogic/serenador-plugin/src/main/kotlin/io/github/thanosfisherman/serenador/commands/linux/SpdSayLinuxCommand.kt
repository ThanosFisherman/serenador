package io.github.thanosfisherman.serenador.commands.linux

import io.github.thanosfisherman.serenador.commands.Command

class SpdSayLinuxCommand(private val text: String, var voice: String? = null) : Command() {
    override val arguments: String
        get() = voice?.let { "spd-say -w -r ${randomRate()} -t \"$it\" \"$text\"" }
            ?: "spd-say -w -r ${randomRate()} \"$text\""

    private fun randomRate(): String {
        return (-90..0).random().toString()
    }
}
