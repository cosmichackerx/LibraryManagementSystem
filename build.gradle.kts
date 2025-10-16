plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "com.library"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("com.library.LibraryApplication")
}

tasks.test {
    useJUnitPlatform()
}

kotlinOptions {
    jvmTarget = "17"
    freeCompilerArgs += listOf(
        "-Xjsr305=strict",
        "-language-version", "1.9",
        "-api-version", "1.9"
    )
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        languageVersion = "1.9"
        apiVersion = "1.9"
    }
}