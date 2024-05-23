// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonDeclareStruct extends PsiElement {

    @Nullable
    MoonAppendDerive getAppendDerive();

    @Nullable
    MoonDeclareGeneric getDeclareGeneric();

    @Nullable
    MoonIdentifier getIdentifier();

    @NotNull
    List<MoonModifier> getModifierList();

    @Nullable
    MoonStructBody getStructBody();

}
