package com.buyconnex.buyconnex.repository.client;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.entity.user.Users;




public interface PanierRepository extends JpaRepository<Paniers, Long> {

	List<Paniers> findByDatePanier(Date datePanier);
	List<Paniers> findByUsers(Users users);
}
