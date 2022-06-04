plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    kotlin(BuildPlugins.KOTLIN_ANDROID)
    kotlin(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.SAFE_ARGS)
}

android {

    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AndroidConfig.APPLICATION_ID
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }
    buildTypes {
        getByName(AndroidConfig.BuildType.RELEASE) {
            isMinifyEnabled = AndroidConfig.BuildTypeRelease.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName(AndroidConfig.BuildType.DEBUG) {
            isMinifyEnabled = AndroidConfig.BuildTypeDebug.isMinifyEnabled
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    namespace = "com.nora.devbyte"

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    // appcompat
    implementation(Libraries.appcompat)

    // coil
    implementation(Libraries.coil)

    // constraint
    implementation(Libraries.constraintLayout)

    // core
    implementation(Libraries.core)

    // coroutines
    implementation(Libraries.coroutinesAndroid)
    implementation(Libraries.coroutinesCore)

    // joda
    implementation(Libraries.jodaTime)

    // koin
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinCore)
    implementation(Libraries.koinNavigation)
    implementation(Libraries.koinWork)

    // kotlin
    implementation(Libraries.kotlinStdlib)

    // lifecycle
    implementation(Libraries.lifecycleLivedata)
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.lifecycleViewmodel)
    kapt(Libraries.lifecycleCompiler)

    // localization
    implementation(Libraries.localization)

    // material
    implementation(Libraries.materialDesign)

    // moshi
    implementation(Libraries.moshi)
    kapt(Libraries.moshiCodeGen)

    // navigation
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationUi)

    // paging
    implementation(Libraries.paging)

    // recyclerview
    implementation(Libraries.recyclerView)

    // retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitMoshiConverter)

    // room
    implementation(Libraries.room)
    implementation(Libraries.roomRuntime)
    kapt(Libraries.roomCompiler)

    // swipe
    implementation(Libraries.swipeRefreshLayout)

    // timber
    implementation(Libraries.timber)

    // work
    implementation(Libraries.work)

    // test
    // espresso
    androidTestImplementation(Libraries.espressoCore)

    // junit
    testImplementation(Libraries.jUnit)
    androidTestImplementation(Libraries.jUnitExt)
}
