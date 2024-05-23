// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.github.moonbit.psi_node.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface MbtiTypes {

    IElementType DECLARE_ALIAS = new MoonElementType("DECLARE_ALIAS");
    IElementType DECLARE_ENUM = new MoonElementType("DECLARE_ENUM");
    IElementType DECLARE_FIELD = new MoonElementType("DECLARE_FIELD");
    IElementType DECLARE_FUNCTION = new MoonElementType("DECLARE_FUNCTION");
    IElementType DECLARE_GENERIC = new MoonElementType("DECLARE_GENERIC");
    IElementType DECLARE_IMPL = new MoonElementType("DECLARE_IMPL");
    IElementType DECLARE_METHOD = new MoonElementType("DECLARE_METHOD");
    IElementType DECLARE_PACKAGE = new MoonElementType("DECLARE_PACKAGE");
    IElementType DECLARE_PARAMETER = new MoonElementType("DECLARE_PARAMETER");
    IElementType DECLARE_STRUCT = new MoonElementType("DECLARE_STRUCT");
    IElementType DECLARE_TRAIT = new MoonElementType("DECLARE_TRAIT");
    IElementType DECLARE_TYPE = new MoonElementType("DECLARE_TYPE");
    IElementType DECLARE_VARIANT = new MoonElementType("DECLARE_VARIANT");
    IElementType ENUM_BODY = new MoonElementType("ENUM_BODY");
    IElementType GENERIC_ITEM = new MoonElementType("GENERIC_ITEM");
    IElementType IDENTIFIER = new MoonElementType("IDENTIFIER");
    IElementType IMPL_BODY = new MoonElementType("IMPL_BODY");
    IElementType MODIFIER = new MoonElementType("MODIFIER");
    IElementType PACKAGE_PATH = new MoonElementType("PACKAGE_PATH");
    IElementType STRUCT_BODY = new MoonElementType("STRUCT_BODY");
    IElementType TRAIT_BODY = new MoonElementType("TRAIT_BODY");
    IElementType TYPE_EXPRESSION = new MoonElementType("TYPE_EXPRESSION");
    IElementType TYPE_EXPRESSION_ATOM = new MoonElementType("TYPE_EXPRESSION_ATOM");
    IElementType TYPE_EXPRESSION_ITEM = new MoonElementType("TYPE_EXPRESSION_ITEM");
    IElementType TYPE_INFIX = new MoonElementType("TYPE_INFIX");
    IElementType TYPE_PREFIX = new MoonElementType("TYPE_PREFIX");
    IElementType TYPE_RETURN = new MoonElementType("TYPE_RETURN");
    IElementType TYPE_SUFFIX = new MoonElementType("TYPE_SUFFIX");
    IElementType UNUSED = new MoonElementType("UNUSED");

    IElementType ACCENT = new MoonTokenType("ACCENT");
    IElementType AT = new MoonTokenType("AT");
    IElementType BRACE_L = new MoonTokenType("{");
    IElementType BRACE_R = new MoonTokenType("}");
    IElementType BRACKET_L = new MoonTokenType("[");
    IElementType BRACKET_R = new MoonTokenType("]");
    IElementType COLON = new MoonTokenType("COLON");
    IElementType COMMA = new MoonTokenType("COMMA");
    IElementType COMMENT_BLOCK = new MoonTokenType("Comment Block");
    IElementType COMMENT_DOCUMENT = new MoonTokenType("Comment Document");
    IElementType COMMENT_LINE = new MoonTokenType("Comment Line");
    IElementType DOLLAR = new MoonTokenType("DOLLAR");
    IElementType DOT = new MoonTokenType("DOT");
    IElementType ESCAPED = new MoonTokenType("ESCAPED");
    IElementType HYPHEN = new MoonTokenType("HYPHEN");
    IElementType INTEGER = new MoonTokenType("INTEGER");
    IElementType KW_ALIAS = new MoonTokenType("KW_ALIAS");
    IElementType KW_ENUM = new MoonTokenType("KW_ENUM");
    IElementType KW_FN = new MoonTokenType("KW_FN");
    IElementType KW_IMPL = new MoonTokenType("KW_IMPL");
    IElementType KW_LET = new MoonTokenType("KW_LET");
    IElementType KW_MUTABLE = new MoonTokenType("KW_MUTABLE");
    IElementType KW_PACKAGE = new MoonTokenType("KW_PACKAGE");
    IElementType KW_PRIVATE = new MoonTokenType("KW_PRIVATE");
    IElementType KW_PUBLIC = new MoonTokenType("KW_PUBLIC");
    IElementType KW_STRUCT = new MoonTokenType("KW_STRUCT");
    IElementType KW_TEST = new MoonTokenType("KW_TEST");
    IElementType KW_TRAIT = new MoonTokenType("KW_TRAIT");
    IElementType KW_TYPE = new MoonTokenType("KW_TYPE");
    IElementType KW_WHILE = new MoonTokenType("KW_WHILE");
    IElementType OP_ADD = new MoonTokenType("OP_ADD");
    IElementType OP_ADD_ASSIGN = new MoonTokenType("OP_ADD_ASSIGN");
    IElementType OP_AND = new MoonTokenType("OP_AND");
    IElementType OP_ASSIGN = new MoonTokenType("OP_ASSIGN");
    IElementType OP_DIV = new MoonTokenType("OP_DIV");
    IElementType OP_GEQ = new MoonTokenType("OP_GEQ");
    IElementType OP_GT = new MoonTokenType("OP_GT");
    IElementType OP_LEQ = new MoonTokenType("OP_LEQ");
    IElementType OP_LT = new MoonTokenType("OP_LT");
    IElementType OP_MOD = new MoonTokenType("OP_MOD");
    IElementType OP_MUL = new MoonTokenType("OP_MUL");
    IElementType OP_OR = new MoonTokenType("OP_OR");
    IElementType OP_REF = new MoonTokenType("OP_REF");
    IElementType OP_THEN = new MoonTokenType("OP_THEN");
    IElementType OP_THROW = new MoonTokenType("OP_THROW");
    IElementType OP_TO = new MoonTokenType("OP_TO");
    IElementType PARENTHESIS_L = new MoonTokenType("(");
    IElementType PARENTHESIS_R = new MoonTokenType(")");
    IElementType PLACE_HOLDER = new MoonTokenType("_");
    IElementType SEMICOLON = new MoonTokenType("SEMICOLON");
    IElementType SYMBOL = new MoonTokenType("SYMBOL");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == DECLARE_ALIAS) {
                return new MbtiDeclareAliasNode(node);
            } else if (type == DECLARE_ENUM) {
                return new MbtiDeclareEnumNode(node);
            } else if (type == DECLARE_FIELD) {
                return new MbtiDeclareFieldNode(node);
            } else if (type == DECLARE_FUNCTION) {
                return new MbtiDeclareFunctionNode(node);
            } else if (type == DECLARE_GENERIC) {
                return new MbtiDeclareGenericNode(node);
            } else if (type == DECLARE_IMPL) {
                return new MbtiDeclareImplNode(node);
            } else if (type == DECLARE_METHOD) {
                return new MbtiDeclareMethodNode(node);
            } else if (type == DECLARE_PACKAGE) {
                return new MbtiDeclarePackageNode(node);
            } else if (type == DECLARE_PARAMETER) {
                return new MbtiDeclareParameterNode(node);
            } else if (type == DECLARE_STRUCT) {
                return new MbtiDeclareStructNode(node);
            } else if (type == DECLARE_TRAIT) {
                return new MbtiDeclareTraitNode(node);
            } else if (type == DECLARE_TYPE) {
                return new MbtiDeclareTypeNode(node);
            } else if (type == DECLARE_VARIANT) {
                return new MbtiDeclareVariantNode(node);
            } else if (type == ENUM_BODY) {
                return new MbtiEnumBodyNode(node);
            } else if (type == GENERIC_ITEM) {
                return new MbtiGenericItemNode(node);
            } else if (type == IDENTIFIER) {
                return new MbtiIdentifierNode(node);
            } else if (type == IMPL_BODY) {
                return new MbtiImplBodyNode(node);
            } else if (type == MODIFIER) {
                return new MbtiModifierNode(node);
            } else if (type == PACKAGE_PATH) {
                return new MbtiPackagePathNode(node);
            } else if (type == STRUCT_BODY) {
                return new MbtiStructBodyNode(node);
            } else if (type == TRAIT_BODY) {
                return new MbtiTraitBodyNode(node);
            } else if (type == TYPE_EXPRESSION) {
                return new MbtiTypeExpressionNode(node);
            } else if (type == TYPE_EXPRESSION_ATOM) {
                return new MbtiTypeExpressionAtomNode(node);
            } else if (type == TYPE_EXPRESSION_ITEM) {
                return new MbtiTypeExpressionItemNode(node);
            } else if (type == TYPE_INFIX) {
                return new MbtiTypeInfixNode(node);
            } else if (type == TYPE_PREFIX) {
                return new MbtiTypePrefixNode(node);
            } else if (type == TYPE_RETURN) {
                return new MbtiTypeReturnNode(node);
            } else if (type == TYPE_SUFFIX) {
                return new MbtiTypeSuffixNode(node);
            } else if (type == UNUSED) {
                return new MbtiUnusedNode(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
