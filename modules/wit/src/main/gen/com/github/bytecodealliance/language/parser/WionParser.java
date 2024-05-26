// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.bytecodealliance.language.psi.WionTypes.*;
import static com.github.bytecodealliance.language.psi.ParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WionParser implements PsiParser, LightPsiParser {

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
    return wion(b, l + 1);
  }

  /* ********************************************************** */
  // dict-key EQUAL wion-value | COMMA
  public static boolean dict_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICT_ITEM, "<dict item>");
    r = dict_item_0(b, l + 1);
    if (!r) r = consumeToken(b, COMMA);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // dict-key EQUAL wion-value
  private static boolean dict_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dict_key(b, l + 1);
    r = r && consumeToken(b, EQUAL);
    r = r && wion_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier | text-literal
  public static boolean dict_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_key")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICT_KEY, "<dict key>");
    r = identifier(b, l + 1);
    if (!r) r = text_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier? BRACE_L dict-item* BRACE_R {
  // //    mixin = "com.github.bytecodealliance.language.mixin.MixinInclude"
  // }
  public static boolean dict_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal")) return false;
    if (!nextTokenIs(b, "<dict literal>", BRACE_L, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICT_LITERAL, "<dict literal>");
    r = dict_literal_0(b, l + 1);
    r = r && consumeToken(b, BRACE_L);
    r = r && dict_literal_2(b, l + 1);
    r = r && consumeToken(b, BRACE_R);
    r = r && dict_literal_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // identifier?
  private static boolean dict_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_0")) return false;
    identifier(b, l + 1);
    return true;
  }

  // dict-item*
  private static boolean dict_literal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dict_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dict_literal_2", c)) break;
    }
    return true;
  }

  // {
  // //    mixin = "com.github.bytecodealliance.language.mixin.MixinInclude"
  // }
  private static boolean dict_literal_4(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // identifier | text-literal | COMMA {
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinInterface"
  // }
  public static boolean flag_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLAG_ITEM, "<flag item>");
    r = identifier(b, l + 1);
    if (!r) r = text_literal(b, l + 1);
    if (!r) r = flag_item_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA {
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinInterface"
  // }
  private static boolean flag_item_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_item_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && flag_item_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinInterface"
  // }
  private static boolean flag_item_2_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // flag-sign BRACKET_L flag-item* BRACKET_R {
  // }
  public static boolean flag_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_literal")) return false;
    if (!nextTokenIs(b, "<flag literal>", ADD, SUB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLAG_LITERAL, "<flag literal>");
    r = flag_sign(b, l + 1);
    r = r && consumeToken(b, BRACKET_L);
    r = r && flag_literal_2(b, l + 1);
    r = r && consumeToken(b, BRACKET_R);
    r = r && flag_literal_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // flag-item*
  private static boolean flag_literal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_literal_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flag_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flag_literal_2", c)) break;
    }
    return true;
  }

  // {
  // }
  private static boolean flag_literal_4(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ADD | SUB
  public static boolean flag_sign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flag_sign")) return false;
    if (!nextTokenIs(b, "<flag sign>", ADD, SUB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLAG_SIGN, "<flag sign>");
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    exit_section_(b, l, m, r, false, null);
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
  // wion-value | COMMA {
  // //	extends = interface
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinInterface"
  // }
  public static boolean list_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_ITEM, "<list item>");
    r = wion_value(b, l + 1);
    if (!r) r = list_item_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA {
  // //	extends = interface
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinInterface"
  // }
  private static boolean list_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_item_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && list_item_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // //	extends = interface
  // //	mixin = "com.github.bytecodealliance.language.mixin.MixinInterface"
  // }
  private static boolean list_item_1_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // BRACKET_L list-item* BRACKET_R {
  // //    mixin = "com.github.bytecodealliance.language.mixin.MixinInterface"
  // }
  public static boolean list_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_literal")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && list_literal_1(b, l + 1);
    r = r && consumeToken(b, BRACKET_R);
    r = r && list_literal_3(b, l + 1);
    exit_section_(b, m, LIST_LITERAL, r);
    return r;
  }

  // list-item*
  private static boolean list_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_literal_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_literal_1", c)) break;
    }
    return true;
  }

  // {
  // //    mixin = "com.github.bytecodealliance.language.mixin.MixinInterface"
  // }
  private static boolean list_literal_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // BIN | OCT | DEC | HEX
  public static boolean number_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = consumeToken(b, BIN);
    if (!r) r = consumeToken(b, OCT);
    if (!r) r = consumeToken(b, DEC);
    if (!r) r = consumeToken(b, HEX);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_SOME PARENTHESIS_L wion-value? PARENTHESIS_R
  // 	| KW_NONE
  public static boolean option_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_literal")) return false;
    if (!nextTokenIs(b, "<option literal>", KW_NONE, KW_SOME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTION_LITERAL, "<option literal>");
    r = option_literal_0(b, l + 1);
    if (!r) r = consumeToken(b, KW_NONE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_SOME PARENTHESIS_L wion-value? PARENTHESIS_R
  private static boolean option_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_literal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SOME, PARENTHESIS_L);
    r = r && option_literal_0_2(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // wion-value?
  private static boolean option_literal_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_literal_0_2")) return false;
    wion_value(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_FINE PARENTHESIS_L wion-value? PARENTHESIS_R
  //   | KW_FAIL PARENTHESIS_L wion-value? PARENTHESIS_R
  public static boolean result_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "result_literal")) return false;
    if (!nextTokenIs(b, "<result literal>", KW_FAIL, KW_FINE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESULT_LITERAL, "<result literal>");
    r = result_literal_0(b, l + 1);
    if (!r) r = result_literal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_FINE PARENTHESIS_L wion-value? PARENTHESIS_R
  private static boolean result_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "result_literal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FINE, PARENTHESIS_L);
    r = r && result_literal_0_2(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // wion-value?
  private static boolean result_literal_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "result_literal_0_2")) return false;
    wion_value(b, l + 1);
    return true;
  }

  // KW_FAIL PARENTHESIS_L wion-value? PARENTHESIS_R
  private static boolean result_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "result_literal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FAIL, PARENTHESIS_L);
    r = r && result_literal_1_2(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // wion-value?
  private static boolean result_literal_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "result_literal_1_2")) return false;
    wion_value(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STRING_S1 | STRING_S2
  public static boolean text_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_literal")) return false;
    if (!nextTokenIs(b, "<text literal>", STRING_S1, STRING_S2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_LITERAL, "<text literal>");
    r = consumeToken(b, STRING_S1);
    if (!r) r = consumeToken(b, STRING_S2);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COMMENT_LINE
  public static boolean useless(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "useless")) return false;
    if (!nextTokenIs(b, COMMENT_LINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT_LINE);
    exit_section_(b, m, USELESS, r);
    return r;
  }

  /* ********************************************************** */
  // variant-name PARENTHESIS_L wion-value? PARENTHESIS_R {
  // //    mixin = "com.github.bytecodealliance.language.mixin.MixinWorld"
  // }
  public static boolean variant_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIANT_LITERAL, "<variant literal>");
    r = variant_name(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_L);
    r = r && variant_literal_2(b, l + 1);
    r = r && consumeToken(b, PARENTHESIS_R);
    r = r && variant_literal_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // wion-value?
  private static boolean variant_literal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_literal_2")) return false;
    wion_value(b, l + 1);
    return true;
  }

  // {
  // //    mixin = "com.github.bytecodealliance.language.mixin.MixinWorld"
  // }
  private static boolean variant_literal_4(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // KW_NONE | KW_TRUE | KW_FALSE | identifier
  public static boolean variant_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variant_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIANT_NAME, "<variant name>");
    r = consumeToken(b, KW_NONE);
    if (!r) r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    if (!r) r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // wion-value
  static boolean wion(PsiBuilder b, int l) {
    return wion_value(b, l + 1);
  }

  /* ********************************************************** */
  // text-literal
  // 	| number-literal
  // 	| dict-literal
  // 	| list-literal
  // 	| flag-literal
  // 	| variant-literal
  // 	| result-literal
  // 	| option-literal
  // 	| KW_TRUE
  // 	| KW_FALSE
  public static boolean wion_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wion_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WION_VALUE, "<wion value>");
    r = text_literal(b, l + 1);
    if (!r) r = number_literal(b, l + 1);
    if (!r) r = dict_literal(b, l + 1);
    if (!r) r = list_literal(b, l + 1);
    if (!r) r = flag_literal(b, l + 1);
    if (!r) r = variant_literal(b, l + 1);
    if (!r) r = result_literal(b, l + 1);
    if (!r) r = option_literal(b, l + 1);
    if (!r) r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
