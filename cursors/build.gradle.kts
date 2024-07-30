plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.slf4j.api)
    runtimeOnly(libs.slf4j.simple)
    implementation(libs.postgres.jdbc)

    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
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
