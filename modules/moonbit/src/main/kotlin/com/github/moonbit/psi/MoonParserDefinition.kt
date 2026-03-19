package com.github.moonbit.psi

import com.github.moonbit.MoonLanguage
import com.github.moonbit.file.MoonFile
import com.github.moonbit.lexer.MoonLexer
import com.github.moonbit.parser.MoonParser
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class MoonParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = MoonLexer()
    override fun createParser(project: Project?): PsiParser = MoonParser()
    override fun getFileNodeType(): IFileElementType = IFileElementType(MoonLanguage)
    override fun getCommentTokens(): TokenSet = TokenSet.create(
        MoonTypes.COMMENT_LINE,
        MoonTypes.COMMENT_DOCUMENT,
        MoonTypes.COMMENT_BLOCK
    )

    override fun getStringLiteralElements(): TokenSet = TokenSet.create()
    override fun getWhitespaceTokens(): TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
    override fun createElement(node: ASTNode): PsiElement = MoonTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = MoonFile(viewProvider)
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }
}

