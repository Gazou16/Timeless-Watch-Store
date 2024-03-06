plugins {
	java
	id("org.springframework.boot") version "3.1.9"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.Timeless"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["springModulithVersion"] = "1.0.5"

dependencies {implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	implementation("org.springframework.boot:spring-boot-starter-integration")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.integration:spring-integration-http")
	implementation("org.springframework.integration:spring-integration-jpa")
	implementation("org.springframework.integration:spring-integration-webflux")
	implementation("org.springframework.modulith:spring-modulith-starter-core")
	implementation("org.springframework.modulith:spring-modulith-starter-jpa")
//	implementation("org.springframework.modulith:spring-modulith-starter-mongodb")
//	implementation("org.springframework.integration:spring-integration-mongodb")
//	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("com.mysql:mysql-connector-j")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.integration:spring-integration-test")
	testImplementation("org.springframework.modulith:spring-modulith-starter-test")
	testImplementation("org.testcontainers:junit-jupiter")
//	testImplementation("org.testcontainers:mongodb")
	testImplementation("org.testcontainers:mysql")
	testImplementation("org.testcontainers:postgresql")

	// https://mvnrepository.com/artifact/org.projectlombok/lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")




	// https://mvnrepository.com/artifact/org.mapstruct/mapstruct
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	// https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor
	implementation("org.mapstruct:mapstruct-processor:1.5.5.Final")
	compileOnly ("org.mapstruct:mapstruct-processor:1.5.5.Final")
	annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.5.Final")
	annotationProcessor ("org.projectlombok:lombok")
	annotationProcessor ("org.projectlombok:lombok-mapstruct-binding:0.2.0")
	testAnnotationProcessor ("org.mapstruct:mapstruct-processor:1.5.5.Final")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
