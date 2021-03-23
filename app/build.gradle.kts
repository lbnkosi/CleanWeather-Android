plugins {
    AppConfig.apply {
        id(ANDROID_EXTENSIONS)
        id(APPLICATION)
        id(KOTLIN_ANDROID)
        id(KOTLIN_KAPT)
        id(HILT_ANDROID_PLUGIN)
    }
}

android {
    AppConfig.apply {
        compileSdkVersion(COMPILE_SDK_VERSION)
        buildToolsVersion(BUILD_TOOLS_VERSION)

        defaultConfig {
            applicationId = APPLICATION_ID
            minSdkVersion(MIN_SDK_VERSION)
            targetSdkVersion(TARGET_SDK_VERSION)
            versionCode = VERSION_CODE
            versionName = VERSION_NAME

            testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
        }

        buildTypes {
            getByName(BUILD_TYPE) {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile(PROGUARD_FILE), PROGUARD_RULES)
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        kotlinOptions { jvmTarget = "1.8" }

        buildFeatures { dataBinding = true }

        lintOptions { isCheckReleaseBuilds = false }

        hilt { enableExperimentalClasspathAggregation = true }
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    Libs.apply {

        //Arch components
        implementation(FRAGMENT_KTX)
        implementation(LIFECYCLE_COMMON)
        implementation(LIFECYCLE_RUNTIME)
        implementation(LIFECYCLE_LIVEDATA)
        implementation(LIFECYCLE_VIEWMODEL)
        implementation(LIFECYCLE_EXTENSIONS)
        implementation(LIFECYCLE_COMMON_JAVA_8)

        //Play services, Place libs
        implementation(ANDROID_PLACE)
        implementation(GMS_SERVICES_PLACES)
        implementation(GMS_PLAY_SERVICE_MAPS)
        implementation(GMS_PLAY_SERVICES_LOCATION)

        //Android & Kotlin stuff
        implementation(MATERIAL)
        implementation(APP_COMPAT)
        implementation(ANDROID_CORE)
        implementation(SWIPE_REFRESH)
        implementation(CONSTRAINT_LAYOUT)
        implementation(KOTLIN_STANDARD_LIB)
        implementation(KOTLIN_COROUTINES_ANDROID)

        //Room
        kapt(ROOM_COMPILER)
        implementation(ROOM_KTX)
        implementation(ROOM_RUNTIME)
        testImplementation(ROOM_TESTING)

        //Hilt
        kapt(HILT_COMPILER)
        implementation(HILT_ANDROID)
        kapt(HILT_ANDROID_X_COMPILER)
        implementation(HILT_VIEWMODEL)

        //Retrofit
        implementation(RETROFIT)
        implementation(RETROFIT_CONVERTER_GSON)
        implementation(OKHTTP_LOGGING_INTERCEPTOR)

        //Unit testing stuff
        testImplementation(JUNIT)
        androidTestImplementation(ESPRESSO)
        androidTestImplementation(ANDROID_TEST_JUNIT)

        //Stetho
        implementation(STETHO)
        implementation(STETHO_OKTTP)

        //Glide
        implementation(GLIDE)
        annotationProcessor(GLIDER_COMPILER)

        //Stream Support
        implementation(STREAM_SUPPORT)

        //Easy permissions
        implementation(EASY_PERMISSIONS)
    }
}