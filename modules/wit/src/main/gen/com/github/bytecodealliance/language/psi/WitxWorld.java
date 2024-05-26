// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WitxWorld extends PsiElement {

  @NotNull
  List<WitxExport> getExportList();

  @Nullable
  WitxIdentifier getIdentifier();

  @NotNull
  List<WitxImport> getImportList();

  @NotNull
  List<WitxInclude> getIncludeList();

  @NotNull
  List<WitxUse> getUseList();

}
