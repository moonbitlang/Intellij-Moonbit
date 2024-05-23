// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.mixin.MixinTrait;
import com.github.moonbit.psi.MbtiDeclareTrait;
import com.github.moonbit.psi.MbtiIdentifier;
import com.github.moonbit.psi.MbtiTraitBody;
import com.github.moonbit.psi.MbtiVisitor;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MbtiDeclareTraitNode extends MixinTrait implements MbtiDeclareTrait {

    public MbtiDeclareTraitNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MbtiVisitor visitor) {
        visitor.visitDeclareTrait(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MbtiVisitor) accept((MbtiVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MbtiIdentifier getIdentifier() {
        return findChildByClass(MbtiIdentifier.class);
    }

    @Override
    @Nullable
    public MbtiTraitBody getTraitBody() {
        return findChildByClass(MbtiTraitBody.class);
    }

}
