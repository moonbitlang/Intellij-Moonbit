package com.github.bytecodealliance.ide.matcher


import com.github.bytecodealliance.language.psi.*
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class WitFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : WitRecursiveVisitor() {

    override fun visitInterfaceBody(o: WitInterfaceBody) {
        descriptors += FoldingDescriptor(o.node, TextRange(o.firstChild.endOffset, o.lastChild.startOffset))

    }


    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}
