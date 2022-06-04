// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.ANDROID_APPLICATION) apply false
    id(BuildPlugins.ANDROID_LIBRARY) apply false
    kotlin(BuildPlugins.KOTLIN_ANDROID) apply false
    id(BuildPlugins.SAFE_ARGS) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}