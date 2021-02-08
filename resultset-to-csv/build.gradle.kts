plugins {
    java
    application
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}

val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val junitVersion = "5.7.0" // releases: https://junit.org/junit5/docs/current/release-notes/index.html
val postgresVersion = "42.2.18" // releases: https://search.maven.org/artifact/org.postgresql/postgresql
val commonsCsvVersion = "1.8" // releases: https://commons.apache.org/proper/commons-csv/changes-report.html

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
    implementation("org.apache.commons:commons-csv:$commonsCsvVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

application {
    mainClass.set("dgroomes.App")
}

tasks {

    withType(Test::class.java) {
        useJUnitPlatform()

        testLogging {
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
}
