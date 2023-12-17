plugins {
    id("kotlin-common-convention")
    id("java-convention")

    id("org.jetbrains.kotlinx.binary-compatibility-validator")
}

tasks {

    java {
        withJavadocJar()
        withSourcesJar()
    }
}
