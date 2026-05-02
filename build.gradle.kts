plugins {
    id("org.jetbrains.kotlin.jvm") version "2.3.20" apply false
    id("org.jetbrains.intellij.platform") version "2.16.0" apply false
    id("org.jetbrains.changelog") version "2.5.0" apply false
    id("org.jetbrains.qodana") version "2025.3.2" apply false
}

group = "MoonLanguage"
version = "0.1.2"

// 共享配置
val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

