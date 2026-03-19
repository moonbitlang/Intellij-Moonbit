package com.github.bytecodealliance.ide.highlight


import com.github.bytecodealliance.ide.highlight.WitColor.*
import com.github.bytecodealliance.language.file.WitFile
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class WitHighlightVisitor : HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    private fun highlight(element: PsiElement?, color: WitColor) {
        if (element == null) return
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = WitHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is WitFile

    override fun visit(element: PsiElement) {}
}

