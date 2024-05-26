// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.bytecodealliance.ide.annotator

import com.github.bytecodealliance.language.psi.WitPackageName
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class LiteralChecker : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        element.accept(CheckVisitor(holder))
    }

    private fun validEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(TextRange.from(offset, length))
            .textAttributes(VALID_STRING_ESCAPE)
            .create()
    }

    private fun uselessEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder.newSilentAnnotation(HighlightSeverity.WEAK_WARNING)
            .range(TextRange.from(offset, length))
            .textAttributes(VALID_STRING_ESCAPE)
            .create()
    }

    private fun invalidEscape(offset: Int, length: Int, holder: AnnotationHolder) {
        holder
            .newSilentAnnotation(HighlightSeverity.ERROR)
            .range(TextRange.from(offset, length))
            .textAttributes(INVALID_STRING_ESCAPE)
            .create()
    }


}

private class CheckVisitor(holder: AnnotationHolder): WitAnnotator(holder) {
    override fun visitPackageName(o: WitPackageName) {
        println(o.text)
        for (name in o.moduleNameList) {
//            holder.newAnnotation(HighlightSeverity.ERROR, "Nested namespace dost not support yet")
//                .range(name.textRange)
//                .create()
        }
    }
}