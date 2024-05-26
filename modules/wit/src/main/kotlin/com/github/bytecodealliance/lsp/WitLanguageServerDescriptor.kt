package com.github.bytecodealliance.lsp

import com.github.bytecodealliance.language.file.WitFileType
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class WitLanguageServerDescriptor : ProjectWideLspServerDescriptor {
    override val lspServerListener = WitLanguageServerListener()

    constructor(project: Project) : super(project, "wit-lsp")

    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file.fileType is WitFileType
    }

    override fun createCommandLine(): GeneralCommandLine {
        return GeneralCommandLine("wit-lsp")
    }
}
