import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.hilt.android)
    alias(libs.plugins.devtools.ksp)

    kotlin("plugin.serialization") version "2.0.21"
}

android {
    namespace = "com.sinut.core_data"
    compileSdk = 35

    val localProperties = gradleLocalProperties(rootDir, providers)

    flavorDimensions += "flavor-type"
    productFlavors {
        create("dev") {
            dimension = "flavor-type"
            buildConfigField("String", "FLAVOR", "\"Dev\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("dev.BASE_URL")}\""
            )
        }
        create("stg") {
            dimension = "flavor-type"
            buildConfigField("String", "FLAVOR", "\"Stg\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("stg.BASE_URL")}\""
            )

        }
        create("prd") {
            dimension = "flavor-type"
            buildConfigField("String", "FLAVOR", "\"Prd\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("prd.BASE_URL")}\""
            )
        }
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        buildConfig = true
    }
}

dependencies {
    // Dependencies Injection - Hilt
    implementation(libs.hilt.android)
    ksp(libs.dagger.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)

    // Serialization
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}