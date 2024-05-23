// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonTypeExpressionItemNode extends AnyMoonNode implements MoonTypeExpressionItem {

    public MoonTypeExpressionItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitTypeExpressionItem(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public MoonTypeExpressionAtom getTypeExpressionAtom() {
        return findNotNullChildByClass(MoonTypeExpressionAtom.class);
    }

    @Override
    @NotNull
    public List<MoonTypePrefix> getTypePrefixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTypePrefix.class);
    }

    @Override
    @NotNull
    public List<MoonTypeSuffix> getTypeSuffixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTypeSuffix.class);
    }

}
