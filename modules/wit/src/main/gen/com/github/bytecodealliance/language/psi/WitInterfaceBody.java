// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WitInterfaceBody extends PsiElement {

  @NotNull
  List<WitDefineType> getDefineTypeList();

  @NotNull
  List<WitEnum> getEnumList();

  @NotNull
  List<WitFlags> getFlagsList();

  @NotNull
  List<WitFunction> getFunctionList();

  @NotNull
  List<WitRecord> getRecordList();

  @NotNull
  List<WitResource> getResourceList();

  @NotNull
  List<WitUse> getUseList();

  @NotNull
  List<WitVariant> getVariantList();

}
