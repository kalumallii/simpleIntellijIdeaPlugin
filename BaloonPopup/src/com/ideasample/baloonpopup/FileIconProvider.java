package com.ideasample.baloonpopup;

import com.intellij.ide.IconProvider;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Shows a custom icon for files
 */
public class FileIconProvider extends IconProvider {

    private static final String INUSE_ICON_URL = "/inuseIcon.png";

    @Nullable
    @Override
    public Icon getIcon(PsiElement element, int flags) {
        PsiFile containingFile = element.getContainingFile();
        if (containingFile != null && containingFile.getName().endsWith(".java")) {
            return IconLoader.getIcon(INUSE_ICON_URL);
        }
        return null;
    }
}
