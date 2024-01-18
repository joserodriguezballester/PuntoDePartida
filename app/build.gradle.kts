@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
// hilt
//    kotlin("kapt")
//    id("com.google.dagger.hilt.android")
//    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.esqueleto"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.esqueleto"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)

    // ViewModel Compose
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")

    // Navegacion
    implementation (libs.androidx.navigation.compose)

    // Retrofit
    implementation (libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Coil
    implementation(libs.coil.compose)
   // implementation ("io.coil-kt:coil-compose:1.4.0")
  //  implementation ("com.google.accompanist:accompanist-coil:0.7.0")

    implementation("androidx.palette:palette:1.0.0")
// Get Palette by Coil
    implementation ("com.github.satoshun.compose.palette:coil:0.0.2")
    // Timber
    implementation ("com.jakewharton.timber:timber:4.7.1")

    //Hilt
//    implementation(libs.hilt.android)
//    kapt(libs.hilt.android.compiler)
//    implementation (libs.androidx.hilt.navigation.compose)


    //Dagger - Hilt
  //  implementation ("com.google.dagger:hilt-android:2.40.5")
  //  kapt ("com.google.dagger:hilt-android-compiler:2.40.5")
  //  implementation (libs.androidx.hilt.lifecycle.viewmodel)
  //  kapt ("androidx.hilt:hilt-compiler:1.1.0")
  //  implementation (libs.androidx.hilt.navigation.compose)




    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}
// Allow references to generated code
//kapt {
//    correctErrorTypes = true
//}