plugins {
    com.swyrazik.monstersanctuary.companion.`java-convention`
}

dependencies {
    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)

    testImplementation(libs.docker.java.core)
    testImplementation(libs.docker.java.transport)
}
