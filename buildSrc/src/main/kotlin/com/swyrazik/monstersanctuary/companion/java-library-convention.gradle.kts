package com.swyrazik.monstersanctuary.companion

plugins {
    java
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

repositories {
    mavenCentral()
}

tasks.named<Test>("test").configure {
    useJUnitPlatform()
}
