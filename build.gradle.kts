import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.20"
    maven
}

val groupId = "jp.aoichaan0513"
group = groupId
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val repo = File(rootDir, "repository")
tasks {
    "uploadArchives"(Upload::class) {
        repositories {
            withConvention(MavenRepositoryHandlerConvention::class) {
                mavenDeployer {
                    withGroovyBuilder {
                        "repository"("url" to uri("file://${repo.absolutePath}"))
                    }

                    pom.project {
                        withGroovyBuilder {
                            "parent" {
                                "groupId"(groupId)
                                "artifactId"(rootProject.name)
                                "version"(version)
                            }
                        }
                    }
                }
            }
        }
    }
}