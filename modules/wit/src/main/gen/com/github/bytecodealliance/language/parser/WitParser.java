// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.bytecodealliance.language.psi.WitTypes.*;
import static com.github.bytecodealliance.language.psi.ParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WitParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return wit(b, l + 1);
  }

  /* ********************************************************** */
  // identifier-free
  public static boolean alias_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_name")) return false;
    if (!nextTokenIs(b, "<alias name>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALIAS_NAME, "<alias name>");
    r = identifier_free(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ANGLE_L (<<term>> (COMMA <<term>>)* COMMA?)? ANGLE_R
  static boolean angle(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "angle")) return false;
    if (!nextTokenIs(b, ANGLE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANGLE_L);
    r = r && angle_1(b, l + 1, _term);
    r = r && consumeToken(b, ANGLE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<term>> (COMMA <<term>>)* COMMA?)?
  private static boolean angle_1(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "angle_1")) return false;
    angle_1_0(b, l + 1, _term);
    return true;
  }

  // <<term>> (COMMA <<term>>)* COMMA?
  private static boolean angle_1_0(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "angle_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _term.parse(b, l);
    r = r && angle_1_0_1(b, l + 1, _term);
    r = r && angle_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA <<term>>)*
  private static boolean angle_1_0_1(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "angle_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!angle_1_0_1_0(b, l + 1, _term)) break;
      if (!empty_element_parsed_guard_(b, "angle_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA <<term>>
  private static boolean angle_1_0_1_0(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "angle_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _term.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean angle_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "angle_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // AT identifier-free annotation-body?
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION, null);
    r = consumeToken(b, AT);
    p = r; // pin = 1
    r = r && report_error_(b, identifier_free(b, l + 1));
    r = p && annotation_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // annotation-body?
  private static boolean annotation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_2")) return false;
    annotation_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<parenthesis annotation-pair>>
  public static boolean annotation_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_body")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, WitParser::annotation_pair);
    exit_section_(b, m, ANNOTATION_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // identifier-safe EQ annotation-value
  public static boolean annotation_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_pair")) return false;
    if (!nextTokenIs(b, "<annotation pair>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_PAIR, "<annotation pair>");
    r = identifier_safe(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && annotation_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VERSION
  // 	| identifier-safe
  public static boolean annotation_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_VALUE, "<annotation value>");
    r = consumeToken(b, VERSION);
    if (!r) r = identifier_safe(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // annotation*
  public static boolean annotations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotations")) return false;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATIONS, "<annotations>");
    while (true) {
      int c = current_position_(b);
      if (!annotation(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotations", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // BRACE_L <<term>>* BRACE_R
  static boolean block(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && block_1(b, l + 1, _term);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<term>>*
  private static boolean block_1(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!_term.parse(b, l)) break;
      if (!empty_element_parsed_guard_(b, "block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BRACE_L (<<term>> (COMMA <<term>>)* COMMA?)? BRACE_R
  static boolean brace(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "brace")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_1(b, l + 1, _term);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<term>> (COMMA <<term>>)* COMMA?)?
  private static boolean brace_1(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "brace_1")) return false;
    brace_1_0(b, l + 1, _term);
    return true;
  }

  // <<term>> (COMMA <<term>>)* COMMA?
  private static boolean brace_1_0(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "brace_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _term.parse(b, l);
    r = r && brace_1_0_1(b, l + 1, _term);
    r = r && brace_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA <<term>>)*
  private static boolean brace_1_0_1(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "brace_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_1_0_1_0(b, l + 1, _term)) break;
      if (!empty_element_parsed_guard_(b, "brace_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA <<term>>
  private static boolean brace_1_0_1_0(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "brace_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _term.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean brace_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brace_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // annotations KW_CONSTRUCTOR tuple (TO type-hint)?
  public static boolean constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor")) return false;
    if (!nextTokenIs(b, "<constructor>", AT, KW_CONSTRUCTOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCTOR, "<constructor>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_CONSTRUCTOR);
    p = r; // pin = 2
    r = r && report_error_(b, tuple(b, l + 1));
    r = p && constructor_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (TO type-hint)?
  private static boolean constructor_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_3")) return false;
    constructor_3_0(b, l + 1);
    return true;
  }

  // TO type-hint
  private static boolean constructor_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TO);
    r = r && type_hint(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // annotations  KW_INTERFACE interface-name interface-body
  public static boolean define_interface(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_interface")) return false;
    if (!nextTokenIs(b, "<define interface>", AT, KW_INTERFACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_INTERFACE, "<define interface>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_INTERFACE);
    p = r; // pin = 2
    r = r && report_error_(b, interface_name(b, l + 1));
    r = p && interface_body(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // annotations KW_TYPE identifier-safe EQ type-hint
  public static boolean define_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_type")) return false;
    if (!nextTokenIs(b, "<define type>", AT, KW_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_TYPE, "<define type>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_TYPE);
    p = r; // pin = 2
    r = r && report_error_(b, identifier_safe(b, l + 1));
    r = p && report_error_(b, consumeToken(b, EQ)) && r;
    r = p && type_hint(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // annotations KW_ENUM identifier-free enum-body
  public static boolean enum_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_$")) return false;
    if (!nextTokenIs(b, "<enum $>", AT, KW_ENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM, "<enum $>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_ENUM);
    p = r; // pin = 2
    r = r && report_error_(b, identifier_free(b, l + 1));
    r = p && enum_body(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<brace semantic-number>>
  public static boolean enum_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_body")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace(b, l + 1, WitParser::semantic_number);
    exit_section_(b, m, ENUM_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // annotations KW_EXPORT export-term
  public static boolean export(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export")) return false;
    if (!nextTokenIs(b, "<export>", AT, KW_EXPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPORT, "<export>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_EXPORT);
    p = r; // pin = 2
    r = r && export_term(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // function
  // 	| inline-interface
  // 	| include-name
  public static boolean export_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPORT_TERM, "<export term>");
    r = function(b, l + 1);
    if (!r) r = inline_interface(b, l + 1);
    if (!r) r = include_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // annotations KW_FLAGS identifier-free flags-body
  public static boolean flags(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flags")) return false;
    if (!nextTokenIs(b, "<flags>", AT, KW_FLAGS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FLAGS, "<flags>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_FLAGS);
    p = r; // pin = 2
    r = r && report_error_(b, identifier_free(b, l + 1));
    r = p && flags_body(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<brace semantic-number>>
  public static boolean flags_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flags_body")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace(b, l + 1, WitParser::semantic_number);
    exit_section_(b, m, FLAGS_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // annotations identifier-safe COLON function-signature
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION, "<function>");
    r = annotations(b, l + 1);
    r = r && identifier_safe(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && function_signature(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // modifier? KW_FUNCTION tuple (TO type-hint)?
  public static boolean function_signature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature")) return false;
    if (!nextTokenIs(b, "<function signature>", KW_FUNCTION, SYMBOL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_SIGNATURE, "<function signature>");
    r = function_signature_0(b, l + 1);
    r = r && consumeToken(b, KW_FUNCTION);
    p = r; // pin = 2
    r = r && report_error_(b, tuple(b, l + 1));
    r = p && function_signature_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // modifier?
  private static boolean function_signature_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature_0")) return false;
    modifier(b, l + 1);
    return true;
  }

  // (TO type-hint)?
  private static boolean function_signature_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature_3")) return false;
    function_signature_3_0(b, l + 1);
    return true;
  }

  // TO type-hint
  private static boolean function_signature_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TO);
    r = r && type_hint(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<angle type-hint>>
  public static boolean generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic")) return false;
    if (!nextTokenIs(b, ANGLE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = angle(b, l + 1, WitParser::type_hint);
    exit_section_(b, m, GENERIC, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL | ESCAPED
  public static boolean identifier_free(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_free")) return false;
    if (!nextTokenIs(b, "<identifier free>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_FREE, "<identifier free>");
    r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, ESCAPED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL | ESCAPED
  public static boolean identifier_safe(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_safe")) return false;
    if (!nextTokenIs(b, "<identifier safe>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_SAFE, "<identifier safe>");
    r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, ESCAPED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // annotations KW_IMPORT export-term
  public static boolean import_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_$")) return false;
    if (!nextTokenIs(b, "<import $>", AT, KW_IMPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT, "<import $>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_IMPORT);
    p = r; // pin = 2
    r = r && export_term(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // annotations KW_INCLUDE include-name
  public static boolean include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include")) return false;
    if (!nextTokenIs(b, "<include>", AT, KW_INCLUDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE, "<include>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_INCLUDE);
    p = r; // pin = 2
    r = r && include_name(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier-safe (COLON identifier-safe) (SLASH interface-name) package-version?
  //   | interface-name
  public static boolean include_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name")) return false;
    if (!nextTokenIs(b, "<include name>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE_NAME, "<include name>");
    r = include_name_0(b, l + 1);
    if (!r) r = interface_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier-safe (COLON identifier-safe) (SLASH interface-name) package-version?
  private static boolean include_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier_safe(b, l + 1);
    r = r && include_name_0_1(b, l + 1);
    r = r && include_name_0_2(b, l + 1);
    r = r && include_name_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON identifier-safe
  private static boolean include_name_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && identifier_safe(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SLASH interface-name
  private static boolean include_name_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SLASH);
    r = r && interface_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // package-version?
  private static boolean include_name_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name_0_3")) return false;
    package_version(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // interface-name COLON KW_INTERFACE interface-body
  public static boolean inline_interface(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_interface")) return false;
    if (!nextTokenIs(b, "<inline interface>", ESCAPED, SYMBOL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INLINE_INTERFACE, "<inline interface>");
    r = interface_name(b, l + 1);
    r = r && consumeTokens(b, 2, COLON, KW_INTERFACE);
    p = r; // pin = 3
    r = r && interface_body(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<block interface-element>>
  public static boolean interface_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_body")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block(b, l + 1, WitParser::interface_element);
    exit_section_(b, m, INTERFACE_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // SEMICOLON
  // 	| use
  // 	| define-type
  // 	| resource
  // 	| record
  // 	| flags
  // 	| enum
  // 	| variant
  // 	| function
  static boolean interface_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_element")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = use(b, l + 1);
    if (!r) r = define_type(b, l + 1);
    if (!r) r = resource(b, l + 1);
    if (!r) r = record(b, l + 1);
    if (!r) r = flags(b, l + 1);
    if (!r) r = enum_$(b, l + 1);
    if (!r) r = variant(b, l + 1);
    if (!r) r = function(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL | ESCAPED
  public static boolean interface_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interface_name")) return false;
    if (!nextTokenIs(b, "<interface name>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_NAME, "<interface name>");
    r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, ESCAPED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // annotations identifier-safe COLON function-signature
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD, "<method>");
    r = annotations(b, l + 1);
    r = r && identifier_safe(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && function_signature(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL | ESCAPED
  public static boolean module_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_name")) return false;
    if (!nextTokenIs(b, "<module name>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODULE_NAME, "<module name>");
    r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, ESCAPED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_PACKAGE package-name
  public static boolean package_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_$")) return false;
    if (!nextTokenIs(b, KW_PACKAGE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PACKAGE, null);
    r = consumeToken(b, KW_PACKAGE);
    p = r; // pin = 1
    r = r && package_name(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // module-name (COLON module-name)* package-version?
  public static boolean package_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name")) return false;
    if (!nextTokenIs(b, "<package name>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PACKAGE_NAME, "<package name>");
    r = module_name(b, l + 1);
    r = r && package_name_1(b, l + 1);
    r = r && package_name_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COLON module-name)*
  private static boolean package_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!package_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "package_name_1", c)) break;
    }
    return true;
  }

  // COLON module-name
  private static boolean package_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && module_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // package-version?
  private static boolean package_name_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name_2")) return false;
    package_version(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // AT VERSION
  public static boolean package_version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_version")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT, VERSION);
    exit_section_(b, m, PACKAGE_VERSION, r);
    return r;
  }

  /* ********************************************************** */
  // identifier-safe COLON type-hint {
  // }
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, "<parameter>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = identifier_safe(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_hint(b, l + 1);
    r = r && parameter_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean parameter_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // PARENTHESIS_L (<<term>> (COMMA <<term>>)* COMMA?)? PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && parenthesis_1(b, l + 1, _term);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<term>> (COMMA <<term>>)* COMMA?)?
  private static boolean parenthesis_1(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "parenthesis_1")) return false;
    parenthesis_1_0(b, l + 1, _term);
    return true;
  }

  // <<term>> (COMMA <<term>>)* COMMA?
  private static boolean parenthesis_1_0(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "parenthesis_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _term.parse(b, l);
    r = r && parenthesis_1_0_1(b, l + 1, _term);
    r = r && parenthesis_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA <<term>>)*
  private static boolean parenthesis_1_0_1(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parenthesis_1_0_1_0(b, l + 1, _term)) break;
      if (!empty_element_parsed_guard_(b, "parenthesis_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA <<term>>
  private static boolean parenthesis_1_0_1_0(PsiBuilder b, int l, Parser _term) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _term.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean parenthesis_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesis_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // annotations KW_RECORD identifier-safe record-body
  public static boolean record(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record")) return false;
    if (!nextTokenIs(b, "<record>", AT, KW_RECORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECORD, "<record>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_RECORD);
    p = r; // pin = 2
    r = r && report_error_(b, identifier_safe(b, l + 1));
    r = p && record_body(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<block record-element>>
  public static boolean record_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_body")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block(b, l + 1, WitParser::record_element);
    exit_section_(b, m, RECORD_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // record-field
  //   | COMMA
  static boolean record_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_element")) return false;
    boolean r;
    r = record_field(b, l + 1);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  /* ********************************************************** */
  // identifier-safe COLON type-hint
  public static boolean record_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_field")) return false;
    if (!nextTokenIs(b, "<record field>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_FIELD, "<record field>");
    r = identifier_safe(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_hint(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // annotations KW_RESOURCE identifier-safe resource-body?
  public static boolean resource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource")) return false;
    if (!nextTokenIs(b, "<resource>", AT, KW_RESOURCE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RESOURCE, "<resource>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_RESOURCE);
    p = r; // pin = 2
    r = r && report_error_(b, identifier_safe(b, l + 1));
    r = p && resource_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // resource-body?
  private static boolean resource_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_3")) return false;
    resource_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<block resource-element>>
  public static boolean resource_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_body")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block(b, l + 1, WitParser::resource_element);
    exit_section_(b, m, RESOURCE_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // method
  //   | constructor
  //   | SEMICOLON
  static boolean resource_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resource_element")) return false;
    boolean r;
    r = method(b, l + 1);
    if (!r) r = constructor(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL | ESCAPED
  public static boolean semantic_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semantic_number")) return false;
    if (!nextTokenIs(b, "<semantic number>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SEMANTIC_NUMBER, "<semantic number>");
    r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, ESCAPED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SEMICOLON
  // 	| package
  // 	| world
  // 	| include
  // 	| define-interface
  static boolean statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = package_$(b, l + 1);
    if (!r) r = world(b, l + 1);
    if (!r) r = include(b, l + 1);
    if (!r) r = define_interface(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // <<parenthesis parameter>>
  public static boolean tuple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenthesis(b, l + 1, WitParser::parameter);
    exit_section_(b, m, TUPLE, r);
    return r;
  }

  /* ********************************************************** */
  // identifier-safe generic?
  public static boolean type_generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic")) return false;
    if (!nextTokenIs(b, "<type generic>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_GENERIC, "<type generic>");
    r = identifier_safe(b, l + 1);
    r = r && type_generic_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // generic?
  private static boolean type_generic_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_generic_1")) return false;
    generic(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // tuple | type-generic
  public static boolean type_hint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_hint")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_HINT, "<type hint>");
    r = tuple(b, l + 1);
    if (!r) r = type_generic(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // annotations KW_USE include-name use-items?
  public static boolean use(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use")) return false;
    if (!nextTokenIs(b, "<use>", AT, KW_USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USE, "<use>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_USE);
    p = r; // pin = 2
    r = r && report_error_(b, include_name(b, l + 1));
    r = p && use_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // use-items?
  private static boolean use_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_3")) return false;
    use_items(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier-safe (KW_AS alias-name)?
  public static boolean use_alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_alias")) return false;
    if (!nextTokenIs(b, "<use alias>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USE_ALIAS, "<use alias>");
    r = identifier_safe(b, l + 1);
    r = r && use_alias_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KW_AS alias-name)?
  private static boolean use_alias_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_alias_1")) return false;
    use_alias_1_0(b, l + 1);
    return true;
  }

  // KW_AS alias-name
  private static boolean use_alias_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_alias_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AS);
    r = r && alias_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<brace use-alias>>
  public static boolean use_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_body")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace(b, l + 1, WitParser::use_alias);
    exit_section_(b, m, USE_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // DOT use-body
  public static boolean use_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USE_ITEMS, null);
    r = consumeToken(b, DOT);
    p = r; // pin = 1
    r = r && use_body(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // annotations KW_VARIANT identifier-free variant-body
  public static boolean variant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant")) return false;
    if (!nextTokenIs(b, "<variant>", AT, KW_VARIANT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIANT, "<variant>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_VARIANT);
    p = r; // pin = 2
    r = r && report_error_(b, identifier_free(b, l + 1));
    r = p && variant_body(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<brace variant-item>>
  public static boolean variant_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_body")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace(b, l + 1, WitParser::variant_item);
    exit_section_(b, m, VARIANT_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // identifier-safe (PARENTHESIS_L type-hint PARENTHESIS_R)?
  public static boolean variant_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_item")) return false;
    if (!nextTokenIs(b, "<variant item>", ESCAPED, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIANT_ITEM, "<variant item>");
    r = identifier_safe(b, l + 1);
    r = r && variant_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PARENTHESIS_L type-hint PARENTHESIS_R)?
  private static boolean variant_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_item_1")) return false;
    variant_item_1_0(b, l + 1);
    return true;
  }

  // PARENTHESIS_L type-hint PARENTHESIS_R
  private static boolean variant_item_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_item_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && type_hint(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statements*
  static boolean wit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wit")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "wit", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // annotations KW_WORLD identifier-free world-body
  public static boolean world(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "world")) return false;
    if (!nextTokenIs(b, "<world>", AT, KW_WORLD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WORLD, "<world>");
    r = annotations(b, l + 1);
    r = r && consumeToken(b, KW_WORLD);
    p = r; // pin = 2
    r = r && report_error_(b, identifier_free(b, l + 1));
    r = p && world_body(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // <<block world-element>>
  public static boolean world_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "world_body")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = block(b, l + 1, WitParser::world_element);
    exit_section_(b, m, WORLD_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // SEMICOLON
  // 	| include
  // 	| import
  // 	| export
  // 	| use
  // 	| define-type
  // 	| enum
  // 	| variant
  // 	| record
  // 	| resource
  // 	| COMMENT_LINE
  static boolean world_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "world_element")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = include(b, l + 1);
    if (!r) r = import_$(b, l + 1);
    if (!r) r = export(b, l + 1);
    if (!r) r = use(b, l + 1);
    if (!r) r = define_type(b, l + 1);
    if (!r) r = enum_$(b, l + 1);
    if (!r) r = variant(b, l + 1);
    if (!r) r = record(b, l + 1);
    if (!r) r = resource(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT_LINE);
    return r;
  }

}
