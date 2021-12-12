package io.github.thanosfisherman.serenador

import io.github.thanosfisherman.serenador.extensions.SerenadorExtension
import io.github.thanosfisherman.serenador.extensions.SerenadorExtension.Companion.initSerenadorExtension
import io.github.thanosfisherman.serenador.listeners.MyBuildListener
import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.Plugin
import org.gradle.api.Project

class SerenadorPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        val serenadorExt = project.initSerenadorExtension()

        project.afterEvaluate {
            if (!serenadorExt.isShutTheFuckUp.getOrElse(false))
                applyTaskExecutorListener(project, serenadorExt)
        }

    }

    private fun applyTaskExecutorListener(project: Project, serenadorExt: SerenadorExtension) {

        if (Os.isFamily(Os.FAMILY_MAC))
            project.gradle.addBuildListener(MyBuildListener(project, serenadorExt))
    }
}
