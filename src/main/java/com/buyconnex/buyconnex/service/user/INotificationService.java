package com.buyconnex.buyconnex.service.user;

import java.util.List;

import com.buyconnex.buyconnex.entity.user.Notifications;
import com.buyconnex.buyconnex.entity.user.Users;

public interface INotificationService {

	public Notifications findById(Long id);
	public Notifications saveNotificatiosn(Notifications notifications);
	public void deleteNotifications(Notifications notifications);
	public Notifications updateNotifications(Notifications notifications);
	public List<Notifications> findByUsers(Users users);
}
