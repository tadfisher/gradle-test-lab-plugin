plugins {
    id("com.github.ben-manes.versions") version "0.17.0"
}

group = "com.simple.gradle.testlab"
version = "0.2-SNAPSHOT"

subprojects {
    System.out.println(name)
    if (name == "sample") {
        buildscript {
            dependencies {
                classpath(project(":test-lab-plugin"))
            }
        }
    }

    apply { plugin("maven-publish") }

    group = rootProject.group
    version = rootProject.version

    configure<PublishingExtension> {
        repositories {
            maven {
                name = "releases"
                url = uri("https://nexus-build.banksimple.com/repository/simple-maven-releases/")
                credentials {
                    username = properties["nexusUsername"]?.toString()
                    password = properties["nexusPassword"]?.toString()
                }
            }
            maven {
                name = "snapshots"
                url = uri("https://nexus-build.banksimple.com/repository/simple-maven-snapshots/")
                credentials {
                    username = properties["nexusUsername"]?.toString()
                    password = properties["nexusPassword"]?.toString()
                }
            }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "4.6-rc-1"
    distributionType = Wrapper.DistributionType.ALL
}
