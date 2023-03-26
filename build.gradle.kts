plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.7.4"
    id("io.micronaut.test-resources") version "3.7.4"
    id( "com.github.davidmc24.gradle.plugin.avro") version "1.6.0"
}

version = "0.1"
group = "com.example"

val kotlinVersion= project.properties["kotlinVersion"]
val confluenticVersion= project.properties["confluenticVersion"]
repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io/")
        url = uri("https://jcenter.bintray.com")
        url = uri("https://packages.confluent.io/maven/")
    }
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.kafka:micronaut-kafka")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")

    implementation("org.apache.avro:avro:1.11.0")

    // Confluent
    implementation("io.confluent:kafka-schema-registry-client:${confluenticVersion}")
    implementation("io.confluent:kafka-streams-avro-serde:${confluenticVersion}")
    implementation("io.confluent:kafka-avro-serializer:${confluenticVersion}")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}


application {
    mainClass.set("com.example.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
    testResources {
        sharedServer.set(true)
    }
}

val generateAvro = tasks.register<com.github.davidmc24.gradle.plugin.avro.GenerateAvroJavaTask>("generateAvro") {
    source("src/main/resources/avro")
    this.setOutputDir(file("src/main/java"))
}

tasks.withType<JavaCompile> {
    dependsOn("generateAvro")
}

avro {
    stringType.set("CharSequence")
    fieldVisibility.set("private")
    customConversion(org.apache.avro.Conversions.UUIDConversion::class.java)
}
