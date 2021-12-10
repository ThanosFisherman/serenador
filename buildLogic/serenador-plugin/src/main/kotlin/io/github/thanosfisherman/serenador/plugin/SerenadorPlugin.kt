package io.github.thanosfisherman.serenador.plugin

import io.github.thanosfisherman.serenador.plugin.commands.Command
import io.github.thanosfisherman.serenador.plugin.commands.SayCommand
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState
import java.io.ByteArrayOutputStream

class SerenadorPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        lel(project)

    }

    private fun lel(project: Project) {
        project.gradle.taskGraph.addTaskExecutionListener(object : TaskExecutionListener {
            override fun beforeExecute(task: Task) {
            }

            override fun afterExecute(task: Task, state: TaskState) {
                if (task.name.contains("assemble")) {
                    println("assembleDebug Executed")
                    if (state.executed) {

                        val outputText = ByteArrayOutputStream().use { baos ->
                            project.exec {

                                commandLine("bash", "-c", Command.sayCommandsFailList.random())
                                standardOutput = baos
                            }
                            baos.toString()
                        }
                        println(outputText)
                    }
                }
            }
        })
    }
}
