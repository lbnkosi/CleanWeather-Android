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

    hilt {
        enableExperimentalClasspathAggregation = true
    }
    lintOptions {

        isCheckReleaseBuilds = false

    }
}

dependencies {

    Libs.apply {

        implementation(SWIPE_REFRESH)

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

        //Stream Support
        implementation(STREAM_SUPPORT)

        //Easy permissions
        implementation(EASY_PERMISSIONS)
    }

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation("com.google.dagger:hilt-android:2.33-beta")
    kapt("com.google.dagger:hilt-compiler:2.33-beta")

    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt ("androidx.hilt:hilt-compiler:1.0.0-beta01")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.31")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}