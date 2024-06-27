package com.buyconnex.buyconnex.repository.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;


public interface VilleRepository extends JpaRepository<Villes, Long> {

	List<Villes> findByCommunes(Communes communes);
	List<Villes> findByPays(Pays pays);
	List<Villes> findByVille(String ville);
	//boolean existByVille(String ville);
}
