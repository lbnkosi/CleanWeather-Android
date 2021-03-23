plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AppConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AppConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(AppConfig.MIN_SDK_VERSION)
        targetSdkVersion(AppConfig.TARGET_SDK_VERSION)
        versionCode(AppConfig.VERSION_CODE)
        versionName(AppConfig.VERSION_NAME)

        testInstrumentationRunner(AppConfig.TEST_INSTRUMENTATION_RUNNER)
        consumerProguardFiles(AppConfig.CONSUMER_RULES)
    }

    buildTypes {
        getByName(AppConfig.BUILD_TYPE) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(AppConfig.PROGUARD_FILE), AppConfig.PROGUARD_RULES)
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":domain"))

    Libs.apply {
        //Retrofit
        implementation(RETROFIT)
        implementation(RETROFIT_CONVERTER_GSON)
        implementation(OKHTTP_LOGGING_INTERCEPTOR)

        //Kotlin
        implementation(ANDROID_CORE)
        implementation(KOTLIN_COROUTINES)
        implementation(KOTLIN_STANDARD_LIB)
        implementation(KOTLIN_COROUTINES_ANDROID)

        //Room
        kapt(ROOM_COMPILER)
        implementation(ROOM_KTX)
        implementation(ROOM_RUNTIME)
        testImplementation(ROOM_TESTING)

        //Unit testing
        testImplementation(JUNIT)
        androidTestImplementation(ANDROID_TEST_JUNIT)
        androidTestImplementation(ESPRESSO)

        //Hilt
        kapt(HILT_COMPILER)
        implementation(HILT_ANDROID)

        //Stream Support
        implementation(STREAM_SUPPORT)

        //Timber
        implementation(TIMBER)
    }
}