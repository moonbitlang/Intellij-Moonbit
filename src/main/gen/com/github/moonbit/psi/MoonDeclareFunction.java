// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
  List<MoonModifier> getModifierList();

  @Nullable
  MoonNamepath getNamepath();

  @Nullable
  MoonReturnType getReturnType();

}
