plugins {
    id("com.android.library")
    id("kotlin-android")
    id ("kotlin-kapt")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode(1)
        versionName("1.0")

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    kapt("com.google.dagger:hilt-compiler:2.33-beta")
    implementation("com.google.dagger:hilt-android:2.33-beta")

    Libs.apply {
        //Retrofit
        implementation(RETROFIT)
        implementation(RETROFIT_CONVERTER_GSON)
        implementation(OKHTTP_LOGGING_INTERCEPTOR)

        //Stream Support
        implementation(STREAM_SUPPORT)

        //Timber
        implementation(TIMBER)

    }

    Libs.apply {
        implementation(KOTLIN_COROUTINES_ANDROID)
        implementation(KOTLIN_COROUTINES)
        implementation(KOTLIN_STANDARD_LIB)

        //Room
        kapt(ROOM_COMPILER)
        implementation(ROOM_KTX)
        implementation(ROOM_RUNTIME)
        testImplementation(ROOM_TESTING)

    }

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.31")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}