//Мануал от гугла специально по котлину + проект
//Генерация классов - в проекте по ссылке Maven / Gradle Plugin instructions
//Описание сервиса на сервере через корутины
//https://cloud.google.com/blog/products/application-development/use-grpc-with-kotlin
//https://github.com/grpc/grpc-kotlin?tab=readme-ov-file

//Настройка сервера и клиента
//https://medium.com/swlh/using-grpc-with-kotlin-for-building-microservices-2a79d95a236a

//Как прописать путь до файлов .proto https://stackoverflow.com/questions/66794075/how-to-specify-the-protobuf-path-using-protobuf-gradle-plugin

//Подключение в спринг https://piotrminkowski.com/2023/08/29/introduction-to-grpc-with-spring-boot/

//Настройка шифрования https://itnext.io/how-to-setup-and-test-tls-in-grpc-grpc-web-1b67cc4413e6

//Правильная обработка ошибок https://www.baeldung.com/grpcs-error-handling

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