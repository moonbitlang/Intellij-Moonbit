package com.github.bytecodealliance.language.psi

import com.github.bytecodealliance.WionLanguage
import com.intellij.psi.tree.IElementType

class WionTokenType(debugName: String) : IElementType(debugName, WionLanguage) {
    override fun toString(): String = "WionTokenType.${super.toString()}"
}