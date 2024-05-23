// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

public interface MoonForStatement extends PsiElement {

    @Nullable
    MoonForCondition getForCondition();

    @Nullable
    MoonForInStatement getForInStatement();

    @Nullable
    MoonForIncrement getForIncrement();

    @Nullable
    MoonForStartup getForStartup();

    @Nullable
    MoonFunctionBody getFunctionBody();

}
