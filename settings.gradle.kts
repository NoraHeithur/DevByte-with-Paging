pluginManagement {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    plugins {
        id("com.android.application") version "7.2.1"
        id("com.android.library") version "7.2.1"
        kotlin("android") version "1.6.21"
        id("androidx.navigation.safeargs.kotlin") version "2.4.2"
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application", "com.android.library" -> {
                    useModule("com.android.tools.build:gradle:7.2.1")
                }
                "androidx.navigation.safeargs.kotlin" -> {
                    useModule("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
                }
            }
        }
    }
}

rootProject.name = "DevByte"
include(":app")