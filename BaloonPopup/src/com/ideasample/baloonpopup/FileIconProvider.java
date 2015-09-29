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
    private static final String OTHER_ICON_URL = "/otherIcon.png";

    public static boolean otherIcon = true;

    @Nullable
    @Override
    public Icon getIcon(PsiElement element, int flags) {
        PsiFile containingFile = element.getContainingFile();

        if (containingFile != null) {
            System.out.println("get Icon: " + element.getContainingFile().getName());
            if (otherIcon)
                return IconLoader.getIcon(INUSE_ICON_URL);
            else
                return IconLoader.getIcon(OTHER_ICON_URL);
        }
        return null;
    }
}
