// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.AnyMoonNode;
import com.github.moonbit.psi.MoonDeclareVariant;
import com.github.moonbit.psi.MoonEnumBody;
import com.github.moonbit.psi.MoonVisitor;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonEnumBodyNode extends AnyMoonNode implements MoonEnumBody {

    public MoonEnumBodyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitEnumBody(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<MoonDeclareVariant> getDeclareVariantList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonDeclareVariant.class);
    }

}
