package io.github.thanosfisherman.serenador.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState

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

                        project.exec {
                            commandLine("say", "-v", PhraseBook.phraseList[3].voice, PhraseBook.phraseList[3].text)
                        }
                    }
                }
            }
        })
    }
}
