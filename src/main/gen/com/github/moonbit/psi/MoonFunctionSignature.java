// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

public interface MoonFunctionSignature extends PsiElement {

    @Nullable
    MoonDeclareGeneric getDeclareGeneric();

    @NotNull
    MoonDeclareParameter getDeclareParameter();

    @NotNull
    MoonIdentifier getIdentifier();

    @Nullable
    MoonModifier getModifier();

    @Nullable
    MoonTypeHint getTypeHint();

}
