buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        Libs.apply {
            classpath(GRADLE)
            classpath(HILT_GRADLE)
            classpath(KOTLIN_GRADLE_PLUGIN)
        }
    }
}

allprojects {

    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) { delete(rootProject.buildDir) }