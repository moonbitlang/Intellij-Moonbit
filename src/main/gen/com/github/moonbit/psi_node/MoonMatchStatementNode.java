// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonMatchStatementNode extends AnyMoonNode implements MoonMatchStatement {

    public MoonMatchStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitMatchStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonMatchBody getMatchBody() {
        return findChildByClass(MoonMatchBody.class);
    }

    @Override
    @Nullable
    public MoonTermExpression getTermExpression() {
        return findChildByClass(MoonTermExpression.class);
    }

}
