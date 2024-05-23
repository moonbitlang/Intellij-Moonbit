// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi_node;

import com.github.moonbit.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.*;

public class MoonTermSuffixNode extends AnyMoonNode implements MoonTermSuffix {

    public MoonTermSuffixNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull MoonVisitor visitor) {
        visitor.visitTermSuffix(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof MoonVisitor) accept((MoonVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MoonCallDict getCallDict() {
        return findChildByClass(MoonCallDict.class);
    }

    @Override
    @Nullable
    public MoonCallField getCallField() {
        return findChildByClass(MoonCallField.class);
    }

    @Override
    @Nullable
    public MoonCallFunction getCallFunction() {
        return findChildByClass(MoonCallFunction.class);
    }

    @Override
    @Nullable
    public MoonCallIndex getCallIndex() {
        return findChildByClass(MoonCallIndex.class);
    }

    @Override
    @Nullable
    public MoonCallMethod getCallMethod() {
        return findChildByClass(MoonCallMethod.class);
    }

    @Override
    @Nullable
    public MoonCallSlice getCallSlice() {
        return findChildByClass(MoonCallSlice.class);
    }

    @Override
    @Nullable
    public MoonCallStatic getCallStatic() {
        return findChildByClass(MoonCallStatic.class);
    }

}
