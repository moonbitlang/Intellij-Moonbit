// This is a generated file. Not intended for manual editing.
package com.github.bytecodealliance.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.bytecodealliance.language.psi.WitxTypes.*;
import com.github.bytecodealliance.language.psi.WitElement;
import com.github.bytecodealliance.language.psi.*;

public class WitxWorldNode extends WitElement implements WitxWorld {

  public WitxWorldNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WitxVisitor visitor) {
    visitor.visitWorld(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WitxVisitor) accept((WitxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WitxExport> getExportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WitxExport.class);
  }

  @Override
  @Nullable
  public WitxIdentifier getIdentifier() {
    return findChildByClass(WitxIdentifier.class);
  }

  @Override
  @NotNull
  public List<WitxImport> getImportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WitxImport.class);
  }

  @Override
  @NotNull
  public List<WitxInclude> getIncludeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WitxInclude.class);
  }

  @Override
  @NotNull
  public List<WitxUse> getUseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WitxUse.class);
  }

}
