// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonTypeExpressionItem extends PsiElement {

    @NotNull
    MoonTypeExpressionAtom getTypeExpressionAtom();

    @NotNull
    List<MoonTypePrefix> getTypePrefixList();

    @NotNull
    List<MoonTypeSuffix> getTypeSuffixList();

}
