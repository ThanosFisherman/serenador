package io.github.thanosfisherman.serenador

import io.github.thanosfisherman.serenador.commandexecutors.linux.LinuxCommandExecutor
import io.github.thanosfisherman.serenador.extensions.SerenadorExtension
import io.github.thanosfisherman.serenador.extensions.SerenadorExtension.Companion.initSerenadorExtension
import io.github.thanosfisherman.serenador.listeners.MyBuildListener
import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.build.event.BuildEventsListenerRegistry
import javax.inject.Inject

class SerenadorPlugin @Inject constructor(private val buildEventsListenerRegistry: BuildEventsListenerRegistry): Plugin<Project> {
    override fun apply(project: Project) {

        val serenadorExt = project.initSerenadorExtension()

       val pls = project.gradle.sharedServices.registerIfAbsent("cmdExxec",LinuxCommandExecutor::class.java) {
       }

       buildEventsListenerRegistry.onTaskCompletion(pls)
        project.afterEvaluate {
            if (!serenadorExt.isShutTheFuckUp.getOrElse(false))
                applyTaskExecutorListener(project, serenadorExt,project.objects)
        }
    }

    private fun applyTaskExecutorListener(project: Project, serenadorExt: SerenadorExtension, objectFactory: ObjectFactory) {

        val listener: MyBuildListener? = when {
            Os.isFamily(Os.FAMILY_MAC) -> {
                project.provideMacBuildListener(serenadorExt)
            }
            Os.isFamily(Os.FAMILY_UNIX) -> {
                project.provideLinuxBuildListener(objectFactory,serenadorExt)
            }
            else -> {
                null
            }
        }
        listener?.let { project.gradle.addBuildListener(it) }
    }
}
