package com.github.bytecodealliance.lsp

import com.intellij.internal.sandbox.LSPServer
import java.util.stream.Stream

class WitLanguageServerListener : LSPServer {
    override fun notifyOfChanges() {
        TODO("Not yet implemented")
    }

    override fun diagnostics(): Stream<LSPServer.Diagnostic> {
        TODO("Not yet implemented")
    }
}