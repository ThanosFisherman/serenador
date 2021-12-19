package io.github.thanosfisherman.serenador.listeners

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.tasks.TaskState

//Unused
class TaskListener(private val project: Project) : TaskExecutionListener {

    override fun beforeExecute(task: Task) {
    }

    override fun afterExecute(task: Task, state: TaskState) {

    }
}
