import org.jetbrains.changelog.Changelog
import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.3.20"
    id("org.jetbrains.intellij.platform") version "2.13.1"
    id("org.jetbrains.changelog") version "2.5.0"
    id("org.jetbrains.qodana") version "2025.3.2"
}

group = "MoonLanguage"
version = "0.1.2"

sourceSets["main"].java.srcDirs("src/main/gen")

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")

    intellijPlatform {
        create("IU", "2026.1")
        bundledPlugins(emptyList<String>())
        plugins(listOf("com.github.voml.neo_theme:0.4.3", "PsiViewer:243.7768"))
        // instrumentationTools() - 暂时注释掉，因为API可能已更改
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
            sinceBuild = "240"
            untilBuild = "250.*"
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
    publishPlugin {
        dependsOn(patchChangelog)
    }
}
