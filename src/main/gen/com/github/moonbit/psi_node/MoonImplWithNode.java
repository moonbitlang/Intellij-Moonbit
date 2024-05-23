// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonImplWithNode extends AnyMoonNode implements MoonImplWith {

    public MoonImplWithNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitImplWith(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonFunctionBody getFunctionBody() {
        return findChildByClass(MoonFunctionBody.class);
    }

    @Override
    @Nullable
    public MoonIdentifierFree getIdentifierFree() {
        return findChildByClass(MoonIdentifierFree.class);
    }

    @Override
    @Nullable
    public MoonReturnType getReturnType() {
        return findChildByClass(MoonReturnType.class);
    }

    @Override
    @Nullable
    public MoonSignatureArguments getSignatureArguments() {
        return findChildByClass(MoonSignatureArguments.class);
    }

}
