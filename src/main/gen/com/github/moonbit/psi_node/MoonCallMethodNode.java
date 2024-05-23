// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonCallMethodNode extends AnyMoonNode implements MoonCallMethod {

    public MoonCallMethodNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitCallMethod(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public MoonCallFunction getCallFunction() {
        return findNotNullChildByClass(MoonCallFunction.class);
    }

    @Override
    @NotNull
    public MoonIdentifierFree getIdentifierFree() {
        return findNotNullChildByClass(MoonIdentifierFree.class);
    }

}
