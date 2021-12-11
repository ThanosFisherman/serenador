package io.github.thanosfisherman.serenador.plugin

import io.github.thanosfisherman.serenador.plugin.commands.Command
import org.gradle.api.Project
import org.gradle.process.ExecResult

class CommandExecutor(private val project: Project) {

    fun execute(command: Command): ExecResult {
        return project.exec {
            commandLine("bash", "-c", command)
            isIgnoreExitValue = true
        }
    }
}

fun CommandExecutor.executeSuccess() {
    val result = execute(Command.sayCommandsSuccessList.random())
    if (result.exitValue == 1) {
        execute(Command.sayCommandsSuccessDefaultVoiceList.random())
    }
}

fun CommandExecutor.executeFailure() {
    val result = execute(Command.sayCommandsFailList.random())
    if (result.exitValue == 1) {
        execute(Command.sayCommandsFailDefaultVoiceList.random())
    }
}