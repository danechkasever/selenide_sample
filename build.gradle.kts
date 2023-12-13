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
    const val TESTNG = "7.8.0"
    const val ASPECTJ = "1.9.20.1"
}
dependencies {
    implementation("org.awaitility:awaitility:${Versions.AWAITITILY}")
    implementation("org.apache.logging.log4j:log4j-core:${Versions.LOG4}")
    testAnnotationProcessor("org.projectlombok:lombok:${Versions.LOMBOK}")
    implementation("io.qameta.allure:allure-java-commons:${Versions.ALLURE}")
    implementation("io.qameta.allure:allure-testng:${Versions.ALLURE}")
    implementation("io.qameta.allure:allure-selenide:${Versions.ALLURE}")
    implementation("com.codeborne:selenide:${Versions.SELENIDE}")
    implementation("org.testng:testng:${Versions.TESTNG}")
    implementation("com.google.inject:guice:5.0.1")
    runtimeOnly("org.aspectj:aspectjweaver:${Versions.ASPECTJ}")

}

allure {
    setVersion("${Versions.ALLURE}")
}
tasks.test {
    ignoreFailures = true
    useTestNG()
    testLogging.showStandardStreams = true
}