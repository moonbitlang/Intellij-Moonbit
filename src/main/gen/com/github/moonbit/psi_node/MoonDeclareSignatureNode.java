// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonDeclareSignatureNode extends AnyMoonNode implements MoonDeclareSignature {

    public MoonDeclareSignatureNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitDeclareSignature(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonDeclareGeneric getDeclareGeneric() {
        return findChildByClass(MoonDeclareGeneric.class);
    }

    @Override
    @NotNull
    public MoonIdentifier getIdentifier() {
        return findNotNullChildByClass(MoonIdentifier.class);
    }

    @Override
    @Nullable
    public MoonModifier getModifier() {
        return findChildByClass(MoonModifier.class);
    }

    @Override
    @Nullable
    public MoonReturnType getReturnType() {
        return findChildByClass(MoonReturnType.class);
    }

    @Override
    @NotNull
    public MoonSignatureParameter getSignatureParameter() {
        return findNotNullChildByClass(MoonSignatureParameter.class);
    }

}
