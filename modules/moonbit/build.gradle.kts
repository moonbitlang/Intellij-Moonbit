import org.jetbrains.changelog.Changelog
import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.3.20"
    id("org.jetbrains.intellij.platform") version "2.15.0"
    id("org.jetbrains.changelog") version "2.5.0"
    id("org.jetbrains.qodana") version "2025.3.2"
}

group = "MoonLanguage"
version = "0.1.2"



kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
        snapshots()
    }
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    testImplementation(libs.findLibrary("junit").get())

    intellijPlatform {
        intellijIdea(libs.findVersion("ideaIU").get().toString())
        bundledPlugins(emptyList<String>())
        plugins(listOf(
            "com.github.voml.neo_theme:0.4.3",
            "PsiViewer:243.7768"
        ))
        pluginVerifier()
        zipSigner()
        testFramework(TestFrameworkType.Platform)
    }
}

intellijPlatform {
    pluginConfiguration {
        name = "moon-intellij"
        version = "0.1.2"

        description = "Moonbit plugin for IntelliJ IDEA"

        changeNotes = "Initial release"

        ideaVersion {
            sinceBuild = libs.findVersion("ideaSinceBuild").get().toString()
            untilBuild = libs.findVersion("ideaUntilBuild").get().toString()
        }
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
        channels = listOf("default")
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}

changelog {
    groups.empty()
    repositoryUrl = "https://github.com/oovm/moonbit-custom"
}

tasks {
    runIde {
        maxHeapSize = "4g"
        jvmArgs("-Didea.no.update=true")
        jvmArgs("-Didea.plugins.snapshot.on.the.fly=false")
        jvmArgs("-Didea.suppress.statistics=true")
    }

    publishPlugin {
        dependsOn(patchChangelog)
    }
}