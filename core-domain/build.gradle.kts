plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    id("maven-publish")
}

android {
    namespace = "mx.com.atriz.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "mx.com.atriz"
            artifactId = "core-domain"
            version = "0.0.2"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
    repositories {
        maven {
            name = "Clean-Helper"
            url = uri("https://maven.pkg.github.com/AtrizDeveloper/Clean-Helper")
            credentials{
                username = System.getenv("github_user")
                password = System.getenv("github_token")
            }
        }
    }
}