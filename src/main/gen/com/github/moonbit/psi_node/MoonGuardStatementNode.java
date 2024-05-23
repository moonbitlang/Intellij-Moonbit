// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonGuardStatementNode extends AnyMoonNode implements MoonGuardStatement {

    public MoonGuardStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitGuardStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonGuardLet getGuardLet() {
        return findChildByClass(MoonGuardLet.class);
    }

    @Override
    @Nullable
    public MoonGuardNormal getGuardNormal() {
        return findChildByClass(MoonGuardNormal.class);
    }

}
