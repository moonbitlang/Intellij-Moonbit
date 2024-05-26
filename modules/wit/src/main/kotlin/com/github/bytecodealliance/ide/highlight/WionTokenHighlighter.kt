package com.github.bytecodealliance.ide.highlight

import com.github.bytecodealliance.language.psi.WionParserDefinition
import com.github.bytecodealliance.language.psi.WionTypes.*
//import com.intellij.json.JsonElementTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class WionTokenHighlighter : SyntaxHighlighter {
    override fun getHighlightingLexer(): Lexer {
        return WionParserDefinition().createLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (val key = wionColor(tokenType)?.textAttributesKey) {
            null -> emptyArray()
            else -> arrayOf(key)
        }
    }

    private fun wionColor(tokenType: IElementType): WionColor? {
        return when (tokenType) {
            KW_TRUE, KW_FALSE -> WionColor.BOOLEAN
            KW_SOME -> WionColor.BUILTIN
            KW_NONE -> WionColor.BUILTIN
            KW_FINE, KW_FAIL -> WionColor.BUILTIN
            STRING_S1, STRING_S2 -> WionColor.STRING
            BIN, OCT, HEX, DEC -> WionColor.NUMBER

            ADD, SUB -> WionColor.BUILTIN
            // 注释
//            JsonElementTypes.LINE_COMMENT -> WionColor.LINE_COMMENT
//            JsonElementTypes.BLOCK_COMMENT -> WionColor.BLOCK_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> WionColor.BAD_CHARACTER
            else -> null
        }
    }

}