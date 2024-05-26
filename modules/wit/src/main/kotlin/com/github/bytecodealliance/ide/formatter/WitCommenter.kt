package com.github.bytecodealliance.ide.formatter

import com.intellij.lang.CodeDocumentationAwareCommenter
import com.intellij.lang.Commenter
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType

class WitCommenter : CodeDocumentationAwareCommenter {
    override fun getLineCommentPrefix(): String = "//"

    override fun getBlockCommentPrefix(): String = "/*"

    override fun getBlockCommentSuffix(): String = "*/"

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null
    override fun getLineCommentTokenType(): IElementType? {
        return null
    }

    override fun getBlockCommentTokenType(): IElementType? {
        return null
    }

    override fun getDocumentationCommentTokenType(): IElementType? {
        return null
    }

    override fun getDocumentationCommentPrefix(): String? {
        return null
    }

    override fun getDocumentationCommentLinePrefix(): String {
        return "///"
    }

    override fun getDocumentationCommentSuffix(): String? {
        return null
    }

    override fun isDocumentationComment(element: PsiComment?): Boolean {
        if (element == null) return false
        return element.text.startsWith("///")
    }
}
