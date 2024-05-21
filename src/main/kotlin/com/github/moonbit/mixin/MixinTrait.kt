package com.github.moonbit.mixin

import com.github.moonbit.ide.view.MoonItemPresentation
import com.github.moonbit.psi.MbtiDeclareTrait
import com.github.moonbit.psi.MoonDeclareTrait
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

abstract class MixinTrait : ASTWrapperPsiElement, PsiNameIdentifierOwner {
    constructor(node: ASTNode) : super(node)

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement? {
        return when (this) {
            is MoonDeclareTrait -> this.identifier
            is MbtiDeclareTrait -> this.identifier
            else -> null
        }
    }

    override fun getPresentation(): ItemPresentation? {
        return MoonItemPresentation(AllIcons.Nodes.Record, nameIdentifier?.text ?: "missing interface")
    }
}