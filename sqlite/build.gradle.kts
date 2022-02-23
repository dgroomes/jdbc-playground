plugins {
    java
    application
}

repositories {
    mavenCentral()
}

val slf4jVersion = "1.7.36" // SLF4J releases: http://www.slf4j.org/news.html
val sqliteVersion = "3.36.0.3" // SQLite JDBC releases: https://github.com/xerial/sqlite-jdbc/releases


dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.xerial:sqlite-jdbc:$sqliteVersion")
}

application {
    mainClass.set("dgroomes.App")
}
