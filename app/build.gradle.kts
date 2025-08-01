import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

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
    val localProperties = gradleLocalProperties(rootDir, providers)
    namespace = "com.sinut.androidsamplearch"
    compileSdk = 35

    flavorDimensions += "flavor-type"
    productFlavors {
        create("dev") {
            dimension = "flavor-type"
            applicationId = "com.sinut.androidsamplearch.dev"
            buildConfigField("String", "FLAVOR", "\"Dev\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("dev.BASE_URL")}\""
            )
        }
        create("stg") {
            dimension = "flavor-type"
            applicationId = "com.sinut.androidsamplearch.stg"
            buildConfigField("String", "FLAVOR", "\"Stg\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("stg.BASE_URL")}\""
            )

        }
        create("prd") {
            dimension = "flavor-type"
            applicationId = "com.sinut.androidsamplearch.prd"
            buildConfigField("String", "FLAVOR", "\"Prd\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("prd.BASE_URL")}\""
            )
        }
    }

    defaultConfig {
        applicationId = "com.sinut.androidsamplearch"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // State Management - ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Dependencies Injection - Hilt
    implementation(libs.hilt.android)
    ksp(libs.dagger.hilt.android.compiler)

    // Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    // Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
}