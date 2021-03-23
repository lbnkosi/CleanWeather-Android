object Libs {

    const val KOTLIN_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3"
    const val KOTLIN_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1"

    const val KOTLIN_STANDARD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:1.4.31"
    const val ANDROID_CORE = "androidx.core:core-ktx:1.3.2"

    const val JUNIT = "junit:junit:4.+"
    const val ANDROID_TEST_JUNIT = "androidx.test.ext:junit:1.1.2"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:3.3.0"

    //Android - Google
    const val APP_COMPAT = "androidx.appcompat:appcompat:1.2.0"
    const val VIEW_PAGER_2 = "androidx.viewpager2:viewpager2:1.0.0"
    const val MATERIAL = "com.google.android.material:material:1.3.0"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val SWIPE_REFRESH = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    //Lottie
    const val LOTTIE = "com.airbnb.android:lottie:3.6.0"

    //Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:4.9.0"

    const val TIMBER = "com.jakewharton.timber:timber:4.7.1"

    const val DAGGER = "com.google.dagger:dagger:2.28"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android:2.23.2"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:2.23.2" //KAPT
    const val DAGGER_ANDROID_SUPPORT = "com.google.dagger:dagger-android-support:2.23.2"
    const val DAGGER_ANDROID_PROCESSOR = "com.google.dagger:dagger-android-processor:2.23.2" //KAPT
    const val DAGGER_ANDROID_PROCESSOR_ANT = "com.google.dagger:dagger-android-processor:2.23.2" //AnnotationProcessor

    //Arch Components
    const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common:2.3.0"
    const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.0"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.3.0"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.0"
    const val LIFECYCLE_COMMON_JAVA_8 = "androidx.lifecycle:lifecycle-common-java8:2.3.0"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0"

    //Room - https://developer.android.com/jetpack/androidx/releases/room
    const val ROOM_COMPILER = "androidx.room:room-compiler:2.2.6" //Kapt
    const val ROOM_KTX = "androidx.room:room-ktx:2.2.6"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:2.2.6"
    const val ROOM_TESTING = "androidx.room:room-testing:2.2.6" //testImplementation

    //Stetho - https://github.com/facebookarchive/stetho
    const val STETHO = "com.facebook.stetho:stetho:1.5.1"
    const val STETHO_OKTTP = "com.facebook.stetho:stetho-okhttp3:1.5.1"

    //StreamSupport - https://github.com/stefan-zobel/streamsupport
    const val STREAM_SUPPORT = "net.sourceforge.streamsupport:streamsupport:1.7.3"

    //Glide - https://github.com/bumptech/glide
    const val GLIDE = "com.github.bumptech.glide:glide:4.12.0"
    const val GLIDER_COMPILER = "com.github.bumptech.glide:compiler:4.12.0" //annotationProcessor

    const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:2.4.0"

    const val MULTIDEX = "androidx.multidex:multidex:2.0.1"

    //Project Build Gradle
    const val BUILD_GRADLE = "com.android.tools.build:gradle:4.1.2"
    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31"
    const val GOOGLE_SERVICES = "com.google.gms:google-services:4.3.5"

    //Play services & place libs
    const val ANDROID_PLACE = "com.google.android.libraries.places:places:2.4.0"
    const val GMS_PLAY_SERVICE_MAPS = "com.google.android.gms:play-services-maps:17.0.0"
    const val GMS_SERVICES_PLACES = "com.google.android.gms:play-services-places:17.0.0"
    const val GMS_PLAY_SERVICES_LOCATION = "com.google.android.gms:play-services-location:18.0.0"

    //Easy permissions
    const val EASY_PERMISSIONS = "pub.devrel:easypermissions:3.0.0"

    const val ANDROID_DEBUG = "com.amitshekhar.android:debug-db:1.0.6"

    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:26.7.0"
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx"

    const val HILT_ANDROID = "com.google.dagger:hilt-android:2.33-beta"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:2.33-beta"
    const val HILT_ANDROID_X_COMPILER = "androidx.hilt:hilt-compiler:1.0.0-beta01"
    const val HILT_VIEWMODEL =  "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"

    const val GRADLE = "com.android.tools.build:gradle:4.1.3"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31"
    const val HILT_GRADLE = "com.google.dagger:hilt-android-gradle-plugin:2.33-beta"
}