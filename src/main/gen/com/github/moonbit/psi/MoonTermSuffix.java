// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MoonTermSuffix extends PsiElement {

    @Nullable
    MoonCallField getCallField();

    @Nullable
    MoonCallFunction getCallFunction();

    @Nullable
    MoonCallIndex getCallIndex();

    @Nullable
    MoonCallMethod getCallMethod();

    @Nullable
    MoonCallSlice getCallSlice();

    @Nullable
    MoonCallStatic getCallStatic();

}
