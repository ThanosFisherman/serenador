package io.github.thanosfisherman.serenador.commandexecutors.macos

import io.github.thanosfisherman.serenador.commandexecutors.CommandExecutor
import io.github.thanosfisherman.serenador.commands.Command
import org.gradle.api.Project
import org.gradle.process.ExecResult

class MacCommandExecutor constructor(private val project: Project) : CommandExecutor {
    override fun execute(command: Command): ExecResult {
        return project.exec {
            commandLine("bash", "-c", command)
            isIgnoreExitValue = true
        }
    }
}
