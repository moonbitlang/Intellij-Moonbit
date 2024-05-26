package com.github.bytecodealliance.language.psi

import com.github.bytecodealliance.WionLanguage
import com.github.bytecodealliance.WitxLanguage
import com.github.bytecodealliance.language._WionLexer
import com.github.bytecodealliance.language.file.WionFile
import com.github.bytecodealliance.language.file.WitFileX
import com.github.bytecodealliance.language.parser.WionParser
import com.github.bytecodealliance.language.parser.WitxParser
//import com.intellij.json.JsonTokenSets
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

class WionParserDefinition : ParserDefinition {
    fun createLexer() = FlexAdapter(_WionLexer(null))
    override fun createLexer(project: Project) = FlexAdapter(_WionLexer(null))
    override fun createParser(project: Project) = WionParser()
    override fun getFileNodeType() = IFileElementType(WionLanguage)
    override fun getCommentTokens(): TokenSet {
//        return JsonTokenSets.JSON_COMMENTARIES
        return TokenSet.EMPTY
    }

    override fun getStringLiteralElements(): TokenSet = TokenSet.create()
    override fun getWhitespaceTokens(): TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
    override fun createElement(node: ASTNode): PsiElement = WionTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = WionFile(viewProvider)
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }
}