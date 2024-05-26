package com.github.bytecodealliance.language.file

import com.github.bytecodealliance.MessageBundle
import com.github.bytecodealliance.WionLanguage
import com.github.bytecodealliance.WitxLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class WionFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, WionLanguage) {
    override fun getFileType(): FileType = WionFileType.INSTANCE
    override fun toString(): String = MessageBundle.message("action.create_file")
}