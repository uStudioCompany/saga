import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")

    id("detekt-convention")
    id("org.jetbrains.kotlinx.kover")
}

tasks {

    withType<KotlinCompile>()
        .configureEach {
            kotlinOptions {
                jvmTarget = Configuration.JVM.targetVersion
                suppressWarnings = false
                freeCompilerArgs = listOf(
                    "-Xjsr305=strict",
                    "-Xjvm-default=all",
                    "-Xexplicit-api=strict"
                )
            }
        }

    withType<Test> {
        useJUnitPlatform()
    }
}

configure<DetektExtension> {
    source.setFrom(project.files("src/main/kotlin", "src/test/kotlin"))
}
