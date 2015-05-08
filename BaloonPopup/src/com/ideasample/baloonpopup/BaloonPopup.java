package com.ideasample.baloonpopup;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.awt.RelativePoint;

public class BaloonPopup extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        String txt= Messages.showInputDialog(project, "What is your name?", "Input Your Name", Messages.getQuestionIcon());

        StatusBar statusBar = WindowManager.getInstance()
                .getStatusBar(DataKeys.PROJECT.getData(e.getDataContext()));

        if (statusBar != null) {
            JBPopupFactory.getInstance()
                    .createHtmlTextBalloonBuilder("Hello, " + txt + "!\n This is a sample baloon popup.", MessageType.INFO, null)
                    .setFadeoutTime(7500)
                    .createBalloon()
                    .show(RelativePoint.getSouthEastOf(statusBar.getComponent()),
                            Balloon.Position.atRight);
        }
    }
}
