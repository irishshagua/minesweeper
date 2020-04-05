plugins {
    java
    application
    id("org.openjfx.javafxplugin") version("0.0.8")
}

repositories {
    jcenter()
}

dependencies {
    val junitVersion = "5.6.0"

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

application {
    // Define the main class for the application.
    mainClassName = "com.mooney.minesweeper.Main"
}


javafx {
    version = "14"
    modules = listOf("javafx.controls")
}

tasks {
    test {
        useJUnitPlatform()
        jvmArgs("--enable-preview")
    }

    withType<JavaCompile> {
        this.options.compilerArgs.add("--enable-preview")
    }

    withType<JavaExec> {
        jvmArgs("--enable-preview")
    }
}