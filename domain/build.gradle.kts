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
        implementation(KOTLIN_COROUTINES_ANDROID)
        implementation(KOTLIN_COROUTINES)
        implementation(KOTLIN_STANDARD_LIB)

        //Dagger
        implementation(DAGGER)
        implementation(DAGGER_ANDROID)
        kapt(DAGGER_COMPILER)
        implementation(DAGGER_ANDROID_SUPPORT)
        kapt(DAGGER_ANDROID_PROCESSOR)
        annotationProcessor(DAGGER_ANDROID_PROCESSOR_ANT)
    }
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.4.31")
}