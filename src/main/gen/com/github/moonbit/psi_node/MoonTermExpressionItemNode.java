// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonTermExpressionItemNode extends AnyMoonNode implements MoonTermExpressionItem {

    public MoonTermExpressionItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitTermExpressionItem(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public MoonTermExpressionAtom getTermExpressionAtom() {
        return findNotNullChildByClass(MoonTermExpressionAtom.class);
    }

    @Override
    @NotNull
    public List<MoonTermPrefix> getTermPrefixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTermPrefix.class);
    }

    @Override
    @NotNull
    public List<MoonTermSuffix> getTermSuffixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTermSuffix.class);
    }

}
