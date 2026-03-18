package com.buyconnex.buyconnex.service.user;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.user.NotificationsVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

public interface INotificationService {

	public Optional<NotificationsVo> findById(Long id);
	public List<NotificationsVo> findAll();
	public NotificationsVo saveNotifications(NotificationsVo notificationsVo);
	public void deleteNotifications(NotificationsVo notificationsVo);
	public void deleteNotificationsById(Long id);
	public NotificationsVo updateNotifications(Long id, NotificationsVo notificationsVo);
	public List<NotificationsVo> findByUsers(UsersVo usersVo);
}
