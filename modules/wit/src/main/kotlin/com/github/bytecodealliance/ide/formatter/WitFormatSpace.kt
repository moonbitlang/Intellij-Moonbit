package com.github.bytecodealliance.ide.formatter

import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings

class WitFormatSpace(private val settings: CodeStyleSettings) {
    companion object {
        fun create(settings: CodeStyleSettings) = WitFormatSpace(settings)
    }

    fun getSpacing(child1: Any?, child2: Any?): Any? {
        return null
    }
}