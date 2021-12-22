package io.github.thanosfisherman.serenador.commandexecutors.linux

import io.github.thanosfisherman.serenador.commandexecutors.CommandExecutor
import io.github.thanosfisherman.serenador.commands.Command
import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters
import org.gradle.process.ExecOperations
import org.gradle.process.ExecResult
import org.gradle.tooling.events.FinishEvent
import org.gradle.tooling.events.OperationCompletionListener
import javax.inject.Inject

abstract class LinuxCommandExecutor @Inject constructor(private val execOperations: ExecOperations) : CommandExecutor,
    BuildService<BuildServiceParameters.None>, OperationCompletionListener, AutoCloseable{
    override fun execute(command: Command): ExecResult {
        return execOperations.exec {
            commandLine("bash", "-c", command)
            isIgnoreExitValue = true
        }
    }

    override fun onFinish(event: FinishEvent?) {
        println("FINISH EVENT")
    }

    override fun close() {
        println("FINISHED AND CLOSED FOR GOOD")
    }
}
