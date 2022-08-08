plugins {
    com.swyrazik.monstersanctuary.companion.`java-convention`
}

dependencies {
    testImplementation(project(":testing:end-to-end:api"))

    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)

    testImplementation(libs.docker.java.core)
    testImplementation(libs.docker.java.transport)
}

// Executes only non-E2E tests by excluding tests tagged with 'e2e' (see @EndToEndTest).
// Use and configure the existing 'test' task so that it can still be used as before
// without unnecessarily adding the burden of also running the slow(er) E2E tests.
// To execute both non-E2E and E2E tests at the same time, the two testing Gradle tasks can be chained,
// for example: ./gradlew test testE2E
tasks.named<Test>("test").configure {
    useJUnitPlatform {
        excludeTags("e2e")
    }
}

// Executes only E2E tests by including only tests tagged with 'e2e' (see @EndToEndTest).
tasks.register<Test>("testE2E") {
    group = "verification"
    description = "Runs the E2E test suite."

    useJUnitPlatform {
        includeTags("e2e")
    }
}
