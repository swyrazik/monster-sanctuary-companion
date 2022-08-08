plugins {
    com.swyrazik.monstersanctuary.companion.`java-library-convention`
}

dependencies {
    api(libs.junit.api)

    implementation(libs.docker.java.core)
    implementation(libs.docker.java.transport)
}
