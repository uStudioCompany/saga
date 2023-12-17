plugins {
    id("kotlin-library-convention")
    id("kover-merge-convention")
    id("licenses-convention")
}

version = "0.0.1-SNAPSHOT"
group = "io.github.ustudiocompany"

repositories {
    mavenCentral()
}

dependencies {

    /* Kotlin */
    implementation(kotlin("stdlib"))

    /* Test */
    testImplementation(libs.bundles.kotest)
}

tasks {
    compileTestKotlin.configure {
        kotlinOptions {
            freeCompilerArgs += listOf("-Xcontext-receivers")
        }
    }
}
