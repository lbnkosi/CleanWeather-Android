plugins {
    id ("java-library")
    id ("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    Libs.apply {

        implementation(KOTLIN_COROUTINES)
        implementation(KOTLIN_STANDARD_LIB)
        implementation(KOTLIN_COROUTINES_ANDROID)

        //Dagger
        kapt(DAGGER_COMPILER)
        implementation(DAGGER)
        kapt(DAGGER_ANDROID_PROCESSOR)
        implementation(DAGGER_ANDROID)
        implementation(DAGGER_ANDROID_SUPPORT)
        annotationProcessor(DAGGER_ANDROID_PROCESSOR_ANT)
    }
}