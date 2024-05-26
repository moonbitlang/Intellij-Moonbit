package com.github.bytecodealliance.ide.highlight

import com.github.bytecodealliance.MessageBundle
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.OptionsBundle
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.util.NlsContexts.AttributeDescriptor
import java.util.function.Supplier
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default

enum class WitColor(humanName: Supplier<@AttributeDescriptor String>, default: TextAttributesKey? = null) {
    // 特殊关键词
    KEYWORD(OptionsBundle.messagePointer("options.language.defaults.keyword"), Default.KEYWORD),
    // 字面量
    NULL(MessageBundle.messagePointer("color.token.null"), Default.KEYWORD),
    BOOLEAN(MessageBundle.messagePointer("color.token.boolean"), Default.KEYWORD),
    NUMBER(MessageBundle.messagePointer("color.token.number"), Default.NUMBER),
    STRING(MessageBundle.messagePointer("color.token.string"), Default.STRING),
    TEXT(MessageBundle.messagePointer("color.token.text"), STRING.textAttributesKey),
    STRING_ESCAPED(MessageBundle.messagePointer("color.token.text"), Default.VALID_STRING_ESCAPE),
    STRING_BAD(MessageBundle.messagePointer("color.token.text"), Default.INVALID_STRING_ESCAPE),
    // 标识符
    IDENTIFIER(OptionsBundle.messagePointer("options.language.defaults.identifier"), Default.IDENTIFIER),
    SYM_WORLD(MessageBundle.messagePointer("color.token.symbol.world"), Default.INTERFACE_NAME),
    SYM_INTERFACE(MessageBundle.messagePointer("color.token.symbol.interface"), Default.INTERFACE_NAME),
    SYM_TYPE(MessageBundle.messagePointer("color.token.symbol.type"), Default.CLASS_NAME),
    SYM_FIELD(MessageBundle.messagePointer("color.token.symbol.field"), Default.INSTANCE_FIELD),

    SYM_VARIANT(MessageBundle.messagePointer("color.token.symbol.variant"), Default.STATIC_FIELD),
//    SYM_ATTRIBUTE(WitBundle.messagePointer("color.token.symbol.attribute"), Default.STATIC_METHOD),
//    SYM_VARIABLE(WitBundle.messagePointer("color.token.symbol.variable"), Default.REASSIGNED_PARAMETER),
    SYM_FUNCTION(MessageBundle.messagePointer("color.token.symbol.function"), Default.FUNCTION_DECLARATION),
    SYM_BUILTIN(MessageBundle.messagePointer("color.token.symbol.builtin"), Default.PREDEFINED_SYMBOL),

    // 标点符号
    PARENTHESES(OptionsBundle.messagePointer("options.language.defaults.parentheses"), Default.PARENTHESES),
    BRACKETS(OptionsBundle.messagePointer("options.language.defaults.brackets"), Default.BRACKETS),
    BRACES(OptionsBundle.messagePointer("options.language.defaults.braces"), Default.BRACES),
    DOT(OptionsBundle.messagePointer("options.language.defaults.dot"), Default.DOT),
    COMMA(OptionsBundle.messagePointer("options.language.defaults.comma"), Default.COMMA),
    OPERATION(MessageBundle.messagePointer("color.token.set"), Default.OPERATION_SIGN),
    SEMICOLON(OptionsBundle.messagePointer("options.language.defaults.semicolon"), Default.SEMICOLON),

    // 注释
    LINE_COMMENT(OptionsBundle.messagePointer("options.language.defaults.line.comment"), Default.LINE_COMMENT),
    BLOCK_COMMENT(OptionsBundle.messagePointer("options.language.defaults.block.comment"), Default.BLOCK_COMMENT),
    DOC_COMMENT(OptionsBundle.messagePointer("options.language.defaults.doc.markup"), Default.DOC_COMMENT),

    // 错误
    BAD_CHARACTER(
        OptionsBundle.messagePointer("options.java.attribute.descriptor.bad.character"),
        HighlighterColors.BAD_CHARACTER
    ),

    // 废弃
    EXTENSION(OptionsBundle.messagePointer("options.language.defaults.metadata"), Default.METADATA),
    ;

    val textAttributesKey: TextAttributesKey = TextAttributesKey.createTextAttributesKey("fluent.$name", default)
    val attributesDescriptor: AttributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}
