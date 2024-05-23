// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonDeclareTraitNode extends AnyMoonNode implements MoonDeclareTrait {

    public MoonDeclareTraitNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitDeclareTrait(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonIdentifier getIdentifier() {
        return findChildByClass(MoonIdentifier.class);
    }

    @Override
    @NotNull
    public List<MoonModifier> getModifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonModifier.class);
    }

    @Override
    @Nullable
    public MoonTraitBody getTraitBody() {
        return findChildByClass(MoonTraitBody.class);
    }

}
