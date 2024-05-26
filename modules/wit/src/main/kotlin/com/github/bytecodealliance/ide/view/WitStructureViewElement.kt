package com.github.bytecodealliance.ide.view

import com.github.bytecodealliance.language.file.WitFile
import com.github.bytecodealliance.language.psi.WitDefineInterface
import com.github.bytecodealliance.language.psi.WitEnum
import com.github.bytecodealliance.language.psi.WitFlags
import com.github.bytecodealliance.language.psi.WitRecord
import com.github.bytecodealliance.language.psi.WitResource
import com.github.bytecodealliance.language.psi.WitVariant
import com.github.bytecodealliance.language.psi.WitWorld
import com.github.bytecodealliance.language.psi_node.WitDefineInterfaceNode
import com.github.bytecodealliance.language.psi_node.WitEnumNode
import com.github.bytecodealliance.language.psi_node.WitExportNode
import com.github.bytecodealliance.language.psi_node.WitFlagsNode
import com.github.bytecodealliance.language.psi_node.WitFunctionNode
import com.github.bytecodealliance.language.psi_node.WitMethodNode
import com.github.bytecodealliance.language.psi_node.WitRecordFieldNode
import com.github.bytecodealliance.language.psi_node.WitRecordNode
import com.github.bytecodealliance.language.psi_node.WitResourceNode
import com.github.bytecodealliance.language.psi_node.WitSemanticNumberNode
import com.github.bytecodealliance.language.psi_node.WitVariantItemNode
import com.github.bytecodealliance.language.psi_node.WitVariantNode
import com.github.bytecodealliance.language.psi_node.WitWorldNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

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

    override fun getChildren(): Array<out TreeElement> = when (node) {
        is WitFile -> getChildOfType(
            WitWorldNode::class.java,
            WitDefineInterfaceNode::class.java,
        )
        is WitWorld -> getChildOfType(
            WitExportNode::class.java,
        )
        is WitDefineInterface -> getChildOfType(
            WitResourceNode::class.java,
            WitRecordNode::class.java,
            WitVariantNode::class.java,
            WitEnumNode::class.java,
            WitFlagsNode::class.java,
            WitFunctionNode::class.java,
        )
        is WitResource -> getChildOfType(
            WitMethodNode::class.java
        )
        is WitRecord -> getChildOfType(
            WitRecordFieldNode::class.java
        )
        is WitEnum, is WitFlags -> getChildOfType(
            WitSemanticNumberNode::class.java
        )
        is WitVariant -> getChildOfType(
            WitVariantItemNode::class.java
        )

        else -> getChildOfType(
//            NavigatablePsiElement::class.java,
        )
    }

    private fun getChildOfType(vararg classes: Class<out NavigatablePsiElement>): Array<WitStructureViewElement> {
        return PsiTreeUtil.getChildrenOfAnyType(node, *classes)
            .map { WitStructureViewElement(it) }
            .toTypedArray()
    }
}

