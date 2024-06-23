package com.buyconnex.buyconnex.mapper.user;

import com.buyconnex.buyconnex.entity.user.Notifications;
import com.buyconnex.buyconnex.vo.user.NotificationsVo;

public class NotificationMapper {

	public static NotificationsVo toVO(Notifications notifications) {
		NotificationsVo notificationsVo = new NotificationsVo();
		notificationsVo.setDateNotif(notifications.getDateNotif());
		notificationsVo.setDescription(notifications.getDescription());
		notificationsVo.setLibelle(notifications.getLibelle());
		notificationsVo.setStatus(notifications.getStatus());
		notificationsVo.setUsers(notifications.getUsers());
		
		return notificationsVo;
	}
	
	public static Notifications toEntity(NotificationsVo notificationsVo) {
		Notifications notifications = new Notifications();
		notifications.setDateNotif(notificationsVo.getDateNotif());
		notifications.setDescription(notificationsVo.getDescription());
		notifications.setLibelle(notificationsVo.getLibelle());
		notifications.setStatus(notificationsVo.getStatus());
		notifications.setUsers(notificationsVo.getUsers());
		
		return notifications;
	}
	
	public static void updateEntityFromVO(NotificationsVo notificationsVo, Notifications notifications) {
		
		notifications.setDateNotif(notificationsVo.getDateNotif());
		notifications.setDescription(notificationsVo.getDescription());
		notifications.setLibelle(notificationsVo.getLibelle());
		notifications.setStatus(notificationsVo.getStatus());
		notifications.setUsers(notificationsVo.getUsers());
	}
}
