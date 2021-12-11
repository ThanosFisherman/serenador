package io.github.thanosfisherman.serenador.plugin

private const val BAD_NEWS = "Bad News"
private const val GOOD_NEWS = "Good News"
private const val CELLO = "Cello"
private const val BELLS = "Bells"

data class PhraseBook(val voice: String, val text: String)

internal val failPhraseList: List<PhraseBook> =
    listOf(
        PhraseBook(BAD_NEWS, "Build process fail oh my god you look so pale"),
        PhraseBook(BAD_NEWS, "Your project failed now it's time to serenade"),
        PhraseBook(BAD_NEWS, "Your project failed and I will now serenade"),
        PhraseBook(
            BAD_NEWS,
            "Don't git commit cause your project is like shit your project manager will be mad a bit"
        ),
        PhraseBook(
            CELLO,
            "Gradle project fail fail fail oh my god EPIC fail try again tomorrow maybe you get better luck"
        ),
        PhraseBook(
            CELLO,
            "In the hall of mountain king I can see your work sink what a sudden failure for your project fa la la"
        ),
        PhraseBook(
            CELLO,
            "Sorry but your coding sucks now it's time for some guts try to ask Patrice because your project gently weeps"
        )
    )

internal val successPhraseList: List<PhraseBook> =
    listOf(
        PhraseBook(
            GOOD_NEWS,
            "Congratulations boy your project succeeded"
        ),
        PhraseBook(
            GOOD_NEWS,
            "Congratulations"
        ),
        PhraseBook(
            BELLS,
            "Your build is done"
        )
    )

