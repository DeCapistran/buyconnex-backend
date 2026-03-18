package com.buyconnex.buyconnex.service.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.user.Notifications;
import com.buyconnex.buyconnex.mapper.user.NotificationMapper;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.repository.user.NotificationRepository;
import com.buyconnex.buyconnex.vo.user.NotificationsVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotificationService implements INotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	@Override
	public Optional<NotificationsVo> findById(Long id) {
		return notificationRepository.findById(id).map(NotificationMapper::toVO);
	}

	@Override
	public List<NotificationsVo> findAll() {
		return notificationRepository.findAll().stream().map(NotificationMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public NotificationsVo saveNotifications(NotificationsVo notificationsVo) {
		Notifications notifications = NotificationMapper.toEntity(notificationsVo);
		Notifications notificationsSave = notificationRepository.save(notifications);
		return NotificationMapper.toVO(notificationsSave);
	}

	@Override
	public void deleteNotifications(NotificationsVo notificationsVo) {
		Notifications notifications = NotificationMapper.toEntity(notificationsVo);
		notificationRepository.delete(notifications);
	}

	@Override
	public void deleteNotificationsById(Long id) {
		notificationRepository.deleteById(id);
	}

	@Override
	public NotificationsVo updateNotifications(Long id, NotificationsVo notificationsVo) {
		return notificationRepository.findById(id).map(notifification -> {
			NotificationMapper.updateEntityFromVO(notificationsVo, notifification);
			Notifications notificationsUpdated = notificationRepository.save(notifification);
			return NotificationMapper.toVO(notificationsUpdated);
		}).orElse(null);
	}

	@Override
	public List<NotificationsVo> findByUsers(UsersVo usersVo) {
		return notificationRepository.findByUsers(UserMapper.toEntity(usersVo)).stream().map(NotificationMapper::toVO).collect(Collectors.toList());	
	}
	
}
