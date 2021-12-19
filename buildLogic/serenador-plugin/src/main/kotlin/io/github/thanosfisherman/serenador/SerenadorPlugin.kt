package io.github.thanosfisherman.serenador

import io.github.thanosfisherman.serenador.commandexecutors.linux.LinuxCommandExecutor
import io.github.thanosfisherman.serenador.commandexecutors.macos.MacCommandExecutor
import io.github.thanosfisherman.serenador.extensions.SerenadorExtension
import io.github.thanosfisherman.serenador.extensions.SerenadorExtension.Companion.initSerenadorExtension
import io.github.thanosfisherman.serenador.listeners.MyBuildListener
import io.github.thanosfisherman.serenador.repositories.linux.PhraseRepoLinuxImpl
import io.github.thanosfisherman.serenador.repositories.macos.PhraseRepoMacImpl
import io.github.thanosfisherman.serenador.sources.PhrasesSource
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

        val listener: MyBuildListener? = when {
            Os.isFamily(Os.FAMILY_MAC) -> {
                project.provideMacBuildListener(serenadorExt)
            }
            Os.isFamily(Os.FAMILY_UNIX) -> {
                project.provideLinuxBuildListener(serenadorExt)
            }
            else -> {
                null
            }
        }
        listener?.let { project.gradle.addBuildListener(it) }
    }
}
