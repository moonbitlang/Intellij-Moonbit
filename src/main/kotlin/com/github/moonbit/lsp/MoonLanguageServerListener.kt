package com.github.moonbit.lsp

import com.intellij.platform.lsp.api.LspServerListener
import org.eclipse.lsp4j.InitializeResult

class MoonLanguageServerListener : LspServerListener {
    override fun serverInitialized(params: InitializeResult) {
        println("Moon LSP: ${params.serverInfo.name}@${params.serverInfo.version}")
    }

    override fun serverStopped(shutdownNormally: Boolean) {
        if (shutdownNormally) {
            println("Moon LSP: server stopped normally")
        } else {
            println("Moon LSP: server stopped unexpectedly")
        }
    }
}