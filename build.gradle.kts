plugins {
    java
    application
    id("org.openjfx.javafxplugin") version ("0.0.8")
    id("org.beryx.jlink") version ("2.12.0")
}

repositories {
    jcenter()
}

dependencies {
    val junitVersion = "5.4.2"

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

jlink {
    options.addAll(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "minesweeper"
        jvmArgs.add("--enable-preview")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_14
    targetCompatibility = JavaVersion.VERSION_14
}

tasks {
    test {
        useJUnitPlatform()
        jvmArgs("--enable-preview")
        testLogging {
            outputs.upToDateWhen { false }
            showStandardStreams = true
        }
    }

    withType<JavaCompile> {
        this.options.compilerArgs.add("--enable-preview")
    }

    withType<JavaExec> {
        jvmArgs("--enable-preview")
    }
}