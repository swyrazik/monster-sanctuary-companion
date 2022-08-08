rootProject.name = "monster-sanctuary-companion"

// Sub-projects
include("server")
include("testing:end-to-end:api")
include("testing:end-to-end:tests")

// Dependencies
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("junit", "5.9.0")
            library(
                "junit.api",
                "org.junit.jupiter",
                "junit-jupiter-api"
            ).versionRef("junit")
            library(
                "junit.engine",
                "org.junit.jupiter",
                "junit-jupiter-engine"
            ).versionRef("junit")

            version("docker.java", "3.2.13")
            library(
                "docker.java.core",
                "com.github.docker-java",
                "docker-java-core"
            ).versionRef("docker.java")
            library(
                "docker.java.transport",
                "com.github.docker-java",
                "docker-java-transport-httpclient5"
            ).versionRef("docker.java")
        }
    }
}
