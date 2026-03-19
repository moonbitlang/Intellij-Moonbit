package com.github.bytecodealliance.language.psi

import com.github.bytecodealliance.WitxLanguage
import com.intellij.psi.tree.IElementType

class WitxTokenType(debugName: String) : IElementType(debugName, WitxLanguage) {
    override fun toString(): String = "WitxTokenType.${super.toString()}"
}
