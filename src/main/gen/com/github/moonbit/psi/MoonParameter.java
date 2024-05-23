// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

public interface MoonParameter extends PsiElement {

    @NotNull
    MoonIdentifier getIdentifier();

    @Nullable
    MoonTermExpression getTermExpression();

    @NotNull
    MoonTypeExpression getTypeExpression();

}
