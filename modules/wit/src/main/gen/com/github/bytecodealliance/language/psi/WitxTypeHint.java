// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WitxTypeHint extends PsiElement {

  @Nullable
  WitxEnum getEnum();

  @Nullable
  WitxFlags getFlags();

  @Nullable
  WitxHandle getHandle();

  @Nullable
  WitxIdentifier getIdentifier();

  @Nullable
  WitxList getList();

  @Nullable
  WitxRecord getRecord();

  @Nullable
  WitxReferenceName getReferenceName();

  @Nullable
  WitxTag getTag();

  @Nullable
  WitxUnion getUnion();

}
