package com.github.bytecodealliance.ide.highlight

import com.github.bytecodealliance.language.file.WionFile
import com.github.bytecodealliance.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class WionNodeHighlighter : WionVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitDictKey(o: WionDictKey) {
        highlight(o, WionColor.KEY)
    }

    override fun visitVariantName(o: WionVariantName) {
        highlight(o, WionColor.VARIANT)
    }

    override fun visitDictLiteral(o: WionDictLiteral) {
        highlight(o.identifier, WionColor.RECORD)
    }

    override fun visitFlagItem(o: WionFlagItem) {
        highlight(o.identifier, WionColor.FLAGS)
    }


    override fun visit(element: PsiElement) = element.accept(this)
    override fun clone() = WionNodeHighlighter()
    override fun suitableForFile(file: PsiFile) = file is WionFile
    override fun analyze(file: PsiFile, update: Boolean, holder: HighlightInfoHolder, action: Runnable): Boolean {
        infoHolder = holder
        action.run()
        return true
    }

    private fun highlight(element: PsiElement?, color: WionColor) {
        if (element == null) return
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)
        infoHolder?.add(builder.create())
    }
}