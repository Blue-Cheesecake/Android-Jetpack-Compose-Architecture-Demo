plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.hilt.android)
    alias(libs.plugins.devtools.ksp)

    kotlin("plugin.serialization") version "2.0.21"

    id("kotlin-parcelize")
}

android {
    namespace = "com.sinut.androidsamplearch"
    compileSdk = 35

    flavorDimensions += "flavor-type"
    productFlavors {
        create("dev") {
            dimension = "flavor-type"
            applicationId = "com.sinut.androidsamplearch.dev"
            buildConfigField("String", "FLAVOR", "\"Dev\"")
        }
        create("stg") {
            dimension = "flavor-type"
            applicationId = "com.sinut.androidsamplearch.stg"
            buildConfigField("String", "FLAVOR", "\"Stg\"")
        }
        create("prd") {
            dimension = "flavor-type"
            applicationId = "com.sinut.androidsamplearch.prd"
            buildConfigField("String", "FLAVOR", "\"Prd\"")
        }
    }

    defaultConfig {
        applicationId = "com.sinut.androidsamplearch"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    androidResources {
        // Localization
        localeFilters += setOf("en", "th")
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.text.google.fonts)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Compat
    implementation(libs.androidx.appcompat)

    // State Management - ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Dependencies Injection - Hilt
    implementation(libs.hilt.android)
    ksp(libs.dagger.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    // Ui
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.compose.shimmer)
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // Local
    implementation(project(":core_data"))

}