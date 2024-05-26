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

public class WitxTypeHintNode extends WitElement implements WitxTypeHint {

  public WitxTypeHintNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WitxVisitor visitor) {
    visitor.visitTypeHint(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WitxVisitor) accept((WitxVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WitxEnum getEnum() {
    return findChildByClass(WitxEnum.class);
  }

  @Override
  @Nullable
  public WitxFlags getFlags() {
    return findChildByClass(WitxFlags.class);
  }

  @Override
  @Nullable
  public WitxHandle getHandle() {
    return findChildByClass(WitxHandle.class);
  }

  @Override
  @Nullable
  public WitxIdentifier getIdentifier() {
    return findChildByClass(WitxIdentifier.class);
  }

  @Override
  @Nullable
  public WitxList getList() {
    return findChildByClass(WitxList.class);
  }

  @Override
  @Nullable
  public WitxRecord getRecord() {
    return findChildByClass(WitxRecord.class);
  }

  @Override
  @Nullable
  public WitxReferenceName getReferenceName() {
    return findChildByClass(WitxReferenceName.class);
  }

  @Override
  @Nullable
  public WitxTag getTag() {
    return findChildByClass(WitxTag.class);
  }

  @Override
  @Nullable
  public WitxUnion getUnion() {
    return findChildByClass(WitxUnion.class);
  }

}
