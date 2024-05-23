// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MbtiGenericItemNode extends AnyMbtiNode implements MbtiGenericItem {

    public MbtiGenericItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MbtiVisitor visitor) {
        visitor.visitGenericItem(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MbtiVisitor) accept((MbtiVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public MbtiIdentifier getIdentifier() {
        return findNotNullChildByClass(MbtiIdentifier.class);
    }

    @Override
    @Nullable
    public MbtiTypeExpression getTypeExpression() {
        return findChildByClass(MbtiTypeExpression.class);
    }

}
