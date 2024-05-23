// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonForStatementNode extends AnyMoonNode implements MoonForStatement {

    public MoonForStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitForStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonForCondition getForCondition() {
        return findChildByClass(MoonForCondition.class);
    }

    @Override
    @Nullable
    public MoonForInStatement getForInStatement() {
        return findChildByClass(MoonForInStatement.class);
    }

    @Override
    @Nullable
    public MoonForIncrement getForIncrement() {
        return findChildByClass(MoonForIncrement.class);
    }

    @Override
    @Nullable
    public MoonForStartup getForStartup() {
        return findChildByClass(MoonForStartup.class);
    }

    @Override
    @Nullable
    public MoonFunctionBody getFunctionBody() {
        return findChildByClass(MoonFunctionBody.class);
    }

}
