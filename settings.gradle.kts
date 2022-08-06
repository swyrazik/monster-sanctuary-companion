rootProject.name = "monster-sanctuary-companion"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("junit", "5.9.0")
            library("junit.api", "org.junit.jupiter", "junit-jupiter-api").versionRef("junit")
            library("junit.engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("junit")
        }
    }
}
