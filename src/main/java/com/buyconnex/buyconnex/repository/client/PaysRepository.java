package com.buyconnex.buyconnex.repository.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;



public interface PaysRepository extends JpaRepository<Pays, Long> {

	List<Pays> findByPays(String pays);
	List<Pays> findByVilles(Villes villes);
	boolean existByPays(String pays);
}
