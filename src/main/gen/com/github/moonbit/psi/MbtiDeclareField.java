// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MbtiDeclareField extends PsiElement {

    @NotNull
    MbtiIdentifier getIdentifier();

    @NotNull
    List<MbtiModifier> getModifierList();

    @NotNull
    MbtiTypeExpression getTypeExpression();

}
