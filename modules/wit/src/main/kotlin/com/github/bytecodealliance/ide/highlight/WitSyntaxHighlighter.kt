package com.github.bytecodealliance.ide.highlight


import com.github.bytecodealliance.language.psi.WitParserDefinition
import com.github.bytecodealliance.language.psi.WitTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class WitSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return WitParserDefinition().createLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): WitColor? {
        return when (tokenType) {
            KW_PACKAGE, KW_WORLD, KW_INTERFACE,
            KW_INCLUDE, KW_USE, KW_IMPORT, KW_EXPORT, KW_AS,
            KW_TYPE, KW_RESOURCE, KW_RECORD, KW_VARIANT, KW_FLAGS, KW_ENUM,
            KW_FUNCTION, KW_CONSTRUCTOR,
            -> WitColor.KEYWORD

            PARENTHESIS_L, PARENTHESIS_R -> WitColor.PARENTHESES
            BRACKET_L, BRACKET_R -> WitColor.BRACKETS
            BRACE_L, BRACE_R -> WitColor.BRACES
            COLON, EQ -> WitColor.OPERATION
            STAR -> WitColor.OPERATION
            AT  -> WitColor.SYM_BUILTIN
            COMMA -> WitColor.COMMA
            // atom
            VERSION -> WitColor.NUMBER

            SELECTION_LINE -> WitColor.TEXT
            STRING_QUOTE, STRING_CHAR -> WitColor.STRING
            STRING_ESCAPE -> WitColor.STRING_ESCAPED
//            STRING -> AwslColor.STRING
            SYMBOL -> WitColor.IDENTIFIER
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

