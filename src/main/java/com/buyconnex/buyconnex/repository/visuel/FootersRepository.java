package com.buyconnex.buyconnex.repository.visuel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.visuel.Footers;


public interface FootersRepository extends JpaRepository<Footers, Long> {

	Footers findByAdresse(String adresse);
	Footers findByMailSupport(String mailSupport);
	Footers findByTelephone(String telephone);
}
