package com.swyrazik.monstersanctuary.companion

plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

repositories {
    mavenCentral()
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
