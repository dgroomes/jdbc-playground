plugins {
    java
    application
}

repositories {
    mavenCentral()
}

val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val junitVersion = "5.7.1" // releases: https://junit.org/junit5/docs/current/release-notes/index.html
val postgresVersion = "42.2.20" // releases: https://jdbc.postgresql.org/ and https://search.maven.org/artifact/org.postgresql/postgresql

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

application {
    mainClass.set("dgroomes.Runner")
}

val customLogSysProp = "-Djava.util.logging.config.file=custom-logging.properties"

tasks {
    withType(Test::class.java) {
        useJUnitPlatform()

        testLogging {
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }

    named<CreateStartScripts>("startScripts") {
        defaultJvmOpts = listOf(customLogSysProp)
    }

    named<JavaExec>("run") {
        jvmArgs = listOf(customLogSysProp)
    }
}
