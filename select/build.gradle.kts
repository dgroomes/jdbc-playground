plugins {
    java
    application
}

repositories {
    mavenLocal()
    jcenter()
}

val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val postgresVersion = "42.2.18" // releases: https://search.maven.org/artifact/org.postgresql/postgresql

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
}

application {
    mainClass.set("dgroomes.App")
}
