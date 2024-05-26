package com.github.bytecodealliance.language.psi


import com.github.bytecodealliance.WitxLanguage
import com.github.bytecodealliance.language._WitxLexer
import com.github.bytecodealliance.language.file.WitFileX
import com.github.bytecodealliance.language.parser.WitxParser
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

class WitParserDefinitionX : ParserDefinition {
    fun createLexer(): Lexer = FlexAdapter(_WitxLexer(null))
    override fun createLexer(project: Project): Lexer = FlexAdapter(_WitxLexer(null))
    override fun createParser(project: Project): PsiParser = WitxParser()
    override fun getFileNodeType(): IFileElementType = IFileElementType(WitxLanguage)
    override fun getCommentTokens(): TokenSet =
        TokenSet.create(WitxTypes.COMMENT_LINE, WitxTypes.COMMENT_BLOCK)

    override fun getStringLiteralElements(): TokenSet = TokenSet.create()
    override fun getWhitespaceTokens(): TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
    override fun createElement(node: ASTNode): PsiElement = WitxTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = WitFileX(viewProvider)
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }
}




