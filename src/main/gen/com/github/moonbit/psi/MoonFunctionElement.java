// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

public interface MoonFunctionElement extends PsiElement {

    @Nullable
    MoonDeclareFunction getDeclareFunction();

    @Nullable
    MoonDeclareTest getDeclareTest();

    @Nullable
    MoonIfStatement getIfStatement();

    @Nullable
    MoonLetStatement getLetStatement();

    @Nullable
    MoonTermExpression getTermExpression();

    @Nullable
    MoonWhileStatement getWhileStatement();

}
