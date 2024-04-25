package com.github.moonbit.ide.highlight

import com.github.bytecodealliance.ide.highlight.MoonColor
import com.github.moonbit.psi.MbtiParserDefinition
import com.github.moonbit.psi.MoonTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class MbtiSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return MbtiParserDefinition().createLexer(null)
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): MoonColor? {
        return when (tokenType) {
            MoonTypes.KW_PACKAGE,
            MoonTypes.KW_TYPE, MoonTypes.KW_TYPE_ALIAS,
            MoonTypes.KW_VARIANT, MoonTypes.KW_FLAGS, MoonTypes.KW_ENUM,
            MoonTypes.KW_FN, MoonTypes.KW_TEST,
            MoonTypes.KW_LET,
                -> MoonColor.KEYWORD

            MoonTypes.KW_PUBLIC, MoonTypes.KW_PRIVATE -> MoonColor.KEYWORD
            MoonTypes.KW_ALL, MoonTypes.KW_ALL -> MoonColor.SYM_BUILTIN

            MoonTypes.PARENTHESIS_L, MoonTypes.PARENTHESIS_R -> MoonColor.PARENTHESES
            MoonTypes.BRACKET_L, MoonTypes.BRACKET_R -> MoonColor.BRACKETS
            MoonTypes.BRACE_L, MoonTypes.BRACE_R -> MoonColor.BRACES
            MoonTypes.COLON, MoonTypes.OP_ASSIGN -> MoonColor.OPERATION
            MoonTypes.AT -> MoonColor.OPERATION

            MoonTypes.COMMA -> MoonColor.COMMA
            // atom
            MoonTypes.VERSION -> MoonColor.NUMBER

//            SELECTION_LINE -> MoonColor.TEXT
//            STRING_QUOTE, STRING_CHAR -> MoonColor.STRING
//            STRING_ESCAPE -> MoonColor.STRING_ESCAPED
//            STRING -> AwslColor.STRING
            MoonTypes.SYMBOL -> MoonColor.IDENTIFIER
            // 注释
            MoonTypes.COMMENT_LINE -> MoonColor.LINE_COMMENT
            MoonTypes.COMMENT_BLOCK -> MoonColor.BLOCK_COMMENT
            MoonTypes.COMMENT_DOCUMENT -> MoonColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> MoonColor.BAD_CHARACTER
            else -> null
        }
    }
}