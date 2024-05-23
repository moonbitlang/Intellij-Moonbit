// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonTryStatementNode extends AnyMoonNode implements MoonTryStatement {

    public MoonTryStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitTryStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<MoonCatchExpression> getCatchExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonCatchExpression.class);
    }

    @Override
    @NotNull
    public MoonTryExpression getTryExpression() {
        return findNotNullChildByClass(MoonTryExpression.class);
    }

}
