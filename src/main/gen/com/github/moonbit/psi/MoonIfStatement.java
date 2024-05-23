// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonIfStatement extends PsiElement {

    @NotNull
    List<MoonElseIf> getElseIfList();

    @Nullable
    MoonElseStatement getElseStatement();

    @Nullable
    MoonThenStatement getThenStatement();

}
