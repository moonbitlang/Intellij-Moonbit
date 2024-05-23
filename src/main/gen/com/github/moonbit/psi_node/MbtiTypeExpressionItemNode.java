// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MbtiTypeExpressionItemNode extends AnyMbtiNode implements MbtiTypeExpressionItem {

    public MbtiTypeExpressionItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MbtiVisitor visitor) {
        visitor.visitTypeExpressionItem(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MbtiVisitor) accept((MbtiVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public MbtiTypeExpressionAtom getTypeExpressionAtom() {
        return findNotNullChildByClass(MbtiTypeExpressionAtom.class);
    }

    @Override
    @NotNull
    public List<MbtiTypePrefix> getTypePrefixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MbtiTypePrefix.class);
    }

    @Override
    @NotNull
    public List<MbtiTypeSuffix> getTypeSuffixList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MbtiTypeSuffix.class);
    }

}
