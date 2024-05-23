// This is a generated file. Not intended for manual editing.
package com.github.moonbit.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.*;

import java.util.List;

public interface MoonStructBody extends PsiElement {

    @NotNull
    List<MoonDeclareField> getDeclareFieldList();

    @NotNull
    List<MoonDeclareMethod> getDeclareMethodList();

}
