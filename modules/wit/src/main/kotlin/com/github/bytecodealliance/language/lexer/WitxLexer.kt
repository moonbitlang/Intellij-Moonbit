package com.github.bytecodealliance.language.lexer

import com.github.bytecodealliance.language.psi.WitTokenType
import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import com.intellij.psi.TokenType

class WitxLexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var startOffset = 0
    private var endOffset = 0
    private var tokenStart = 0
    private var tokenEnd = 0
    private var currentPosition = 0

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.tokenStart = startOffset
        this.tokenEnd = startOffset
        this.currentPosition = startOffset
    }

    override fun getState(): Int = 0

    override fun getTokenStart(): Int = tokenStart

    override fun getTokenEnd(): Int = tokenEnd

    override fun getTokenType(): IElementType? {
        if (tokenStart >= endOffset) return null
        return when (buffer[tokenStart]) {
            '(' -> WitTokenType("PARENTHESIS_L")
            ')' -> WitTokenType("PARENTHESIS_R")
            '[' -> WitTokenType("BRACKET_L")
            ']' -> WitTokenType("BRACKET_R")
            '{' -> WitTokenType("BRACE_L")
            '}' -> WitTokenType("BRACE_R")
            '=' -> WitTokenType("EQUAL")
            ',' -> WitTokenType("COMMA")
            '+' -> WitTokenType("ADD")
            '-' -> WitTokenType("SUB")
            '"' -> {
                tokenEnd = findStringEnd(currentPosition)
                WitTokenType("STRING_S1")
            }
            '\'' -> {
                tokenEnd = findStringEnd(currentPosition, '\'')
                WitTokenType("STRING_S2")
            }
            '/' -> {
                if (currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '/') {
                    tokenEnd = findCommentEnd(currentPosition)
                    WitTokenType("COMMENT_LINE")
                } else {
                    tokenEnd = currentPosition + 1
                    TokenType.BAD_CHARACTER
                }
            }
            in '0'..'9' -> {
                tokenEnd = findNumberEnd(currentPosition)
                WitTokenType("DEC")
            }
            in 'a'..'z', in 'A'..'Z', '_' -> {
                tokenEnd = findIdentifierEnd(currentPosition)
                val identifier = buffer.subSequence(tokenStart, tokenEnd).toString()
                when (identifier) {
                    "some" -> WitTokenType("KW_SOME")
                    "none" -> WitTokenType("KW_NONE")
                    "true" -> WitTokenType("KW_TRUE")
                    "false" -> WitTokenType("KW_FALSE")
                    "fine" -> WitTokenType("KW_FINE")
                    "fail" -> WitTokenType("KW_FAIL")
                    else -> WitTokenType("SYMBOL")
                }
            }
            else -> if (Character.isWhitespace(buffer[tokenStart])) {
                tokenEnd = findWhitespaceEnd(currentPosition)
                TokenType.WHITE_SPACE
            } else {
                tokenEnd = currentPosition + 1
                TokenType.BAD_CHARACTER
            }
        }
    }

    override fun advance() {
        tokenStart = tokenEnd
        currentPosition = tokenEnd
    }

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = endOffset

    private fun findStringEnd(start: Int, delimiter: Char = '"'): Int {
        var pos = start + 1
        while (pos < endOffset) {
            if (buffer[pos] == '\\') {
                pos += 2
            } else if (buffer[pos] == delimiter) {
                return pos + 1
            } else {
                pos++
            }
        }
        return endOffset
    }

    private fun findCommentEnd(start: Int): Int {
        var pos = start + 2
        while (pos < endOffset && buffer[pos] != '\n') {
            pos++
        }
        return pos
    }

    private fun findNumberEnd(start: Int): Int {
        var pos = start + 1
        while (pos < endOffset && buffer[pos].isDigit()) {
            pos++
        }
        return pos
    }

    private fun findIdentifierEnd(start: Int): Int {
        var pos = start + 1
        while (pos < endOffset && (buffer[pos].isLetterOrDigit() || buffer[pos] == '_')) {
            pos++
        }
        return pos
    }

    private fun findWhitespaceEnd(start: Int): Int {
        var pos = start + 1
        while (pos < endOffset && buffer[pos].isWhitespace()) {
            pos++
        }
        return pos
    }
}
