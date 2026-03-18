package com.buyconnex.buyconnex.repository.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Villes;


public interface CommuneRepository extends JpaRepository<Communes, Long> {

	List<Communes> findByCommune(String commune);
	List<Communes> findByVilles(Villes villes);
	//boolean existByCommune(String commune);
}
