/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.8/userguide/building_java_projects.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */
import de.qualersoft.jmeter.gradleplugin.task.*

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    `java-library`
    id("com.gradleup.shadow") version "8.3.0"
    id("de.qualersoft.jmeter") version "2.4.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenLocal()
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    // This dependency is used by the application.
    implementation(libs.guava)
    val iroha2Ver by System.getProperties()

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")

    api("com.github.hyperledger.iroha-java:admin-client:iroha2-dev-SNAPSHOT")
    implementation("com.github.hyperledger.iroha-java:model:iroha2-dev-SNAPSHOT")
    implementation("com.github.hyperledger.iroha-java:block:iroha2-dev-SNAPSHOT")

    implementation("net.i2p.crypto:eddsa:0.3.0")
    implementation("org.bouncycastle:bcprov-jdk15on:1.65")
    implementation("com.github.multiformats:java-multihash:1.3.0")
    implementation("org.slf4j:slf4j-simple:1.7.9")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.10.2")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.App"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.App"
    }
}

tasks {
  register<JMeterRunTask>("runJMeter") { // (4)
    jmxFile.set("Test.jmx") // (5)
  }

  register<JMeterGuiTask>("edit") {
    jmxFile.set("Test.jmx")
  }
}