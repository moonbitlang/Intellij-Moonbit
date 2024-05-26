<!-- Plugin description -->


A [Wasm Interface Type](https://github.com/WebAssembly/component-model/blob/main/design/mvp/WIT.md) plugin for
IntelliJ-based IDEs, supports the old `*.witx` and latest `*.wit` file extension.

## Features

| Feature            | Progress | Implement                                                                                                                                                |
|--------------------|----------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| Language Server    | ✅        | [WitLanguageProtocol]()                                                                                                                                  |
| Syntax Highlight   | ✅        | [WitSyntaxHighlighter](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/highlight/WitSyntaxHighlighter.kt) |
| Semantic Highlight | ✅        | [WitHighlightVisitor](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/highlight/WitHighlightVisitor.kt)   |
| Pretty Formatter   | ✅        | [WitFormatBuilder](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/formatter/WitFormatBuilder.kt)         |
| Block Folding      | ✅        | [WitFoldingVisitor](https://github.com/oovm/WIT-Intellij/blob/main/src/main/kotlin/com/github/bytecodealliance/ide/matcher/WitFoldingVisitor.kt)         |
| Braces Matcher     | ✅        |                                                                                                                                                          |
| Smart Enter        | ✅        | [WitSmartEnter]()                                                                                                                                        |

<!-- Plugin description end -->
