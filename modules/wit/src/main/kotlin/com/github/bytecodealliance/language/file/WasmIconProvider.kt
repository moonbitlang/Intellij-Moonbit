package com.github.bytecodealliance.language.file

import com.intellij.icons.AllIcons
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon

class WasmIconProvider : com.intellij.ide.IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val fileName = psiElement.containingFile.name

        return when {
            fileName.endsWith(".wit") -> Wit
            else -> null
        }
    }

    companion object {
        val Wit = IconLoader.getIcon("/icons/wit.svg", WasmIconProvider::class.java)
        val Wion = AllIcons.FileTypes.Unknown
    }
}