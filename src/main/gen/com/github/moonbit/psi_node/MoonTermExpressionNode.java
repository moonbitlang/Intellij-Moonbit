// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonTermExpressionNode extends AnyMoonNode implements MoonTermExpression {

    public MoonTermExpressionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitTermExpression(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<MoonTermExpressionItem> getTermExpressionItemList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTermExpressionItem.class);
    }

    @Override
    @NotNull
    public List<MoonTermInfix> getTermInfixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTermInfix.class);
    }

}
