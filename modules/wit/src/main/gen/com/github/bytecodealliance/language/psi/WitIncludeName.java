// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WitIncludeName extends PsiElement {

  @NotNull
  List<WitIdentifierSafe> getIdentifierSafeList();

  @NotNull
  WitInterfaceName getInterfaceName();

  @Nullable
  WitPackageVersion getPackageVersion();

}
