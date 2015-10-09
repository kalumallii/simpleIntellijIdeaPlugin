package com.ideasample.baloonpopup;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;

public class ModuleManagerPopup extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        ModuleManager manager = ModuleManager.getInstance(project);
        Notifications.Bus.notify(new Notification("module", "module", "Module Manager != null: " + (manager != null), NotificationType.INFORMATION));
        Notifications.Bus.notify(new Notification("module", "module", "Modules are: " + (manager.getModules().length), NotificationType.INFORMATION));
    }
}
