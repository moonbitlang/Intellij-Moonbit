// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonDeclareVariantNode extends AnyMoonNode implements MoonDeclareVariant {

    public MoonDeclareVariantNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitDeclareVariant(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonDeclareParameters getDeclareParameters() {
        return findChildByClass(MoonDeclareParameters.class);
    }

    @Override
    @NotNull
    public MoonIdentifier getIdentifier() {
        return findNotNullChildByClass(MoonIdentifier.class);
    }

}
