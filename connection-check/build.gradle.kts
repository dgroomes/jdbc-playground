plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.slf4j.api)
    runtimeOnly(libs.slf4j.simple)
    implementation(libs.postgres.jdbc)
}

application {
    mainClass.set("dgroomes.ConnectionCheckApp")
}
