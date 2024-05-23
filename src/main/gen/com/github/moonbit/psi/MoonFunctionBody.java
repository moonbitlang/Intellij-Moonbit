// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonFunctionBody extends PsiElement {

    @NotNull
    List<MoonControlStatement> getControlStatementList();

    @NotNull
    List<MoonDeclareFunction> getDeclareFunctionList();

    @NotNull
    List<MoonDeclareTest> getDeclareTestList();

    @NotNull
    List<MoonForStatement> getForStatementList();

    @NotNull
    List<MoonLetStatement> getLetStatementList();

    @NotNull
    List<MoonTermExpression> getTermExpressionList();

    @NotNull
    List<MoonTryStatement> getTryStatementList();

    @NotNull
    List<MoonWhileStatement> getWhileStatementList();

}
