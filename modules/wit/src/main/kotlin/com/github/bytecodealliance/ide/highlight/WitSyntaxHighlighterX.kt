package com.github.bytecodealliance.ide.highlight

import com.github.bytecodealliance.language.psi.WitParserDefinitionX
import com.github.bytecodealliance.language.psi.WitTypes
import com.github.bytecodealliance.language.psi.WitxTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class WitSyntaxHighlighterX : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return WitParserDefinitionX().createLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): WitColor? {
        return when (tokenType) {
            KW_TYPE, KW_ENUM, KW_RECORD
            -> WitColor.KEYWORD

            WitTypes.PARENTHESIS_L, WitTypes.PARENTHESIS_R -> WitColor.PARENTHESES
            WitTypes.BRACKET_L, WitTypes.BRACKET_R -> WitColor.BRACKETS
            WitTypes.BRACE_L, WitTypes.BRACE_R -> WitColor.BRACES
            WitTypes.COLON, WitTypes.EQ -> WitColor.OPERATION
            WitTypes.AT, WitTypes.STAR -> WitColor.OPERATION

            WitTypes.COMMA -> WitColor.COMMA
            // atom
            WitTypes.VERSION -> WitColor.NUMBER

            WitTypes.SELECTION_LINE -> WitColor.TEXT
            WitTypes.STRING_QUOTE, WitTypes.STRING_CHAR -> WitColor.STRING
            WitTypes.STRING_ESCAPE -> WitColor.STRING_ESCAPED
//            STRING -> AwslColor.STRING
            WitTypes.SYMBOL -> WitColor.IDENTIFIER
            // 注释
            COMMENT_LINE -> WitColor.LINE_COMMENT
            COMMENT_BLOCK -> WitColor.BLOCK_COMMENT
            COMMENT_DOCUMENT -> WitColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> WitColor.BAD_CHARACTER
            else -> null
        }
    }
}