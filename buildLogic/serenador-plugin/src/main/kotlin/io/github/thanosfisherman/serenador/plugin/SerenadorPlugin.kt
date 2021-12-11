package io.github.thanosfisherman.serenador.plugin

import io.github.thanosfisherman.serenador.plugin.listeners.MyBuildListener
import org.gradle.api.Plugin
import org.gradle.api.Project

class SerenadorPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        applyTaskExecutorListener(project)
    }

    private fun applyTaskExecutorListener(project: Project) {
        project.gradle.addBuildListener(MyBuildListener(project))
    }
}
