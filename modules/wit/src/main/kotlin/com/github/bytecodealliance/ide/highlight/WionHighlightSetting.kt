package com.github.bytecodealliance.ide.highlight

import com.github.bytecodealliance.language.file.WasmIconProvider
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class WionHighlightSetting : ColorSettingsPage {

    override fun getAttributeDescriptors() = WionColor.entries
        .map { it.attributesDescriptor }
        .toTypedArray()

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = "Wion"

    override fun getIcon() = WasmIconProvider.Wit

    override fun getHighlighter() = WionTokenHighlighter()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
        return WionColor.entries
            .associateBy({ it.name }, { it.textAttributesKey })
    }

    override fun getDemoText() = javaClass.getResource("/colors/wion.ftl")!!.readText()
}