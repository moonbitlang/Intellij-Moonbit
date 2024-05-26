package com.github.bytecodealliance.language.mixin

import com.github.bytecodealliance.ide.view.WitItemPresentation
import com.github.bytecodealliance.language.psi.WitElement
import com.github.bytecodealliance.language.psi.WitMethod
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

abstract class MixinMethod(node: ASTNode) : WitElement(node),
    PsiNameIdentifierOwner,
    WitMethod {
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement? {
        return this.identifierSafe
    }


    override fun getPresentation(): ItemPresentation? {
        return WitItemPresentation(AllIcons.Nodes.Method, nameIdentifier?.text ?: "missing interface")
    }
}