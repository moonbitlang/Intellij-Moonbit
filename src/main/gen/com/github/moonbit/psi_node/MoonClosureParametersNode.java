// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.AnyMoonNode;
import com.github.moonbit.psi.MoonClosureParameters;
import com.github.moonbit.psi.MoonIdentifier;
import com.github.moonbit.psi.MoonVisitor;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonClosureParametersNode extends AnyMoonNode implements MoonClosureParameters {

    public MoonClosureParametersNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitClosureParameters(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<MoonIdentifier> getIdentifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonIdentifier.class);
    }

}
