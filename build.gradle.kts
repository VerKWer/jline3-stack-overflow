plugins {
	application
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jline:jline:3.25.1")
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
		vendor.set(JvmVendorSpec.ADOPTIUM)
	}
}

application {
	mainClass = "dev.kwer.jline3.example.App"
}

tasks.register<Jar>("fatJar") {
	dependsOn(configurations.runtimeClasspath)
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	archiveBaseName.set("${project.name}-FAT")
	archiveVersion.set("")  // don't add x.y.z-SNAPSHOT to archiveBaseName
	destinationDirectory.set(file("${projectDir}/build"))
	manifest {
		attributes["Main-Class"] = application.mainClass
	}
	from(sourceSets.main.get().output)
	from(configurations.runtimeClasspath.get().map { if(it.isDirectory) it else zipTree(it) })
}
