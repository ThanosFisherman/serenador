import org.gradle.api.Project
import java.util.*
import kotlin.collections.LinkedHashMap

object MavenArtifact {

    val ARTIFACT_NAME = "serenador"
    val ARTIFACT_GROUP = "io.github.thanosfisherman.serenador"
    val VERSION_NAME = "1.0"
    val POM_URL = "https://github.com/ThanosFisherman/serenador"
    val POM_SCM_URL = "https://github.com/ThanosFisherman/serenador"
    val POM_SCM_CONNECTION = "scm:git:github.com/ThanosFisherman/serenador.git"
    val POM_SCM_DEV_CONNECTION = "scm:git:ssh://github.com/ThanosFisherman/serenador.git"
    val POM_ISSUE_URL = "https://github.com/ThanosFisherman/serenador/issues"
    val POM_DESC = "Gradle plugin utilizing text to speech to give you feedback about your project's build state"
    val TAGS = listOf("gradle", "plugin", "serenador", "kotlin")

    val GITHUB_REPO = "ThanosFisherman/serenador"
    val GITHUB_README = "README.md"
    val LIBRARY_NAME = "serenador"

    val POM_LICENSE_NAME = "The Apache Software License, Version 2.0"
    val POM_LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0.txt"
    val POM_LICENSE_DIST = "http://www.apache.org/licenses/LICENSE-2.0.txt"

    val POM_DEVELOPER_ID = "thanosfisherman"
    val POM_DEVELOPER_NAME = "Thanos Psaridis"
    val DEVELOPER_EMAIL = "psaridis@gmail.com"

    val RELEASE_REPO_URL = "https://oss.sonatype.org/service/local/staging/deploy/maven2"
    val SNAPSHOT_REPO_URL = "https://oss.sonatype.org/content/repositories/snapshots"
    val REPO_NAME = "sonatype"
}

object PluginArtifact {
    val WEBSITE = MavenArtifact.POM_URL
    val VCS_URL = MavenArtifact.POM_URL
    val DESCRIPTION = MavenArtifact.POM_DESC
    val TAGS = MavenArtifact.TAGS
    val PLUGIN_ID = MavenArtifact.ARTIFACT_GROUP
    val PLUGIN_NAME = "serenadorPlugin"
    val DISPLAY_NAME = "Serenador Plugin"
    val VERSION_NAME = MavenArtifact.VERSION_NAME
}

