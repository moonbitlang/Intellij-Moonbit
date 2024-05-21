package com.github.moonbit.ide.view

import com.intellij.navigation.ItemPresentation
import javax.swing.Icon

class MoonItemPresentation : ItemPresentation {
    private val icon: Icon
    val text: String
    private val detail: String?

    constructor(icon: Icon, text: String, detail: String? = null) {
        this.icon = icon
        this.text = text
        this.detail = detail
    }

    override fun getPresentableText(): String = text
    override fun getIcon(unused: Boolean): Icon = icon
    override fun getLocationString(): String? = detail
}