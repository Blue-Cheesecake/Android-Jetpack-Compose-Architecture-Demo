import java.util.Properties

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

    val localProperties = Properties()

    flavorDimensions += "flavor-type"
    productFlavors {
        create("dev") {
            val propertiesFile = File(rootDir, "dev.properties")

            if (propertiesFile.exists() && propertiesFile.isFile) {
                propertiesFile.inputStream().use { localProperties.load(it) }
            }

            dimension = "flavor-type"
            buildConfigField("String", "FLAVOR", "\"Dev\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("BASE_URL")}\""
            )
        }
        create("stg") {
            val propertiesFile = File(rootDir, "stg.properties")

            if (propertiesFile.exists() && propertiesFile.isFile) {
                propertiesFile.inputStream().use { localProperties.load(it) }
            }

            dimension = "flavor-type"
            buildConfigField("String", "FLAVOR", "\"Stg\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("BASE_URL")}\""
            )

        }
        create("prd") {
            val propertiesFile = File(rootDir, "prd.properties")

            if (propertiesFile.exists() && propertiesFile.isFile) {
                propertiesFile.inputStream().use { localProperties.load(it) }
            }

            dimension = "flavor-type"
            buildConfigField("String", "FLAVOR", "\"Prd\"")
            buildConfigField(
                "String", "BASE_URL", "\"${localProperties.getProperty("BASE_URL")}\""
            )
        }
    }

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    implementation(libs.androidx.datastore.preferences)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}