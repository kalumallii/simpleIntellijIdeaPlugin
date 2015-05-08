package com.ideasample.baloonpopup;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

public class About extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        String message = "This is a very basic plugin for IntelliJ IDEA to show a baloon type popup";
        Messages.showInfoMessage(message, "About");
    }
}
