plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.darkempire78.opencalculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.darkempire78.opencalculator"
        minSdk = 21
        targetSdk = 34
        versionCode = 53
        versionName = "3.2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }

    viewBinding {
        enable = true
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    androidResources {
        // 使用新的 localeFilters 替代已弃用的 resourceConfigurations
        localeFilters.addAll(listOf(
            "ar",    // Arabic
            "az",    // Azerbaijani
            "be",    // Belarusian
            "bn",    // Bengali
            "bs",    // Bosnian
            "cs",    // Czech
            "de",    // German
            "el",    // Greek
            "es",    // Spanish
            "fa",    // Persian
            "fr",    // French
            "hi",    // Hindi
            "hr",    // Croatian
            "hu",    // Hungarian
            "in",    // Indonesian (注意：正确的代码是 "id")
            "it",    // Italian
            "ja",    // Japanese
            "kn",    // Kannada
            "mk",    // Macedonian
            "ml",    // Malayalam
            "nb",    // Norwegian Bokmål (移除地区限定 -rNO)
            "nl",    // Dutch
            "or",    // Odia
            "pl",    // Polish
            "pt-rBR" // Portuguese (Brazil) - 注意格式
        ))
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.preference.ktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidslidinguppanel)
    implementation(libs.androidx.preference.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.gson)
}