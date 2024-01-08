plugins {
    kotlin("jvm") version "1.9.22"
    id("com.google.protobuf") version "0.9.4"
}

group = "my.study"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/io.grpc/grpc-protobuf
    implementation("io.grpc:grpc-protobuf:1.60.1")
    // https://mvnrepository.com/artifact/io.grpc/grpc-kotlin-stub
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")
    // https://mvnrepository.com/artifact/com.google.protobuf/protobuf-kotlin
    implementation("com.google.protobuf:protobuf-kotlin:3.25.1")
    // https://mvnrepository.com/artifact/io.grpc/grpc-netty
    implementation("io.grpc:grpc-netty:1.60.1")


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.1"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.60.1"
        }
        create("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:1.4.1:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
                create("grpckt")
            }
            it.builtins {
                create("kotlin")
            }
        }
    }
}