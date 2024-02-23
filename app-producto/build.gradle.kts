plugins {
    id("java")
    id("io.quarkus") version "3.6.5"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val quarkusVersion = "3.6.5"

dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:${quarkusVersion}"))

    implementation("io.quarkus:quarkus-arc") //CDI: Arc
    implementation("io.quarkus:quarkus-resteasy-reactive") //JAX-RS: RESTEasy
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson") //JAX-RS-Json: Jackson
    implementation("io.quarkus:quarkus-hibernate-orm-panache") //JPA: Hibernate
    implementation("io.quarkus:quarkus-jdbc-postgresql") //Driver JDBC: PostgreSQL


    implementation("org.eclipse.microprofile.config:microprofile-config-api:4.0") // MicroProfile Config
    implementation("org.eclipse.microprofile.rest.client:microprofile-rest-client-api:4.0") // MicroProfile Rest Client
    implementation("org.eclipse.microprofile.health:microprofile-health-api:4.0") // MicroProfile Health
}

tasks.test {
    useJUnitPlatform()
}