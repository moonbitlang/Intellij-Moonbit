package com.github.bytecodealliance.ide.view

import com.github.bytecodealliance.language.file.WitFile
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

class WitStructureViewElement(private val node: NavigatablePsiElement) :
    StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any {
        return node
    }

    override fun navigate(requestFocus: Boolean) {
        node.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return node.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return node.canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        val name = node.name
        return name ?: ""
    }

    override fun getPresentation(): ItemPresentation {
        val presentation = node.presentation
        return presentation ?: PresentationData()
    }

    override fun getChildren(): Array<out TreeElement> {
        return emptyArray()
    }
}

