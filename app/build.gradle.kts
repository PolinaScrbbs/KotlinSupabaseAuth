plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.deyana_auth"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.deyana_auth"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        compose = true
    }
}

dependencies {

    // Основные библиотеки AndroidX
    implementation(libs.androidx.core.ktx) // Kotlin Extensions for AndroidX
    implementation(libs.androidx.lifecycle.runtime.ktx) // Для работы с жизненным циклом
    implementation(libs.androidx.activity.compose) // Compose для активностей
    implementation(platform(libs.androidx.compose.bom)) // BOM для Compose
    implementation(libs.androidx.ui) // Базовые компоненты UI Compose
    implementation(libs.androidx.ui.graphics) // Графика для Compose
    implementation(libs.androidx.ui.tooling.preview) // Инструменты для предпросмотра
    implementation(libs.androidx.material3) // Material Design 3 для Compose

    // Retrofit для HTTP запросов
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Converter для Gson

    // Для тестирования
    testImplementation(libs.junit) // Для юнит-тестов
    androidTestImplementation(libs.androidx.junit) // Для тестирования в Android
    androidTestImplementation(libs.androidx.espresso.core) // Для UI тестов
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose в тестах
    androidTestImplementation(libs.androidx.ui.test.junit4) // UI тесты для Compose

    // Отладочные зависимости для UI
    debugImplementation(libs.androidx.ui.tooling) // Отладка UI для Compose
    debugImplementation(libs.androidx.ui.test.manifest) // Для тестирования манифеста

    // Дополнительные зависимости для работы с сетью и безопасностью
    implementation(libs.androidx.security.crypto) // Для шифрования данных

    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("androidx.core:core-ktx:1.7.0")
}
