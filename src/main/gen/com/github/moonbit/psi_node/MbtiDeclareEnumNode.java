// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MbtiDeclareEnumNode extends AnyMbtiNode implements MbtiDeclareEnum {

    public MbtiDeclareEnumNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MbtiVisitor visitor) {
        visitor.visitDeclareEnum(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MbtiVisitor) accept((MbtiVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MbtiEnumBody getEnumBody() {
        return findChildByClass(MbtiEnumBody.class);
    }

    @Override
    @Nullable
    public MbtiIdentifier getIdentifier() {
        return findChildByClass(MbtiIdentifier.class);
    }

}
