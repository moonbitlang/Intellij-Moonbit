// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WionDictLiteral extends PsiElement {

  @NotNull
  List<WionDictItem> getDictItemList();

  @Nullable
  WionIdentifier getIdentifier();

}
