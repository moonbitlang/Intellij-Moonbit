package com.github.bytecodealliance.language.parser

import com.github.bytecodealliance.language.psi.WitTokenType
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import com.intellij.psi.PsiElement

class WitParser : PsiParser {
    override fun parse(elementType: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()
        parseWit(builder)
        rootMarker.done(elementType)
        return builder.treeBuilt
    }

    private fun parseWit(builder: PsiBuilder) {
        parseWitValue(builder)
    }

    private fun parseWitValue(builder: PsiBuilder): Boolean {
        return parseTextLiteral(builder) ||
                parseNumberLiteral(builder) ||
                parseDictLiteral(builder) ||
                parseListLiteral(builder) ||
                parseFlagLiteral(builder) ||
                parseVariantLiteral(builder) ||
                parseResultLiteral(builder) ||
                parseOptionLiteral(builder) ||
                parseBooleanLiteral(builder)
    }

    private fun parseTextLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("STRING_S1") || builder.tokenType == WitTokenType("STRING_S2")) {
            builder.advanceLexer()
            marker.done(WitTokenType("TEXT_LITERAL"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseNumberLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("DEC")) {
            builder.advanceLexer()
            marker.done(WitTokenType("NUMBER_LITERAL"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseDictLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("BRACE_L")) {
            builder.advanceLexer()
            while (parseDictItem(builder)) {
                // Continue parsing dict items
            }
            if (builder.tokenType == WitTokenType("BRACE_R")) {
                builder.advanceLexer()
                marker.done(WitTokenType("DICT_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseDictItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseDictKey(builder) && builder.tokenType == WitTokenType("EQUAL")) {
            builder.advanceLexer()
            if (parseWitValue(builder)) {
                marker.done(WitTokenType("DICT_ITEM"))
                return true
            }
        } else if (builder.tokenType == WitTokenType("COMMA")) {
            builder.advanceLexer()
            marker.done(WitTokenType("DICT_ITEM"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseDictKey(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("SYMBOL")) {
            builder.advanceLexer()
            marker.done(WitTokenType("DICT_KEY"))
            return true
        } else if (builder.tokenType == WitTokenType("STRING_S1") || builder.tokenType == WitTokenType("STRING_S2")) {
            builder.advanceLexer()
            marker.done(WitTokenType("DICT_KEY"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseListLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("BRACKET_L")) {
            builder.advanceLexer()
            while (parseListItem(builder)) {
                // Continue parsing list items
            }
            if (builder.tokenType == WitTokenType("BRACKET_R")) {
                builder.advanceLexer()
                marker.done(WitTokenType("LIST_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseListItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseWitValue(builder)) {
            marker.done(WitTokenType("LIST_ITEM"))
            return true
        } else if (builder.tokenType == WitTokenType("COMMA")) {
            builder.advanceLexer()
            marker.done(WitTokenType("LIST_ITEM"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseFlagLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseFlagSign(builder) && builder.tokenType == WitTokenType("BRACKET_L")) {
            builder.advanceLexer()
            while (parseFlagItem(builder)) {
                // Continue parsing flag items
            }
            if (builder.tokenType == WitTokenType("BRACKET_R")) {
                builder.advanceLexer()
                marker.done(WitTokenType("FLAG_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseFlagSign(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("ADD") || builder.tokenType == WitTokenType("SUB")) {
            builder.advanceLexer()
            marker.done(WitTokenType("FLAG_SIGN"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseFlagItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("SYMBOL")) {
            builder.advanceLexer()
            marker.done(WitTokenType("FLAG_ITEM"))
            return true
        } else if (builder.tokenType == WitTokenType("STRING_S1") || builder.tokenType == WitTokenType("STRING_S2")) {
            builder.advanceLexer()
            marker.done(WitTokenType("FLAG_ITEM"))
            return true
        } else if (builder.tokenType == WitTokenType("COMMA")) {
            builder.advanceLexer()
            marker.done(WitTokenType("FLAG_ITEM"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseVariantLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseVariantName(builder) && builder.tokenType == WitTokenType("PARENTHESIS_L")) {
            builder.advanceLexer()
            parseWitValue(builder) // Optional value
            if (builder.tokenType == WitTokenType("PARENTHESIS_R")) {
                builder.advanceLexer()
                marker.done(WitTokenType("VARIANT_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseVariantName(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("KW_NONE") ||
                builder.tokenType == WitTokenType("KW_TRUE") ||
                builder.tokenType == WitTokenType("KW_FALSE") ||
                builder.tokenType == WitTokenType("SYMBOL")) {
            builder.advanceLexer()
            marker.done(WitTokenType("VARIANT_NAME"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseResultLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if ((builder.tokenType == WitTokenType("KW_FINE") || builder.tokenType == WitTokenType("KW_FAIL")) &&
                builder.tokenType == WitTokenType("PARENTHESIS_L")) {
            builder.advanceLexer()
            parseWitValue(builder) // Optional value
            if (builder.tokenType == WitTokenType("PARENTHESIS_R")) {
                builder.advanceLexer()
                marker.done(WitTokenType("RESULT_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseOptionLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("KW_SOME") && builder.tokenType == WitTokenType("PARENTHESIS_L")) {
            builder.advanceLexer()
            parseWitValue(builder) // Optional value
            if (builder.tokenType == WitTokenType("PARENTHESIS_R")) {
                builder.advanceLexer()
                marker.done(WitTokenType("OPTION_LITERAL"))
                return true
            }
        } else if (builder.tokenType == WitTokenType("KW_NONE")) {
            builder.advanceLexer()
            marker.done(WitTokenType("OPTION_LITERAL"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseBooleanLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WitTokenType("KW_TRUE") || builder.tokenType == WitTokenType("KW_FALSE")) {
            builder.advanceLexer()
            marker.done(WitTokenType("WION_VALUE"))
            return true
        }
        marker.rollbackTo()
        return false
    }
}
