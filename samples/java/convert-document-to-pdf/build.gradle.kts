/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("buildlogic.java-conventions")
}

dependencies {
    api(project(":docfilters-sample"))
}

tasks.withType<Jar> {
    mustRunAfter(":docfilters-sample:jar")
    
    manifest {
         attributes["Main-Class"] = "com.documentfilters.ConvertDocumentToPDF"
    }
    
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

tasks.register<Copy>("copyJars") {
    from("${buildDir}/libs")
    include("**/*.jar")
    into("../libs")
}

tasks.named<Jar>("jar") {
    dependsOn("copyJars")
}

description = "Convert Document to PDF"
