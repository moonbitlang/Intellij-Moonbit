package com.github.moonbit.parser

import com.github.moonbit.psi.MoonTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import com.intellij.lang.PsiBuilder

class MoonParser : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val marker = builder.mark()
        parseFile(builder)
        marker.done(root)
        return builder.treeBuilt
    }

    private fun parseFile(builder: PsiBuilder) {
        while (!builder.eof()) {
            when (builder.tokenType) {
                MoonTypes.KW_PACKAGE -> parsePackage(builder)
                MoonTypes.KW_IMPORT -> parseImport(builder)
                MoonTypes.KW_EXPORT -> parseExport(builder)
                MoonTypes.KW_WORLD -> parseWorld(builder)
                MoonTypes.KW_INTERFACE -> parseInterface(builder)
                MoonTypes.KW_RECORD -> parseRecord(builder)
                MoonTypes.KW_ENUM -> parseEnum(builder)
                MoonTypes.KW_FLAGS -> parseFlags(builder)
                MoonTypes.KW_VARIANT -> parseVariant(builder)
                MoonTypes.KW_TRAIT -> parseTrait(builder)
                MoonTypes.KW_STRUCT -> parseStruct(builder)
                MoonTypes.KW_FN -> parseFunction(builder)
                MoonTypes.KW_LET -> parseLet(builder)
                MoonTypes.KW_TYPE -> parseTypeDef(builder)
                MoonTypes.KW_TYPE_ALIAS -> parseTypeAlias(builder)
                MoonTypes.KW_IMPLEMENT -> parseImpl(builder)
                MoonTypes.KW_EXTERN -> parseExtern(builder)
                else -> builder.advanceLexer()
            }
        }
    }

    private fun parsePackage(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.PACKAGE)
    }

    private fun parseImport(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        parsePath(builder)
        if (builder.tokenType == MoonTypes.KW_AS) {
            builder.advanceLexer()
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.IMPORT)
    }

    private fun parseExport(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        when (builder.tokenType) {
            MoonTypes.KW_IMPORT -> parseImport(builder)
            MoonTypes.KW_INCLUDE -> parseInclude(builder)
            else -> builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.EXPORT)
    }

    private fun parseInclude(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.INCLUDE)
    }

    private fun parsePath(builder: PsiBuilder) {
        while (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
            if (builder.tokenType == MoonTypes.DOT) {
                builder.advanceLexer()
            } else {
                break
            }
        }
    }

    private fun parseWorld(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseWorldBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.WORLD)
    }

    private fun parseWorldBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            when (builder.tokenType) {
                MoonTypes.KW_USE -> parseUse(builder)
                MoonTypes.KW_INCLUDE -> parseInclude(builder)
                MoonTypes.KW_RECORD -> parseRecord(builder)
                MoonTypes.KW_ENUM -> parseEnum(builder)
                MoonTypes.KW_FLAGS -> parseFlags(builder)
                MoonTypes.KW_VARIANT -> parseVariant(builder)
                MoonTypes.KW_TRAIT -> parseTrait(builder)
                MoonTypes.KW_STRUCT -> parseStruct(builder)
                MoonTypes.KW_FN -> parseFunction(builder)
                MoonTypes.KW_TYPE -> parseTypeDef(builder)
                MoonTypes.KW_TYPE_ALIAS -> parseTypeAlias(builder)
                else -> builder.advanceLexer()
            }
        }
    }

    private fun parseUse(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        parsePath(builder)
        if (builder.tokenType == MoonTypes.KW_AS) {
            builder.advanceLexer()
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.USE)
    }

    private fun parseInterface(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseInterfaceBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.INTERFACE)
    }

    private fun parseTypeParameters(builder: PsiBuilder) {
        if (builder.tokenType == MoonTypes.LT) {
            builder.advanceLexer()
            while (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer()
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer()
                } else {
                    break
                }
            }
            if (builder.tokenType == MoonTypes.GT) {
                builder.advanceLexer()
            }
        }
    }

    private fun parseInterfaceBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            when (builder.tokenType) {
                MoonTypes.KW_FN -> parseFunctionSignature(builder)
                MoonTypes.KW_TYPE -> parseTypeDef(builder)
                MoonTypes.KW_TYPE_ALIAS -> parseTypeAlias(builder)
                else -> builder.advanceLexer()
            }
        }
    }

    private fun parseFunctionSignature(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseFunctionParameters(builder)
        parseReturnType(builder)
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.FUNCTION_SIGNATURE)
    }

    private fun parseFunctionParameters(builder: PsiBuilder) {
        if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
            builder.advanceLexer()
            while (builder.tokenType != MoonTypes.PARENTHESIS_R) {
                if (builder.tokenType == MoonTypes.SYMBOL) {
                    builder.advanceLexer()
                }
                if (builder.tokenType == MoonTypes.COLON) {
                    builder.advanceLexer()
                    parseType(builder)
                }
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer()
                } else {
                    break
                }
            }
            if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                builder.advanceLexer()
            }
        }
    }

    private fun parseReturnType(builder: PsiBuilder) {
        if (builder.tokenType == MoonTypes.OP_TO) {
            builder.advanceLexer()
            parseType(builder)
        }
    }

    private fun parseType(builder: PsiBuilder) {
        when (builder.tokenType) {
            MoonTypes.SYMBOL -> {
                builder.advanceLexer()
                if (builder.tokenType == MoonTypes.LT) {
                    builder.advanceLexer()
                    parseType(builder)
                    if (builder.tokenType == MoonTypes.COMMA) {
                        builder.advanceLexer()
                        parseType(builder)
                    }
                    if (builder.tokenType == MoonTypes.GT) {
                        builder.advanceLexer()
                    }
                }
            }
            MoonTypes.PARENTHESIS_L -> {
                builder.advanceLexer()
                parseType(builder)
                if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                    builder.advanceLexer()
                }
            }
            else -> builder.advanceLexer()
        }
    }

    private fun parseRecord(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseRecordBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.RECORD)
    }

    private fun parseRecordBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer()
                if (builder.tokenType == MoonTypes.COLON) {
                    builder.advanceLexer()
                    parseType(builder)
                }
                if (builder.tokenType == MoonTypes.SEMICOLON) {
                    builder.advanceLexer()
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseEnum(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseEnumBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.ENUM)
    }

    private fun parseEnumBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer()
                if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
                    builder.advanceLexer()
                    parseType(builder)
                    if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                        builder.advanceLexer()
                    }
                }
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer()
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseFlags(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseFlagsBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.FLAGS)
    }

    private fun parseFlagsBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer()
                if (builder.tokenType == MoonTypes.OP_ASSIGN) {
                    builder.advanceLexer()
                    if (builder.tokenType == MoonTypes.INTEGER) {
                        builder.advanceLexer()
                    }
                }
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer()
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseVariant(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseVariantBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.VARIANT)
    }

    private fun parseVariantBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer()
                if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
                    builder.advanceLexer()
                    parseType(builder)
                    if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                        builder.advanceLexer()
                    }
                }
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer()
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseTrait(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.KW_WITH) {
            builder.advanceLexer()
            parsePath(builder)
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseTraitBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.TRAIT)
    }

    private fun parseTraitBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            when (builder.tokenType) {
                MoonTypes.KW_FN -> parseFunctionSignature(builder)
                MoonTypes.KW_TYPE -> parseTypeDef(builder)
                else -> builder.advanceLexer()
            }
        }
    }

    private fun parseStruct(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseStructBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.STRUCT)
    }

    private fun parseStructBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.KW_MUTABLE) {
                builder.advanceLexer()
            }
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer()
                if (builder.tokenType == MoonTypes.COLON) {
                    builder.advanceLexer()
                    parseType(builder)
                }
                if (builder.tokenType == MoonTypes.OP_ASSIGN) {
                    builder.advanceLexer()
                    parseExpression(builder)
                }
                if (builder.tokenType == MoonTypes.SEMICOLON) {
                    builder.advanceLexer()
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseFunction(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseFunctionParameters(builder)
        parseReturnType(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.FUNCTION)
    }

    private fun parseFunctionBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            when (builder.tokenType) {
                MoonTypes.KW_LET -> parseLet(builder)
                MoonTypes.KW_IF -> parseIf(builder)
                MoonTypes.KW_MATCH -> parseMatch(builder)
                MoonTypes.KW_WHILE -> parseWhile(builder)
                MoonTypes.KW_FOR -> parseFor(builder)
                MoonTypes.KW_RETURN -> parseReturn(builder)
                MoonTypes.KW_BREAK -> parseBreak(builder)
                MoonTypes.KW_CONTINUE -> parseContinue(builder)
                MoonTypes.KW_RAISE -> parseRaise(builder)
                MoonTypes.KW_TRY -> parseTry(builder)
                else -> parseExpression(builder)
            }
        }
    }

    private fun parseLet(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.KW_MUTABLE) {
            builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.COLON) {
            builder.advanceLexer()
            parseType(builder)
        }
        if (builder.tokenType == MoonTypes.OP_ASSIGN) {
            builder.advanceLexer()
            parseExpression(builder)
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.LET)
    }

    private fun parseIf(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
            builder.advanceLexer()
            parseExpression(builder)
            if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == MoonTypes.KW_ELSE) {
            builder.advanceLexer()
            if (builder.tokenType == MoonTypes.KW_IF) {
                parseIf(builder)
            } else if (builder.tokenType == MoonTypes.BRACE_L) {
                builder.advanceLexer()
                parseFunctionBody(builder)
                if (builder.tokenType == MoonTypes.BRACE_R) {
                    builder.advanceLexer()
                }
            }
        }
        marker.done(MoonTypes.IF)
    }

    private fun parseMatch(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
            builder.advanceLexer()
            parseExpression(builder)
            if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseMatchBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.MATCH)
    }

    private fun parseMatchBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            parsePattern(builder)
            if (builder.tokenType == MoonTypes.OP_THEN) {
                builder.advanceLexer()
                parseExpression(builder)
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer()
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parsePattern(builder: PsiBuilder) {
        when (builder.tokenType) {
            MoonTypes.SYMBOL -> builder.advanceLexer()
            MoonTypes.INTEGER -> builder.advanceLexer()
            MoonTypes.PARENTHESIS_L -> {
                builder.advanceLexer()
                parsePattern(builder)
                if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                    builder.advanceLexer()
                }
            }
            else -> builder.advanceLexer()
        }
    }

    private fun parseWhile(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
            builder.advanceLexer()
            parseExpression(builder)
            if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.WHILE)
    }

    private fun parseFor(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.KW_IN) {
            builder.advanceLexer()
            parseExpression(builder)
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.FOR)
    }

    private fun parseReturn(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        parseExpression(builder)
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.RETURN)
    }

    private fun parseBreak(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.BREAK)
    }

    private fun parseContinue(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.CONTINUE)
    }

    private fun parseRaise(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        parseExpression(builder)
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.RAISE)
    }

    private fun parseTry(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == MoonTypes.KW_CATCH) {
            builder.advanceLexer()
            if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
                builder.advanceLexer()
                if (builder.tokenType == MoonTypes.SYMBOL) {
                    builder.advanceLexer()
                }
                if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                    builder.advanceLexer()
                }
            }
            if (builder.tokenType == MoonTypes.BRACE_L) {
                builder.advanceLexer()
                parseFunctionBody(builder)
                if (builder.tokenType == MoonTypes.BRACE_R) {
                    builder.advanceLexer()
                }
            }
        }
        marker.done(MoonTypes.TRY)
    }

    private fun parseTypeDef(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.OP_ASSIGN) {
            builder.advanceLexer()
            parseType(builder)
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.TYPE_DEF)
    }

    private fun parseTypeAlias(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer()
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.OP_ASSIGN) {
            builder.advanceLexer()
            parseType(builder)
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        marker.done(MoonTypes.TYPE_ALIAS)
    }

    private fun parseImpl(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.KW_FOR) {
            builder.advanceLexer()
            parseType(builder)
        }
        if (builder.tokenType == MoonTypes.KW_WITH) {
            builder.advanceLexer()
            parsePath(builder)
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer()
            parseImplBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer()
            }
        }
        marker.done(MoonTypes.IMPL)
    }

    private fun parseImplBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            when (builder.tokenType) {
                MoonTypes.KW_FN -> parseFunction(builder)
                else -> builder.advanceLexer()
            }
        }
    }

    private fun parseExtern(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        if (builder.tokenType == MoonTypes.KW_FN) {
            parseFunctionSignature(builder)
        }
        marker.done(MoonTypes.EXTERN)
    }

    private fun parseExpression(builder: PsiBuilder) {
        parseTerm(builder)
        while (isBinaryOperator(builder.tokenType)) {
            builder.advanceLexer()
            parseTerm(builder)
        }
    }

    private fun parseTerm(builder: PsiBuilder) {
        when (builder.tokenType) {
            MoonTypes.INTEGER, MoonTypes.SYMBOL -> builder.advanceLexer()
            MoonTypes.PARENTHESIS_L -> {
                builder.advanceLexer()
                parseExpression(builder)
                if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                    builder.advanceLexer()
                }
            }
            else -> builder.advanceLexer()
        }
    }

    private fun isBinaryOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            MoonTypes.OP_ADD, MoonTypes.OP_SUB, MoonTypes.OP_MUL, MoonTypes.OP_DIV, MoonTypes.OP_MOD,
            MoonTypes.OP_EQ, MoonTypes.OP_NE, MoonTypes.OP_LT, MoonTypes.OP_LEQ, MoonTypes.OP_GT, MoonTypes.OP_GEQ,
            MoonTypes.OP_AND, MoonTypes.OP_OR, MoonTypes.OP_BIT_AND, MoonTypes.OP_BIT_OR, MoonTypes.OP_XOR,
            MoonTypes.OP_ASSIGN, MoonTypes.OP_ADD_ASSIGN, MoonTypes.OP_SUB_ASSIGN, MoonTypes.OP_MUL_ASSIGN, MoonTypes.OP_DIV_ASSIGN
            -> true
            else -> false
        }
    }
}
