package com.github.bytecodealliance.language.file

import com.github.bytecodealliance.MessageBundle
import com.github.bytecodealliance.WitLanguage
import com.github.bytecodealliance.WitxLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class WitFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, WitLanguage) {
    override fun getFileType(): FileType = WitFileType.INSTANCE
    override fun getParserDefinition(): ParserDefinition {
        // print file extension


        return super.getParserDefinition()
    }
    override fun toString(): String = MessageBundle.message("action.create_file")
}

class WitFileX(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, WitxLanguage) {
    override fun getFileType(): FileType = WitFileTypeX.INSTANCE
    override fun getParserDefinition(): ParserDefinition {
        // print file extension


        return super.getParserDefinition()
    }
    override fun toString(): String = MessageBundle.message("action.create_file")
}

