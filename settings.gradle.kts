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
    }
}

rootProject.name = "TheYoyisMovies"
include(":app")

// Módulos de feature
include(":feature:auth")
include(":feature:home")
include(":feature:search")
include(":feature:movie-detail")
include(":feature:player")
include(":feature:profile")

// Módulos core
include(":core:ui")
include(":core:network")
include(":core:database")
include(":core:domain")
include(":core:testing")
include(":core:analytics")
