package com.github.moonbit.ide.highlight


import com.github.bytecodealliance.ide.highlight.MoonColor
import com.github.moonbit.psi.MoonParserDefinition
import com.github.moonbit.psi.MoonTypes
import com.github.moonbit.psi.MoonTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class MoonTokenHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return MoonParserDefinition().createLexer(null)
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): MoonColor? {
        return when (tokenType) {
            KW_PACKAGE,
            KW_TYPE, KW_TYPE_ALIAS,
            KW_STRUCT,
            KW_TRAIT, KW_IMPLEMENT, KW_WITH,
            KW_VARIANT, KW_FLAGS, KW_ENUM,
            KW_FN, KW_TEST,
            KW_LET,
            KW_FOR, KW_WHILE,
            KW_IF, KW_ELSE,
            KW_MATCH,
            KW_RETURN, KW_CONTINUE, KW_BREAK,
                -> MoonColor.KEYWORD

            KW_PUBLIC, KW_PRIVATE -> MoonColor.KEYWORD
            KW_ALL, KW_ALL -> MoonColor.SYM_BUILTIN
            KW_MUTABLE -> MoonColor.KEYWORD

            PARENTHESIS_L, PARENTHESIS_R -> MoonColor.PARENTHESES
            BRACKET_L, BRACKET_R -> MoonColor.BRACKETS
            BRACE_L, BRACE_R -> MoonColor.BRACES
            COLON, OP_ASSIGN -> MoonColor.OPERATION
            OP_ADD, OP_ASSIGN,
            OP_SUB,
            OP_MUL,
            OP_DIV, OP_DIV_ASSIGN,
            OP_MOD,
            AT,
                -> MoonColor.OPERATION

            COMMA -> MoonColor.COMMA
            // atom
            INTEGER -> MoonColor.NUMBER

//            SELECTION_LINE -> MoonColor.TEXT
//            STRING_QUOTE, STRING_CHAR -> MoonColor.STRING
//            STRING_ESCAPE -> MoonColor.STRING_ESCAPED
            STRING_TEXT, DOUBLE_QUOTE_L, DOUBLE_QUOTE_R -> MoonColor.STRING
            SYMBOL -> MoonColor.IDENTIFIER
            // 注释
            COMMENT_LINE -> MoonColor.LINE_COMMENT
            COMMENT_BLOCK -> MoonColor.BLOCK_COMMENT
            COMMENT_DOCUMENT -> MoonColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> MoonColor.BAD_CHARACTER
            else -> null
        }
    }
}

