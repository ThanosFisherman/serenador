package io.github.thanosfisherman.serenador

import io.github.thanosfisherman.serenador.commandexecutors.linux.LinuxCommandExecutor
import io.github.thanosfisherman.serenador.commandexecutors.macos.MacCommandExecutor
import io.github.thanosfisherman.serenador.extensions.SerenadorExtension
import io.github.thanosfisherman.serenador.listeners.MyBuildListener
import io.github.thanosfisherman.serenador.repositories.linux.PhraseRepoLinuxImpl
import io.github.thanosfisherman.serenador.repositories.macos.PhraseRepoMacImpl
import io.github.thanosfisherman.serenador.sources.PhrasesSource
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory


fun Project.provideMacBuildListener(serenadorExtension: SerenadorExtension): MyBuildListener {
    return MyBuildListener(MacCommandExecutor(this), PhraseRepoMacImpl(PhrasesSource), serenadorExtension)
}

fun Project.provideLinuxBuildListener(
    objectFactory: ObjectFactory,
    serenadorExtension: SerenadorExtension
): MyBuildListener {
    val cmd = objectFactory.newInstance(LinuxCommandExecutor::class.java)
    return MyBuildListener(
        cmd,
        PhraseRepoLinuxImpl(PhrasesSource),
        serenadorExtension
    )
}
