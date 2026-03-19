package com.github.moonbit.lexer

import com.github.moonbit.psi.MoonTypes
import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import com.intellij.psi.TokenType

class MoonLexer : LexerBase() {
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
        skipWhitespace()
        if (tokenStart >= endOffset) return null

        val currentChar = buffer[tokenStart]
        return when {
            currentChar == '/' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '/' -> {
                tokenEnd = findCommentEnd(currentPosition)
                MoonTypes.COMMENT_LINE
            }
            currentChar == '/' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '*' -> {
                tokenEnd = findBlockCommentEnd(currentPosition)
                MoonTypes.COMMENT_BLOCK
            }
            currentChar == '#' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '|' -> {
                tokenEnd = findStringLineEnd(currentPosition)
                MoonTypes.STRING_LINE
            }
            currentChar == '(' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.PARENTHESIS_L
            }
            currentChar == ')' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.PARENTHESIS_R
            }
            currentChar == '[' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.BRACKET_L
            }
            currentChar == ']' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.BRACKET_R
            }
            currentChar == '{' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.BRACE_L
            }
            currentChar == '}' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.BRACE_R
            }
            currentChar == ':' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.COLON
            }
            currentChar == ';' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.SEMICOLON
            }
            currentChar == ',' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.COMMA
            }
            currentChar == '$' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.DOLLAR
            }
            currentChar == '@' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.AT
            }
            currentChar == '^' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_XOR
            }
            currentChar == '+' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '=' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_ADD_ASSIGN
            }
            currentChar == '+' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_ADD
            }
            currentChar == '*' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '=' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_MUL_ASSIGN
            }
            currentChar == '*' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_MUL
            }
            currentChar == '/' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '=' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_DIV_ASSIGN
            }
            currentChar == '/' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_DIV
            }
            currentChar == '%' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_MOD
            }
            currentChar == '-' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '>' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_TO
            }
            currentChar == '-' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '=' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_SUB_ASSIGN
            }
            currentChar == '-' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_SUB
            }
            currentChar == '<' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '=' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_LEQ
            }
            currentChar == '<' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '<' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_LL
            }
            currentChar == '<' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_LT
            }
            currentChar == '>' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '>' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_GG
            }
            currentChar == '>' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '=' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_GEQ
            }
            currentChar == '>' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_GT
            }
            currentChar == '|' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '|' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_OR
            }
            currentChar == '|' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '>' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_THEN
            }
            currentChar == '|' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_BIT_OR
            }
            currentChar == '&' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '&' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_AND
            }
            currentChar == '&' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_BIT_AND
            }
            currentChar == '!' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '=' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_NE
            }
            currentChar == '!' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_ERROR
            }
            currentChar == '=' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '=' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_EQ
            }
            currentChar == '=' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '>' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_PATTERN_TO
            }
            currentChar == '=' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_ASSIGN
            }
            currentChar == '~' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_REF
            }
            currentChar == '?' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.OP_THROW
            }
            currentChar == '.' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '.' && currentPosition + 2 < endOffset && buffer[currentPosition + 2] == '<' -> {
                tokenEnd = currentPosition + 3
                MoonTypes.OP_RANGE_TO
            }
            currentChar == '.' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == '.' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.OP_SPREAD
            }
            currentChar == '.' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.DOT
            }
            currentChar == ':' && currentPosition + 1 < endOffset && buffer[currentPosition + 1] == ':' -> {
                tokenEnd = currentPosition + 2
                MoonTypes.NAME_JOIN
            }
            currentChar == '\'' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.SINGLE_QUOTE_L
            }
            currentChar == '"' -> {
                tokenEnd = currentPosition + 1
                MoonTypes.DOUBLE_QUOTE_L
            }
            currentChar in '0'..'9' -> {
                tokenEnd = findNumberEnd(currentPosition)
                when {
                    buffer[tokenStart] == '0' && tokenStart + 1 < tokenEnd && buffer[tokenStart + 1] == 'x' -> MoonTypes.BYTES_HEX
                    buffer[tokenStart] == '0' && tokenStart + 1 < tokenEnd && buffer[tokenStart + 1] == 'o' -> MoonTypes.BYTES_OCT
                    buffer[tokenStart] == '0' && tokenStart + 1 < tokenEnd && buffer[tokenStart + 1] == 'b' -> MoonTypes.BYTES_BIN
                    else -> MoonTypes.INTEGER
                }
            }
            currentChar in 'a'..'z' || currentChar in 'A'..'Z' || currentChar == '_' -> {
                tokenEnd = findIdentifierEnd(currentPosition)
                val identifier = buffer.subSequence(tokenStart, tokenEnd).toString()
                when (identifier) {
                    "package" -> MoonTypes.KW_PACKAGE
                    "world" -> MoonTypes.KW_WORLD
                    "interface" -> MoonTypes.KW_INTERFACE
                    "include" -> MoonTypes.KW_INCLUDE
                    "export" -> MoonTypes.KW_EXPORT
                    "import" -> MoonTypes.KW_IMPORT
                    "use" -> MoonTypes.KW_USE
                    "as" -> MoonTypes.KW_AS
                    "resource" -> MoonTypes.KW_RESOURCE
                    "record" -> MoonTypes.KW_RECORD
                    "enum" -> MoonTypes.KW_ENUM
                    "flags" -> MoonTypes.KW_FLAGS
                    "variant" -> MoonTypes.KW_VARIANT
                    "constructor" -> MoonTypes.KW_CONSTRUCTOR
                    "trait" -> MoonTypes.KW_TRAIT
                    "struct" -> MoonTypes.KW_STRUCT
                    "priv" -> MoonTypes.KW_PRIVATE
                    "mut" -> MoonTypes.KW_MUTABLE
                    "let" -> MoonTypes.KW_LET
                    "fn" -> MoonTypes.KW_FN
                    "test" -> MoonTypes.KW_TEST
                    "guard" -> MoonTypes.KW_GUARD
                    "if" -> MoonTypes.KW_IF
                    "else" -> MoonTypes.KW_ELSE
                    "match" -> MoonTypes.KW_MATCH
                    "while" -> MoonTypes.KW_WHILE
                    "for" -> MoonTypes.KW_FOR
                    "in" -> MoonTypes.KW_IN
                    "return" -> MoonTypes.KW_RETURN
                    "continue" -> MoonTypes.KW_CONTINUE
                    "break" -> MoonTypes.KW_BREAK
                    "raise" -> MoonTypes.KW_RAISE
                    "try" -> MoonTypes.KW_TRY
                    "catch" -> MoonTypes.KW_CATCH
                    "type" -> MoonTypes.KW_TYPE
                    "typealias" -> MoonTypes.KW_TYPE_ALIAS
                    "derive" -> MoonTypes.KW_DERIVE
                    "impl" -> MoonTypes.KW_IMPLEMENT
                    "with" -> MoonTypes.KW_WITH
                    "extern" -> MoonTypes.KW_EXTERN
                    "pub" -> MoonTypes.KW_PUBLIC
                    "all" -> MoonTypes.KW_ALL
                    "open" -> MoonTypes.KW_OPEN
                    else -> MoonTypes.SYMBOL
                }
            }
            else -> {
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

    private fun skipWhitespace() {
        while (tokenStart < endOffset && Character.isWhitespace(buffer[tokenStart])) {
            tokenStart++
        }
        currentPosition = tokenStart
    }

    private fun findCommentEnd(start: Int): Int {
        var pos = start + 2
        while (pos < endOffset && buffer[pos] != '\n') {
            pos++
        }
        return pos
    }

    private fun findBlockCommentEnd(start: Int): Int {
        var pos = start + 2
        while (pos < endOffset) {
            if (buffer[pos] == '*' && pos + 1 < endOffset && buffer[pos + 1] == '/') {
                return pos + 2
            }
            pos++
        }
        return endOffset
    }

    private fun findStringLineEnd(start: Int): Int {
        var pos = start + 2
        while (pos < endOffset && buffer[pos] != '\n') {
            pos++
        }
        return pos
    }

    private fun findNumberEnd(start: Int): Int {
        var pos = start + 1
        while (pos < endOffset && (buffer[pos].isDigit() || buffer[pos] == '_')) {
            pos++
        }
        if (pos < endOffset && (buffer[pos] == 'U' || buffer[pos] == 'L' || buffer[pos] == 'N')) {
            pos++
            if (pos < endOffset && buffer[pos] == 'L') {
                pos++
            }
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
}
