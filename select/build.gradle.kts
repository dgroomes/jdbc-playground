plugins {
    java
    application
}

repositories {
    mavenCentral()
}

val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val postgresVersion = "42.2.20" // releases: https://jdbc.postgresql.org/ and https://search.maven.org/artifact/org.postgresql/postgresql

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
}

application {
    mainClass.set("dgroomes.App")
}
