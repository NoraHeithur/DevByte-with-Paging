object AndroidConfig {
    const val versionName = "1.0"
    const val versionCode = 1

    const val APPLICATION_ID = "com.nora.devbyte"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    const val COMPILE_SDK = 32
    const val TARGET_SDK = 32
    const val MIN_SDK = 24

    interface BuildType {
        companion object {
            const val RELEASE = "release"
            const val DEBUG = "debug"
        }

        val isMinifyEnabled: Boolean
    }

    object BuildTypeDebug : BuildType {
        override val isMinifyEnabled: Boolean = false
    }

    object BuildTypeRelease : BuildType {
        override val isMinifyEnabled: Boolean = false
    }
}