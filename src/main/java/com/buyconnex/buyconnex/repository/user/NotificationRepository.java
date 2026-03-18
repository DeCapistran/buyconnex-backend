package com.buyconnex.buyconnex.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.user.Notifications;
import com.buyconnex.buyconnex.entity.user.Users;


public interface NotificationRepository extends JpaRepository<Notifications, Long> {

	List<Notifications> findByUsers (Users user);
	Optional<Notifications> findById(Long id);
}
