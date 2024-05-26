package com.github.bytecodealliance.ide.doc

import com.github.bytecodealliance.language.psi.WitElement
import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import java.util.function.Consumer


class WitDocumentationProvider : DocumentationProvider {

    override fun findDocComment(file: PsiFile, range: TextRange): PsiDocCommentBase? {
        return super.findDocComment(file, range)
    }

    override fun collectDocComments(file: PsiFile, sink: Consumer<in PsiDocCommentBase>) {
//        file.accept(object : PsiRecursiveElementVisitor() {
//            override fun visitElement(element: PsiElement) {
//                if (element is PsiComment) {
//                    if (element.text.startsWith("///")) {
//                        println(element.text)
//                        sink.accept(DocumentWrapper(element))
//                    }
//                }
//                super.visitElement(element)
//            }
//        })
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        return comment.text.trimStart('/', ' ')
    }

}

private class DocumentWrapper(psi: PsiComment) : WitElement(psi.node), PsiDocCommentBase {
    override fun getTokenType(): IElementType {
        return node.elementType
    }

    override fun getOwner(): PsiElement? {
//        for (sibling in siblings(forward = true)) {
//            when (sibling) {
//                is WitRecord, is WitResource -> {
//                    return sibling
//                }
//
//                is WitFunction -> {
//                    return sibling
//                }
//            }
//        }
        return null
    }
}