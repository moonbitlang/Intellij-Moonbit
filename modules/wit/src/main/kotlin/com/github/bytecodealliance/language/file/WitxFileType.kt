package com.github.bytecodealliance.language.file

import com.github.bytecodealliance.MessageBundle
import com.github.bytecodealliance.WitxLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class WitxFileType private constructor() : LanguageFileType(WitxLanguage) {

    override fun getName(): String = WitxLanguage.id

    override fun getDescription(): String = MessageBundle.message("filetype.x.description")

    override fun getDefaultExtension(): String = "witx;"

    override fun getIcon(): Icon = WasmIconProvider.Wit

    companion object {
        @JvmStatic
        val INSTANCE = WitxFileType()
    }
}