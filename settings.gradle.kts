pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
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

rootProject.name = "Helper"
include(":core-ui")
//include(":data")
//include(":domain")
include(":core-domain")
include(":core-data")
