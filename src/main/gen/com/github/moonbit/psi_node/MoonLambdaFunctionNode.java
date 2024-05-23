// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonLambdaFunctionNode extends AnyMoonNode implements MoonLambdaFunction {

    public MoonLambdaFunctionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitLambdaFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonClosureParameters getClosureParameters() {
        return findChildByClass(MoonClosureParameters.class);
    }

    @Override
    @NotNull
    public MoonFunctionBody getFunctionBody() {
        return findNotNullChildByClass(MoonFunctionBody.class);
    }

}
