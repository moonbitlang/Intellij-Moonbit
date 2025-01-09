<!-- Plugin description -->


A [moonbit language](https://github.com/moonbitlang/core) plugin for
IntelliJ-based IDEs, supports the `*.mbt` file extension.

## Features

| Feature            | Progress | Implement                                                                                                                                                   |
|--------------------|----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Language Server    | ✅        | [MoonLanguageProtocol](https://github.com/moonbitlang/Intellij-Moonbit/blob/dev/src/main/kotlin/com/github/moonbit/lsp/MoonLanguageProtocol.kt)             |
| Syntax Highlight   | ✅        | [MoonTokenHighlighter](https://github.com/moonbitlang/Intellij-Moonbit/blob/dev/src/main/kotlin/com/github/moonbit/ide/highlight/MoonTokenHighlighter.kt)   |
| Semantic Highlight | ✅        | [MoonSyntaxHighlighter](https://github.com/moonbitlang/Intellij-Moonbit/blob/dev/src/main/kotlin/com/github/moonbit/ide/highlight/MoonSyntaxHighlighter.kt) |
| Pretty Formatter   | ✅        | [MoonFormatBuilder](https://github.com/moonbitlang/Intellij-Moonbit/blob/dev/src/main/kotlin/com/github/moonbit/ide/formatter/MoonFormatBuilder.kt)         |
| Structure View     | ✅        | [MoonFormatBuilder](https://github.com/moonbitlang/Intellij-Moonbit/blob/dev/src/main/kotlin/com/github/moonbit/ide/formatter/MoonFormatBuilder.kt)         |
| Block Folding      | ✅        | [MoonFoldingVisitor](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/matcher/WitFoldingVisitor.kt)           |
| Braces Matcher     | ✅        |                                                                                                                                                             |
| Smart Enter        | ✅        | [MoonSmartEnter]()                                                                                                                                          |

<!-- Plugin description end -->
