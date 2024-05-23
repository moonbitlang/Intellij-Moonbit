// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonDefineTypeNode extends AnyMoonNode implements MoonDefineType {

    public MoonDefineTypeNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitDefineType(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonAppendDerive getAppendDerive() {
        return findChildByClass(MoonAppendDerive.class);
    }

    @Override
    @NotNull
    public List<MoonModifier> getModifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonModifier.class);
    }

    @Override
    @NotNull
    public List<MoonTypeExpression> getTypeExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTypeExpression.class);
    }

}
