package com.github.bytecodealliance.language.psi


import com.github.bytecodealliance.WitLanguage
import com.github.bytecodealliance.language._WitLexer
import com.github.bytecodealliance.language.file.WitFile
import com.github.bytecodealliance.language.parser.WitParser
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

class WitParserDefinition : ParserDefinition {
    fun createLexer(): Lexer = FlexAdapter(_WitLexer(null))
    override fun createLexer(project: Project): Lexer = FlexAdapter(_WitLexer(null))
    override fun createParser(project: Project): PsiParser = WitParser()
    override fun getFileNodeType(): IFileElementType = IFileElementType(WitLanguage)
    override fun getCommentTokens(): TokenSet =
        TokenSet.create(WitTypes.COMMENT_LINE, WitTypes.COMMENT_DOCUMENT, WitTypes.COMMENT_BLOCK)

    override fun getStringLiteralElements(): TokenSet = TokenSet.create()
    override fun getWhitespaceTokens(): TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
    override fun createElement(node: ASTNode): PsiElement = WitTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = WitFile(viewProvider)
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

}

