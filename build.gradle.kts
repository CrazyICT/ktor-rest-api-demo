val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project
val ktorm_version: String by project
val mysql_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "dev.mrcrazy"
version = "0.0.1"

application {
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=true")
    mainClass.set("dev.mrcrazy.ApplicationKt")
}

tasks {
    jar {
        manifest {
            attributes(
                mapOf(
                    "Main-Class" to "dev.mrcrazy.ApplicationKt", //will make your jar (produced by jar task) runnable
                    "ImplementationTitle" to project.name,
                    "Implementation-Version" to project.version)
            )
        }
    }
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", "dev.example.ApplicationKt"))
        }
    }
}

repositories {
    mavenCentral()
}


dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")

    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-locations:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")

    // DB
    implementation("org.ktorm:ktorm-core:${ktorm_version}")
    implementation("mysql:mysql-connector-java:${mysql_version}")

    // DI
    implementation("io.insert-koin:koin-ktor:$koin_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}