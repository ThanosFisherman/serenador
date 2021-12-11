package io.github.thanosfisherman.serenador.plugin.extensions

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class SerenadorExtension @Inject constructor(objects: ObjectFactory) {

    private var isShutTheFuckUpMutable = false
    internal val isShutTheFuckUp get() = isShutTheFuckUpMutable

    /** Configure the inner DSL object, [PhraseBookHandler]. */
    val phraseBook: PhraseBookHandler = objects.newInstance(PhraseBookHandler::class.java)

    /** Configure the inner DSL object, [PhraseBookHandler]. */
    fun phraseBook(action: Action<PhraseBookHandler>) {
        action.execute(phraseBook)
    }

    fun shutTheFuckUp(isShutTheFuck: Boolean) {
        isShutTheFuckUpMutable = isShutTheFuck
    }

    companion object {
        fun Project.initSerenadorExtension(): SerenadorExtension {
            return extensions.create("serenadorExtension", SerenadorExtension::class.java)
        }
    }
}

/**
 * An inner DSL object.
 */
open class PhraseBookHandler {
    private val successPhrasesMutable = mutableListOf<String>()
    internal val successPhrases: List<String> = successPhrasesMutable.toList()

    private val failPhrasesMutable = mutableListOf<String>()
    internal val failPhrases: List<String> = failPhrasesMutable.toList()

    fun addSuccessPhrase(phrase: String) {
        successPhrasesMutable.add(phrase)
    }

    fun addFailPhrase(phrase: String) {
        failPhrasesMutable.add(phrase)
    }
}