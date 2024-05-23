// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MbtiDeclareFunctionNode extends AnyMbtiNode implements MbtiDeclareFunction {

    public MbtiDeclareFunctionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MbtiVisitor visitor) {
        visitor.visitDeclareFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MbtiVisitor) accept((MbtiVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MbtiDeclareGeneric getDeclareGeneric() {
        return findChildByClass(MbtiDeclareGeneric.class);
    }

    @Override
    @Nullable
    public MbtiDeclareParameter getDeclareParameter() {
        return findChildByClass(MbtiDeclareParameter.class);
    }

    @Override
    @NotNull
    public MbtiIdentifier getIdentifier() {
        return findNotNullChildByClass(MbtiIdentifier.class);
    }

    @Override
    @NotNull
    public List<MbtiModifier> getModifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MbtiModifier.class);
    }

}
