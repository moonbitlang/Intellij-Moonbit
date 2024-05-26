package com.github.bytecodealliance

import com.intellij.lang.Language

object WitLanguage : Language("wit") {
    private fun readResolve(): Any = WitLanguage

    override fun getDisplayName(): String {
        return "WIT IDL"
    }
}


