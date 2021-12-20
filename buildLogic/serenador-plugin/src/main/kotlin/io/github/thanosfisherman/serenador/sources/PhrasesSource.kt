package io.github.thanosfisherman.serenador.sources

object PhrasesSource {

    fun getFailPhrasesList(): List<String> {
        return getPhrases("failPhrases.txt")
    }

    fun getSuccessPhrasesList(): List<String> {
        return getPhrases("successPhrases.txt")
    }

    private fun getPhrases(path: String): List<String> {
        val resInputStream = javaClass.classLoader.getResourceAsStream(path) ?: return emptyList()
        return resInputStream.bufferedReader().use { buff ->
            buff.readLines().filter { it.isNotBlank() && !it.contains("#") }.map { it.trim() }
        }
    }
}
