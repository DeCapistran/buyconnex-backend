package com.buyconnex.buyconnex.controller.account;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.service.user.NotificationService;
import com.buyconnex.buyconnex.vo.user.NotificationsVo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationRestController {

	@Autowired
	NotificationService notificationService;
	
	@GetMapping
	public ResponseEntity<List<NotificationsVo>> findAllNotifications() {
		List<NotificationsVo> notification = notificationService.findAll();
		return ResponseEntity.ok(notification);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NotificationsVo> findNotificationById(@PathVariable Long id) {
		NotificationsVo notification = notificationService.findById(id).isPresent() ? notificationService.findById(id).get() : null;
		return notification != null ? ResponseEntity.ok(notification) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<NotificationsVo> saveNotification(@Valid @RequestBody NotificationsVo notificationsVo) {
		NotificationsVo notification = notificationService.saveNotifications(notificationsVo);
		return ResponseEntity.status(201).body(notification);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NotificationsVo> updateNotification(@PathVariable Long id, @Valid @RequestBody NotificationsVo notificationsVo) {
		NotificationsVo notification = notificationService.updateNotifications(id, notificationsVo);
		return notification != null ? ResponseEntity.ok(notification) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteByIdNotification(@PathVariable Long id) {
		notificationService.deleteNotificationsById(id);
		return ResponseEntity.noContent().build();
	}
}
