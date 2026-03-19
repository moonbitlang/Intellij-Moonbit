package com.github.bytecodealliance.language.psi


import com.github.bytecodealliance.WitLanguage
import com.github.bytecodealliance.language.lexer.WitLexer
import com.github.bytecodealliance.language.parser.WitParser
import com.github.bytecodealliance.language.file.WitFile
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class WitParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = WitLexer()
    override fun createParser(project: Project): PsiParser = WitParser()
    override fun getFileNodeType(): IFileElementType = IFileElementType(WitLanguage)
    override fun getCommentTokens(): TokenSet =
        TokenSet.create(WitTokenType("COMMENT_LINE"), WitTokenType("COMMENT_DOCUMENT"), WitTokenType("COMMENT_BLOCK"))

    override fun getStringLiteralElements(): TokenSet = TokenSet.create()
    override fun getWhitespaceTokens(): TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
    override fun createElement(node: ASTNode): PsiElement = WitElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = WitFile(viewProvider)
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

}

