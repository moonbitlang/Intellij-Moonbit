// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MbtiTypeExpressionNode extends AnyMbtiNode implements MbtiTypeExpression {

    public MbtiTypeExpressionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MbtiVisitor visitor) {
        visitor.visitTypeExpression(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MbtiVisitor) accept((MbtiVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<MbtiTypeExpressionItem> getTypeExpressionItemList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MbtiTypeExpressionItem.class);
    }

    @Override
    @NotNull
    public List<MbtiTypeInfix> getTypeInfixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MbtiTypeInfix.class);
    }

}
