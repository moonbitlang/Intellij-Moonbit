// This is a generated file. Not intended for manual editing.
package com.github.moonbit.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.moonbit.psi.MoonTypes.*;
import static com.github.moonbit.psi.MoonParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MoonParser implements PsiParser, LightPsiParser {

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
        return moon(b, l + 1);
    }

    /* ********************************************************** */
    // DOT identifier
    public static boolean call_field(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_field")) return false;
        if (!nextTokenIs(b, DOT)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOT);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, CALL_FIELD, r);
        return r;
    }

    /* ********************************************************** */
    // errorable? PARENTHESIS_L (term-expression (COMMA term-expression)* COMMA?)? PARENTHESIS_R
    public static boolean call_function(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_function")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CALL_FUNCTION, "<call function>");
        r = call_function_0(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_L);
        r = r && call_function_2(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // errorable?
    private static boolean call_function_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_function_0")) return false;
        errorable(b, l + 1);
        return true;
    }

    // (term-expression (COMMA term-expression)* COMMA?)?
    private static boolean call_function_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_function_2")) return false;
        call_function_2_0(b, l + 1);
        return true;
    }

    // term-expression (COMMA term-expression)* COMMA?
    private static boolean call_function_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_function_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = term_expression(b, l + 1);
        r = r && call_function_2_0_1(b, l + 1);
        r = r && call_function_2_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA term-expression)*
    private static boolean call_function_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_function_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!call_function_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "call_function_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA term-expression
    private static boolean call_function_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_function_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && term_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean call_function_2_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_function_2_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // DOT INTEGER
    public static boolean call_index(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_index")) return false;
        if (!nextTokenIs(b, DOT)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, DOT, INTEGER);
        exit_section_(b, m, CALL_INDEX, r);
        return r;
    }

    /* ********************************************************** */
    // DOT call-function
    public static boolean call_method(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_method")) return false;
        if (!nextTokenIs(b, DOT)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOT);
        r = r && call_function(b, l + 1);
        exit_section_(b, m, CALL_METHOD, r);
        return r;
    }

    /* ********************************************************** */
    // BRACKET_L term-expression (COMMA term-expression)* BRACKET_R
    public static boolean call_slice(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_slice")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACKET_L);
        r = r && term_expression(b, l + 1);
        r = r && call_slice_2(b, l + 1);
        r = r && consumeToken(b, BRACKET_R);
        exit_section_(b, m, CALL_SLICE, r);
        return r;
    }

    // (COMMA term-expression)*
    private static boolean call_slice_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_slice_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!call_slice_2_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "call_slice_2", c)) break;
        }
        return true;
    }

    // COMMA term-expression
    private static boolean call_slice_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "call_slice_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && term_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // SINGLE_QUOTE_L STRING_TEXT+ SINGLE_QUOTE_R
    public static boolean char_literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "char_literal")) return false;
        if (!nextTokenIs(b, SINGLE_QUOTE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, SINGLE_QUOTE_L);
        r = r && char_literal_1(b, l + 1);
        r = r && consumeToken(b, SINGLE_QUOTE_R);
        exit_section_(b, m, CHAR_LITERAL, r);
        return r;
    }

    // STRING_TEXT+
    private static boolean char_literal_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "char_literal_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, STRING_TEXT);
        while (r) {
            int c = current_position_(b);
            if (!consumeToken(b, STRING_TEXT)) break;
            if (!empty_element_parsed_guard_(b, "char_literal_1", c)) break;
        }
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // KW_RETURN term-expression?
    // 	| KW_CONTINUE term-expression?
    // 	| KW_BREAK term-expression?
    // 	| KW_RAISE term-expression?
    public static boolean control_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, CONTROL_STATEMENT, "<control statement>");
        r = control_statement_0(b, l + 1);
        if (!r) r = control_statement_1(b, l + 1);
        if (!r) r = control_statement_2(b, l + 1);
        if (!r) r = control_statement_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_RETURN term-expression?
    private static boolean control_statement_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_RETURN);
        r = r && control_statement_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // term-expression?
    private static boolean control_statement_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement_0_1")) return false;
        term_expression(b, l + 1);
        return true;
    }

    // KW_CONTINUE term-expression?
    private static boolean control_statement_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_CONTINUE);
        r = r && control_statement_1_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // term-expression?
    private static boolean control_statement_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement_1_1")) return false;
        term_expression(b, l + 1);
        return true;
    }

    // KW_BREAK term-expression?
    private static boolean control_statement_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement_2")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_BREAK);
        r = r && control_statement_2_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // term-expression?
    private static boolean control_statement_2_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement_2_1")) return false;
        term_expression(b, l + 1);
        return true;
    }

    // KW_RAISE term-expression?
    private static boolean control_statement_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement_3")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_RAISE);
        r = r && control_statement_3_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // term-expression?
    private static boolean control_statement_3_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "control_statement_3_1")) return false;
        term_expression(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_FN declare-parameters function-body
    public static boolean declare_closure(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_closure")) return false;
        if (!nextTokenIs(b, KW_FN)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_CLOSURE, null);
        r = consumeToken(b, KW_FN);
        p = r; // pin = 1
        r = r && report_error_(b, declare_parameters(b, l + 1));
        r = p && function_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // modifier* KW_ENUM identifier enum-body derive-statement?
    public static boolean declare_enum(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enum")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_ENUM, "<declare enum>");
        r = declare_enum_0(b, l + 1);
        r = r && consumeToken(b, KW_ENUM);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, enum_body(b, l + 1)) && r;
        r = p && declare_enum_4(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // modifier*
    private static boolean declare_enum_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enum_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_enum_0", c)) break;
        }
        return true;
    }

    // derive-statement?
    private static boolean declare_enum_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_enum_4")) return false;
        derive_statement(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_MUTABLE? identifier type-hint {
    // //    mixin = "com.github.bytecodealliance.language.mixin.MixinField"
    // }
    public static boolean declare_field(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FIELD, "<declare field>");
        r = declare_field_0(b, l + 1);
        r = r && identifier(b, l + 1);
        r = r && type_hint(b, l + 1);
        r = r && declare_field_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // KW_MUTABLE?
    private static boolean declare_field_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_field_0")) return false;
        consumeToken(b, KW_MUTABLE);
        return true;
    }

    // {
    // //    mixin = "com.github.bytecodealliance.language.mixin.MixinField"
    // }
    private static boolean declare_field_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // modifier* function-extern? KW_FN namepath declare-generic? declare-parameters return-type? (function-body | function-inline)
    public static boolean declare_function(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_FUNCTION, "<declare function>");
        r = declare_function_0(b, l + 1);
        r = r && declare_function_1(b, l + 1);
        r = r && consumeToken(b, KW_FN);
        p = r; // pin = 3
        r = r && report_error_(b, namepath(b, l + 1));
        r = p && report_error_(b, declare_function_4(b, l + 1)) && r;
        r = p && report_error_(b, declare_parameters(b, l + 1)) && r;
        r = p && report_error_(b, declare_function_6(b, l + 1)) && r;
        r = p && declare_function_7(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // modifier*
    private static boolean declare_function_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_function_0", c)) break;
        }
        return true;
    }

    // function-extern?
    private static boolean declare_function_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_1")) return false;
        function_extern(b, l + 1);
        return true;
    }

    // declare-generic?
    private static boolean declare_function_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_4")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_function_6(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_6")) return false;
        return_type(b, l + 1);
        return true;
    }

    // function-body | function-inline
    private static boolean declare_function_7(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_function_7")) return false;
        boolean r;
        r = function_body(b, l + 1);
        if (!r) r = function_inline(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // BRACKET_L (generic-item (COMMA generic-item)*)? BRACKET_R
    public static boolean declare_generic(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACKET_L);
        r = r && declare_generic_1(b, l + 1);
        r = r && consumeToken(b, BRACKET_R);
        exit_section_(b, m, DECLARE_GENERIC, r);
        return r;
    }

    // (generic-item (COMMA generic-item)*)?
    private static boolean declare_generic_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1")) return false;
        declare_generic_1_0(b, l + 1);
        return true;
    }

    // generic-item (COMMA generic-item)*
    private static boolean declare_generic_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = generic_item(b, l + 1);
        r = r && declare_generic_1_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA generic-item)*
    private static boolean declare_generic_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!declare_generic_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_generic_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA generic-item
    private static boolean declare_generic_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_generic_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && generic_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // modifier* KW_IMPLEMENT identifier-free KW_FOR identifier-free impl-with
    public static boolean declare_impl(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_impl")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_IMPL, "<declare impl>");
        r = declare_impl_0(b, l + 1);
        r = r && consumeToken(b, KW_IMPLEMENT);
        p = r; // pin = 2
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && report_error_(b, consumeToken(b, KW_FOR)) && r;
        r = p && report_error_(b, identifier_free(b, l + 1)) && r;
        r = p && impl_with(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // modifier*
    private static boolean declare_impl_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_impl_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_impl_0", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // identifier COLON declare-signature {
    // //	mixin = "com.github.bytecodealliance.language.mixin.MixinMethod"
    // }
    public static boolean declare_method(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_method")) return false;
        if (!nextTokenIs(b, "<declare method>", ESCAPED, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_METHOD, "<declare method>");
        r = identifier(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && declare_signature(b, l + 1);
        r = r && declare_method_3(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // {
    // //	mixin = "com.github.bytecodealliance.language.mixin.MixinMethod"
    // }
    private static boolean declare_method_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // PARENTHESIS_L (parameter (COMMA parameter)* COMMA?)? PARENTHESIS_R
    public static boolean declare_parameters(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_parameters")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && declare_parameters_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, DECLARE_PARAMETERS, r);
        return r;
    }

    // (parameter (COMMA parameter)* COMMA?)?
    private static boolean declare_parameters_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_parameters_1")) return false;
        declare_parameters_1_0(b, l + 1);
        return true;
    }

    // parameter (COMMA parameter)* COMMA?
    private static boolean declare_parameters_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_parameters_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parameter(b, l + 1);
        r = r && declare_parameters_1_0_1(b, l + 1);
        r = r && declare_parameters_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA parameter)*
    private static boolean declare_parameters_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_parameters_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!declare_parameters_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_parameters_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA parameter
    private static boolean declare_parameters_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_parameters_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && parameter(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean declare_parameters_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_parameters_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // modifier? identifier declare-generic? signature-parameter return-type? {
    // }
    public static boolean declare_signature(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_signature")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_SIGNATURE, "<declare signature>");
        r = declare_signature_0(b, l + 1);
        r = r && identifier(b, l + 1);
        r = r && declare_signature_2(b, l + 1);
        r = r && signature_parameter(b, l + 1);
        r = r && declare_signature_4(b, l + 1);
        r = r && declare_signature_5(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // modifier?
    private static boolean declare_signature_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_signature_0")) return false;
        modifier(b, l + 1);
        return true;
    }

    // declare-generic?
    private static boolean declare_signature_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_signature_2")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // return-type?
    private static boolean declare_signature_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_signature_4")) return false;
        return_type(b, l + 1);
        return true;
    }

    // {
    // }
    private static boolean declare_signature_5(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // modifier* KW_STRUCT identifier declare-generic? struct-body derive-statement?
    public static boolean declare_struct(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_struct")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_STRUCT, "<declare struct>");
        r = declare_struct_0(b, l + 1);
        r = r && consumeToken(b, KW_STRUCT);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, declare_struct_3(b, l + 1)) && r;
        r = p && report_error_(b, struct_body(b, l + 1)) && r;
        r = p && declare_struct_5(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // modifier*
    private static boolean declare_struct_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_struct_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_struct_0", c)) break;
        }
        return true;
    }

    // declare-generic?
    private static boolean declare_struct_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_struct_3")) return false;
        declare_generic(b, l + 1);
        return true;
    }

    // derive-statement?
    private static boolean declare_struct_5(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_struct_5")) return false;
        derive_statement(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_TEST string-literal? function-body
    public static boolean declare_test(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_test")) return false;
        if (!nextTokenIs(b, KW_TEST)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_TEST, null);
        r = consumeToken(b, KW_TEST);
        p = r; // pin = 1
        r = r && report_error_(b, declare_test_1(b, l + 1));
        r = p && function_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // string-literal?
    private static boolean declare_test_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_test_1")) return false;
        string_literal(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // modifier* KW_TRAIT identifier trait-body
    public static boolean declare_trait(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_TRAIT, "<declare trait>");
        r = declare_trait_0(b, l + 1);
        r = r && consumeToken(b, KW_TRAIT);
        p = r; // pin = 2
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && trait_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // modifier*
    private static boolean declare_trait_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_trait_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "declare_trait_0", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // identifier
    public static boolean declare_variant(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "declare_variant")) return false;
        if (!nextTokenIs(b, "<declare variant>", ESCAPED, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DECLARE_VARIANT, "<declare variant>");
        r = identifier(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // modifier* KW_TYPE type-expression type-expression
    public static boolean define_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "define_type")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DEFINE_TYPE, "<define type>");
        r = define_type_0(b, l + 1);
        r = r && consumeToken(b, KW_TYPE);
        p = r; // pin = 2
        r = r && report_error_(b, type_expression(b, l + 1));
        r = p && type_expression(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // modifier*
    private static boolean define_type_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "define_type_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!modifier(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "define_type_0", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // KW_DERIVE PARENTHESIS_L (identifier (COMMA identifier)*)? PARENTHESIS_R {
    // 	//	mixin = "com.github.bytecodealliance.language.mixin.MixinDerive"
    // }
    public static boolean derive_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "derive_statement")) return false;
        if (!nextTokenIs(b, KW_DERIVE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeTokens(b, 0, KW_DERIVE, PARENTHESIS_L);
        r = r && derive_statement_2(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        r = r && derive_statement_4(b, l + 1);
        exit_section_(b, m, DERIVE_STATEMENT, r);
        return r;
    }

    // (identifier (COMMA identifier)*)?
    private static boolean derive_statement_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "derive_statement_2")) return false;
        derive_statement_2_0(b, l + 1);
        return true;
    }

    // identifier (COMMA identifier)*
    private static boolean derive_statement_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "derive_statement_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier(b, l + 1);
        r = r && derive_statement_2_0_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA identifier)*
    private static boolean derive_statement_2_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "derive_statement_2_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!derive_statement_2_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "derive_statement_2_0_1", c)) break;
        }
        return true;
    }

    // COMMA identifier
    private static boolean derive_statement_2_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "derive_statement_2_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // 	//	mixin = "com.github.bytecodealliance.language.mixin.MixinDerive"
    // }
    private static boolean derive_statement_4(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // BRACE_L (dict-term (COMMA dict-term)* COMMA?)? BRACE_R
    public static boolean dict_literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dict_literal")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && dict_literal_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, DICT_LITERAL, r);
        return r;
    }

    // (dict-term (COMMA dict-term)* COMMA?)?
    private static boolean dict_literal_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dict_literal_1")) return false;
        dict_literal_1_0(b, l + 1);
        return true;
    }

    // dict-term (COMMA dict-term)* COMMA?
    private static boolean dict_literal_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dict_literal_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = dict_term(b, l + 1);
        r = r && dict_literal_1_0_1(b, l + 1);
        r = r && dict_literal_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA dict-term)*
    private static boolean dict_literal_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dict_literal_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!dict_literal_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "dict_literal_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA dict-term
    private static boolean dict_literal_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dict_literal_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && dict_term(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean dict_literal_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dict_literal_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // identifier COLON term-expression
    public static boolean dict_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "dict_term")) return false;
        if (!nextTokenIs(b, "<dict term>", ESCAPED, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, DICT_TERM, "<dict term>");
        r = identifier(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && term_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_ELSE function-body
    public static boolean else_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "else_statement")) return false;
        if (!nextTokenIs(b, KW_ELSE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, ELSE_STATEMENT, null);
        r = consumeToken(b, KW_ELSE);
        p = r; // pin = 1
        r = r && function_body(b, l + 1);
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // BRACE_L enum-element* BRACE_R
    public static boolean enum_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "enum_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && enum_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, ENUM_BODY, r);
        return r;
    }

    // enum-element*
    private static boolean enum_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "enum_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!enum_element(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "enum_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // SEMICOLON
    // 	| declare-variant
    // 	| declare-field
    // 	| declare-method
    static boolean enum_element(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "enum_element")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = declare_variant(b, l + 1);
        if (!r) r = declare_field(b, l + 1);
        if (!r) r = declare_method(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // OP_ERROR | OP_THROW
    public static boolean errorable(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "errorable")) return false;
        if (!nextTokenIs(b, "<errorable>", OP_ERROR, OP_THROW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, ERRORABLE, "<errorable>");
        r = consumeToken(b, OP_ERROR);
        if (!r) r = consumeToken(b, OP_THROW);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_FLAGS identifier BRACE_L (semantic-number (COMMA semantic-number)* COMMA?)? BRACE_R
    public static boolean flags(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "flags")) return false;
        if (!nextTokenIs(b, KW_FLAGS)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, FLAGS, null);
        r = consumeToken(b, KW_FLAGS);
        p = r; // pin = 1
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, consumeToken(b, BRACE_L)) && r;
        r = p && report_error_(b, flags_3(b, l + 1)) && r;
        r = p && consumeToken(b, BRACE_R) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (semantic-number (COMMA semantic-number)* COMMA?)?
    private static boolean flags_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "flags_3")) return false;
        flags_3_0(b, l + 1);
        return true;
    }

    // semantic-number (COMMA semantic-number)* COMMA?
    private static boolean flags_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "flags_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = semantic_number(b, l + 1);
        r = r && flags_3_0_1(b, l + 1);
        r = r && flags_3_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA semantic-number)*
    private static boolean flags_3_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "flags_3_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!flags_3_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "flags_3_0_1", c)) break;
        }
        return true;
    }

    // COMMA semantic-number
    private static boolean flags_3_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "flags_3_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && semantic_number(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean flags_3_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "flags_3_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // term-expression SEMICOLON
    public static boolean for_condition(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_condition")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FOR_CONDITION, "<for condition>");
        r = term_expression(b, l + 1);
        r = r && consumeToken(b, SEMICOLON);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_FOR identifier KW_IN term-expression function-body
    public static boolean for_in_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_in_statement")) return false;
        if (!nextTokenIs(b, KW_FOR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_FOR);
        r = r && identifier(b, l + 1);
        r = r && consumeToken(b, KW_IN);
        r = r && term_expression(b, l + 1);
        r = r && function_body(b, l + 1);
        exit_section_(b, m, FOR_IN_STATEMENT, r);
        return r;
    }

    /* ********************************************************** */
    // term-expression
    public static boolean for_increment(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_increment")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FOR_INCREMENT, "<for increment>");
        r = term_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // term-expression SEMICOLON
    public static boolean for_startup(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_startup")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, FOR_STARTUP, "<for startup>");
        r = term_expression(b, l + 1);
        r = r && consumeToken(b, SEMICOLON);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // for-in-statement | KW_FOR for-startup for-condition for-increment function-body
    public static boolean for_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_statement")) return false;
        if (!nextTokenIs(b, KW_FOR)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = for_in_statement(b, l + 1);
        if (!r) r = for_statement_1(b, l + 1);
        exit_section_(b, m, FOR_STATEMENT, r);
        return r;
    }

    // KW_FOR for-startup for-condition for-increment function-body
    private static boolean for_statement_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "for_statement_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_FOR);
        r = r && for_startup(b, l + 1);
        r = r && for_condition(b, l + 1);
        r = r && for_increment(b, l + 1);
        r = r && function_body(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L function-element* BRACE_R {
    // }
    public static boolean function_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && function_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        r = r && function_body_3(b, l + 1);
        exit_section_(b, m, FUNCTION_BODY, r);
        return r;
    }

    // function-element*
    private static boolean function_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!function_element(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "function_body_1", c)) break;
        }
        return true;
    }

    // {
    // }
    private static boolean function_body_3(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // SEMICOLON
    // 	| let-statement
    // 	| declare-function
    // 	| declare-test
    // 	| while-statement
    // 	| for-statement
    // 	| control-statement
    // 	| term-expression
    static boolean function_element(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_element")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = let_statement(b, l + 1);
        if (!r) r = declare_function(b, l + 1);
        if (!r) r = declare_test(b, l + 1);
        if (!r) r = while_statement(b, l + 1);
        if (!r) r = for_statement(b, l + 1);
        if (!r) r = control_statement(b, l + 1);
        if (!r) r = term_expression(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // KW_EXTERN string-literal
    public static boolean function_extern(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_extern")) return false;
        if (!nextTokenIs(b, KW_EXTERN)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, KW_EXTERN);
        r = r && string_literal(b, l + 1);
        exit_section_(b, m, FUNCTION_EXTERN, r);
        return r;
    }

    /* ********************************************************** */
    // OP_ASSIGN term-expression
    public static boolean function_inline(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "function_inline")) return false;
        if (!nextTokenIs(b, OP_ASSIGN)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_ASSIGN);
        r = r && term_expression(b, l + 1);
        exit_section_(b, m, FUNCTION_INLINE, r);
        return r;
    }

    /* ********************************************************** */
    // BRACKET_L (type-expression (COMMA type-expression)* COMMA?)? BRACKET_R
    public static boolean generic_call(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call")) return false;
        if (!nextTokenIs(b, BRACKET_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACKET_L);
        r = r && generic_call_1(b, l + 1);
        r = r && consumeToken(b, BRACKET_R);
        exit_section_(b, m, GENERIC_CALL, r);
        return r;
    }

    // (type-expression (COMMA type-expression)* COMMA?)?
    private static boolean generic_call_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1")) return false;
        generic_call_1_0(b, l + 1);
        return true;
    }

    // type-expression (COMMA type-expression)* COMMA?
    private static boolean generic_call_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = type_expression(b, l + 1);
        r = r && generic_call_1_0_1(b, l + 1);
        r = r && generic_call_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA type-expression)*
    private static boolean generic_call_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!generic_call_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "generic_call_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA type-expression
    private static boolean generic_call_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean generic_call_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_call_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // identifier (COLON type-expression)?
    public static boolean generic_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_item")) return false;
        if (!nextTokenIs(b, "<generic item>", ESCAPED, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, GENERIC_ITEM, "<generic item>");
        r = identifier(b, l + 1);
        r = r && generic_item_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (COLON type-expression)?
    private static boolean generic_item_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_item_1")) return false;
        generic_item_1_0(b, l + 1);
        return true;
    }

    // COLON type-expression
    private static boolean generic_item_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "generic_item_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COLON);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // SYMBOL | ESCAPED
    public static boolean identifier(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "identifier")) return false;
        if (!nextTokenIs(b, "<identifier>", ESCAPED, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, ESCAPED);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // SYMBOL | KW_TEST
    public static boolean identifier_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "identifier_free")) return false;
        if (!nextTokenIs(b, "<identifier free>", KW_TEST, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_FREE, "<identifier free>");
        r = consumeToken(b, SYMBOL);
        if (!r) r = consumeToken(b, KW_TEST);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_IF then-statement else-statement?
    public static boolean if_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_statement")) return false;
        if (!nextTokenIs(b, KW_IF)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, IF_STATEMENT, null);
        r = consumeToken(b, KW_IF);
        p = r; // pin = 1
        r = r && report_error_(b, then_statement(b, l + 1));
        r = p && if_statement_2(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // else-statement?
    private static boolean if_statement_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "if_statement_2")) return false;
        else_statement(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // KW_WITH identifier-free signature-parameter return-type? function-body
    public static boolean impl_with(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "impl_with")) return false;
        if (!nextTokenIs(b, KW_WITH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, IMPL_WITH, null);
        r = consumeToken(b, KW_WITH);
        p = r; // pin = 1
        r = r && report_error_(b, identifier_free(b, l + 1));
        r = p && report_error_(b, signature_parameter(b, l + 1)) && r;
        r = p && report_error_(b, impl_with_3(b, l + 1)) && r;
        r = p && function_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // return-type?
    private static boolean impl_with_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "impl_with_3")) return false;
        return_type(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // modifier? KW_LET KW_MUTABLE? identifier type-hint? OP_ASSIGN term-expression
    public static boolean let_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_statement")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LET_STATEMENT, "<let statement>");
        r = let_statement_0(b, l + 1);
        r = r && consumeToken(b, KW_LET);
        p = r; // pin = 2
        r = r && report_error_(b, let_statement_2(b, l + 1));
        r = p && report_error_(b, identifier(b, l + 1)) && r;
        r = p && report_error_(b, let_statement_4(b, l + 1)) && r;
        r = p && report_error_(b, consumeToken(b, OP_ASSIGN)) && r;
        r = p && term_expression(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // modifier?
    private static boolean let_statement_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_statement_0")) return false;
        modifier(b, l + 1);
        return true;
    }

    // KW_MUTABLE?
    private static boolean let_statement_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_statement_2")) return false;
        consumeToken(b, KW_MUTABLE);
        return true;
    }

    // type-hint?
    private static boolean let_statement_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "let_statement_4")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // BRACKET_L (list-term (COMMA list-term)* COMMA?)? BRACKET_R type-hint?
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

    // (list-term (COMMA list-term)* COMMA?)?
    private static boolean list_literal_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "list_literal_1")) return false;
        list_literal_1_0(b, l + 1);
        return true;
    }

    // list-term (COMMA list-term)* COMMA?
    private static boolean list_literal_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "list_literal_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = list_term(b, l + 1);
        r = r && list_literal_1_0_1(b, l + 1);
        r = r && list_literal_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA list-term)*
    private static boolean list_literal_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "list_literal_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!list_literal_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "list_literal_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA list-term
    private static boolean list_literal_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "list_literal_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && list_term(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean list_literal_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "list_literal_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    // type-hint?
    private static boolean list_literal_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "list_literal_3")) return false;
        type_hint(b, l + 1);
        return true;
    }

    /* ********************************************************** */
    // OP_SPREAD? term-expression
    public static boolean list_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "list_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, LIST_TERM, "<list term>");
        r = list_term_0(b, l + 1);
        r = r && term_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_SPREAD?
    private static boolean list_term_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "list_term_0")) return false;
        consumeToken(b, OP_SPREAD);
        return true;
    }

    /* ********************************************************** */
    // BRACE_L match-element* BRACE_R
    public static boolean match_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && match_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, MATCH_BODY, r);
        return r;
    }

    // match-element*
    private static boolean match_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!match_element(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "match_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // match-variant
    static boolean match_element(PsiBuilder b, int l) {
        return match_variant(b, l + 1);
    }

    /* ********************************************************** */
    // KW_MATCH term-expression match-body
    public static boolean match_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_statement")) return false;
        if (!nextTokenIs(b, KW_MATCH)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, MATCH_STATEMENT, null);
        r = consumeToken(b, KW_MATCH);
        p = r; // pin = 1
        r = r && report_error_(b, term_expression(b, l + 1));
        r = p && match_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // identifier
    public static boolean match_variant(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "match_variant")) return false;
        if (!nextTokenIs(b, "<match variant>", ESCAPED, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MATCH_VARIANT, "<match variant>");
        r = identifier(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_PUBLIC | KW_PRIVATE
    public static boolean modifier(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "modifier")) return false;
        if (!nextTokenIs(b, "<modifier>", KW_PRIVATE, KW_PUBLIC)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, MODIFIER, "<modifier>");
        r = consumeToken(b, KW_PUBLIC);
        if (!r) r = consumeToken(b, KW_PRIVATE);
        exit_section_(b, l, m, r, false, null);
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
    // statements*
    static boolean moon(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "moon")) return false;
        while (true) {
            int c = current_position_(b);
            if (!statements(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "moon", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // identifier (NAME_JOIN identifier)*
    public static boolean namepath(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath")) return false;
        if (!nextTokenIs(b, "<namepath>", ESCAPED, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAMEPATH, "<namepath>");
        r = identifier(b, l + 1);
        r = r && namepath_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (NAME_JOIN identifier)*
    private static boolean namepath_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_1", c)) break;
        }
        return true;
    }

    // NAME_JOIN identifier
    private static boolean namepath_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, NAME_JOIN);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // identifier-free (DOT identifier-free)*
    public static boolean namepath_free(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free")) return false;
        if (!nextTokenIs(b, "<namepath free>", KW_TEST, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAMEPATH_FREE, "<namepath free>");
        r = identifier_free(b, l + 1);
        r = r && namepath_free_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (DOT identifier-free)*
    private static boolean namepath_free_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!namepath_free_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "namepath_free_1", c)) break;
        }
        return true;
    }

    // DOT identifier-free
    private static boolean namepath_free_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "namepath_free_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOT);
        r = r && identifier_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // INTEGER | BYTES_HEX | BYTES_OCT | BYTES_BIN
    public static boolean number_literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "number_literal")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
        r = consumeToken(b, INTEGER);
        if (!r) r = consumeToken(b, BYTES_HEX);
        if (!r) r = consumeToken(b, BYTES_OCT);
        if (!r) r = consumeToken(b, BYTES_BIN);
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
    // OP_REF? identifier COLON type-expression (OP_ASSIGN term-expression)? {
    // }
    public static boolean parameter(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
        r = parameter_0(b, l + 1);
        r = r && identifier(b, l + 1);
        r = r && consumeToken(b, COLON);
        r = r && type_expression(b, l + 1);
        r = r && parameter_4(b, l + 1);
        r = r && parameter_5(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // OP_REF?
    private static boolean parameter_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_0")) return false;
        consumeToken(b, OP_REF);
        return true;
    }

    // (OP_ASSIGN term-expression)?
    private static boolean parameter_4(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_4")) return false;
        parameter_4_0(b, l + 1);
        return true;
    }

    // OP_ASSIGN term-expression
    private static boolean parameter_4_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "parameter_4_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_ASSIGN);
        r = r && term_expression(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // {
    // }
    private static boolean parameter_5(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // declare-method
    //   | constructor
    //   | SEMICOLON
    //   | HYPHEN
    //   | DOLLAR
    //   | ACCENT
    //   | OP_REF
    //   | OP_PATTERN_TO
    static boolean resource_element(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "resource_element")) return false;
        boolean r;
        r = declare_method(b, l + 1);
        if (!r) r = consumeToken(b, CONSTRUCTOR);
        if (!r) r = consumeToken(b, SEMICOLON);
        if (!r) r = consumeToken(b, HYPHEN);
        if (!r) r = consumeToken(b, DOLLAR);
        if (!r) r = consumeToken(b, ACCENT);
        if (!r) r = consumeToken(b, OP_REF);
        if (!r) r = consumeToken(b, OP_PATTERN_TO);
        return r;
    }

    /* ********************************************************** */
    // OP_TO type-expression (OP_ERROR type-expression)?
    public static boolean return_type(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "return_type")) return false;
        if (!nextTokenIs(b, OP_TO)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_TO);
        r = r && type_expression(b, l + 1);
        r = r && return_type_2(b, l + 1);
        exit_section_(b, m, RETURN_TYPE, r);
        return r;
    }

    // (OP_ERROR type-expression)?
    private static boolean return_type_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "return_type_2")) return false;
        return_type_2_0(b, l + 1);
        return true;
    }

    // OP_ERROR type-expression
    private static boolean return_type_2_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "return_type_2_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_ERROR);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, null, r);
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
    // PARENTHESIS_L (identifier (COMMA identifier)* COMMA?)? PARENTHESIS_R
    public static boolean signature_parameter(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "signature_parameter")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && signature_parameter_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, SIGNATURE_PARAMETER, r);
        return r;
    }

    // (identifier (COMMA identifier)* COMMA?)?
    private static boolean signature_parameter_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "signature_parameter_1")) return false;
        signature_parameter_1_0(b, l + 1);
        return true;
    }

    // identifier (COMMA identifier)* COMMA?
    private static boolean signature_parameter_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "signature_parameter_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = identifier(b, l + 1);
        r = r && signature_parameter_1_0_1(b, l + 1);
        r = r && signature_parameter_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA identifier)*
    private static boolean signature_parameter_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "signature_parameter_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!signature_parameter_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "signature_parameter_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA identifier
    private static boolean signature_parameter_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "signature_parameter_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && identifier(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean signature_parameter_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "signature_parameter_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // SEMICOLON
    //     | package
    //     | define-type
    // 	| declare-struct
    // 	| declare-enum
    // 	| declare-trait
    // 	| declare-impl
    // 	| let-statement
    // 	| declare-function
    // 	| declare-closure
    // 	| declare-test
    // 	| while-statement
    // 	| for-statement
    // 	| if-statement
    // 	| match-statement
    static boolean statements(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "statements")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = package_$(b, l + 1);
        if (!r) r = define_type(b, l + 1);
        if (!r) r = declare_struct(b, l + 1);
        if (!r) r = declare_enum(b, l + 1);
        if (!r) r = declare_trait(b, l + 1);
        if (!r) r = declare_impl(b, l + 1);
        if (!r) r = let_statement(b, l + 1);
        if (!r) r = declare_function(b, l + 1);
        if (!r) r = declare_closure(b, l + 1);
        if (!r) r = declare_test(b, l + 1);
        if (!r) r = while_statement(b, l + 1);
        if (!r) r = for_statement(b, l + 1);
        if (!r) r = if_statement(b, l + 1);
        if (!r) r = match_statement(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // STRING_LINE+
    public static boolean string_lines(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "string_lines")) return false;
        if (!nextTokenIs(b, STRING_LINE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, STRING_LINE);
        while (r) {
            int c = current_position_(b);
            if (!consumeToken(b, STRING_LINE)) break;
            if (!empty_element_parsed_guard_(b, "string_lines", c)) break;
        }
        exit_section_(b, m, STRING_LINES, r);
        return r;
    }

    /* ********************************************************** */
    // DOUBLE_QUOTE_L STRING_TEXT+ DOUBLE_QUOTE_R
    public static boolean string_literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "string_literal")) return false;
        if (!nextTokenIs(b, DOUBLE_QUOTE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, DOUBLE_QUOTE_L);
        r = r && string_literal_1(b, l + 1);
        r = r && consumeToken(b, DOUBLE_QUOTE_R);
        exit_section_(b, m, STRING_LITERAL, r);
        return r;
    }

    // STRING_TEXT+
    private static boolean string_literal_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "string_literal_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, STRING_TEXT);
        while (r) {
            int c = current_position_(b);
            if (!consumeToken(b, STRING_TEXT)) break;
            if (!empty_element_parsed_guard_(b, "string_literal_1", c)) break;
        }
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // BRACE_L struct-element* BRACE_R
    public static boolean struct_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "struct_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && struct_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, STRUCT_BODY, r);
        return r;
    }

    // struct-element*
    private static boolean struct_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "struct_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!struct_element(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "struct_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // COMMA
    // 	| declare-field
    // 	| declare-method
    static boolean struct_element(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "struct_element")) return false;
        boolean r;
        r = consumeToken(b, COMMA);
        if (!r) r = declare_field(b, l + 1);
        if (!r) r = declare_method(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // term-expression-item (term-infix term-expression-item)*
    public static boolean term_expression(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TERM_EXPRESSION, "<term expression>");
        r = term_expression_item(b, l + 1);
        r = r && term_expression_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (term-infix term-expression-item)*
    private static boolean term_expression_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!term_expression_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "term_expression_1", c)) break;
        }
        return true;
    }

    // term-infix term-expression-item
    private static boolean term_expression_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = term_infix(b, l + 1);
        r = r && term_expression_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // PARENTHESIS_L term-expression PARENTHESIS_R
    // 	| if-statement
    // 	| dict-literal
    // 	| list-literal
    // 	| tuple-literal
    // 	| string-literal
    // 	| string-lines
    // 	| char-literal
    // 	| number-literal
    // 	| AT namepath-free
    // 	| namepath
    public static boolean term_expression_atom(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression_atom")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TERM_EXPRESSION_ATOM, "<term expression atom>");
        r = term_expression_atom_0(b, l + 1);
        if (!r) r = if_statement(b, l + 1);
        if (!r) r = dict_literal(b, l + 1);
        if (!r) r = list_literal(b, l + 1);
        if (!r) r = tuple_literal(b, l + 1);
        if (!r) r = string_literal(b, l + 1);
        if (!r) r = string_lines(b, l + 1);
        if (!r) r = char_literal(b, l + 1);
        if (!r) r = number_literal(b, l + 1);
        if (!r) r = term_expression_atom_9(b, l + 1);
        if (!r) r = namepath(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L term-expression PARENTHESIS_R
    private static boolean term_expression_atom_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression_atom_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && term_expression(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // AT namepath-free
    private static boolean term_expression_atom_9(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression_atom_9")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, AT);
        r = r && namepath_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // term-prefix* term-expression-atom term-suffix*
    public static boolean term_expression_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TERM_EXPRESSION_ITEM, "<term expression item>");
        r = term_expression_item_0(b, l + 1);
        r = r && term_expression_atom(b, l + 1);
        r = r && term_expression_item_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // term-prefix*
    private static boolean term_expression_item_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression_item_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!term_prefix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "term_expression_item_0", c)) break;
        }
        return true;
    }

    // term-suffix*
    private static boolean term_expression_item_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_expression_item_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!term_suffix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "term_expression_item_2", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // OP_ASSIGN
    // 	| OP_ADD | OP_ADD_ASSIGN
    // 	| OP_SUB
    // 	| OP_MUL
    // 	| OP_DIV | OP_DIV_ASSIGN
    // 	| OP_MOD
    // 	| OP_EQ | OP_NE
    // 	| OP_LT | OP_LEQ
    // 	| OP_GT | OP_GEQ
    // 	| OP_OR | OP_AND
    // 	| OP_THEN
    // 	| OP_SPREAD
    // 	| OP_RANGE_TO
    public static boolean term_infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_infix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TERM_INFIX, "<term infix>");
        r = consumeToken(b, OP_ASSIGN);
        if (!r) r = consumeToken(b, OP_ADD);
        if (!r) r = consumeToken(b, OP_ADD_ASSIGN);
        if (!r) r = consumeToken(b, OP_SUB);
        if (!r) r = consumeToken(b, OP_MUL);
        if (!r) r = consumeToken(b, OP_DIV);
        if (!r) r = consumeToken(b, OP_DIV_ASSIGN);
        if (!r) r = consumeToken(b, OP_MOD);
        if (!r) r = consumeToken(b, OP_EQ);
        if (!r) r = consumeToken(b, OP_NE);
        if (!r) r = consumeToken(b, OP_LT);
        if (!r) r = consumeToken(b, OP_LEQ);
        if (!r) r = consumeToken(b, OP_GT);
        if (!r) r = consumeToken(b, OP_GEQ);
        if (!r) r = consumeToken(b, OP_OR);
        if (!r) r = consumeToken(b, OP_AND);
        if (!r) r = consumeToken(b, OP_THEN);
        if (!r) r = consumeToken(b, OP_SPREAD);
        if (!r) r = consumeToken(b, OP_RANGE_TO);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_ADD | OP_SUB | OP_REF
    public static boolean term_prefix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_prefix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TERM_PREFIX, "<term prefix>");
        r = consumeToken(b, OP_ADD);
        if (!r) r = consumeToken(b, OP_SUB);
        if (!r) r = consumeToken(b, OP_REF);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_THROW
    // 	| call-function
    // 	| call-method
    // 	| call-field
    // 	| call-index
    // 	| call-slice
    public static boolean term_suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "term_suffix")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TERM_SUFFIX, "<term suffix>");
        r = consumeToken(b, OP_THROW);
        if (!r) r = call_function(b, l + 1);
        if (!r) r = call_method(b, l + 1);
        if (!r) r = call_field(b, l + 1);
        if (!r) r = call_index(b, l + 1);
        if (!r) r = call_slice(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // term-expression function-body {
    // }
    public static boolean then_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "then_statement")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, THEN_STATEMENT, "<then statement>");
        r = term_expression(b, l + 1);
        r = r && function_body(b, l + 1);
        r = r && then_statement_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // {
    // }
    private static boolean then_statement_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // BRACE_L trait-element* BRACE_R
    public static boolean trait_body(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "trait_body")) return false;
        if (!nextTokenIs(b, BRACE_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, BRACE_L);
        r = r && trait_body_1(b, l + 1);
        r = r && consumeToken(b, BRACE_R);
        exit_section_(b, m, TRAIT_BODY, r);
        return r;
    }

    // trait-element*
    private static boolean trait_body_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "trait_body_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!trait_element(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "trait_body_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // declare-signature
    static boolean trait_element(PsiBuilder b, int l) {
        return declare_signature(b, l + 1);
    }

    /* ********************************************************** */
    // PARENTHESIS_L PARENTHESIS_R
    // 	| PARENTHESIS_L (tuple-term (COMMA tuple-term)* COMMA?)? PARENTHESIS_R
    public static boolean tuple_literal(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_literal")) return false;
        if (!nextTokenIs(b, PARENTHESIS_L)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = parseTokens(b, 0, PARENTHESIS_L, PARENTHESIS_R);
        if (!r) r = tuple_literal_1(b, l + 1);
        exit_section_(b, m, TUPLE_LITERAL, r);
        return r;
    }

    // PARENTHESIS_L (tuple-term (COMMA tuple-term)* COMMA?)? PARENTHESIS_R
    private static boolean tuple_literal_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_literal_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && tuple_literal_1_1(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // (tuple-term (COMMA tuple-term)* COMMA?)?
    private static boolean tuple_literal_1_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_literal_1_1")) return false;
        tuple_literal_1_1_0(b, l + 1);
        return true;
    }

    // tuple-term (COMMA tuple-term)* COMMA?
    private static boolean tuple_literal_1_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_literal_1_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = tuple_term(b, l + 1);
        r = r && tuple_literal_1_1_0_1(b, l + 1);
        r = r && tuple_literal_1_1_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA tuple-term)*
    private static boolean tuple_literal_1_1_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_literal_1_1_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!tuple_literal_1_1_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "tuple_literal_1_1_0_1", c)) break;
        }
        return true;
    }

    // COMMA tuple-term
    private static boolean tuple_literal_1_1_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_literal_1_1_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && tuple_term(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean tuple_literal_1_1_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_literal_1_1_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // term-expression
    public static boolean tuple_term(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "tuple_term")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TUPLE_TERM, "<tuple term>");
        r = term_expression(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // type-expression-item (type-infix type-expression-item)*
    public static boolean type_expression(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION, "<type expression>");
        r = type_expression_item(b, l + 1);
        r = r && type_expression_1(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // (type-infix type-expression-item)*
    private static boolean type_expression_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!type_expression_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "type_expression_1", c)) break;
        }
        return true;
    }

    // type-infix type-expression-item
    private static boolean type_expression_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = type_infix(b, l + 1);
        r = r && type_expression_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // PARENTHESIS_L type-expression PARENTHESIS_R
    // 	| AT namepath-free
    // 	| namepath
    public static boolean type_expression_atom(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_atom")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION_ATOM, "<type expression atom>");
        r = type_expression_atom_0(b, l + 1);
        if (!r) r = type_expression_atom_1(b, l + 1);
        if (!r) r = namepath(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // PARENTHESIS_L type-expression PARENTHESIS_R
    private static boolean type_expression_atom_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_atom_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, PARENTHESIS_L);
        r = r && type_expression(b, l + 1);
        r = r && consumeToken(b, PARENTHESIS_R);
        exit_section_(b, m, null, r);
        return r;
    }

    // AT namepath-free
    private static boolean type_expression_atom_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_atom_1")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, AT);
        r = r && namepath_free(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    /* ********************************************************** */
    // type-prefix* type-expression-atom type-suffix*
    public static boolean type_expression_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_item")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_EXPRESSION_ITEM, "<type expression item>");
        r = type_expression_item_0(b, l + 1);
        r = r && type_expression_atom(b, l + 1);
        r = r && type_expression_item_2(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    // type-prefix*
    private static boolean type_expression_item_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_item_0")) return false;
        while (true) {
            int c = current_position_(b);
            if (!type_prefix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "type_expression_item_0", c)) break;
        }
        return true;
    }

    // type-suffix*
    private static boolean type_expression_item_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_expression_item_2")) return false;
        while (true) {
            int c = current_position_(b);
            if (!type_suffix(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "type_expression_item_2", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // COLON type-expression
    public static boolean type_hint(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_hint")) return false;
        if (!nextTokenIs(b, COLON)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COLON);
        r = r && type_expression(b, l + 1);
        exit_section_(b, m, TYPE_HINT, r);
        return r;
    }

    /* ********************************************************** */
    // OP_ADD | OP_TO
    public static boolean type_infix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_infix")) return false;
        if (!nextTokenIs(b, "<type infix>", OP_ADD, OP_TO)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_INFIX, "<type infix>");
        r = consumeToken(b, OP_ADD);
        if (!r) r = consumeToken(b, OP_TO);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // OP_ADD
    public static boolean type_prefix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_prefix")) return false;
        if (!nextTokenIs(b, OP_ADD)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, OP_ADD);
        exit_section_(b, m, TYPE_PREFIX, r);
        return r;
    }

    /* ********************************************************** */
    // generic-call | OP_THROW
    public static boolean type_suffix(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "type_suffix")) return false;
        if (!nextTokenIs(b, "<type suffix>", BRACKET_L, OP_THROW)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, TYPE_SUFFIX, "<type suffix>");
        r = generic_call(b, l + 1);
        if (!r) r = consumeToken(b, OP_THROW);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

    /* ********************************************************** */
    // KW_VARIANT identifier BRACE_L (variant-item (COMMA variant-item)* COMMA?)? BRACE_R
    public static boolean variant(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "variant")) return false;
        if (!nextTokenIs(b, KW_VARIANT)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, VARIANT, null);
        r = consumeToken(b, KW_VARIANT);
        p = r; // pin = 1
        r = r && report_error_(b, identifier(b, l + 1));
        r = p && report_error_(b, consumeToken(b, BRACE_L)) && r;
        r = p && report_error_(b, variant_3(b, l + 1)) && r;
        r = p && consumeToken(b, BRACE_R) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // (variant-item (COMMA variant-item)* COMMA?)?
    private static boolean variant_3(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "variant_3")) return false;
        variant_3_0(b, l + 1);
        return true;
    }

    // variant-item (COMMA variant-item)* COMMA?
    private static boolean variant_3_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "variant_3_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = variant_item(b, l + 1);
        r = r && variant_3_0_1(b, l + 1);
        r = r && variant_3_0_2(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // (COMMA variant-item)*
    private static boolean variant_3_0_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "variant_3_0_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!variant_3_0_1_0(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "variant_3_0_1", c)) break;
        }
        return true;
    }

    // COMMA variant-item
    private static boolean variant_3_0_1_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "variant_3_0_1_0")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, COMMA);
        r = r && variant_item(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // COMMA?
    private static boolean variant_3_0_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "variant_3_0_2")) return false;
        consumeToken(b, COMMA);
        return true;
    }

    /* ********************************************************** */
    // identifier (PARENTHESIS_L type-hint PARENTHESIS_R)? {
    // //    mixin = "com.github.bytecodealliance.language.mixin.MixinVariantItem"
    // }
    public static boolean variant_item(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "variant_item")) return false;
        if (!nextTokenIs(b, "<variant item>", ESCAPED, SYMBOL)) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, VARIANT_ITEM, "<variant item>");
        r = identifier(b, l + 1);
        r = r && variant_item_1(b, l + 1);
        r = r && variant_item_2(b, l + 1);
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

    // {
    // //    mixin = "com.github.bytecodealliance.language.mixin.MixinVariantItem"
    // }
    private static boolean variant_item_2(PsiBuilder b, int l) {
        return true;
    }

    /* ********************************************************** */
    // KW_WHILE term-expression function-body
    public static boolean while_statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "while_statement")) return false;
        if (!nextTokenIs(b, KW_WHILE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, WHILE_STATEMENT, null);
        r = consumeToken(b, KW_WHILE);
        p = r; // pin = 1
        r = r && report_error_(b, term_expression(b, l + 1));
        r = p && function_body(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

}
