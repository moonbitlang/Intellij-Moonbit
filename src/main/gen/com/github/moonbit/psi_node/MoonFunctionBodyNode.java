// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.*;

import java.util.List;

public class MoonFunctionBodyNode extends AnyMoonNode implements MoonFunctionBody {

    public MoonFunctionBodyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitFunctionBody(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<MoonControlStatement> getControlStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonControlStatement.class);
    }

    @Override
    @NotNull
    public List<MoonDeclareFunction> getDeclareFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonDeclareFunction.class);
    }

    @Override
    @NotNull
    public List<MoonDeclareTest> getDeclareTestList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonDeclareTest.class);
    }

    @Override
    @NotNull
    public List<MoonForStatement> getForStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonForStatement.class);
    }

    @Override
    @NotNull
    public List<MoonLetStatement> getLetStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonLetStatement.class);
    }

    @Override
    @NotNull
    public List<MoonTermExpression> getTermExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTermExpression.class);
    }

    @Override
    @NotNull
    public List<MoonTryStatement> getTryStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonTryStatement.class);
    }

    @Override
    @NotNull
    public List<MoonWhileStatement> getWhileStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, MoonWhileStatement.class);
    }

}
