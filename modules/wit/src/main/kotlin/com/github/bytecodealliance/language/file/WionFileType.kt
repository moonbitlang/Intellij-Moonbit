package com.github.bytecodealliance.language.file

import com.github.bytecodealliance.MessageBundle
import com.github.bytecodealliance.WionLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class WionFileType private constructor() : LanguageFileType(WionLanguage) {

    override fun getName(): String = WionLanguage.id

    override fun getDescription(): String = MessageBundle.message("filetype.x.description")

    override fun getDefaultExtension(): String = "wion;"

    override fun getIcon(): Icon = WasmIconProvider.Wion

    companion object {
        @JvmStatic
        val INSTANCE = WionFileType()
    }
}