package com.github.bytecodealliance.lsp

import com.intellij.platform.lsp.api.LspServerListener
import org.eclipse.lsp4j.InitializeResult

class WitLanguageServerListener : LspServerListener {
    override fun serverInitialized(params: InitializeResult) {
        println("WitLanguageServerListener: ${params.serverInfo.name}@${params.serverInfo.version}")
    }
}