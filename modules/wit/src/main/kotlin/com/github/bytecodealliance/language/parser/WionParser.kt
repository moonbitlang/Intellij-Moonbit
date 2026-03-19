package com.github.bytecodealliance.language.parser

import com.github.bytecodealliance.language.psi.WionTokenType
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

class WionParser : PsiParser {
    override fun parse(elementType: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()
        parseWion(builder)
        rootMarker.done(elementType)
        return builder.treeBuilt
    }

    private fun parseWion(builder: PsiBuilder) {
        parseWionValue(builder)
    }

    private fun parseWionValue(builder: PsiBuilder): Boolean {
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
        if (builder.tokenType == WionTokenType("STRING_S1") || builder.tokenType == WionTokenType("STRING_S2")) {
            builder.advanceLexer()
            marker.done(WionTokenType("TEXT_LITERAL"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseNumberLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("DEC")) {
            builder.advanceLexer()
            marker.done(WionTokenType("NUMBER_LITERAL"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseDictLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("BRACE_L")) {
            builder.advanceLexer()
            while (parseDictItem(builder)) {
                // Continue parsing dict items
            }
            if (builder.tokenType == WionTokenType("BRACE_R")) {
                builder.advanceLexer()
                marker.done(WionTokenType("DICT_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseDictItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseDictKey(builder) && builder.tokenType == WionTokenType("EQUAL")) {
            builder.advanceLexer()
            if (parseWionValue(builder)) {
                marker.done(WionTokenType("DICT_ITEM"))
                return true
            }
        } else if (builder.tokenType == WionTokenType("COMMA")) {
            builder.advanceLexer()
            marker.done(WionTokenType("DICT_ITEM"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseDictKey(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("SYMBOL")) {
            builder.advanceLexer()
            marker.done(WionTokenType("DICT_KEY"))
            return true
        } else if (builder.tokenType == WionTokenType("STRING_S1") || builder.tokenType == WionTokenType("STRING_S2")) {
            builder.advanceLexer()
            marker.done(WionTokenType("DICT_KEY"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseListLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("BRACKET_L")) {
            builder.advanceLexer()
            while (parseListItem(builder)) {
                // Continue parsing list items
            }
            if (builder.tokenType == WionTokenType("BRACKET_R")) {
                builder.advanceLexer()
                marker.done(WionTokenType("LIST_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseListItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseWionValue(builder)) {
            marker.done(WionTokenType("LIST_ITEM"))
            return true
        } else if (builder.tokenType == WionTokenType("COMMA")) {
            builder.advanceLexer()
            marker.done(WionTokenType("LIST_ITEM"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseFlagLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseFlagSign(builder) && builder.tokenType == WionTokenType("BRACKET_L")) {
            builder.advanceLexer()
            while (parseFlagItem(builder)) {
                // Continue parsing flag items
            }
            if (builder.tokenType == WionTokenType("BRACKET_R")) {
                builder.advanceLexer()
                marker.done(WionTokenType("FLAG_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseFlagSign(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("ADD") || builder.tokenType == WionTokenType("SUB")) {
            builder.advanceLexer()
            marker.done(WionTokenType("FLAG_SIGN"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseFlagItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("SYMBOL")) {
            builder.advanceLexer()
            marker.done(WionTokenType("FLAG_ITEM"))
            return true
        } else if (builder.tokenType == WionTokenType("STRING_S1") || builder.tokenType == WionTokenType("STRING_S2")) {
            builder.advanceLexer()
            marker.done(WionTokenType("FLAG_ITEM"))
            return true
        } else if (builder.tokenType == WionTokenType("COMMA")) {
            builder.advanceLexer()
            marker.done(WionTokenType("FLAG_ITEM"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseVariantLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (parseVariantName(builder) && builder.tokenType == WionTokenType("PARENTHESIS_L")) {
            builder.advanceLexer()
            parseWionValue(builder) // Optional value
            if (builder.tokenType == WionTokenType("PARENTHESIS_R")) {
                builder.advanceLexer()
                marker.done(WionTokenType("VARIANT_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseVariantName(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("KW_NONE") ||
                builder.tokenType == WionTokenType("KW_TRUE") ||
                builder.tokenType == WionTokenType("KW_FALSE") ||
                builder.tokenType == WionTokenType("SYMBOL")) {
            builder.advanceLexer()
            marker.done(WionTokenType("VARIANT_NAME"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseResultLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if ((builder.tokenType == WionTokenType("KW_FINE") || builder.tokenType == WionTokenType("KW_FAIL")) &&
                builder.tokenType == WionTokenType("PARENTHESIS_L")) {
            builder.advanceLexer()
            parseWionValue(builder) // Optional value
            if (builder.tokenType == WionTokenType("PARENTHESIS_R")) {
                builder.advanceLexer()
                marker.done(WionTokenType("RESULT_LITERAL"))
                return true
            }
        }
        marker.rollbackTo()
        return false
    }

    private fun parseOptionLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("KW_SOME") && builder.tokenType == WionTokenType("PARENTHESIS_L")) {
            builder.advanceLexer()
            parseWionValue(builder) // Optional value
            if (builder.tokenType == WionTokenType("PARENTHESIS_R")) {
                builder.advanceLexer()
                marker.done(WionTokenType("OPTION_LITERAL"))
                return true
            }
        } else if (builder.tokenType == WionTokenType("KW_NONE")) {
            builder.advanceLexer()
            marker.done(WionTokenType("OPTION_LITERAL"))
            return true
        }
        marker.rollbackTo()
        return false
    }

    private fun parseBooleanLiteral(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType == WionTokenType("KW_TRUE") || builder.tokenType == WionTokenType("KW_FALSE")) {
            builder.advanceLexer()
            marker.done(WionTokenType("WION_VALUE"))
            return true
        }
        marker.rollbackTo()
        return false
    }
}
