// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

public interface MoonLetStatement extends PsiElement {

    @Nullable
    MoonIdentifier getIdentifier();

    @Nullable
    MoonModifier getModifier();

    @Nullable
    MoonTermExpression getTermExpression();

    @Nullable
    MoonTypeHint getTypeHint();

}
