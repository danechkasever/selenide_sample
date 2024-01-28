plugins {
   id("java")
   id("io.freefair.lombok") version "8.4"
   id("io.qameta.allure") version "2.11.2"
}
apply(plugin = "io.qameta.allure")

group = "sample"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
object Versions {
    const val LOMBOK = "1.18.30"
    const val LOG4 = "2.21.0"
    const val AWAITITILY = "4.2.0"
    const val ALLURE = "2.25.0"
    const val SELENIDE = "7.0.1"
    const val JUNIT = "5.10.0"
    const val ASPECTJ = "1.9.20.1"
    const val ASSERTJ = "3.24.2"
    const val GUICE = "7.0.0"
}
dependencies {
    implementation("org.awaitility:awaitility:${Versions.AWAITITILY}")
    implementation("org.assertj:assertj-core:${Versions.ASSERTJ}")
    implementation("org.apache.logging.log4j:log4j-core:${Versions.LOG4}")
    testAnnotationProcessor("org.projectlombok:lombok:${Versions.LOMBOK}")
    implementation("io.qameta.allure:allure-java-commons:${Versions.ALLURE}")
    implementation("io.qameta.allure:allure-junit5:${Versions.ALLURE}")
    implementation("io.qameta.allure:allure-selenide:${Versions.ALLURE}")
    implementation("com.codeborne:selenide-core:${Versions.SELENIDE}")
    implementation("org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT}")
    implementation("org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT}")
    implementation("com.google.inject:guice:${Versions.GUICE}")
    runtimeOnly("org.aspectj:aspectjweaver:${Versions.ASPECTJ}")

}

allure {
    setVersion("${Versions.ALLURE}")
    adapter.autoconfigure.set(true)
    adapter.aspectjVersion.set(Versions.ASPECTJ)
    adapter.frameworks.junit5.adapterVersion.set("2.24.0")
    adapter.frameworks.junit5.enabled.set(true)
}


tasks.test {
    group = "localTesting"
    useJUnitPlatform {
        includeEngines("junit-jupiter")
    }
}