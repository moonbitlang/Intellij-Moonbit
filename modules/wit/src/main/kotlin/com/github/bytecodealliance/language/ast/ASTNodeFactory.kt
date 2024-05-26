package com.github.bytecodealliance.language.ast

import com.github.bytecodealliance.WitLanguage
import com.github.bytecodealliance.language.file.WitFile
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

class ASTNodeFactory(private val project: Project) {
    fun createFile(text: String): WitFile {
        val file =  PsiFileFactory.getInstance(project).createFileFromText("dummy.fluent", WitLanguage, text)
        return file as WitFile
    }
}