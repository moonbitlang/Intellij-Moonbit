// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.bytecodealliance.language.psi_node.*;

public interface WionTypes {

  IElementType DICT_ITEM = new WionElementType("DICT_ITEM");
  IElementType DICT_KEY = new WionElementType("DICT_KEY");
  IElementType DICT_LITERAL = new WionElementType("DICT_LITERAL");
  IElementType FLAG_ITEM = new WionElementType("FLAG_ITEM");
  IElementType FLAG_LITERAL = new WionElementType("FLAG_LITERAL");
  IElementType FLAG_SIGN = new WionElementType("FLAG_SIGN");
  IElementType IDENTIFIER = new WionElementType("IDENTIFIER");
  IElementType LIST_ITEM = new WionElementType("LIST_ITEM");
  IElementType LIST_LITERAL = new WionElementType("LIST_LITERAL");
  IElementType NUMBER_LITERAL = new WionElementType("NUMBER_LITERAL");
  IElementType OPTION_LITERAL = new WionElementType("OPTION_LITERAL");
  IElementType RESULT_LITERAL = new WionElementType("RESULT_LITERAL");
  IElementType TEXT_LITERAL = new WionElementType("TEXT_LITERAL");
  IElementType USELESS = new WionElementType("USELESS");
  IElementType VARIANT_LITERAL = new WionElementType("VARIANT_LITERAL");
  IElementType VARIANT_NAME = new WionElementType("VARIANT_NAME");
  IElementType WION_VALUE = new WionElementType("WION_VALUE");

  IElementType ADD = new WionTokenType("ADD");
  IElementType BIN = new WionTokenType("BIN");
  IElementType BRACE_L = new WionTokenType("{");
  IElementType BRACE_R = new WionTokenType("}");
  IElementType BRACKET_L = new WionTokenType("[");
  IElementType BRACKET_R = new WionTokenType("]");
  IElementType COMMA = new WionTokenType(",");
  IElementType COMMENT_LINE = new WionTokenType("COMMENT_LINE");
  IElementType DEC = new WionTokenType("DEC");
  IElementType EQUAL = new WionTokenType("=");
  IElementType HEX = new WionTokenType("HEX");
  IElementType KW_FAIL = new WionTokenType("KW_FAIL");
  IElementType KW_FALSE = new WionTokenType("KW_FALSE");
  IElementType KW_FINE = new WionTokenType("KW_FINE");
  IElementType KW_NONE = new WionTokenType("KW_NONE");
  IElementType KW_SOME = new WionTokenType("KW_SOME");
  IElementType KW_TRUE = new WionTokenType("KW_TRUE");
  IElementType OCT = new WionTokenType("OCT");
  IElementType PARENTHESIS_L = new WionTokenType("(");
  IElementType PARENTHESIS_R = new WionTokenType(")");
  IElementType STRING_CHAR = new WionTokenType("String Character");
  IElementType STRING_ESCAPE = new WionTokenType("String Escaped");
  IElementType STRING_QUOTE = new WionTokenType("String Quote");
  IElementType STRING_S1 = new WionTokenType("STRING_S1");
  IElementType STRING_S2 = new WionTokenType("STRING_S2");
  IElementType SUB = new WionTokenType("SUB");
  IElementType SYMBOL = new WionTokenType("SYMBOL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DICT_ITEM) {
        return new WionDictItemNode(node);
      }
      else if (type == DICT_KEY) {
        return new WionDictKeyNode(node);
      }
      else if (type == DICT_LITERAL) {
        return new WionDictLiteralNode(node);
      }
      else if (type == FLAG_ITEM) {
        return new WionFlagItemNode(node);
      }
      else if (type == FLAG_LITERAL) {
        return new WionFlagLiteralNode(node);
      }
      else if (type == FLAG_SIGN) {
        return new WionFlagSignNode(node);
      }
      else if (type == IDENTIFIER) {
        return new WionIdentifierNode(node);
      }
      else if (type == LIST_ITEM) {
        return new WionListItemNode(node);
      }
      else if (type == LIST_LITERAL) {
        return new WionListLiteralNode(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new WionNumberLiteralNode(node);
      }
      else if (type == OPTION_LITERAL) {
        return new WionOptionLiteralNode(node);
      }
      else if (type == RESULT_LITERAL) {
        return new WionResultLiteralNode(node);
      }
      else if (type == TEXT_LITERAL) {
        return new WionTextLiteralNode(node);
      }
      else if (type == USELESS) {
        return new WionUselessNode(node);
      }
      else if (type == VARIANT_LITERAL) {
        return new WionVariantLiteralNode(node);
      }
      else if (type == VARIANT_NAME) {
        return new WionVariantNameNode(node);
      }
      else if (type == WION_VALUE) {
        return new WionWionValueNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
