package com.github.bytecodealliance.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile

class WitFormatBuilder : FormattingModelBuilder {
    override fun getRangeAffectingIndent(file: PsiFile?, offset: Int, elementAtOffset: ASTNode?): TextRange? = null

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val settings = formattingContext.codeStyleSettings
        val element = formattingContext.psiElement
        val block = object : Block {
            override fun getTextRange(): TextRange {
                return element.node.textRange
            }

            override fun getSubBlocks(): MutableList<Block> {
                return mutableListOf()
            }

            override fun getWrap(): Wrap? {
                return null
            }

            override fun getIndent(): Indent? {
                return Indent.getNoneIndent()
            }

            override fun getAlignment(): Alignment? {
                return null
            }

            override fun getSpacing(child1: Block?, child2: Block): Spacing? {
                return null
            }

            override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
                return ChildAttributes(Indent.getNoneIndent(), null)
            }

            override fun isIncomplete(): Boolean {
                return false
            }

            override fun isLeaf(): Boolean {
                return element.node.firstChildNode == null
            }
        }
        return FormattingModelProvider.createFormattingModelForPsiFile(element.containingFile, block, settings)
    }

    companion object {
        fun getChildAttributes(node: ASTNode, newChildIndex: Int): ChildAttributes {
            val indent = Indent.getNoneIndent()
            return ChildAttributes(indent, null)
        }

        fun computeIndent(parent: ASTNode, child: ASTNode): Indent? {
            return Indent.getNoneIndent()
        }

        private fun ASTNode.byCorner(child: ASTNode): Indent {
            val isCorner = this.firstChildNode == child || this.lastChildNode == child
            return when {
                isCorner -> Indent.getNoneIndent()
                else -> Indent.getNormalIndent()
            }
        }
        private fun ASTNode.indentInRange(child: ASTNode, head: Int, tail: Int): Indent {
            val children = this.getChildren(null);
            val index = children.indexOf(child)
            val last = children.size - tail
            return when {
                index <= head -> Indent.getNoneIndent()
                index >= last -> Indent.getNoneIndent()
                else -> Indent.getNormalIndent()
            }
        }
    }
}
