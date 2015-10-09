package com.ideasample.baloonpopup;

import com.intellij.ide.projectView.ProjectView;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.Arrays;

public class RefreshAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        FileIconProvider.otherIcon = !FileIconProvider.otherIcon;
        VirtualFile files[] = FileEditorManager.getInstance(e.getProject()).getOpenFiles();
        for(VirtualFile file : files){
            LocalFileSystem.getInstance().refreshFiles(Arrays.asList(files));
            System.out.println("triggering refresh for: " + file.getName());
            FileEditorManagerEx.getInstanceEx(e.getProject()).updateFilePresentation(file);
            ProjectView.getInstance(e.getProject()).refresh();
        }
    }
}
