// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonCallFunctionNode extends AnyMoonNode implements MoonCallFunction {

    public MoonCallFunctionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitCallFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<MoonTermExpression> getTermExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTermExpression.class);
    }

    @Override
    @Nullable
    public MoonThrowable getThrowable() {
        return findChildByClass(MoonThrowable.class);
    }

}
