package com.github.bytecodealliance.language.file

import com.github.bytecodealliance.MessageBundle
import com.github.bytecodealliance.WitLanguage
import com.github.bytecodealliance.WitxLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class WitFileType private constructor() : LanguageFileType(WitLanguage) {

    override fun getName(): String = WitLanguage.id

    override fun getDescription(): String = MessageBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "wit;"

    override fun getIcon(): Icon = WasmIconProvider.Wit

    companion object {
        @JvmStatic
        val INSTANCE = WitFileType()
    }
}

class WitFileTypeX private constructor() : LanguageFileType(WitxLanguage) {

    override fun getName(): String = WitxLanguage.id

    override fun getDescription(): String = MessageBundle.message("filetype.x.description")

    override fun getDefaultExtension(): String = "witx;"

    override fun getIcon(): Icon = WasmIconProvider.Wit

    companion object {
        @JvmStatic
        val INSTANCE = WitFileTypeX()
    }
}
