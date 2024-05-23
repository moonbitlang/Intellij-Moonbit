// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonGuardNormalNode extends AnyMoonNode implements MoonGuardNormal {

    public MoonGuardNormalNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitGuardNormal(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonElseStatement getElseStatement() {
        return findChildByClass(MoonElseStatement.class);
    }

    @Override
    @Nullable
    public MoonTermExpression getTermExpression() {
        return findChildByClass(MoonTermExpression.class);
    }

}
