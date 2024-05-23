// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonDefineType extends PsiElement {

    @Nullable
    MoonAppendDerive getAppendDerive();

    @NotNull
    List<MoonModifier> getModifierList();

    @NotNull
    List<MoonTypeExpression> getTypeExpressionList();

}
