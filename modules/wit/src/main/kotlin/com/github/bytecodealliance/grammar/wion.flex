package com.github.bytecodealliance.language;


import static com.github.bytecodealliance.language.psi.WionTypes.*;
//import static com.intellij.json.JsonElementTypes.LINE_COMMENT;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;

%%

//%{
//public WitLexer() {
//	this((java.io.Reader)null);
//}
//%}

%public
%class _WionLexer
%implements com.intellij.lexer.FlexLexer
%function advance
%type com.intellij.psi.tree.IElementType
%unicode

//%state TextContextIndent
WHITE_SPACE      = [\s\t]
COMMENT_LINE     = [/]{2}[^\r\n]*
COMMENT_BLOCK    = [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
//SYMBOL=[\p{XID_Start}_][\p{XID_Continue}_]*
ESCAPED = %[a-zA-Z0-9\-]+
// namespace:package/module_function@2024.2.4-semver
SYMBOL = [@#/:.\-\p{XID_Start}][@#/:.\-\p{XID_Continue}]*

STRING_S1 = '[^']*'
STRING_S2 = \"(\\.|[^\\\"])*\"

SIGN = [+-]
INTEGER = 0|[1-9](_?[0-9])*
DECIMAL = \.[0-9](_?[0-9])*
EXPONENT = [eE]{SIGN}?[0-9](_?[0-9])*

BIN  = 0b[01](_?[01])*
OCT  = 0o[0-7](_?[0-7])*
DEC  = {SIGN}?{INTEGER}{DECIMAL}?{EXPONENT}?
HEX  = 0x[0-9a-fA-F](_?[0-9a-fA-F])*

KW_SOME  = "some"
KW_NONE  = "none"
KW_FINE  = "fine"
KW_FAIL  = "fail"
KW_TRUE  = "true"
KW_FALSE = "false"
%%

<YYINITIAL> {
    {WHITE_SPACE}+     { return WHITE_SPACE; }
	{COMMENT_LINE}     { return COMMENT_LINE; }
//	{COMMENT_BLOCK}    { return COMMENT_BLOCK; }
}

<YYINITIAL> {
	"(" { return PARENTHESIS_L; }
    ")" { return PARENTHESIS_R; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
	"{" { return BRACE_L; }
	"}" { return BRACE_R; }
//	"<" { return ANGLE_L; }
//	">" { return ANGLE_R; }
}
<YYINITIAL> {
	[+] { return ADD; }
    [-] { return SUB; }
	= { return EQUAL; }
	, { return COMMA; }
}
<YYINITIAL> {
	{KW_SOME} { return KW_SOME; }
	{KW_NONE} { return KW_NONE; }

	{KW_FINE} { return KW_FINE; }
	{KW_FAIL} { return KW_FAIL; }

	{KW_TRUE}  { return KW_TRUE; }
	{KW_FALSE} { return KW_FALSE; }

	{SYMBOL}  { return SYMBOL; }
}

<YYINITIAL> {
	{BIN} { return BIN; }
	{OCT} { return OCT; }
	{HEX} { return HEX; }
	{DEC} { return DEC; }
}

<YYINITIAL> {
	{STRING_S1} { return STRING_S1; }
	{STRING_S2} { return STRING_S2; }
}



// =====================================================================================================================
[^] { return BAD_CHARACTER; }
