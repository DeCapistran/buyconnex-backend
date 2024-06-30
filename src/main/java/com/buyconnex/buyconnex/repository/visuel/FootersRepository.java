package com.buyconnex.buyconnex.repository.visuel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.visuel.Footers;


public interface FootersRepository extends JpaRepository<Footers, Long> {

	Optional<Footers> findByAdresse(String adresse);
	Optional<Footers> findByMailSupport(String mailSupport);
	Optional<Footers> findByTelephone(String telephone);
}
