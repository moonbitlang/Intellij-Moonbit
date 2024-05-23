// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonDeclareImpl extends PsiElement {

    @Nullable
    MoonDeclareGeneric getDeclareGeneric();

    @Nullable
    MoonImplFor getImplFor();

    @Nullable
    MoonImplWith getImplWith();

    @NotNull
    List<MoonModifier> getModifierList();

    @Nullable
    MoonNamepath getNamepath();

}
