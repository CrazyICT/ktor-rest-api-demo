val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project
val exposed_version: String by project
val mysql_connector_version: String by project
val hikaricp_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "dev.mrcrazy"
version = "0.0.1"

application {
    mainClass.set("dev.mrcrazy.ApplicationKt")
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

    // Logging
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // DB
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")
    implementation("mysql:mysql-connector-java:$mysql_connector_version")
    // @TODO configure correct setup!
    implementation("com.zaxxer:HikariCP:$hikaricp_version")

    // DI
    implementation("io.insert-koin:koin-ktor:$koin_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

// Deploy tasks
tasks {
    jar {
        manifest {
            attributes(
                mapOf(
                    "Main-Class" to "dev.mrcrazy.ApplicationKt",
                    "ImplementationTitle" to project.name,
                    "Implementation-Version" to project.version)
            )
        }
    }
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", "dev.mrcrazy.ApplicationKt"))
        }
    }
}
