package com.github.moonbit.parser

import com.github.moonbit.psi.MoonTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import com.intellij.psi.PsiBuilder

class MoonParser : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val marker = builder.mark()
        parseFile(builder)
        marker.done(root)
        return builder.treeBuilt
    }

    private fun parseFile(builder: PsiBuilder) {
        while (!builder.eof()) {
            when (val tokenType = builder.tokenType) {
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
        builder.advanceLexer() // package
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // package name
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.PACKAGE)
    }

    private fun parseImport(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // import
        parsePath(builder)
        if (builder.tokenType == MoonTypes.KW_AS) {
            builder.advanceLexer() // as
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer() // alias
            }
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.IMPORT)
    }

    private fun parseExport(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // export
        when (builder.tokenType) {
            MoonTypes.KW_IMPORT -> parseImport(builder)
            MoonTypes.KW_INCLUDE -> parseInclude(builder)
            else -> builder.advanceLexer()
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.EXPORT)
    }

    private fun parseInclude(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // include
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // include path
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
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
        builder.advanceLexer() // world
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // world name
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseWorldBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
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
        builder.advanceLexer() // use
        parsePath(builder)
        if (builder.tokenType == MoonTypes.KW_AS) {
            builder.advanceLexer() // as
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer() // alias
            }
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.USE)
    }

    private fun parseInterface(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // interface
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // interface name
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseInterfaceBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.INTERFACE)
    }

    private fun parseTypeParameters(builder: PsiBuilder) {
        if (builder.tokenType == MoonTypes.LT) {
            builder.advanceLexer() // <
            while (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer() // type parameter
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer() // ,
                } else {
                    break
                }
            }
            if (builder.tokenType == MoonTypes.GT) {
                builder.advanceLexer() // >
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
        builder.advanceLexer() // fn
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // function name
        }
        parseFunctionParameters(builder)
        parseReturnType(builder)
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.FUNCTION_SIGNATURE)
    }

    private fun parseFunctionParameters(builder: PsiBuilder) {
        if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
            builder.advanceLexer() // (
            while (builder.tokenType != MoonTypes.PARENTHESIS_R) {
                if (builder.tokenType == MoonTypes.SYMBOL) {
                    builder.advanceLexer() // parameter name
                }
                if (builder.tokenType == MoonTypes.COLON) {
                    builder.advanceLexer() // :
                    parseType(builder)
                }
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer() // ,
                } else {
                    break
                }
            }
            if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                builder.advanceLexer() // )
            }
        }
    }

    private fun parseReturnType(builder: PsiBuilder) {
        if (builder.tokenType == MoonTypes.OP_TO) {
            builder.advanceLexer() // ->
            parseType(builder)
        }
    }

    private fun parseType(builder: PsiBuilder) {
        when (builder.tokenType) {
            MoonTypes.SYMBOL -> {
                builder.advanceLexer() // type name
                if (builder.tokenType == MoonTypes.LT) {
                    builder.advanceLexer() // <
                    parseType(builder)
                    if (builder.tokenType == MoonTypes.COMMA) {
                        builder.advanceLexer() // ,
                        parseType(builder)
                    }
                    if (builder.tokenType == MoonTypes.GT) {
                        builder.advanceLexer() // >
                    }
                }
            }
            MoonTypes.PARENTHESIS_L -> {
                builder.advanceLexer() // (
                parseType(builder)
                if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                    builder.advanceLexer() // )
                }
            }
            else -> builder.advanceLexer()
        }
    }

    private fun parseRecord(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // record
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // record name
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseRecordBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.RECORD)
    }

    private fun parseRecordBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer() // field name
                if (builder.tokenType == MoonTypes.COLON) {
                    builder.advanceLexer() // :
                    parseType(builder)
                }
                if (builder.tokenType == MoonTypes.SEMICOLON) {
                    builder.advanceLexer() // ;
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseEnum(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // enum
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // enum name
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseEnumBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.ENUM)
    }

    private fun parseEnumBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer() // enum variant
                if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
                    builder.advanceLexer() // (
                    parseType(builder)
                    if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                        builder.advanceLexer() // )
                    }
                }
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer() // ,
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseFlags(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // flags
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // flags name
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseFlagsBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.FLAGS)
    }

    private fun parseFlagsBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer() // flag name
                if (builder.tokenType == MoonTypes.OP_ASSIGN) {
                    builder.advanceLexer() // =
                    if (builder.tokenType == MoonTypes.INTEGER) {
                        builder.advanceLexer() // value
                    }
                }
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer() // ,
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseVariant(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // variant
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // variant name
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseVariantBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.VARIANT)
    }

    private fun parseVariantBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer() // variant case
                if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
                    builder.advanceLexer() // (
                    parseType(builder)
                    if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                        builder.advanceLexer() // )
                    }
                }
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer() // ,
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseTrait(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // trait
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // trait name
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.KW_WITH) {
            builder.advanceLexer() // with
            parsePath(builder)
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseTraitBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
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
        builder.advanceLexer() // struct
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // struct name
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseStructBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.STRUCT)
    }

    private fun parseStructBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            if (builder.tokenType == MoonTypes.KW_MUTABLE) {
                builder.advanceLexer() // mut
            }
            if (builder.tokenType == MoonTypes.SYMBOL) {
                builder.advanceLexer() // field name
                if (builder.tokenType == MoonTypes.COLON) {
                    builder.advanceLexer() // :
                    parseType(builder)
                }
                if (builder.tokenType == MoonTypes.OP_ASSIGN) {
                    builder.advanceLexer() // =
                    parseExpression(builder)
                }
                if (builder.tokenType == MoonTypes.SEMICOLON) {
                    builder.advanceLexer() // ;
                }
            } else {
                builder.advanceLexer()
            }
        }
    }

    private fun parseFunction(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // fn
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // function name
        }
        parseFunctionParameters(builder)
        parseReturnType(builder)
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
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
        builder.advanceLexer() // let
        if (builder.tokenType == MoonTypes.KW_MUTABLE) {
            builder.advanceLexer() // mut
        }
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // variable name
        }
        if (builder.tokenType == MoonTypes.COLON) {
            builder.advanceLexer() // :
            parseType(builder)
        }
        if (builder.tokenType == MoonTypes.OP_ASSIGN) {
            builder.advanceLexer() // =
            parseExpression(builder)
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.LET)
    }

    private fun parseIf(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // if
        if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
            builder.advanceLexer() // (
            parseExpression(builder)
            if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                builder.advanceLexer() // )
            }
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        if (builder.tokenType == MoonTypes.KW_ELSE) {
            builder.advanceLexer() // else
            if (builder.tokenType == MoonTypes.KW_IF) {
                parseIf(builder)
            } else if (builder.tokenType == MoonTypes.BRACE_L) {
                builder.advanceLexer() // {
                parseFunctionBody(builder)
                if (builder.tokenType == MoonTypes.BRACE_R) {
                    builder.advanceLexer() // }
                }
            }
        }
        marker.done(MoonTypes.IF)
    }

    private fun parseMatch(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // match
        if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
            builder.advanceLexer() // (
            parseExpression(builder)
            if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                builder.advanceLexer() // )
            }
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseMatchBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.MATCH)
    }

    private fun parseMatchBody(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != MoonTypes.BRACE_R) {
            parsePattern(builder)
            if (builder.tokenType == MoonTypes.OP_THEN) {
                builder.advanceLexer() // =>
                parseExpression(builder)
                if (builder.tokenType == MoonTypes.COMMA) {
                    builder.advanceLexer() // ,
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
        builder.advanceLexer() // while
        if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
            builder.advanceLexer() // (
            parseExpression(builder)
            if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                builder.advanceLexer() // )
            }
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.WHILE)
    }

    private fun parseFor(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // for
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // variable name
        }
        if (builder.tokenType == MoonTypes.KW_IN) {
            builder.advanceLexer() // in
            parseExpression(builder)
        }
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        marker.done(MoonTypes.FOR)
    }

    private fun parseReturn(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // return
        parseExpression(builder)
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.RETURN)
    }

    private fun parseBreak(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // break
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.BREAK)
    }

    private fun parseContinue(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // continue
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.CONTINUE)
    }

    private fun parseRaise(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // raise
        parseExpression(builder)
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.RAISE)
    }

    private fun parseTry(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // try
        if (builder.tokenType == MoonTypes.BRACE_L) {
            builder.advanceLexer() // {
            parseFunctionBody(builder)
            if (builder.tokenType == MoonTypes.BRACE_R) {
                builder.advanceLexer() // }
            }
        }
        if (builder.tokenType == MoonTypes.KW_CATCH) {
            builder.advanceLexer() // catch
            if (builder.tokenType == MoonTypes.PARENTHESIS_L) {
                builder.advanceLexer() // (
                if (builder.tokenType == MoonTypes.SYMBOL) {
                    builder.advanceLexer() // error variable
                }
                if (builder.tokenType == MoonTypes.PARENTHESIS_R) {
                    builder.advanceLexer() // )
                }
            }
            if (builder.tokenType == MoonTypes.BRACE_L) {
                builder.advanceLexer() // {
                parseFunctionBody(builder)
                if (builder.tokenType == MoonTypes.BRACE_R) {
                    builder.advanceLexer() // }
                }
            }
        }
        marker.done(MoonTypes.TRY)
    }

    private fun parseTypeDef(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // type
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // type name
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.OP_ASSIGN) {
            builder.advanceLexer() // =
            parseType(builder)
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.TYPE_DEF)
    }

    private fun parseTypeAlias(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // typealias
        if (builder.tokenType == MoonTypes.SYMBOL) {
            builder.advanceLexer() // alias name
        }
        parseTypeParameters(builder)
        if (builder.tokenType == MoonTypes.OP_ASSIGN) {
            builder.advanceLexer() // =
            parseType(builder)
        }
        if (builder.tokenType == MoonTypes.SEMICOLON) {
            builder.advanceLexer() // ;
        }
        marker.done(MoonTypes.TYPE_ALIAS)
    }

    private fun parseImpl(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // impl
        if (builder.tokenType == MoonTypes.KW_FOR) {
            builder.advanceLexer() // for
            parseType(builder)
        }
        if (builder.tokenType == MoonTypes