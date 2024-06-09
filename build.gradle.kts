/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `java-library`
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }

    maven {
        url = uri("https://maven.pkg.github.com/anjoismysign/BlobLib")
    }

    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/public/")
    }

    maven {
        url = uri("https://libraries.minecraft.net/")
    }

    maven {
        url = uri("https://repo.codemc.io/repository/maven-public/")
    }

    maven {
        url = uri("https://nexuslite.gcnt.net/repos/other/")
    }
}

dependencies {
    implementation(libs.de.tr7zw.item.nbt.api)
    compileOnly(libs.org.spigotmc.spigot.api)
    compileOnly(libs.com.mojang.authlib)

    implementation(libs.folialib)
}

group = "valorless.valorlessutils"
version = "1.7.1"
description = "ValorlessUtils"
java.sourceCompatibility = JavaVersion.VERSION_1_8

// Define the build variable
extra["build"] = 228

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.shadowJar {
    archiveFileName.set("ValorlessUtils-${project.version}.${project.extra["build"]}.jar")

    relocate("com.tcoded.folialib", "valorless.valorlessutils.folialib")
    relocate("de.tr7zw.changeme.nbtapi", "valorless.valorlessutils.nbt")
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand(mapOf("version" to project.version, "build" to project.extra["build"]))
    }
}