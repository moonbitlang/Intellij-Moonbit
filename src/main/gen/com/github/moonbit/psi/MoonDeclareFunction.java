// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonDeclareFunction extends PsiElement {

    @Nullable
    MoonDeclareGeneric getDeclareGeneric();

    @Nullable
    MoonDeclareParameters getDeclareParameters();

    @Nullable
    MoonFunctionBody getFunctionBody();

    @Nullable
    MoonFunctionExtern getFunctionExtern();

    @Nullable
    MoonFunctionInline getFunctionInline();

    @NotNull
    MoonFunctionName getFunctionName();

    @NotNull
    List<MoonModifier> getModifierList();

    @Nullable
    MoonReturnType getReturnType();

}
