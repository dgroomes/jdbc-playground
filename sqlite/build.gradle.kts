plugins {
    java
    application
}

repositories {
    mavenCentral()
}

val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val sqliteVersion = "3.34.0" // releases: https://github.com/xerial/sqlite-jdbc/releases/tag/3.34.0


dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.xerial:sqlite-jdbc:$sqliteVersion")
}

application {
    mainClass.set("dgroomes.App")
}
