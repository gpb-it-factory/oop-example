plugins {
    id("java")
}

group = "ru.gazprombank"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
java {
    //sourceCompatibility = JavaVersion.VERSION_21_PREVIEW
    //targetCompatibility = JavaVersion.VERSION_21_PREVIEW
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}