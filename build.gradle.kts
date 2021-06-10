plugins {
    kotlin("jvm") version "1.5.10"
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "com.jiangyc"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("org.mybatis.generator.MainKt")
}

javafx {
    version = "11"
    modules("javafx.controls", "javafx.fxml")
}

repositories {
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/groups/public")
    }
    mavenCentral()
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib"))
    // Kotlin Third-party UI library.
    implementation("no.tornado", "tornadofx", "1.7.20")

    // MyBatis Generator core
    implementation("org.mybatis.generator", "mybatis-generator-core", "1.4.0")
    // A plugin for MyBatis Generator to use Lombok annotations instead of getters and setters
    implementation("com.softwareloop", "mybatis-generator-lombok-plugin", "1.0")

    // JDBC libraries.
    // MySQL
    implementation("mysql", "mysql-connector-java", "8.0.25")
    // PostgreSQL
    implementation("org.postgresql", "postgresql", "42.2.20")
    // SQLite
    implementation("org.xerial", "sqlite-jdbc", "3.34.0")

    // Log libraries.
    implementation("org.slf4j", "slf4j-api", "1.7.30")
    implementation("org.slf4j", "slf4j-simple", "1.7.30")

    // Hutool
    implementation("cn.hutool", "hutool-all", "5.6.7")
    // Jackson databind
    implementation("com.fasterxml.jackson.core", "jackson-databind", "2.12.3")
    // JSch is a pure Java implementation of SSH2
    implementation("com.jcraft", "jsch", "0.1.55")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }
    jar {
        manifest {
            attributes(
                "Main-Class" to "org.mybatis.generator.MainKt"
            )
        }
    }
}