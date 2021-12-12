package io.github.thanosfisherman.serenador.listeners

import io.github.thanosfisherman.serenador.CommandExecutor
import io.github.thanosfisherman.serenador.executeFailure
import io.github.thanosfisherman.serenador.executeSuccess
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState

class TaskListener(private val project: Project) : TaskExecutionListener {
    var isExecutedOnce = false
    override fun beforeExecute(task: Task) {
    }

    override fun afterExecute(task: Task, state: TaskState) {
        println("TASK NAME " + task.name)
        if (task.name.contains("compile")) {
            if (!isExecutedOnce) {
                val executor = CommandExecutor(project)
                if (state.failure != null) {
                    executor.executeFailure()
                } else if (state.executed) {
                    executor.executeSuccess()
                }
                isExecutedOnce = true
            }
        }

    }
}
