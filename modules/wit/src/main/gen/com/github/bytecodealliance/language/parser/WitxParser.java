// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.bytecodealliance.language.psi.WitxTypes.*;
import static com.github.bytecodealliance.language.psi.ParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WitxParser implements PsiParser, LightPsiParser {

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
    return witx(b, l + 1);
  }

  /* ********************************************************** */
  // KW_CONSTRUCTOR function-parameters
  public static boolean constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constructor")) return false;
    if (!nextTokenIs(b, KW_CONSTRUCTOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCTOR, null);
    r = consumeToken(b, KW_CONSTRUCTOR);
    p = r; // pin = 1
    r = r && function_parameters(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // PARENTHESIS_L KW_ENUM tag enum-items* PARENTHESIS_R
  public static boolean enum_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_$")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM, null);
    r = consumeTokens(b, 2, PARENTHESIS_L, KW_ENUM);
    p = r; // pin = 2
    r = r && report_error_(b, tag(b, l + 1));
    r = p && report_error_(b, enum_3(b, l + 1)) && r;
    r = p && consumeToken(b, PARENTHESIS_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // enum-items*
  private static boolean enum_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_items(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // reference-name
  public static boolean enum_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_items")) return false;
    if (!nextTokenIs(b, REFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reference_name(b, l + 1);
    exit_section_(b, m, ENUM_ITEMS, r);
    return r;
  }

  /* ********************************************************** */
  // KW_EXPORT interface-name
  public static boolean export(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export")) return false;
    if (!nextTokenIs(b, KW_EXPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPORT, null);
    r = consumeTokens(b, 1, KW_EXPORT, INTERFACE_NAME);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // PARENTHESIS_L KW_FLAGS tag enum-items* PARENTHESIS_R
  public static boolean flags(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flags")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FLAGS, null);
    r = consumeTokens(b, 2, PARENTHESIS_L, KW_FLAGS);
    p = r; // pin = 2
    r = r && report_error_(b, tag(b, l + 1));
    r = p && report_error_(b, flags_3(b, l + 1)) && r;
    r = p && consumeToken(b, PARENTHESIS_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // enum-items*
  private static boolean flags_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flags_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_items(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flags_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifier COLON function-signature {
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinFunction"
  // }
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && function_signature(b, l + 1);
    r = r && function_3(b, l + 1);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  // {
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinFunction"
  // }
  private static boolean function_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // PARENTHESIS_L (parameter (COMMA parameter)* COMMA?)? PARENTHESIS_R
  public static boolean function_parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && function_parameters_1(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, FUNCTION_PARAMETERS, r);
    return r;
  }

  // (parameter (COMMA parameter)* COMMA?)?
  private static boolean function_parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters_1")) return false;
    function_parameters_1_0(b, l + 1);
    return true;
  }

  // parameter (COMMA parameter)* COMMA?
  private static boolean function_parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter(b, l + 1);
    r = r && function_parameters_1_0_1(b, l + 1);
    r = r && function_parameters_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA parameter)*
  private static boolean function_parameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_parameters_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_parameters_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA parameter
  private static boolean function_parameters_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean function_parameters_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_parameters_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // identifier? KW_FUNCTION function-parameters (TO type-hint)?
  public static boolean function_signature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature")) return false;
    if (!nextTokenIs(b, "<function signature>", KW_FUNCTION, SYMBOL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_SIGNATURE, "<function signature>");
    r = function_signature_0(b, l + 1);
    r = r && consumeToken(b, KW_FUNCTION);
    p = r; // pin = 2
    r = r && report_error_(b, function_parameters(b, l + 1));
    r = p && function_signature_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // identifier?
  private static boolean function_signature_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature_0")) return false;
    identifier(b, l + 1);
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
  // PARENTHESIS_L KW_HANDLE PARENTHESIS_R
  public static boolean handle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "handle")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PARENTHESIS_L, KW_HANDLE, PARENTHESIS_R);
    exit_section_(b, m, HANDLE, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // KW_IMPORT include-name
  public static boolean import_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_$")) return false;
    if (!nextTokenIs(b, KW_IMPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT, null);
    r = consumeToken(b, KW_IMPORT);
    p = r; // pin = 1
    r = r && include_name(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_INCLUDE include-name
  public static boolean include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include")) return false;
    if (!nextTokenIs(b, KW_INCLUDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE, null);
    r = consumeToken(b, KW_INCLUDE);
    p = r; // pin = 1
    r = r && include_name(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier (COLON identifier) (SLASH interface-name) (AT VERSION)
  //   | interface-name
  public static boolean include_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name")) return false;
    if (!nextTokenIs(b, "<include name>", INTERFACE_NAME, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE_NAME, "<include name>");
    r = include_name_0(b, l + 1);
    if (!r) r = consumeToken(b, INTERFACE_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier (COLON identifier) (SLASH interface-name) (AT VERSION)
  private static boolean include_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && include_name_0_1(b, l + 1);
    r = r && include_name_0_2(b, l + 1);
    r = r && include_name_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON identifier
  private static boolean include_name_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SLASH interface-name
  private static boolean include_name_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SLASH, INTERFACE_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // AT VERSION
  private static boolean include_name_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_name_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT, VERSION);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L KW_LIST type-hint PARENTHESIS_R
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PARENTHESIS_L, KW_LIST);
    r = r && type_hint(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, LIST, r);
    return r;
  }

  /* ********************************************************** */
  // identifier COLON function-signature {
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinMethod"
  // }
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && function_signature(b, l + 1);
    r = r && method_3(b, l + 1);
    exit_section_(b, m, METHOD, r);
    return r;
  }

  // {
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinMethod"
  // }
  private static boolean method_3(PsiBuilder b, int l) {
    return true;
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
  // organization-name (COLON module-name) (AT VERSION)
  //   | module-name
  public static boolean package_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name")) return false;
    if (!nextTokenIs(b, "<package name>", MODULE_NAME, ORGANIZATION_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PACKAGE_NAME, "<package name>");
    r = package_name_0(b, l + 1);
    if (!r) r = consumeToken(b, MODULE_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // organization-name (COLON module-name) (AT VERSION)
  private static boolean package_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ORGANIZATION_NAME);
    r = r && package_name_0_1(b, l + 1);
    r = r && package_name_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON module-name
  private static boolean package_name_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, MODULE_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // AT VERSION
  private static boolean package_name_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "package_name_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT, VERSION);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier COLON type-hint {
  // }
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type_hint(b, l + 1);
    r = r && parameter_3(b, l + 1);
    exit_section_(b, m, PARAMETER, r);
    return r;
  }

  // {
  // }
  private static boolean parameter_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // PARENTHESIS_L KW_RECORD record-element* PARENTHESIS_R
  public static boolean record(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECORD, null);
    r = consumeTokens(b, 2, PARENTHESIS_L, KW_RECORD);
    p = r; // pin = 2
    r = r && report_error_(b, record_2(b, l + 1));
    r = p && consumeToken(b, PARENTHESIS_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // record-element*
  private static boolean record_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!record_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "record_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // record-field
  static boolean record_element(PsiBuilder b, int l) {
    return record_field(b, l + 1);
  }

  /* ********************************************************** */
  // PARENTHESIS_L KW_FIELD reference-name type-hint PARENTHESIS_R
  public static boolean record_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_field")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECORD_FIELD, null);
    r = consumeTokens(b, 2, PARENTHESIS_L, KW_FIELD);
    p = r; // pin = 2
    r = r && report_error_(b, reference_name(b, l + 1));
    r = p && report_error_(b, type_hint(b, l + 1)) && r;
    r = p && consumeToken(b, PARENTHESIS_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // REFERENCE
  public static boolean reference_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference_name")) return false;
    if (!nextTokenIs(b, REFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REFERENCE);
    exit_section_(b, m, REFERENCE_NAME, r);
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
  // typename
  static boolean statements(PsiBuilder b, int l) {
    return typename(b, l + 1);
  }

  /* ********************************************************** */
  // PARENTHESIS_L KW_WITX identifier type-hint PARENTHESIS_R
  public static boolean tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TAG, null);
    r = consumeTokens(b, 2, PARENTHESIS_L, KW_WITX);
    p = r; // pin = 2
    r = r && report_error_(b, identifier(b, l + 1));
    r = p && report_error_(b, type_hint(b, l + 1)) && r;
    r = p && consumeToken(b, PARENTHESIS_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  //   | reference-name
  //   | tag
  //   | handle
  //   | record
  //   | flags
  //   | enum
  //   | union
  //   | list
  public static boolean type_hint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_hint")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_HINT, "<type hint>");
    r = identifier(b, l + 1);
    if (!r) r = reference_name(b, l + 1);
    if (!r) r = tag(b, l + 1);
    if (!r) r = handle(b, l + 1);
    if (!r) r = record(b, l + 1);
    if (!r) r = flags(b, l + 1);
    if (!r) r = enum_$(b, l + 1);
    if (!r) r = union(b, l + 1);
    if (!r) r = list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PARENTHESIS_L KW_TYPE reference-name type-hint PARENTHESIS_R
  public static boolean typename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typename")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPENAME, null);
    r = consumeTokens(b, 2, PARENTHESIS_L, KW_TYPE);
    p = r; // pin = 2
    r = r && report_error_(b, reference_name(b, l + 1));
    r = p && report_error_(b, type_hint(b, l + 1)) && r;
    r = p && consumeToken(b, PARENTHESIS_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // PARENTHESIS_L KW_UNION tag enum-items* PARENTHESIS_R
  public static boolean union(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNION, null);
    r = consumeTokens(b, 2, PARENTHESIS_L, KW_UNION);
    p = r; // pin = 2
    r = r && report_error_(b, tag(b, l + 1));
    r = p && report_error_(b, union_3(b, l + 1)) && r;
    r = p && consumeToken(b, PARENTHESIS_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // enum-items*
  private static boolean union_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_items(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "union_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_USE include-name use-items?
  public static boolean use(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use")) return false;
    if (!nextTokenIs(b, KW_USE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USE, null);
    r = consumeToken(b, KW_USE);
    p = r; // pin = 1
    r = r && report_error_(b, include_name(b, l + 1));
    r = p && use_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // use-items?
  private static boolean use_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_2")) return false;
    use_items(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier (KW_AS alias-name)? {
  // }
  public static boolean use_alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_alias")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && use_alias_1(b, l + 1);
    r = r && use_alias_2(b, l + 1);
    exit_section_(b, m, USE_ALIAS, r);
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
    r = consumeTokens(b, 0, KW_AS, ALIAS_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean use_alias_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // DOT BRACE_L (use-alias (COMMA use-alias)* COMMA?)? BRACE_R
  public static boolean use_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USE_ITEMS, null);
    r = consumeTokens(b, 1, DOT, BRACE_L);
    p = r; // pin = 1
    r = r && report_error_(b, use_items_2(b, l + 1));
    r = p && consumeToken(b, BRACE_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (use-alias (COMMA use-alias)* COMMA?)?
  private static boolean use_items_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_2")) return false;
    use_items_2_0(b, l + 1);
    return true;
  }

  // use-alias (COMMA use-alias)* COMMA?
  private static boolean use_items_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = use_alias(b, l + 1);
    r = r && use_items_2_0_1(b, l + 1);
    r = r && use_items_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA use-alias)*
  private static boolean use_items_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!use_items_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "use_items_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA use-alias
  private static boolean use_items_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && use_alias(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean use_items_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_items_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // identifier (PARENTHESIS_L type-hint PARENTHESIS_R)? {
  // //    mixin = "com.github.bytecodealliance.language.mixin.MixinVariantItem"
  // }
  public static boolean variant_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_item")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && variant_item_1(b, l + 1);
    r = r && variant_item_2(b, l + 1);
    exit_section_(b, m, VARIANT_ITEM, r);
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

  // {
  // //    mixin = "com.github.bytecodealliance.language.mixin.MixinVariantItem"
  // }
  private static boolean variant_item_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // statements*
  static boolean witx(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "witx")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "witx", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_WORLD identifier BRACE_L world-element* BRACE_R
  public static boolean world(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "world")) return false;
    if (!nextTokenIs(b, KW_WORLD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WORLD, null);
    r = consumeToken(b, KW_WORLD);
    p = r; // pin = 1
    r = r && report_error_(b, identifier(b, l + 1));
    r = p && report_error_(b, consumeToken(b, BRACE_L)) && r;
    r = p && report_error_(b, world_3(b, l + 1)) && r;
    r = p && consumeToken(b, BRACE_R) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // world-element*
  private static boolean world_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "world_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!world_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "world_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // include
  //   | import
  //   | export
  //   | use
  static boolean world_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "world_element")) return false;
    boolean r;
    r = include(b, l + 1);
    if (!r) r = import_$(b, l + 1);
    if (!r) r = export(b, l + 1);
    if (!r) r = use(b, l + 1);
    return r;
  }

}
