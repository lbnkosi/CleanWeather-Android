plugins {
    id("kotlin-android-extensions")
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {

    compileSdkVersion(30)
    buildToolsVersion = "30.0.2"

    defaultConfig {
        applicationId = "com.lbnkosi.weatherapp"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    Libs.apply {

        implementation(ANDROID_CORE)
        implementation(KOTLIN_STANDARD_LIB)

        implementation(MATERIAL)
        implementation(APP_COMPAT)
        implementation(SWIPE_REFRESH)
        implementation(CONSTRAINT_LAYOUT)

        //Room
        kapt(ROOM_COMPILER)
        implementation(ROOM_KTX)
        implementation(ROOM_RUNTIME)
        testImplementation(ROOM_TESTING)

        //Retrofit
        implementation(RETROFIT)
        implementation(RETROFIT_CONVERTER_GSON)
        implementation(OKHTTP_LOGGING_INTERCEPTOR)

        //Stetho
        implementation(STETHO)
        implementation(STETHO_OKTTP)

        implementation(KOTLIN_COROUTINES_ANDROID)

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

        kapt(HILT_COMPILER)
        implementation(HILT_ANDROID)
        kapt (HILT_ANDROID_X_COMPILER)
        implementation (HILT_VIEWMODEL)

        //Stream Support
        implementation(STREAM_SUPPORT)

        //Easy permissions
        implementation(EASY_PERMISSIONS)

        implementation(GLIDE)
        annotationProcessor(GLIDER_COMPILER)

        testImplementation(JUNIT)
        androidTestImplementation(ESPRESSO)
        androidTestImplementation(ANDROID_TEST_JUNIT)
    }
}