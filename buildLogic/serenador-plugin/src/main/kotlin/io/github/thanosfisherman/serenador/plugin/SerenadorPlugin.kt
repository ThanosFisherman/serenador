package io.github.thanosfisherman.serenador.plugin

import io.github.thanosfisherman.serenador.plugin.extensions.SerenadorExtension.Companion.initSerenadorExtension
import io.github.thanosfisherman.serenador.plugin.listeners.MyBuildListener
import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.Plugin
import org.gradle.api.Project

class SerenadorPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        val serenadorExt = project.initSerenadorExtension()

        project.afterEvaluate {
            if (!serenadorExt.isShutTheFuckUp)
                applyTaskExecutorListener(project)
        }

    }

    private fun applyTaskExecutorListener(project: Project) {

        if (Os.isFamily(Os.FAMILY_MAC))
            project.gradle.addBuildListener(MyBuildListener(project))
    }
}
