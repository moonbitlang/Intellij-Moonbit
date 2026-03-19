package com.github.moonbit.parser

import com.github.moonbit.psi.MoonTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import com.intellij.psi.PsiBuilder

class MbtiParser : PsiParser {
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
                MoonTypes.KW_INTERFACE -> parseInterface(builder)
                MoonTypes.KW_TYPE -> parseTypeDef(builder)
                MoonTypes.KW_TYPE_ALIAS -> parseTypeAlias(builder)
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
}
