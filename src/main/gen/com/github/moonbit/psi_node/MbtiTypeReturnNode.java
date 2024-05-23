// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.AnyMbtiNode;
import com.github.moonbit.psi.MbtiTypeExpression;
import com.github.moonbit.psi.MbtiTypeReturn;
import com.github.moonbit.psi.MbtiVisitor;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MbtiTypeReturnNode extends AnyMbtiNode implements MbtiTypeReturn {

    public MbtiTypeReturnNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MbtiVisitor visitor) {
        visitor.visitTypeReturn(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MbtiVisitor) accept((MbtiVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public MbtiTypeExpression getTypeExpression() {
        return findNotNullChildByClass(MbtiTypeExpression.class);
    }

}
