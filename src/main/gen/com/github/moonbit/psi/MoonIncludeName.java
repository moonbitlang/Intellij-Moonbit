// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonIncludeName extends PsiElement {

    @NotNull
    List<MoonIdentifier> getIdentifierList();

    @Nullable
    MoonPackageVersion getPackageVersion();

}
