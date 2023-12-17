import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.publish.maven.MavenPom

@Suppress("unused")
object Configuration {

    object JVM {
        val targetVersion: String
            get() = System.getenv("JAVA_VERSION") ?: "1.8"

        val compatibility: JavaVersion
            get() = JavaVersion.toVersion(targetVersion)
    }

    object Artifact {
        val jdk: String
            get() = "-jdk" + JVM.compatibility.majorVersion
    }
}
