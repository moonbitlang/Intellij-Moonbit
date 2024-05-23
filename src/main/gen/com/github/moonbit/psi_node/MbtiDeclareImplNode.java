// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MbtiDeclareImplNode extends AnyMbtiNode implements MbtiDeclareImpl {

    public MbtiDeclareImplNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MbtiVisitor visitor) {
        visitor.visitDeclareImpl(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MbtiVisitor) accept((MbtiVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MbtiIdentifier getIdentifier() {
        return findChildByClass(MbtiIdentifier.class);
    }

    @Override
    @Nullable
    public MbtiImplBody getImplBody() {
        return findChildByClass(MbtiImplBody.class);
    }

}
