package com.ideasample.baloonpopup;

import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;

public class NotificationWithLog extends AnAction {

	public static final NotificationGroup GROUP_DISPLAY_ID_INFO =
			new NotificationGroup(PluginConstants.GROUP_NOTIFICATION_ID, NotificationDisplayType.BALLOON, true);

	@Override
	public void actionPerformed(AnActionEvent e) {
		Project project = e.getData(PlatformDataKeys.PROJECT);
		notify(project, PluginConstants.CONNECTION_SUCCESS_TITLE, PluginConstants.CONNECTION_SUCCESS_DESCRIPTION);
	}

	public static void notify(final Project project,String title, String content) {
		final Notification notification =
                GROUP_DISPLAY_ID_INFO.createNotification(title, content, NotificationType.INFORMATION, null);
		ApplicationManager.getApplication().invokeLater(new Runnable() {
			@Override
			public void run() {
				Notifications.Bus.notify(notification, project);
			}
		});
	}
}