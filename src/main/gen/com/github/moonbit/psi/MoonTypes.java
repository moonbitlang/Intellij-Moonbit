// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.moonbit.psi_node.*;

public interface MoonTypes {

  IElementType APPEND_DERIVE = new MoonElementType("APPEND_DERIVE");
    IElementType CALL_DICT = new MoonElementType("CALL_DICT");
    IElementType CALL_FIELD = new MoonElementType("CALL_FIELD");
    IElementType CALL_FUNCTION = new MoonElementType("CALL_FUNCTION");
    IElementType CALL_INDEX = new MoonElementType("CALL_INDEX");
    IElementType CALL_METHOD = new MoonElementType("CALL_METHOD");
    IElementType CALL_SLICE = new MoonElementType("CALL_SLICE");
    IElementType CALL_STATIC = new MoonElementType("CALL_STATIC");
    IElementType CHAR_LITERAL = new MoonElementType("CHAR_LITERAL");
    IElementType CHAR_SYNTAX = new MoonElementType("CHAR_SYNTAX");
    IElementType CLOSURE_PARAMETERS = new MoonElementType("CLOSURE_PARAMETERS");
    IElementType CONTROL_STATEMENT = new MoonElementType("CONTROL_STATEMENT");
    IElementType DECLARE_CLOSURE = new MoonElementType("DECLARE_CLOSURE");
    IElementType DECLARE_ENUM = new MoonElementType("DECLARE_ENUM");
    IElementType DECLARE_FIELD = new MoonElementType("DECLARE_FIELD");
    IElementType DECLARE_FUNCTION = new MoonElementType("DECLARE_FUNCTION");
    IElementType DECLARE_GENERIC = new MoonElementType("DECLARE_GENERIC");
    IElementType DECLARE_IMPL = new MoonElementType("DECLARE_IMPL");
    IElementType DECLARE_METHOD = new MoonElementType("DECLARE_METHOD");
    IElementType DECLARE_PARAMETERS = new MoonElementType("DECLARE_PARAMETERS");
    IElementType DECLARE_SIGNATURE = new MoonElementType("DECLARE_SIGNATURE");
    IElementType DECLARE_STRUCT = new MoonElementType("DECLARE_STRUCT");
    IElementType DECLARE_TEST = new MoonElementType("DECLARE_TEST");
    IElementType DECLARE_TRAIT = new MoonElementType("DECLARE_TRAIT");
    IElementType DECLARE_VARIANT = new MoonElementType("DECLARE_VARIANT");
    IElementType DEFINE_TYPE = new MoonElementType("DEFINE_TYPE");
    IElementType DEFINE_TYPE_ALIAS = new MoonElementType("DEFINE_TYPE_ALIAS");
    IElementType DICT_LITERAL = new MoonElementType("DICT_LITERAL");
    IElementType DICT_TERM = new MoonElementType("DICT_TERM");
    IElementType ELSE_IF = new MoonElementType("ELSE_IF");
    IElementType ELSE_STATEMENT = new MoonElementType("ELSE_STATEMENT");
    IElementType ENUM_BODY = new MoonElementType("ENUM_BODY");
    IElementType FLAGS = new MoonElementType("FLAGS");
    IElementType FOR_CONDITION = new MoonElementType("FOR_CONDITION");
    IElementType FOR_INCREMENT = new MoonElementType("FOR_INCREMENT");
    IElementType FOR_IN_STATEMENT = new MoonElementType("FOR_IN_STATEMENT");
    IElementType FOR_STARTUP = new MoonElementType("FOR_STARTUP");
    IElementType FOR_STATEMENT = new MoonElementType("FOR_STATEMENT");
    IElementType FUNCTION_BODY = new MoonElementType("FUNCTION_BODY");
    IElementType FUNCTION_EXTERN = new MoonElementType("FUNCTION_EXTERN");
    IElementType FUNCTION_INLINE = new MoonElementType("FUNCTION_INLINE");
    IElementType FUNCTION_NAME = new MoonElementType("FUNCTION_NAME");
    IElementType GENERIC_CALL = new MoonElementType("GENERIC_CALL");
    IElementType GENERIC_ITEM = new MoonElementType("GENERIC_ITEM");
    IElementType GUARD_LET = new MoonElementType("GUARD_LET");
    IElementType GUARD_NORMAL = new MoonElementType("GUARD_NORMAL");
    IElementType GUARD_STATEMENT = new MoonElementType("GUARD_STATEMENT");
    IElementType IDENTIFIER = new MoonElementType("IDENTIFIER");
    IElementType IDENTIFIER_FREE = new MoonElementType("IDENTIFIER_FREE");
    IElementType IF_STATEMENT = new MoonElementType("IF_STATEMENT");
    IElementType IMPL_FOR = new MoonElementType("IMPL_FOR");
    IElementType IMPL_WITH = new MoonElementType("IMPL_WITH");
    IElementType LET_STATEMENT = new MoonElementType("LET_STATEMENT");
    IElementType LIST_LITERAL = new MoonElementType("LIST_LITERAL");
    IElementType LIST_TERM = new MoonElementType("LIST_TERM");
    IElementType MATCH_BODY = new MoonElementType("MATCH_BODY");
    IElementType MATCH_STATEMENT = new MoonElementType("MATCH_STATEMENT");
    IElementType MATCH_VARIANT = new MoonElementType("MATCH_VARIANT");
    IElementType MODIFIER = new MoonElementType("MODIFIER");
    IElementType MODULE_NAME = new MoonElementType("MODULE_NAME");
    IElementType NAMEPATH = new MoonElementType("NAMEPATH");
    IElementType NUMBER_LITERAL = new MoonElementType("NUMBER_LITERAL");
    IElementType PACKAGE = new MoonElementType("PACKAGE");
    IElementType PACKAGE_NAME = new MoonElementType("PACKAGE_NAME");
    IElementType PACKAGE_VERSION = new MoonElementType("PACKAGE_VERSION");
    IElementType PARAMETER = new MoonElementType("PARAMETER");
    IElementType RETURN_TYPE = new MoonElementType("RETURN_TYPE");
    IElementType SEMANTIC_NUMBER = new MoonElementType("SEMANTIC_NUMBER");
    IElementType SIGNATURE_ARGUMENTS = new MoonElementType("SIGNATURE_ARGUMENTS");
    IElementType SIGNATURE_PARAMETER = new MoonElementType("SIGNATURE_PARAMETER");
    IElementType STRING_LINES = new MoonElementType("STRING_LINES");
    IElementType STRING_LITERAL = new MoonElementType("STRING_LITERAL");
    IElementType STRING_SYNTAX = new MoonElementType("STRING_SYNTAX");
    IElementType STRUCT_BODY = new MoonElementType("STRUCT_BODY");
    IElementType TERM_EXPRESSION = new MoonElementType("TERM_EXPRESSION");
    IElementType TERM_EXPRESSION_ATOM = new MoonElementType("TERM_EXPRESSION_ATOM");
    IElementType TERM_EXPRESSION_ITEM = new MoonElementType("TERM_EXPRESSION_ITEM");
    IElementType TERM_INFIX = new MoonElementType("TERM_INFIX");
    IElementType TERM_PREFIX = new MoonElementType("TERM_PREFIX");
    IElementType TERM_SUFFIX = new MoonElementType("TERM_SUFFIX");
    IElementType THEN_STATEMENT = new MoonElementType("THEN_STATEMENT");
    IElementType THROWABLE = new MoonElementType("THROWABLE");
    IElementType TRAIT_BODY = new MoonElementType("TRAIT_BODY");
    IElementType TUPLE_LITERAL = new MoonElementType("TUPLE_LITERAL");
    IElementType TUPLE_TERM = new MoonElementType("TUPLE_TERM");
    IElementType TYPE_EXPRESSION = new MoonElementType("TYPE_EXPRESSION");
    IElementType TYPE_EXPRESSION_ATOM = new MoonElementType("TYPE_EXPRESSION_ATOM");
    IElementType TYPE_EXPRESSION_ITEM = new MoonElementType("TYPE_EXPRESSION_ITEM");
    IElementType TYPE_HINT = new MoonElementType("TYPE_HINT");
    IElementType TYPE_INFIX = new MoonElementType("TYPE_INFIX");
    IElementType TYPE_PREFIX = new MoonElementType("TYPE_PREFIX");
    IElementType TYPE_SUFFIX = new MoonElementType("TYPE_SUFFIX");
    IElementType VARIANT = new MoonElementType("VARIANT");
    IElementType VARIANT_ITEM = new MoonElementType("VARIANT_ITEM");
    IElementType WHILE_STATEMENT = new MoonElementType("WHILE_STATEMENT");

    IElementType AT = new MoonTokenType("AT");
    IElementType BRACE_L = new MoonTokenType("{");
    IElementType BRACE_R = new MoonTokenType("}");
    IElementType BRACKET_L = new MoonTokenType("[");
    IElementType BRACKET_R = new MoonTokenType("]");
    IElementType BYTES_BIN = new MoonTokenType("BYTES_BIN");
    IElementType BYTES_HEX = new MoonTokenType("BYTES_HEX");
    IElementType BYTES_OCT = new MoonTokenType("BYTES_OCT");
    IElementType COLON = new MoonTokenType("COLON");
    IElementType COMMA = new MoonTokenType("COMMA");
    IElementType COMMENT_BLOCK = new MoonTokenType("Comment Block");
    IElementType COMMENT_DOCUMENT = new MoonTokenType("Comment Document");
    IElementType COMMENT_LINE = new MoonTokenType("Comment Line");
    IElementType CONSTRUCTOR = new MoonTokenType("constructor");
    IElementType DOLLAR = new MoonTokenType("DOLLAR");
    IElementType DOT = new MoonTokenType("DOT");
    IElementType DOUBLE_QUOTE_L = new MoonTokenType("DOUBLE_QUOTE_L");
    IElementType DOUBLE_QUOTE_R = new MoonTokenType("DOUBLE_QUOTE_R");
    IElementType ESCAPED = new MoonTokenType("ESCAPED");
    IElementType HYPHEN = new MoonTokenType("HYPHEN");
    IElementType INTEGER = new MoonTokenType("INTEGER");
    IElementType KW_ALL = new MoonTokenType("KW_ALL");
    IElementType KW_BREAK = new MoonTokenType("KW_BREAK");
    IElementType KW_CONTINUE = new MoonTokenType("KW_CONTINUE");
    IElementType KW_DERIVE = new MoonTokenType("KW_DERIVE");
    IElementType KW_ELSE = new MoonTokenType("KW_ELSE");
    IElementType KW_ENUM = new MoonTokenType("KW_ENUM");
    IElementType KW_EXTERN = new MoonTokenType("KW_EXTERN");
    IElementType KW_FLAGS = new MoonTokenType("KW_FLAGS");
    IElementType KW_FN = new MoonTokenType("KW_FN");
    IElementType KW_FOR = new MoonTokenType("KW_FOR");
    IElementType KW_GUARD = new MoonTokenType("KW_GUARD");
    IElementType KW_IF = new MoonTokenType("KW_IF");
    IElementType KW_IMPLEMENT = new MoonTokenType("KW_IMPLEMENT");
    IElementType KW_IN = new MoonTokenType("KW_IN");
    IElementType KW_LET = new MoonTokenType("KW_LET");
    IElementType KW_MATCH = new MoonTokenType("KW_MATCH");
    IElementType KW_MUTABLE = new MoonTokenType("KW_MUTABLE");
    IElementType KW_OPEN = new MoonTokenType("KW_OPEN");
    IElementType KW_PACKAGE = new MoonTokenType("KW_PACKAGE");
    IElementType KW_PRIVATE = new MoonTokenType("KW_PRIVATE");
    IElementType KW_PUBLIC = new MoonTokenType("KW_PUBLIC");
    IElementType KW_RAISE = new MoonTokenType("KW_RAISE");
    IElementType KW_RETURN = new MoonTokenType("KW_RETURN");
    IElementType KW_STRUCT = new MoonTokenType("KW_STRUCT");
    IElementType KW_TEST = new MoonTokenType("KW_TEST");
    IElementType KW_TRAIT = new MoonTokenType("KW_TRAIT");
    IElementType KW_TYPE = new MoonTokenType("KW_TYPE");
    IElementType KW_TYPE_ALIAS = new MoonTokenType("KW_TYPE_ALIAS");
    IElementType KW_VARIANT = new MoonTokenType("KW_VARIANT");
    IElementType KW_WHILE = new MoonTokenType("KW_WHILE");
    IElementType KW_WITH = new MoonTokenType("KW_WITH");
    IElementType NAME_JOIN = new MoonTokenType("NAME_JOIN");
    IElementType OP_ADD = new MoonTokenType("OP_ADD");
    IElementType OP_ADD_ASSIGN = new MoonTokenType("OP_ADD_ASSIGN");
    IElementType OP_AND = new MoonTokenType("OP_AND");
    IElementType OP_ASSIGN = new MoonTokenType("OP_ASSIGN");
    IElementType OP_BIT_AND = new MoonTokenType("OP_BIT_AND");
    IElementType OP_BIT_OR = new MoonTokenType("OP_BIT_OR");
    IElementType OP_DIV = new MoonTokenType("OP_DIV");
    IElementType OP_DIV_ASSIGN = new MoonTokenType("OP_DIV_ASSIGN");
    IElementType OP_EQ = new MoonTokenType("OP_EQ");
    IElementType OP_ERROR = new MoonTokenType("OP_ERROR");
    IElementType OP_GEQ = new MoonTokenType("OP_GEQ");
    IElementType OP_GG = new MoonTokenType("OP_GG");
    IElementType OP_GT = new MoonTokenType("OP_GT");
    IElementType OP_LEQ = new MoonTokenType("OP_LEQ");
    IElementType OP_LL = new MoonTokenType("OP_LL");
    IElementType OP_LT = new MoonTokenType("OP_LT");
    IElementType OP_MOD = new MoonTokenType("OP_MOD");
    IElementType OP_MUL = new MoonTokenType("OP_MUL");
    IElementType OP_MUL_ASSIGN = new MoonTokenType("OP_MUL_ASSIGN");
    IElementType OP_NE = new MoonTokenType("OP_NE");
    IElementType OP_OR = new MoonTokenType("OP_OR");
    IElementType OP_PATTERN_TO = new MoonTokenType("OP_PATTERN_TO");
    IElementType OP_RANGE_TO = new MoonTokenType("OP_RANGE_TO");
    IElementType OP_REF = new MoonTokenType("OP_REF");
    IElementType OP_SPREAD = new MoonTokenType("OP_SPREAD");
    IElementType OP_SUB = new MoonTokenType("OP_SUB");
    IElementType OP_SUB_ASSIGN = new MoonTokenType("OP_SUB_ASSIGN");
    IElementType OP_THEN = new MoonTokenType("OP_THEN");
    IElementType OP_THROW = new MoonTokenType("OP_THROW");
    IElementType OP_TO = new MoonTokenType("OP_TO");
    IElementType OP_XOR = new MoonTokenType("OP_XOR");
    IElementType PARENTHESIS_L = new MoonTokenType("(");
    IElementType PARENTHESIS_R = new MoonTokenType(")");
    IElementType SEMICOLON = new MoonTokenType("SEMICOLON");
    IElementType SINGLE_QUOTE_L = new MoonTokenType("SINGLE_QUOTE_L");
    IElementType SINGLE_QUOTE_R = new MoonTokenType("SINGLE_QUOTE_R");
    IElementType STRING_LINE = new MoonTokenType("STRING_LINE");
    IElementType STRING_TEXT = new MoonTokenType("STRING_TEXT");
    IElementType SYMBOL = new MoonTokenType("SYMBOL");
    IElementType VERSION = new MoonTokenType("VERSION");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == APPEND_DERIVE) {
                return new MoonAppendDeriveNode(node);
            } else if (type == CALL_DICT) {
                return new MoonCallDictNode(node);
            } else if (type == CALL_FIELD) {
                return new MoonCallFieldNode(node);
            } else if (type == CALL_FUNCTION) {
                return new MoonCallFunctionNode(node);
            } else if (type == CALL_INDEX) {
                return new MoonCallIndexNode(node);
            } else if (type == CALL_METHOD) {
                return new MoonCallMethodNode(node);
            } else if (type == CALL_SLICE) {
                return new MoonCallSliceNode(node);
            } else if (type == CALL_STATIC) {
                return new MoonCallStaticNode(node);
            } else if (type == CHAR_LITERAL) {
                return new MoonCharLiteralNode(node);
            } else if (type == CHAR_SYNTAX) {
                return new MoonCharSyntaxNode(node);
            } else if (type == CLOSURE_PARAMETERS) {
                return new MoonClosureParametersNode(node);
            } else if (type == CONTROL_STATEMENT) {
                return new MoonControlStatementNode(node);
            } else if (type == DECLARE_CLOSURE) {
                return new MoonDeclareClosureNode(node);
            } else if (type == DECLARE_ENUM) {
                return new MoonDeclareEnumNode(node);
            } else if (type == DECLARE_FIELD) {
                return new MoonDeclareFieldNode(node);
            } else if (type == DECLARE_FUNCTION) {
                return new MoonDeclareFunctionNode(node);
            } else if (type == DECLARE_GENERIC) {
                return new MoonDeclareGenericNode(node);
            } else if (type == DECLARE_IMPL) {
                return new MoonDeclareImplNode(node);
            } else if (type == DECLARE_METHOD) {
                return new MoonDeclareMethodNode(node);
            } else if (type == DECLARE_PARAMETERS) {
                return new MoonDeclareParametersNode(node);
            } else if (type == DECLARE_SIGNATURE) {
                return new MoonDeclareSignatureNode(node);
            } else if (type == DECLARE_STRUCT) {
                return new MoonDeclareStructNode(node);
            } else if (type == DECLARE_TEST) {
                return new MoonDeclareTestNode(node);
            } else if (type == DECLARE_TRAIT) {
                return new MoonDeclareTraitNode(node);
            } else if (type == DECLARE_VARIANT) {
                return new MoonDeclareVariantNode(node);
            } else if (type == DEFINE_TYPE) {
                return new MoonDefineTypeNode(node);
            } else if (type == DEFINE_TYPE_ALIAS) {
                return new MoonDefineTypeAliasNode(node);
            } else if (type == DICT_LITERAL) {
                return new MoonDictLiteralNode(node);
            } else if (type == DICT_TERM) {
                return new MoonDictTermNode(node);
            } else if (type == ELSE_IF) {
                return new MoonElseIfNode(node);
            } else if (type == ELSE_STATEMENT) {
                return new MoonElseStatementNode(node);
            } else if (type == ENUM_BODY) {
                return new MoonEnumBodyNode(node);
            } else if (type == FLAGS) {
                return new MoonFlagsNode(node);
            } else if (type == FOR_CONDITION) {
                return new MoonForConditionNode(node);
            } else if (type == FOR_INCREMENT) {
                return new MoonForIncrementNode(node);
            } else if (type == FOR_IN_STATEMENT) {
                return new MoonForInStatementNode(node);
            } else if (type == FOR_STARTUP) {
                return new MoonForStartupNode(node);
            } else if (type == FOR_STATEMENT) {
                return new MoonForStatementNode(node);
            } else if (type == FUNCTION_BODY) {
                return new MoonFunctionBodyNode(node);
            } else if (type == FUNCTION_EXTERN) {
                return new MoonFunctionExternNode(node);
            } else if (type == FUNCTION_INLINE) {
                return new MoonFunctionInlineNode(node);
            } else if (type == FUNCTION_NAME) {
                return new MoonFunctionNameNode(node);
            } else if (type == GENERIC_CALL) {
                return new MoonGenericCallNode(node);
            } else if (type == GENERIC_ITEM) {
                return new MoonGenericItemNode(node);
            } else if (type == GUARD_LET) {
                return new MoonGuardLetNode(node);
            } else if (type == GUARD_NORMAL) {
                return new MoonGuardNormalNode(node);
            } else if (type == GUARD_STATEMENT) {
                return new MoonGuardStatementNode(node);
            } else if (type == IDENTIFIER) {
                return new MoonIdentifierNode(node);
            } else if (type == IDENTIFIER_FREE) {
                return new MoonIdentifierFreeNode(node);
            } else if (type == IF_STATEMENT) {
                return new MoonIfStatementNode(node);
            } else if (type == IMPL_FOR) {
                return new MoonImplForNode(node);
            } else if (type == IMPL_WITH) {
                return new MoonImplWithNode(node);
            } else if (type == LET_STATEMENT) {
                return new MoonLetStatementNode(node);
            } else if (type == LIST_LITERAL) {
                return new MoonListLiteralNode(node);
            } else if (type == LIST_TERM) {
                return new MoonListTermNode(node);
            } else if (type == MATCH_BODY) {
                return new MoonMatchBodyNode(node);
            } else if (type == MATCH_STATEMENT) {
                return new MoonMatchStatementNode(node);
            } else if (type == MATCH_VARIANT) {
                return new MoonMatchVariantNode(node);
            } else if (type == MODIFIER) {
                return new MoonModifierNode(node);
            } else if (type == MODULE_NAME) {
                return new MoonModuleNameNode(node);
            } else if (type == NAMEPATH) {
                return new MoonNamepathNode(node);
            } else if (type == NUMBER_LITERAL) {
                return new MoonNumberLiteralNode(node);
            } else if (type == PACKAGE) {
                return new MoonPackageNode(node);
            } else if (type == PACKAGE_NAME) {
                return new MoonPackageNameNode(node);
            } else if (type == PACKAGE_VERSION) {
                return new MoonPackageVersionNode(node);
            } else if (type == PARAMETER) {
                return new MoonParameterNode(node);
            } else if (type == RETURN_TYPE) {
                return new MoonReturnTypeNode(node);
            } else if (type == SEMANTIC_NUMBER) {
                return new MoonSemanticNumberNode(node);
            } else if (type == SIGNATURE_ARGUMENTS) {
                return new MoonSignatureArgumentsNode(node);
            } else if (type == SIGNATURE_PARAMETER) {
                return new MoonSignatureParameterNode(node);
            } else if (type == STRING_LINES) {
                return new MoonStringLinesNode(node);
            } else if (type == STRING_LITERAL) {
                return new MoonStringLiteralNode(node);
            } else if (type == STRING_SYNTAX) {
                return new MoonStringSyntaxNode(node);
            } else if (type == STRUCT_BODY) {
                return new MoonStructBodyNode(node);
            } else if (type == TERM_EXPRESSION) {
                return new MoonTermExpressionNode(node);
            } else if (type == TERM_EXPRESSION_ATOM) {
                return new MoonTermExpressionAtomNode(node);
            } else if (type == TERM_EXPRESSION_ITEM) {
                return new MoonTermExpressionItemNode(node);
            } else if (type == TERM_INFIX) {
                return new MoonTermInfixNode(node);
            } else if (type == TERM_PREFIX) {
                return new MoonTermPrefixNode(node);
            } else if (type == TERM_SUFFIX) {
                return new MoonTermSuffixNode(node);
            } else if (type == THEN_STATEMENT) {
                return new MoonThenStatementNode(node);
            } else if (type == THROWABLE) {
                return new MoonThrowableNode(node);
            } else if (type == TRAIT_BODY) {
                return new MoonTraitBodyNode(node);
            } else if (type == TUPLE_LITERAL) {
                return new MoonTupleLiteralNode(node);
            } else if (type == TUPLE_TERM) {
                return new MoonTupleTermNode(node);
            } else if (type == TYPE_EXPRESSION) {
                return new MoonTypeExpressionNode(node);
            } else if (type == TYPE_EXPRESSION_ATOM) {
                return new MoonTypeExpressionAtomNode(node);
            } else if (type == TYPE_EXPRESSION_ITEM) {
                return new MoonTypeExpressionItemNode(node);
            } else if (type == TYPE_HINT) {
                return new MoonTypeHintNode(node);
            } else if (type == TYPE_INFIX) {
                return new MoonTypeInfixNode(node);
            } else if (type == TYPE_PREFIX) {
                return new MoonTypePrefixNode(node);
            } else if (type == TYPE_SUFFIX) {
                return new MoonTypeSuffixNode(node);
            } else if (type == VARIANT) {
                return new MoonVariantNode(node);
            } else if (type == VARIANT_ITEM) {
                return new MoonVariantItemNode(node);
            } else if (type == WHILE_STATEMENT) {
                return new MoonWhileStatementNode(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
