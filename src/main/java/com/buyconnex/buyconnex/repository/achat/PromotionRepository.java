package com.buyconnex.buyconnex.repository.achat;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Promotions;



public interface PromotionRepository extends JpaRepository<Promotions, Long> {

	List<Promotions> findByDateFin(Date dateFin);
	List<Promotions> findByDateDebut(Date dateDebut);
	List<Promotions> findByPourcentage(int pourcentage);
}
