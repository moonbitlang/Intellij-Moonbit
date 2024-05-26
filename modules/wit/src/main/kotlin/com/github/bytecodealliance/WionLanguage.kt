package com.github.bytecodealliance

import com.intellij.lang.Language

object WionLanguage : Language("wion") {
    private fun readResolve(): Any = WionLanguage
    override fun getDisplayName(): String {
        return "wion"
    }
}