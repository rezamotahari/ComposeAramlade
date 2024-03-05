plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    kotlin("kapt")
    id("kotlinx-serialization")

    id("app.cash.sqldelight")

}

android {
    namespace = "com.parstamin.composearamkade"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.parstamin.composearamkade"
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0") // for ViewModelScope
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0") // for LifecycleScope


    // Glide
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")

    // Constraint Layout
    implementation("androidx.constraintlayout:constraintlayout:2.2.0-alpha13")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha13")

    val navVersion = "2.7.6"

    implementation("androidx.navigation:navigation-compose:$navVersion")

    implementation("androidx.compose.material:material:1.6.2")


    val ktor = "2.3.8"
    implementation("io.ktor:ktor-client-core:$ktor")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor")
    implementation("io.ktor:ktor-client-android:$ktor")
    implementation("io.ktor:ktor-client-logging:$ktor")

    val koin = "3.5.3"
    implementation("io.insert-koin:koin-core:$koin")
    implementation("io.insert-koin:koin-android:$koin")
    implementation("io.insert-koin:koin-androidx-compose:$koin")

//sqldelight
    implementation("app.cash.sqldelight:android-driver:2.0.0")
    implementation("app.cash.sqldelight:coroutines-extensions-jvm:2.0.0")

}
kapt {
    correctErrorTypes = true
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("com.parstamin.composearamkade.db")
        }
    }
}