package com.ideasample.baloonpopup;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Created by kasun32 on 6/4/15.
 */
public class NotificationWithLog extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent e) {

		Notifications.Bus
				.register(PluginConstants.GROUP_NOTIFICATION_ID, NotificationDisplayType.BALLOON);
		Notification notification = new Notification(PluginConstants.GROUP_NOTIFICATION_ID,
		                                             PluginConstants.CONNECTION_SUCCESS_TITLE,
		                                             PluginConstants.CONNECTION_SUCCESS_DESCRIPTION,
		                                             NotificationType.INFORMATION);
		Notifications.Bus.notify(notification);
	}
}