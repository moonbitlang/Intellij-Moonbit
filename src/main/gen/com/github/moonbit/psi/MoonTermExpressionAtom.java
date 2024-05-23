// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

public interface MoonTermExpressionAtom extends PsiElement {

    @Nullable
    MoonCharLiteral getCharLiteral();

    @Nullable
    MoonDictLiteral getDictLiteral();

    @Nullable
    MoonGuardStatement getGuardStatement();

    @Nullable
    MoonIdentifier getIdentifier();

    @Nullable
    MoonIdentifierFree getIdentifierFree();

    @Nullable
    MoonIfStatement getIfStatement();

    @Nullable
    MoonLambdaFunction getLambdaFunction();

    @Nullable
    MoonListLiteral getListLiteral();

    @Nullable
    MoonNumberLiteral getNumberLiteral();

    @Nullable
    MoonStringLines getStringLines();

    @Nullable
    MoonStringLiteral getStringLiteral();

    @Nullable
    MoonTermExpression getTermExpression();

    @Nullable
    MoonTupleLiteral getTupleLiteral();

}
