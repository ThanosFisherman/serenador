package io.github.thanosfisherman.serenador.commandexecutors.linux

import io.github.thanosfisherman.serenador.commandexecutors.CommandExecutor
import io.github.thanosfisherman.serenador.commands.Command
import org.gradle.api.Project
import org.gradle.process.ExecResult

class LinuxCommandExecutor constructor(private val project: Project) : CommandExecutor {
    override fun execute(command: Command): ExecResult {
        return project.exec {
            commandLine("bash", "-c", command)
            isIgnoreExitValue = true
        }
    }
}
