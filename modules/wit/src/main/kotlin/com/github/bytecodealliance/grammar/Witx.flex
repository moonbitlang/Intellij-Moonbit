package com.github.bytecodealliance.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.bytecodealliance.language.psi.WitxTypes.*;

%%

//%{
//public WitLexer() {
//	this((java.io.Reader)null);
//}
//%}

%public
%class _WitxLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

//%state TextContextIndent

WHITE_SPACE      = [\s\t]
COMMENT_LINE     = ;{2}[^\r\n]*

REFERENCE = \$[a-zA-Z0-9_]*
SYMBOL    = [a-zA-Z][a-zA-Z0-9_]*
//STRING=\"([^\"\\]|\\.)*\"
INTEGER=(0|[1-9][0-9_]*)
DECIMAL=([0-9]+\.[0-9]*([Ee][0-9]+)?)|(\.[0-9]+([Ee][0-9]+)?)

CRLF      = \r\n | \n | \r
HEX = [0-9a-fA-F]

KW_WITX        = "@witx"
KW_PACKAGE     = "package"
KW_WORLD       = "world"
KW_INTERFACE   = "interface"
KW_INCLUDE     = "include"
KW_EXPORT      = "export"
KW_IMPORT      = "import"
KW_USE         = "use"
KW_AS          = "as"
KW_TYPE        = "typename"
KW_HANDLE      = "handle"
KW_RECORD      = "record"
KW_FIELD	   = "field"
KW_ENUM        = "enum"
KW_FLAGS       = "flags"
KW_UNION       = "union"
KW_FUNCTION    = "func"
KW_CONSTRUCTOR = "constructor"
KW_LIST		   = "list"

%%

<YYINITIAL> {
    {WHITE_SPACE}+     { return WHITE_SPACE; }
	{COMMENT_LINE}     { return COMMENT_LINE; }
}

<YYINITIAL> {
	"(" { return PARENTHESIS_L; }
    ")" { return PARENTHESIS_R; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
	"{" { return BRACE_L; }
	"}" { return BRACE_R; }
	"<" { return ANGLE_L; }
	">" { return ANGLE_R; }
    "->" { return TO; }
	"^" { return ACCENT; }
	":" { return COLON; }
	"$" { return DOLLAR; }
	"@" { return AT; }
	"/" { return SLASH; }
	"." { return DOT; }
	"," { return COMMA; }
	"-" { return HYPHEN; }
	"=" { return EQ; }
}
<YYINITIAL> {
	{KW_WITX}      { return KW_WITX; }
	{KW_PACKAGE}   { return KW_PACKAGE; }
	{KW_WORLD}     { return KW_WORLD; }
	{KW_INTERFACE} { return KW_INTERFACE; }

	{KW_INCLUDE} { return KW_INCLUDE; }
	{KW_USE}     { return KW_USE; }
	{KW_AS}      { return KW_AS; }
	{KW_IMPORT}  { return KW_IMPORT; }
	{KW_EXPORT}  { return KW_EXPORT; }

	{KW_TYPE}     { return KW_TYPE; }
	{KW_HANDLE}   { return KW_HANDLE; }
	{KW_LIST}     { return KW_LIST; }
	{KW_RECORD}   { return KW_RECORD; }
	{KW_FIELD}    { return KW_FIELD; }
	{KW_ENUM}     { return KW_ENUM; }
	{KW_FLAGS}    { return KW_FLAGS; }
	{KW_UNION}    { return KW_UNION; }

	{KW_FUNCTION}    { return KW_FUNCTION; }
    {KW_CONSTRUCTOR} { return KW_CONSTRUCTOR; }

	{REFERENCE} { return REFERENCE; }
	{SYMBOL}    { return SYMBOL; }
}
// =====================================================================================================================
[^] { return BAD_CHARACTER; }
