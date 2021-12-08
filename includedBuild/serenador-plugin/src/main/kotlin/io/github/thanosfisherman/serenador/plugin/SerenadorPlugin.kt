package io.github.thanosfisherman.serenador.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState

val phrases = mapOf(
    "Bad News" to "Build process fail oh my god you look so pale",
    "Bad News2" to "Your project failed now it's time to serenade",
    "Bad News3" to "Your project failed and I will now serenade",
    "Bad News4" to "Don't git commit cause your project is like shit your project manager will be mad a bit",
    "Cello" to "Gradle project fail fail fail oh my god EPIC fail try again tomorrow maybe you get better luck",
    "Cello2" to "In the hall of mountain king I can see your work sink what a sudden failure for your project fa la la",
    "Cello3" to "Sorry but your coding sucks now it's time for some guts try to ask Patrice because your project gently weeps",
    "Good News" to "Congratulations"
)

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
                            commandLine("say", "-v", "Good News", phrases["Good News"])
                        }
                    }
                }
            }
        })
    }
}
