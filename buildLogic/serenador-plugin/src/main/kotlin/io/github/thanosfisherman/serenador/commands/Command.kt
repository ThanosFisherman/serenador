package io.github.thanosfisherman.serenador.commands


abstract class Command {

    abstract val arguments: String
    override fun toString() = arguments
}
