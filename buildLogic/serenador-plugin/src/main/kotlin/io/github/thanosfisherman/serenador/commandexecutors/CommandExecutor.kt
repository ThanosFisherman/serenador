package io.github.thanosfisherman.serenador.commandexecutors

import io.github.thanosfisherman.serenador.commands.Command
import org.gradle.process.ExecResult

interface CommandExecutor{

    fun execute(command: Command): ExecResult
}
